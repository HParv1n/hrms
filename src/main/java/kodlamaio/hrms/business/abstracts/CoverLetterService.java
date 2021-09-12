package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.createDtos.CoverLetterCreateDto;

import java.util.List;

public interface CoverLetterService {
    Result add(CoverLetterCreateDto coverLetterCreateDto);

    Result delete(int coverLetterId);

    DataResult<List<CoverLetter>> findByResume_ResumeId(int resumeId);

}
