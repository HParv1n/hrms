package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Course;
import kodlamaio.hrms.entities.dtos.createDtos.CourseCreateDto;

import java.util.List;

public interface CourseService {

    Result add(CourseCreateDto courseCreateDto);

    Result delete(int courseId);

    DataResult<List<Course>> getByResume_ResumeId(int resumeId);
}
