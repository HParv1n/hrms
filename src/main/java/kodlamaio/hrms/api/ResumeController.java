package kodlamaio.hrms.api;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resume/")
@CrossOrigin
public class ResumeController {

    private ResumeService resumeService;


    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

//    @PostMapping("add")
//    public Result add(@RequestParam int candidateId){
//        return this.resumeService.add(candidateId);
//    }

    @GetMapping("getAll")
    public DataResult<List<Resume>> getAll() {
        return this.resumeService.getAll();
    }

    @GetMapping("findByCandidate_CandidateId")
    DataResult<Resume> findByCandidate_CandidateId(int candidateId) {
        return this.resumeService.findByCandidate_CandidateId(candidateId);
    }

    @GetMapping("getByResumeId")
    DataResult<Resume> getByResumeId(@RequestParam int resumeId) {
        return this.resumeService.getByResumeId(resumeId);
    }


}
