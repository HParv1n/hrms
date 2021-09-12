package kodlamaio.hrms.api;


import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.concretes.EmployerManager;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.ErrorDataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerUpdate;
import kodlamaio.hrms.entities.dtos.createDtos.EmployerCreateDto;
import kodlamaio.hrms.entities.dtos.getDtos.EmployerGetAllDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employer")
@CrossOrigin
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }

    @PostMapping("/create")
    public Result add(@Valid @RequestBody EmployerCreateDto employerCreateDto) {
        return this.employerService.add(employerCreateDto);
    }

    @GetMapping("getByEmail")
    public DataResult<Employer> getByEmail(String email) {
        return this.employerService.getByEmail(email);
    }

    @GetMapping("getById")
    public DataResult<Employer> getById(@RequestParam int employerId) {
        return this.employerService.getById(employerId);
    }

    @PutMapping("updateEmployer")
    public Result update(EmployerUpdate employerUpdate) {
        return this.employerService.update(employerUpdate);
    }

    @GetMapping("verifyUpdate")
    public Result verifyUpdate(@RequestParam int employerUpdateId, @RequestParam int personnelId) {
        return this.employerService.verifyUpdate(employerUpdateId, personnelId);
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
