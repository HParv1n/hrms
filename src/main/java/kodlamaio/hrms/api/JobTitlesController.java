package kodlamaio.hrms.api;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.ErrorDataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;
import kodlamaio.hrms.entities.dtos.createDtos.JobTitleCreateDto;
import kodlamaio.hrms.entities.dtos.getDtos.JobTitlesGetAllDto;
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
@RequestMapping("/api/jobtitle")
@CrossOrigin
public class JobTitlesController {

    private JobTitleService jobTitleService;

    @Autowired
    public JobTitlesController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @GetMapping("/getAll")
    public DataResult<List<JobTitle>> getAll() {
        return this.jobTitleService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody JobTitle jobTitle) {
        return this.jobTitleService.add(jobTitle);
    }


    @GetMapping("/getByJobTitleName")
    public DataResult<JobTitle> getByJobTitleName(String jobTitleName) {
        return this.jobTitleService.getByJobTitleName(jobTitleName);
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
