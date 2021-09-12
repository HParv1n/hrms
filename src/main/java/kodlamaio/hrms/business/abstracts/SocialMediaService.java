package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import kodlamaio.hrms.entities.dtos.createDtos.SocialMediaCreateDto;

import java.util.List;

public interface SocialMediaService {

    Result add(SocialMediaCreateDto socialMediaCreateDto);

    DataResult<List<SocialMedia>> getByResume_ResumeId(int resumeId);

    Result delete(int socialMediaId);

    Result deleteGithub(int socialMediaId);

    Result deleteFacebook(int socialMediaId);

    Result deleteLinkedin(int socialMediaId);


}
