package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utils.result.ErrorResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.core.utils.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.ActivationCode;
import kodlamaio.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDate;

@Service
public class ActivationCodeManager implements ActivationCodeService {

    private ActivationCodeDao activationCodeDao;
    private UserDao userDao;
    private CandidateDao candidateDao;
    private ResumeService resumeService;

    @Autowired
    public ActivationCodeManager(ActivationCodeDao activationCodeDao, UserDao userDao, CandidateDao candidateDao, ResumeService resumeService) {
        this.activationCodeDao = activationCodeDao;
        this.userDao = userDao;
        this.candidateDao = candidateDao;
        this.resumeService = resumeService;
    }

    String generatedCode = "";
    private SecureRandom mixer = new SecureRandom();
    private final String contents = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private String randomValueSupplier(int length) {
        StringBuilder randomValueConstructor = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            randomValueConstructor.append(contents.charAt(mixer.nextInt(contents.length())));
        }
        return randomValueConstructor.toString();
    }


    @Override
    public ActivationCode getByCode(String code) {
        return this.activationCodeDao.getByCode(code);
    }


    @Override
    public String createActivationCode(User user) {

        for (int i = 0; i == 0; i = 0) {
            generatedCode = randomValueSupplier(16);

            if (getByCode(generatedCode) == null) {
                break;
            }
        }
        ActivationCode activationCode = new ActivationCode();
        activationCode.setUserId(user.getUserId());
        activationCode.setCode(generatedCode);

        activationCodeDao.save(activationCode);
        return generatedCode;
    }

    @Override
    public Result activateUser(String code) {
        if (activationCodeDao.getByCode(code) == null) {
            return new ErrorResult("incorrect code");
        }

        User user = userDao.getById(activationCodeDao.getByCode(code).getUserId());
        if (user.isMailVerify()) {
            return new ErrorResult("Mail has already been approved");
        }
        user.setMailVerify(true);
        userDao.save(user);

        ActivationCode activationCode = activationCodeDao.getByCode(code);
        activationCode.setVerified(true);
        activationCode.setVerifyDate(LocalDate.now());
        activationCodeDao.save(activationCode);

        if (candidateDao.existsById(user.getUserId())) {
            this.resumeService.add(user.getUserId());
        }
        return new SuccessResult("User activated");
    }
}
