package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.createDtos.CandidateCreateDto;
import kodlamaio.hrms.entities.dtos.getDtos.CandidateForGetDto;

import java.util.List;


public interface CandidateService {
    DataResult<List<Candidate>> getAll();

    DataResult<List<Candidate>> getMailVerifyTrue();

    Result add(CandidateCreateDto candidateCreateDto);

    DataResult<Candidate> getByEmail(String email);


}
