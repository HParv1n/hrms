package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Personnel;
import kodlamaio.hrms.entities.dtos.createDtos.PersonnelUpdateDto;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;

import java.util.List;

public interface PersonnelService {

    Result create(Personnel personnel);

    DataResult<List<Personnel>> getAll();

    Result update(PersonnelUpdateDto personnelUpdateDto);
}
