package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.SocialMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer> {
    List<SocialMedia> getByResume_ResumeId(int resumeId);

}
