package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.*;
import kodlamaio.hrms.dataAccess.abstracts.*;
import kodlamaio.hrms.entities.concretes.JobAdActivation;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobTitle;
import kodlamaio.hrms.entities.dtos.createDtos.JobAdvertisementCreateDto;
import kodlamaio.hrms.entities.dtos.getDtos.JobAdvertisementGetAllDto;
import kodlamaio.hrms.entities.dtos.getDtos.JobAdvertisementGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {


    private JobAdvertisementDao jobAdvertisementDao;
    private DtoConverterService dtoConverterService;
    private JobTitleDao jobTitleDao;
    private EmployerDao employerDao;
    private CityDao cityDao;
    private PersonnelDao personnelDao;
    private JobAdActivationDao jobAdActivationDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, DtoConverterService dtoConverterService, JobTitleDao jobTitleDao, EmployerDao employerDao, CityDao cityDao, PersonnelDao personnelDao, JobAdActivationDao jobAdActivationDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.dtoConverterService = dtoConverterService;
        this.jobTitleDao = jobTitleDao;
        this.employerDao = employerDao;
        this.cityDao = cityDao;
        this.personnelDao = personnelDao;
        this.jobAdActivationDao = jobAdActivationDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>("All job advertisement listed");
    }

    @Override
    public DataResult<JobAdvertisement> getByJobAdvertisementId(int id) {
        if (!jobAdvertisementDao.existsById(id)) {
            return new ErrorDataResult<JobAdvertisement>("There is no such job advertisement");
        }
        return new SuccessDataResult<JobAdvertisement>("Job advertisement listed", this.jobAdvertisementDao.getById(id));
    }

//    @Override
//    public DataResult<List<JobAdvertisement>> getActiveAndOrderLastDate() {
//        return new SuccessDataResult<List<JobAdvertisement>>("Active job advertisements listed by date",this.jobAdvertisementDao.getByActiveOrderByLastDate(true));
//    }

//    @Override
//    public DataResult<List<JobAdvertisement>> getActiveAndCompanyId(int id) {
//        return new SuccessDataResult<List<JobAdvertisement>>("Active job advertisements listed by employer",this.jobAdvertisementDao.getByActiveTrueAndEmployer_UserId(id));
//    }


    @Override
    public Result add(JobAdvertisementCreateDto jobAdvertisementCreateDto) {
        JobAdvertisement jobAdvertisement = (JobAdvertisement) dtoConverterService.dtoToEntity(jobAdvertisementCreateDto, JobAdvertisement.class);
        jobAdvertisement.setJobAdvertId(0);
        jobAdvertisement.setActive(false);
        jobAdvertisement.setConfirmed(false);
        jobAdvertisement.setCreateDate(LocalDate.now());
        jobAdvertisement.setJobTitle(this.jobTitleDao.getById(jobAdvertisementCreateDto.getJobTitleId()));
        jobAdvertisement.setCity(this.cityDao.getById(jobAdvertisementCreateDto.getCityId()));
        jobAdvertisement.setEmployer(this.employerDao.getById(jobAdvertisementCreateDto.getEmployerId()));
        this.jobAdvertisementDao.save(jobAdvertisement);

        JobAdActivation jobAdActivation = new JobAdActivation();
        jobAdActivation.setJobAdActivationId(jobAdvertisement.getJobAdvertId());
        jobAdActivation.setConfirm(false);
        this.jobAdActivationDao.save(jobAdActivation);
        return new SuccessResult("Job advertisement added");
    }

    @Override
    public Result setPassive(int jobAdvertisementId) {
        try {
            JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(jobAdvertisementId);
            jobAdvertisement.setActive(false);
            jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("Job advertisement deactivated");
        } catch (EntityNotFoundException exception) {
            return new ErrorResult("Job advertisement is not found");
        }
    }

    @Override
    public Result setActiveAndConfirm(int jobAdvertisementId, int personnelId) {
        if (!this.personnelDao.existsById(personnelId)) {
            return new ErrorResult("There is no such personnel");
        }
        try {
            JobAdActivation jobAdActivation = this.jobAdActivationDao.getById(jobAdvertisementId);
            jobAdActivation.setConfirmDate(LocalDate.now());
            jobAdActivation.setConfirm(true);
            jobAdActivation.setPersonnelId(personnelId);
            this.jobAdActivationDao.save(jobAdActivation);

            JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(jobAdvertisementId);
            jobAdvertisement.setActive(true);
            jobAdvertisement.setConfirmed(true);
            this.jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("Job advertisement activated");
        } catch (EntityNotFoundException exception) {
            return new SuccessResult("Job advertisement is not found");
        }
    }


//    @Override
//    public DataResult<List<JobAdvertisement>> findAllByIsActive(){
//        return new SuccessDataResult<List<JobAdvertisement>>("Aktiv is elanlari",this.jobAdvertisementDao.getByIsActive(true));
//    }


}
