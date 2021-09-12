package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.getDtos.JobAdvertisementGetDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
//      List<JobAdvertisement> getByIsActive(boolean isActive);
//      List<JobAdvertisement> getByActiveOrderByLastDate(boolean isActive);
//      List<JobAdvertisement> getByActiveTrueAndEmployer_UserId(int id);


}
