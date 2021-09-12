package kodlamaio.hrms.api;

import kodlamaio.hrms.business.abstracts.CourseService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.ErrorDataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Course;
import kodlamaio.hrms.entities.dtos.createDtos.CourseCreateDto;
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
@RequestMapping("/api/course/")
@CrossOrigin
public class CoursesController {

    @Autowired
    private CourseService courseService;


    @PostMapping("add")
    public Result add(@Valid @RequestBody CourseCreateDto courseCreateDto) {
        return this.courseService.add(courseCreateDto);
    }

    @DeleteMapping("deleteCourse")
    public Result delete(@RequestParam int courseId) {
        return this.courseService.delete(courseId);
    }


    @GetMapping("getByResume_ResumeId")
    public DataResult<List<Course>> getByResume_ResumeId(@RequestParam int resumeId) {
        return this.courseService.getByResume_ResumeId(resumeId);
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
