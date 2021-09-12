package kodlamaio.hrms.api;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import kodlamaio.hrms.entities.dtos.createDtos.SocialMediaCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/socialmedia/")
@CrossOrigin
public class SocialMediaController {

    private SocialMediaService socialMediaService;


    @Autowired
    public SocialMediaController(SocialMediaService socialMediaService) {
        this.socialMediaService = socialMediaService;
    }

    @PostMapping("add")
    public Result add(@Valid @RequestBody SocialMediaCreateDto socialMediaCreateDto) {
        return this.socialMediaService.add(socialMediaCreateDto);
    }

    @GetMapping("getByResume_ResumeId")
    public DataResult<List<SocialMedia>> getByResume_ResumeId(@RequestParam int resumeId) {
        return this.socialMediaService.getByResume_ResumeId(resumeId);
    }

    @DeleteMapping("delete")
    public Result delete(@RequestParam int socialMediaId) {
        return this.socialMediaService.delete(socialMediaId);
    }

    @DeleteMapping("deleteGithub")
    public Result deleteGithub(@RequestParam int socialMediaId) {
        return this.socialMediaService.deleteGithub(socialMediaId);
    }

    @DeleteMapping("deleteFacebook")
    Result deleteFacebook(@RequestParam int socialMediaId) {
        return this.socialMediaService.deleteFacebook(socialMediaId);
    }

    @DeleteMapping("deleteLinkedin")
    public Result deleteLinkedin(@RequestParam int socialMediaId) {
        return this.socialMediaService.deleteLinkedin(socialMediaId);
    }

}
