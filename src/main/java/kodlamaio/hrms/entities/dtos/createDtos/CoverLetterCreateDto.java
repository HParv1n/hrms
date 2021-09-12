package kodlamaio.hrms.entities.dtos.createDtos;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CoverLetterCreateDto {

    private int resumeId;

    @NotNull
    @NotBlank
    private String ResumeDescription;
}
