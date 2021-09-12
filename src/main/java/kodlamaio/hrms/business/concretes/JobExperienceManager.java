package kodlamaio.hrms.business.concretes;


import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.*;
import kodlamaio.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.createDtos.JobExperienceCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {

    private DtoConverterService dtoConverterService;
    private JobExperienceDao jobExperienceDao;
    private ResumeDao resumeDao;

    @Autowired
    public JobExperienceManager(DtoConverterService dtoConverterService, JobExperienceDao jobExperienceDao, ResumeDao resumeDao) {
        this.dtoConverterService = dtoConverterService;
        this.jobExperienceDao = jobExperienceDao;
        this.resumeDao = resumeDao;
    }

    @Override
    public Result add(JobExperienceCreateDto jobExperienceCreateDto) {
        JobExperience jobExperience = (JobExperience) dtoConverterService.dtoToEntity(jobExperienceCreateDto, JobExperience.class);
        jobExperience.setResume(this.resumeDao.getById(jobExperienceCreateDto.getResumeId()));
        jobExperienceDao.save(jobExperience);
        return new SuccessResult("Job Experience added");
    }

    @Override
    public Result delete(int jobExperienceId) {
        if (!this.jobExperienceDao.existsById(jobExperienceId)) {
            return new ErrorResult("There is such job experience not found");
        }
        this.jobExperienceDao.deleteById(jobExperienceId);
        return new SuccessResult("Job experience deleted");
    }


    @Override
    public DataResult<List<JobExperience>> getByResume_ResumeId(int resumeId) {
        return new SuccessDataResult<List<JobExperience>>("Var bele sohbet", this.jobExperienceDao.getByResume_ResumeId(resumeId));
    }
}
