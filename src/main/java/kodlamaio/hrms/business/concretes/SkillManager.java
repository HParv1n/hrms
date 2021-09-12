package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.core.utils.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utils.result.*;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.dataAccess.abstracts.SkillDao;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.createDtos.SkillCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.function.SupplierUtils;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class SkillManager implements SkillService {

    private SkillDao skillDao;
    private DtoConverterService dtoConverterService;
    private ResumeDao resumeDao;

    @Autowired
    public SkillManager(SkillDao skillDao, DtoConverterService dtoConverterService, ResumeDao resumeDao) {
        this.skillDao = skillDao;
        this.dtoConverterService = dtoConverterService;
        this.resumeDao = resumeDao;
    }


    @Override
    public Result add(SkillCreateDto skillCreateDto) {
        Skill skill = (Skill) dtoConverterService.dtoToEntity(skillCreateDto, Skill.class);
        skill.setResume(this.resumeDao.getById(skillCreateDto.getResumeId()));
        skillDao.save(skill);
        return new SuccessResult("Islem Basarili");
    }

    @Override
    public Result delete(int skillId) {
        if (!this.skillDao.existsById(skillId)) {
            return new ErrorResult("There is such skill is not found");
        }
        this.skillDao.deleteById(skillId);
        return new SuccessResult("Skill deleted");
    }

    @Override
    public DataResult<List<Skill>> findByResume_ResumeId(@RequestParam int resumeId) {
        if (!resumeDao.existsById(resumeId)) {
            return new ErrorDataResult<List<Skill>>("yoxdur bele sohbet");
        }
        return new SuccessDataResult<List<Skill>>("Var bele sohbet!", this.skillDao.findByResume_ResumeId(resumeId));
    }
}
