package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerUpdate;
import kodlamaio.hrms.entities.dtos.createDtos.EmployerCreateDto;
import kodlamaio.hrms.entities.dtos.getDtos.EmployerGetAllDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployerService {


    DataResult<List<Employer>> getAll();

    Result add(EmployerCreateDto employerCreateDto);

    DataResult<Employer> getByEmail(String email);

    DataResult<Employer> getById(int employerId);

    Result update(EmployerUpdate employerUpdate);

    Result verifyUpdate(int employerUpdateId, int personnelId);

}
