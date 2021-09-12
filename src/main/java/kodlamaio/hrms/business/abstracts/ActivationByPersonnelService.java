package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface ActivationByPersonnelService {

    void createActivationByPersonnel(Employer employer);

    Result activateEmployer(int employerId, int personnelId);
}
