package kodlamaio.hrms.api;

import kodlamaio.hrms.business.abstracts.PersonnelService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Personnel;
import kodlamaio.hrms.entities.dtos.createDtos.PersonnelUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personnel/")
@CrossOrigin
public class PersonnelsController {

    private PersonnelService personnelService;


    @Autowired
    public PersonnelsController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @PostMapping("add")
    Result add(@RequestBody Personnel personnel) {
        return this.personnelService.create(personnel);
    }

    @GetMapping("getAll")
    DataResult<List<Personnel>> getAll() {
        return this.personnelService.getAll();
    }

    @PutMapping("update")
    Result update(PersonnelUpdateDto personnelUpdateDto) {
        return this.personnelService.update(personnelUpdateDto);
    }
}
