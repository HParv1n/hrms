package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.createDtos.JobAdvertisementCreateDto;
import kodlamaio.hrms.entities.dtos.getDtos.JobAdvertisementGetAllDto;
import kodlamaio.hrms.entities.dtos.getDtos.JobAdvertisementGetDto;

import java.util.List;

public interface JobAdvertisementService {

    Result add(JobAdvertisementCreateDto jobAdvertisementCreateDto);

    Result setPassive(int jobAdvertisementId);

    Result setActiveAndConfirm(int jobAdvertisementId, int personnelId);

    DataResult<List<JobAdvertisement>> getAll();

    DataResult<JobAdvertisement> getByJobAdvertisementId(int id);
//    DataResult<List<JobAdvertisement>> getActiveAndOrderLastDate();
//    DataResult<List<JobAdvertisement>> getActiveAndCompanyId(int id);
//    DataResult<List<JobAdvertisement>> findAllByIsActive();

}
