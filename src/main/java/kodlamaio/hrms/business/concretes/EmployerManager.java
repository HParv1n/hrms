package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.*;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerUpdateDao;
import kodlamaio.hrms.dataAccess.abstracts.PersonnelDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerUpdate;
import kodlamaio.hrms.entities.concretes.Personnel;
import kodlamaio.hrms.entities.dtos.createDtos.EmployerCreateDto;
import kodlamaio.hrms.entities.dtos.getDtos.EmployerGetAllDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private DtoConverterService dtoConverterService;
    private UserService userService;
    private ActivationCodeService activationCodeService;
    private ActivationByPersonnelService activationByPersonnelService;
    private PersonnelDao personnelDao;
    private EmailService emailService;
    private EmployerUpdateDao employerUpdateDao;


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>("Employer Listed", this.employerDao.findAll());
    }

    @Autowired
    public EmployerManager(EmployerDao employerDao, DtoConverterService dtoConverterService, UserService userService, ActivationCodeService activationCodeService, ActivationByPersonnelService activationByPersonnelService, PersonnelDao personnelDao, EmailService emailService, EmployerUpdateDao employerUpdateDao) {
        this.employerDao = employerDao;
        this.dtoConverterService = dtoConverterService;
        this.userService = userService;
        this.activationCodeService = activationCodeService;
        this.activationByPersonnelService = activationByPersonnelService;
        this.personnelDao = personnelDao;
        this.emailService = emailService;
        this.employerUpdateDao = employerUpdateDao;
    }

    @Override
    public Result add(EmployerCreateDto employerCreateDto) {
        if (!employerCreateDto.getPassword().equals(employerCreateDto.getConfirmPassword())) {
            return new ErrorResult("Password do not match");
        }
        Employer employer = (Employer) dtoConverterService.dtoToEntity(employerCreateDto, Employer.class);
        employer.setWaitingUpdate(false);
        employer.setActive(false);
        employer.setMailVerify(false);
        this.employerDao.save(employer);

        this.emailService.sendVerifyEmail(employer, this.activationCodeService.createActivationCode(employer));
        activationByPersonnelService.createActivationByPersonnel(employer);

        return new SuccessResult("Verification code sent to " + employer.getEmail());
    }

    @Override
    public DataResult<Employer> getByEmail(String email) {
        return new SuccessDataResult<Employer>("Listed", this.employerDao.getByEmail(email));
    }

    @Override
    public DataResult<Employer> getById(int employerId) {
        if (!employerDao.existsById(employerId)) {
            return new ErrorDataResult<Employer>("Employer is not found");
        }
        return new SuccessDataResult<Employer>("Employers listed", this.employerDao.getById(employerId));
    }

    @Override
    public Result update(EmployerUpdate employerUpdate) {
        employerUpdate.setEmployerUpdateId(0);
        employerUpdate.setCreateDate(LocalDate.now());
        employerUpdate.setPersonnelId(null);
        Employer employer = this.employerDao.getById(employerUpdate.getEmployerId());
        this.employerUpdateDao.save(employerUpdate);
        employer.setWaitingUpdate(true);
        this.employerDao.save(employer);
        return new SuccessResult("An update request has been sent to the personnel, it will be visible after the personnel's approval.");
    }

    @Override
    public Result verifyUpdate(int employerUpdateId, int personnelId) {
        if (!this.employerUpdateDao.existsById(employerUpdateId)) {
            return new ErrorResult("No such update request");
        } else if (!this.personnelDao.existsById(personnelId)) {
            return new ErrorResult("There is no such personnel");
        }
        EmployerUpdate employerUpdate = this.employerUpdateDao.getById(employerUpdateId);
        Employer employer = this.employerDao.getById(employerUpdate.getEmployerId());

        employerUpdate.setVerified(true);
        employerUpdate.setPersonnelId(personnelId);
        employerUpdate.setVerifyDate(LocalDate.now());
        this.employerUpdateDao.save(employerUpdate);

        employer.setEmail(employerUpdate.getEmail());
        employer.setCompanyName(employerUpdate.getCompanyName());
        employer.setWebAddress(employerUpdate.getWebAddress());
        employer.setPhoneNumber(employerUpdate.getPhoneNumber());
        employer.setWaitingUpdate(false);
        this.employerDao.save(employer);
        return new SuccessResult("Informations updated");

    }

}
