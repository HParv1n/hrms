package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.createDtos.LanguageCreateDto;

import java.util.List;

public interface LanguageService {

    Result add(LanguageCreateDto languageCreateDto);

    Result delete(int languageId);

    DataResult<List<Language>> getByResume_ResumeId(int id);

}
