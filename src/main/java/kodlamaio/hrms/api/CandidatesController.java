package kodlamaio.hrms.api;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.ErrorDataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.createDtos.CandidateCreateDto;
import kodlamaio.hrms.entities.dtos.getDtos.CandidateForGetDto;
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
@RequestMapping("/api/candidate/")
@CrossOrigin
public class CandidatesController {

    private CandidateService candidateService;

    @Autowired
    public CandidatesController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping("getAll")
    public DataResult<List<Candidate>> getAll() {
        return this.candidateService.getAll();
    }


    @PostMapping("add")
    public Result add(@Valid @RequestBody CandidateCreateDto candidateCreateDto) {
        return this.candidateService.add(candidateCreateDto);
    }

    @GetMapping("getByEmail")
    public DataResult<Candidate> getByEmail(@RequestParam String email) {
        return this.candidateService.getByEmail(email);
    }

    @GetMapping("getMailVerifyTrue")
    public DataResult<List<Candidate>> getMailVerifyTrue() {
        return this.candidateService.getMailVerifyTrue();
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
