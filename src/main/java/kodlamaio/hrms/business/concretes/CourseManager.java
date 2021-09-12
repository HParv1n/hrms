package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CourseService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.*;
import kodlamaio.hrms.dataAccess.abstracts.CourseDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Course;
import kodlamaio.hrms.entities.dtos.createDtos.CourseCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseManager implements CourseService {

    private CourseDao courseDao;
    private DtoConverterService dtoConverterService;
    private ResumeDao resumeDao;


    @Autowired
    public CourseManager(CourseDao courseDao, DtoConverterService dtoConverterService, ResumeDao resumeDao) {
        this.courseDao = courseDao;
        this.dtoConverterService = dtoConverterService;
        this.resumeDao = resumeDao;
    }

    @Override
    public Result add(CourseCreateDto courseCreateDto) {
        Course course = (Course) dtoConverterService.dtoToEntity(courseCreateDto, Course.class);
        course.setResume(this.resumeDao.getById(courseCreateDto.getResumeId()));
        this.courseDao.save(course);
        return new SuccessResult("Course added");
    }

    @Override
    public Result delete(int courseId) {
        if (!courseDao.existsById(courseId)) {
            return new ErrorResult("Course not found");
        }
        this.courseDao.deleteById(courseId);
        return new SuccessResult("Course deleted!");
    }

    @Override
    public DataResult<List<Course>> getByResume_ResumeId(int resumeId) {
        if ((!resumeDao.existsById(resumeId))) {
            return new ErrorDataResult<List<Course>>("Resume not found!");
        }
        return new SuccessDataResult<List<Course>>("Course listed!", this.courseDao.getByResume_ResumeId(resumeId));
    }
}
