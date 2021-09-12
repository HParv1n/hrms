package kodlamaio.hrms.api;

import kodlamaio.hrms.business.abstracts.UniversityService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.University;
import kodlamaio.hrms.entities.dtos.createDtos.UniversityCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/university/")
@CrossOrigin
public class UniversityController {

    private UniversityService universityService;

    @Autowired
    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }


    @PostMapping("add")
    public Result add(@Valid @RequestBody UniversityCreateDto universityCreateDto) {
        return this.universityService.add(universityCreateDto);
    }

    @DeleteMapping("delete")
    public Result delete(@RequestParam int universityId) {
        return this.universityService.delete(universityId);
    }

    @GetMapping("findByResume_ResumeId")
    public DataResult<List<University>> findByResume_ResumeId(@RequestParam int resumeId) {
        return this.universityService.findByResume_ResumeId(resumeId);
    }

}
