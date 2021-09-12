package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.*;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.createDtos.LanguageCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;
    private DtoConverterService dtoConverterService;
    private ResumeDao resumeDao;


    @Autowired
    public LanguageManager(LanguageDao languageDao, DtoConverterService dtoConverterService, ResumeDao resumeDao) {
        this.languageDao = languageDao;
        this.dtoConverterService = dtoConverterService;
        this.resumeDao = resumeDao;
    }

    @Override
    public Result add(LanguageCreateDto languageCreateDto) {
        Language language = (Language) dtoConverterService.dtoToEntity(languageCreateDto, Language.class);
        language.setResume(this.resumeDao.getById(languageCreateDto.getResumeId()));
        languageDao.save(language);
        return new SuccessResult("Language added");
    }


    @Override
    public Result delete(int languageId) {
        if (!this.languageDao.existsById(languageId)) {
            return new SuccessResult("There is such language is not found");
        }
        this.languageDao.deleteById(languageId);
        return new SuccessResult("Language is deleted");
    }

    @Override
    public DataResult<List<Language>> getByResume_ResumeId(int resumeId) {
        if (!this.resumeDao.existsById(resumeId)) {
            return new ErrorDataResult<List<Language>>("Resume is not found!");
        }
        return new SuccessDataResult<List<Language>>("Data Listelendi", this.languageDao.getByResume_ResumeId(resumeId));
    }
}
