package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.University;
import kodlamaio.hrms.entities.dtos.createDtos.UniversityCreateDto;

import java.util.List;

public interface UniversityService {
    Result add(UniversityCreateDto universityCreateDto);

    Result delete(int universityId);

    DataResult<List<University>> findByResume_ResumeId(int resumeId);

}
