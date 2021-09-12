package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoDao extends JpaRepository<Photo, Integer> {
    //    List<Photo> getByOrOrderByPhotoId();
    Photo getByResume_ResumeId(int id);
}
