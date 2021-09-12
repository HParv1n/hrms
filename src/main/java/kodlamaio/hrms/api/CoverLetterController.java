package kodlamaio.hrms.api;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.ErrorDataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.core.utils.result.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import kodlamaio.hrms.entities.dtos.createDtos.CoverLetterCreateDto;
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
@RequestMapping("/api/coverletter/")
@CrossOrigin
public class CoverLetterController {

    private CoverLetterService coverLetterService;

    @Autowired
    public CoverLetterController(CoverLetterService coverLetterService) {
        this.coverLetterService = coverLetterService;
    }

    @PostMapping("add")
    public Result add(@Valid @RequestBody CoverLetterCreateDto coverLetterCreateDto) {
        return this.coverLetterService.add(coverLetterCreateDto);
    }


    @GetMapping("findByResume_ResumeId")
    public DataResult<List<CoverLetter>> findByResume_ResumeId(@RequestParam int resumeId) {
        return this.coverLetterService.findByResume_ResumeId(resumeId);
    }

    @DeleteMapping("deleteCoverLetter")
    public Result delete(int coverLetterId) {
        return this.coverLetterService.delete(coverLetterId);
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
