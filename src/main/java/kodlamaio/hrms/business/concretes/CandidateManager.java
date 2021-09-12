package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.createDtos.CandidateCreateDto;
import kodlamaio.hrms.entities.dtos.getDtos.CandidateForGetDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {

    private CandidateDao candidateDao;
    private DtoConverterService dtoConverterService;
    private UserService userService;
    private ActivationCodeService activationCodeService;
    private EmailService emailService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, DtoConverterService dtoConverterService, UserService userService, ActivationCodeService activationCodeService, EmailService emailService) {
        this.candidateDao = candidateDao;
        this.dtoConverterService = dtoConverterService;
        this.userService = userService;
        this.activationCodeService = activationCodeService;
        this.emailService = emailService;
    }

    @Override
    public Result add(CandidateCreateDto candidateCreateDto) {
        if (!candidateCreateDto.getPassword().equals(candidateCreateDto.getConfirmPassword())) {
            return new ErrorResult("Password do not match");
        }
        Candidate candidate = (Candidate) dtoConverterService.dtoToEntity(candidateCreateDto, Candidate.class);
        candidate.setMailVerify(false);
        this.candidateDao.save(candidate);
        this.emailService.sendVerifyEmail(candidate, this.activationCodeService.createActivationCode(candidate));
        return new SuccessResult("Verification code sent to " + candidate.getEmail());
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>("All candidates brought", this.candidateDao.findAll());
    }

    @Override
    public DataResult<Candidate> getByEmail(String email) {
        return new SuccessDataResult<Candidate>("Email listelendi", this.candidateDao.getByEmail(email));
    }

    @Override
    public DataResult<List<Candidate>> getMailVerifyTrue() {
        return new SuccessDataResult<List<Candidate>>("Data listed", this.candidateDao.getByMailVerifyTrue());
    }


}
