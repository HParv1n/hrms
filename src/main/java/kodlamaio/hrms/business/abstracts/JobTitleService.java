package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobTitle;
import kodlamaio.hrms.entities.dtos.createDtos.JobTitleCreateDto;
import kodlamaio.hrms.entities.dtos.getDtos.JobTitlesGetAllDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface JobTitleService {
    DataResult<List<JobTitle>> getAll();

    Result add(JobTitle jobTitle);

    DataResult<JobTitle> getByJobTitleName(String jobTitleName);
}
