package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.core.utils.result.SuccessDataResult;
import kodlamaio.hrms.core.utils.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;
import kodlamaio.hrms.entities.dtos.createDtos.JobTitleCreateDto;
import kodlamaio.hrms.entities.dtos.getDtos.JobTitlesGetAllDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;
    private DtoConverterService dtoConverterService;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao, DtoConverterService dtoConverterService) {
        this.jobTitleDao = jobTitleDao;
        this.dtoConverterService = dtoConverterService;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>("Islem Basarili", this.jobTitleDao.findAll());
    }


    @Override
    public DataResult<JobTitle> getByJobTitleName(String jobTitleName) {
        return new SuccessDataResult<JobTitle>("JOb title name listed", this.jobTitleDao.getByJobTitleName(jobTitleName));
    }

    @Override
    public Result add(JobTitle jobTitle) {
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult("Job title added");
    }
}
