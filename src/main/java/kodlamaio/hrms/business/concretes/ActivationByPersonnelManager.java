package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ActivationByPersonnelService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.ErrorResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.core.utils.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationByPersonnelDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.ActivationByPersonnel;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;

@Service
public class ActivationByPersonnelManager implements ActivationByPersonnelService {

    private DtoConverterService dtoConverterService;
    private EmployerDao employerDao;
    private ActivationByPersonnelDao activationByPersonnelDao;

    @Autowired
    public ActivationByPersonnelManager(DtoConverterService dtoConverterService, EmployerDao employerDao, ActivationByPersonnelDao activationByPersonnelDao) {
        this.dtoConverterService = dtoConverterService;
        this.employerDao = employerDao;
        this.activationByPersonnelDao = activationByPersonnelDao;
    }

    @Override
    public void createActivationByPersonnel(Employer employer) {
        ActivationByPersonnel activationByPersonnel = new ActivationByPersonnel();
        activationByPersonnel.setEmployeeId(employer.getUserId());
        activationByPersonnel.setVerified(false);
        activationByPersonnel.setPersonnelId(null);
        activationByPersonnelDao.save(activationByPersonnel);

    }

    @Override
    public Result activateEmployer(int employerId, int personnelId) {
        try {
            Employer employer = employerDao.getById(employerId);
            ActivationByPersonnel activationByPersonnel = activationByPersonnelDao.getById(personnelId);

            employer.setActive(true);
            employerDao.save(employer);

            activationByPersonnel.setVerifyDate(LocalDate.now());
            activationByPersonnel.setVerified(true);
            activationByPersonnel.setPersonnelId(personnelId);
            activationByPersonnelDao.save(activationByPersonnel);

        } catch (EntityNotFoundException exception) {
            return new ErrorResult("Yoxdur bele Id");
        }
        return new SuccessResult("Istifadeci aktiv edildi");
    }
}
