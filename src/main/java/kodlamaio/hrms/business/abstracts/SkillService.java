package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utils.result.DataResult;
import kodlamaio.hrms.core.utils.result.Result;
import kodlamaio.hrms.entities.concretes.Skill;
import kodlamaio.hrms.entities.dtos.createDtos.SkillCreateDto;

import java.util.List;

public interface SkillService {

    Result add(SkillCreateDto skillCreateDto);

    Result delete(int skillId);

    DataResult<List<Skill>> findByResume_ResumeId(int resumeId);

}
