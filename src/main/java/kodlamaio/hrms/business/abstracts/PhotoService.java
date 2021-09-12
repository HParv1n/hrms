package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoService {

    DataResult<List<Photo>> getAll();

    Result update(MultipartFile multipartFile, int resumeId);

    Result delete(int id);

    DataResult<Photo> getById(int id);

    Boolean isExist(int id);

}
