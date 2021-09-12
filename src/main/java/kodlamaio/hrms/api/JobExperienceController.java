package kodlamaio.hrms.api;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.ErrorDataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.core.utils.result.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobExperience;
import kodlamaio.hrms.entities.dtos.createDtos.JobExperienceCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobexperience/")
@CrossOrigin
public class JobExperienceController {

    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceController(JobExperienceService jobExperienceService) {
        this.jobExperienceService = jobExperienceService;
    }

    @PostMapping("add")
    public Result add(@Valid @RequestBody JobExperienceCreateDto jobExperienceCreateDto) {
        return this.jobExperienceService.add(jobExperienceCreateDto);
    }


    @GetMapping("getByResume_ResumeId")
    public DataResult<List<JobExperience>> getByResume_ResumeId(@RequestParam int resumeId) {
        return this.jobExperienceService.getByResume_ResumeId(resumeId);
    }

    @GetMapping("delete")
    public Result delete(@RequestParam int jobExperienceId) {
        return this.jobExperienceService.delete(jobExperienceId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>("Validation Errors", validationErrors);
        return errors;
    }
}
