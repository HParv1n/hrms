package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.UniversityService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.*;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.dataAccess.abstracts.UniversityDao;
import kodlamaio.hrms.entities.concretes.University;
import kodlamaio.hrms.entities.dtos.createDtos.UniversityCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityManager implements UniversityService {

    private DtoConverterService dtoConverterService;
    private UniversityDao universityDao;
    private ResumeDao resumeDao;

    @Autowired
    public UniversityManager(DtoConverterService dtoConverterService, UniversityDao universityDao, ResumeDao resumeDao) {
        this.dtoConverterService = dtoConverterService;
        this.universityDao = universityDao;
        this.resumeDao = resumeDao;
    }


    @Override
    public Result add(UniversityCreateDto universityCreateDto) {
        University university = (University) dtoConverterService.dtoToEntity(universityCreateDto, University.class);
        university.setResume(this.resumeDao.getById(universityCreateDto.getResumeId()));
        universityDao.save(university);
        return new SuccessResult("University added");
    }

    @Override
    public Result delete(int universityId) {
        if (!this.universityDao.existsById(universityId)) {
            return new ErrorResult("There is such university is not found");
        }
        this.universityDao.deleteById(universityId);
        return new SuccessResult("University deleted");
    }

    @Override
    public DataResult<List<University>> findByResume_ResumeId(int resumeId) {
        if (!resumeDao.existsById(resumeId)) {
            return new ErrorDataResult<List<University>>("yoxdur bele sohbet");
        }
        return new SuccessDataResult<List<University>>("Var bele sohbet!", this.universityDao.findByResume_ResumeId(resumeId));
    }
}
