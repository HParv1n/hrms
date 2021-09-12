package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.dtos.createDtos.CityCreateDto;
import kodlamaio.hrms.entities.dtos.getDtos.CityGetAllDto;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();
}
