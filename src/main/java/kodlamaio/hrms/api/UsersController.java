package kodlamaio.hrms.api;

import kodlamaio.hrms.business.abstracts.UniversityService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.createDtos.UserLoginDto;
import kodlamaio.hrms.entities.dtos.createDtos.UserReturnLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/User/")
@CrossOrigin
public class UsersController {


    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("getAll")
    public DataResult<List<User>> getAll() {
        return this.userService.getAll();
    }

    @PostMapping("login")
    public DataResult<UserReturnLoginDto> login(UserLoginDto userLoginDto) {
        return this.userService.login(userLoginDto);
    }

    @GetMapping("getVerifiedUsers")
    public DataResult<List<User>> getVerifiedUsers() {
        return this.userService.getVerifiedUsers();
    }
}
