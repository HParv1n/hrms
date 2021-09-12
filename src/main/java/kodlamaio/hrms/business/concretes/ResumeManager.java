package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.PhotoDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Photo;
import kodlamaio.hrms.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    private DtoConverterService dtoConverterService;
    private ResumeDao resumeDao;
    private CandidateDao candidateDao;
    private PhotoDao photoDao;


    @Autowired
    public ResumeManager(DtoConverterService dtoConverterService, ResumeDao resumeDao, CandidateDao candidateDao, PhotoDao photoDao) {
        this.dtoConverterService = dtoConverterService;
        this.resumeDao = resumeDao;
        this.candidateDao = candidateDao;
        this.photoDao = photoDao;
    }

    @Override
    public Result add(int candidateId) {
        Resume resume = new Resume();
        resume.setCandidate(candidateDao.getById(candidateId));
        this.resumeDao.save(resume);

        Photo photo = new Photo();
        photo.setResume(resume);
        photo.setPhotoUrl("https://t4.ftcdn.net/jpg/00/64/67/63/360_F_64676383_LdbmhiNM6Ypzb3FM4PPuFP9rHe7ri8Ju.jpg");
        this.photoDao.save(photo);
        return new SuccessResult("Resume added");
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<List<Resume>>("Resumes listed", this.resumeDao.findAll());
    }

    @Override
    public DataResult<Resume> findByCandidate_CandidateId(int candidateId) {
        if (this.resumeDao.getByCandidate_UserId(candidateId) == null) {
            return new ErrorDataResult<Resume>("Yoxdur bele candidate");
        }
        return new SuccessDataResult<Resume>("Var bele candidate", this.resumeDao.getByCandidate_UserId(candidateId));

    }

    @Override
    public DataResult<Resume> getByResumeId(int resumeId) {
        if (!this.resumeDao.existsById(resumeId)) {
            return new ErrorDataResult<Resume>("There is such resume is not found");
        }
        return new SuccessDataResult<Resume>("Resumes listed", this.resumeDao.getById(resumeId));
    }
}
