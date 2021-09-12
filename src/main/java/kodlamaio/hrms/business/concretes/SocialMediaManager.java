package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.*;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.dataAccess.abstracts.SocialMediaDao;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import kodlamaio.hrms.entities.dtos.createDtos.SocialMediaCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaManager implements SocialMediaService {

    private DtoConverterService dtoConverterService;
    private SocialMediaDao socialMediaDao;
    private ResumeDao resumeDao;

    @Autowired
    public SocialMediaManager(DtoConverterService dtoConverterService, SocialMediaDao socialMediaDao, ResumeDao resumeDao) {
        this.dtoConverterService = dtoConverterService;
        this.socialMediaDao = socialMediaDao;
        this.resumeDao = resumeDao;
    }

    @Override
    public Result add(SocialMediaCreateDto socialMediaCreateDto) {
        SocialMedia socialMedia = (SocialMedia) dtoConverterService.dtoToEntity(socialMediaCreateDto, SocialMedia.class);
        socialMedia.setResume(this.resumeDao.getById(socialMediaCreateDto.getResumeId()));
        this.socialMediaDao.save(socialMedia);
        return new SuccessResult("Social media added");
    }

    @Override
    public DataResult<List<SocialMedia>> getByResume_ResumeId(int resumeId) {
        if (!resumeDao.existsById(resumeId)) {
            return new ErrorDataResult<List<SocialMedia>>("yoxdur bele sohbet");
        }
        return new SuccessDataResult<List<SocialMedia>>("Yoxdur bele sohbet", this.socialMediaDao.getByResume_ResumeId(resumeId));
    }

    @Override
    public Result delete(int socialMediaId) {
        if (!this.socialMediaDao.existsById(socialMediaId)) {
            return new ErrorResult("There is such social media not found");
        }
        this.socialMediaDao.deleteById(socialMediaId);
        return new SuccessResult("Social media deleted");
    }

    @Override
    public Result deleteGithub(int socialMediaId) {
        if (!this.socialMediaDao.existsById(socialMediaId)) {
            return new ErrorResult("There is such social media not found");
        }
        SocialMedia socialMedia = this.socialMediaDao.getById(socialMediaId);
        socialMedia.setGithubAddress(null);
        socialMediaDao.save(socialMedia);
        return new SuccessResult("Github deleted");
    }

    @Override
    public Result deleteFacebook(int socialMediaId) {
        if (!this.socialMediaDao.existsById(socialMediaId)) {
            return new ErrorResult("There is such social media not found");
        }
        SocialMedia socialMedia = this.socialMediaDao.getById(socialMediaId);
        socialMedia.setFacebookAddress(null);
        socialMediaDao.save(socialMedia);
        return new SuccessResult("Facebook deleted");
    }

    @Override
    public Result deleteLinkedin(int socialMediaId) {
        if (!this.socialMediaDao.existsById(socialMediaId)) {
            return new ErrorResult("There is such social media not found");
        }
        SocialMedia socialMedia = this.socialMediaDao.getById(socialMediaId);
        socialMedia.setLinkedinAdress(null);
        socialMediaDao.save(socialMedia);
        return new SuccessResult("Linkedin deleted");
    }
}
