package kodlamaio.hrms.api;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.createDtos.LanguageCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/language/")
@CrossOrigin
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping("add")
    public Result add(@Valid @RequestBody LanguageCreateDto languageCreateDto) {
        return this.languageService.add(languageCreateDto);
    }


    @DeleteMapping("delete")
    public Result delete(@RequestParam int languageId) {
        return this.languageService.delete(languageId);
    }


    @GetMapping("getByResume_ResumeId")
    public DataResult<List<Language>> getByResume_ResumeId(@RequestParam int resumeId) {
        return this.languageService.getByResume_ResumeId(resumeId);
    }
}
