package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.core.utils.result.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.createDtos.JobExperienceCreateDto;

import java.util.List;

public interface JobExperienceService {

    Result add(JobExperienceCreateDto jobExperienceCreateDto);

    Result delete(int jobExperienceId);

    DataResult<List<JobExperience>> getByResume_ResumeId(int resumeId);
}
