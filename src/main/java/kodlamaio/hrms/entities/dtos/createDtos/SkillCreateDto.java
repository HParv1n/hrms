package kodlamaio.hrms.entities.dtos.createDtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SkillCreateDto {

    private int resumeId;

    @NotNull
    @NotBlank
    private String skillName;
}
