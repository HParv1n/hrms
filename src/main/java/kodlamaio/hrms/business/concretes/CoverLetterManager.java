package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.*;
import kodlamaio.hrms.dataAccess.abstracts.CoverLetterDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.dtos.createDtos.CoverLetterCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoverLetterManager implements CoverLetterService {

    private DtoConverterService dtoConverterService;
    private CoverLetterDao coverLetterDao;
    private ResumeDao resumeDao;

    @Autowired
    public CoverLetterManager(DtoConverterService dtoConverterService, CoverLetterDao coverLetterDao, ResumeDao resumeDao) {
        this.dtoConverterService = dtoConverterService;
        this.coverLetterDao = coverLetterDao;
        this.resumeDao = resumeDao;
    }

    @Override
    public Result add(CoverLetterCreateDto coverLetterCreateDto) {
        CoverLetter coverLetter = (CoverLetter) dtoConverterService.dtoToEntity(coverLetterCreateDto, CoverLetter.class);
        coverLetter.setResume(this.resumeDao.getById(coverLetterCreateDto.getResumeId()));
        coverLetterDao.save(coverLetter);
        return new SuccessResult("Cover letter added");
    }

    @Override
    public Result delete(int coverLetterId) {
        if (!coverLetterDao.existsById(coverLetterId)) {
            return new ErrorResult("Cover letter not found");
        }
        this.coverLetterDao.deleteById(coverLetterId);
        return new SuccessResult("Cover letter deleted");
    }

    @Override
    public DataResult<List<CoverLetter>> findByResume_ResumeId(int resumeId) {
        if (!this.resumeDao.existsById(resumeId)) {
            return new ErrorDataResult<List<CoverLetter>>("Cover letter not found");
        }
        return new SuccessDataResult<List<CoverLetter>>("Cover letter listed!", this.coverLetterDao.findByResume_ResumeId(resumeId));
    }
}
