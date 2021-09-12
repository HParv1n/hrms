package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.PersonnelService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.core.utils.result.SuccessDataResult;
import kodlamaio.hrms.core.utils.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.PersonnelDao;
import kodlamaio.hrms.entities.concretes.Personnel;
import kodlamaio.hrms.entities.dtos.createDtos.PersonnelUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelManager implements PersonnelService {

    private DtoConverterService dtoConverterService;
    private PersonnelDao personnelDao;
    private UserService userService;


    @Autowired
    public PersonnelManager(DtoConverterService dtoConverterService, PersonnelDao personnelDao, UserService userService) {
        this.dtoConverterService = dtoConverterService;
        this.personnelDao = personnelDao;
        this.userService = userService;
    }

    @Override
    public Result create(Personnel personnel) {
        personnel.setMailVerify(true);
        personnelDao.save(personnel);
        return new SuccessResult("Signed in");
    }

    @Override
    public DataResult<List<Personnel>> getAll() {
        return new SuccessDataResult<List<Personnel>>("Data listed", this.personnelDao.findAll());
    }

    @Override
    public Result update(PersonnelUpdateDto personnelUpdateDto) {
        Personnel personnel = (Personnel) dtoConverterService.dtoToEntity(personnelUpdateDto, Personnel.class);
        personnelDao.save(personnel);
        return new SuccessResult("Information saved");
    }
}
