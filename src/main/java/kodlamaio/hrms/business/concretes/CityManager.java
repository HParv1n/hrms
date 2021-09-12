package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.core.utils.result.SuccessDataResult;
import kodlamaio.hrms.core.utils.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.dtos.createDtos.CityCreateDto;
import kodlamaio.hrms.entities.dtos.getDtos.CityGetAllDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {


    private CityDao cityDao;


    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>("Islem Basarili", this.cityDao.findAll());
    }

}
