package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.ErrorDataResult;
import kodlamaio.hrms.core.utils.result.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.PersonnelDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Personnel;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.createDtos.UserLoginDto;
import kodlamaio.hrms.entities.dtos.createDtos.UserReturnLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class UserManager implements UserService {

    private DtoConverterService dtoConverterService;
    private EmployerDao employerDao;
    private PersonnelDao personnelDao;
    private CandidateDao candidateDao;
    private UserDao userDao;


    @Autowired
    public UserManager(DtoConverterService dtoConverterService, EmployerDao employerDao, PersonnelDao personnelDao, CandidateDao candidateDao, UserDao userDao) {
        this.dtoConverterService = dtoConverterService;
        this.employerDao = employerDao;
        this.personnelDao = personnelDao;
        this.candidateDao = candidateDao;
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>("Users listed", this.userDao.findAll());
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>("Email listed", this.userDao.getByEmail(email));
    }

    @Override
    public DataResult<List<User>> getVerifiedUsers() {
        return new SuccessDataResult<List<User>>("Data listed", this.userDao.getByMailVerifyTrue());
    }


    @Override
    public DataResult<UserReturnLoginDto> login(UserLoginDto userLoginDto) {
        User user = this.userDao.getByEmail(userLoginDto.getEmail());
        if (user == null) {
            return new ErrorDataResult<UserReturnLoginDto>("Email is incorrect");
        } else if (!user.getPassword().equals(userLoginDto.getPassword())) {
            return new ErrorDataResult<UserReturnLoginDto>("Password is incorrect");
        } else if (!user.isMailVerify()) {
            return new ErrorDataResult<UserReturnLoginDto>("You need to do an email confirmation to log in");
        }

        UserReturnLoginDto userReturnLoginDto = new UserReturnLoginDto();
        userReturnLoginDto.setUserReturnLoginId(user.getUserId());
        userReturnLoginDto.setEmail(user.getEmail());

        if (this.candidateDao.existsById(user.getUserId())) {
            userReturnLoginDto.setUserType(1);
            userReturnLoginDto.setName(this.candidateDao.getById(user.getUserId()).getFirstName() + " " + this.candidateDao.getById(user.getUserId()).getLastName());
        } else if (this.employerDao.existsById(user.getUserId())) {
            userReturnLoginDto.setUserType(2);
            userReturnLoginDto.setName(this.employerDao.getById(user.getUserId()).getCompanyName());
        } else if (this.personnelDao.existsById(user.getUserId())) {
            userReturnLoginDto.setUserType(3);
            userReturnLoginDto.setName(this.personnelDao.getById(user.getUserId()).getFirstName() + " " + this.personnelDao.getById(user.getUserId()).getLastName());
        } else {
            return new ErrorDataResult<UserReturnLoginDto>("An error occurred");
        }
        return new SuccessDataResult<UserReturnLoginDto>("Signed in", userReturnLoginDto);
    }

}
