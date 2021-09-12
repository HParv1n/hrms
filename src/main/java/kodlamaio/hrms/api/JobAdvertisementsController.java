package kodlamaio.hrms.api;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.ErrorDataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.createDtos.JobAdvertisementCreateDto;
import kodlamaio.hrms.entities.dtos.getDtos.JobAdvertisementGetAllDto;
import kodlamaio.hrms.entities.dtos.getDtos.JobAdvertisementGetDto;
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
@RequestMapping("api/jobadvertisement/")
@CrossOrigin
public class JobAdvertisementsController {

    @Autowired
    private JobAdvertisementService jobAdvertisementService;

    @GetMapping("getall")
    public DataResult<List<JobAdvertisement>> getall() {
        return this.jobAdvertisementService.getAll();
    }

    @PostMapping("add")
    public Result add(@Valid @RequestBody JobAdvertisementCreateDto jobAdvertisementCreateDto) {
        return this.jobAdvertisementService.add(jobAdvertisementCreateDto);
    }

    @GetMapping("getByJobAdvertisementId")
    public DataResult<JobAdvertisement> getByJobAdvertisementId(@RequestParam int id) {
        return this.jobAdvertisementService.getByJobAdvertisementId(id);
    }


    @GetMapping("setActiveAndConfirm")
    public Result setActiveAndConfirm(@RequestParam int jobAdvertisementId, @RequestParam int personnelId) {
        return this.jobAdvertisementService.setActiveAndConfirm(jobAdvertisementId, personnelId);
    }

    @GetMapping("setPassive")
    public Result setPassive(@RequestParam int jobAdvertisementId) {
        return this.jobAdvertisementService.setPassive(jobAdvertisementId);
    }
//    @GetMapping("findAllByStatusIsTrue")
//    public ResponseEntity<?> findAllByIsActive(){
//        return ResponseEntity.ok(this.jobAdvertisementService.g());
//    }

//
//    @GetMapping("findAllByStatusIsTrueAndEmployer_CompanyName")
//    public DataResult<List<JobAdvertisementGetDto>> findAllByStatusIsTrueAndEmployer_CompanyName(String employerName){
//        return this.jobAdvertisementService.findAllByIsActiveAndEmployer_CompanyName(employerName);
//    }


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