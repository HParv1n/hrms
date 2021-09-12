package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.createDtos.UserLoginDto;
import kodlamaio.hrms.entities.dtos.createDtos.UserReturnLoginDto;

import javax.xml.crypto.Data;
import java.util.List;

public interface UserService {
    DataResult<User> getByEmail(String email);

    DataResult<List<User>> getVerifiedUsers();

    DataResult<List<User>> getAll();

    DataResult<UserReturnLoginDto> login(UserLoginDto userLoginDto);

}
