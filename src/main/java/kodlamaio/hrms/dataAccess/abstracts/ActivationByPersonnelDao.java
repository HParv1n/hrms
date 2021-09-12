package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.ActivationByPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivationByPersonnelDao extends JpaRepository<ActivationByPersonnel, Integer> {

}
