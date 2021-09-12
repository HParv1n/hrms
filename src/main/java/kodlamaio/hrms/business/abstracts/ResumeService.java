package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Resume;

import java.util.List;

public interface ResumeService {
    Result add(int candidateId);

    DataResult<List<Resume>> getAll();

    DataResult<Resume> findByCandidate_CandidateId(int candidateId);

    DataResult<Resume> getByResumeId(int resumeId);

}
