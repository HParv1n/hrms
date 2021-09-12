package kodlamaio.hrms.api;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.createDtos.SkillCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/skill/")
@CrossOrigin
public class SkillController {

    private SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("add")
    public Result add(@Valid @RequestBody SkillCreateDto skillCreateDto) {
        return this.skillService.add(skillCreateDto);
    }

    @DeleteMapping("delete")
    public Result delete(@RequestParam int skillId) {
        return this.skillService.delete(skillId);
    }


    @GetMapping("findByResume_ResumeId")
    public DataResult<List<Skill>> findByResume_ResumeId(@RequestParam int resumeId) {
        return this.skillService.findByResume_ResumeId(resumeId);
    }
}
