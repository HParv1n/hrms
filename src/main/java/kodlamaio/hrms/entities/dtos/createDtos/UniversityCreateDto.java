package kodlamaio.hrms.entities.dtos.createDtos;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UniversityCreateDto {

    private int resumeId;

    @NotNull
    @NotBlank
    private String universityName;

    @NotNull
    @NotBlank
    private String departmentName;

    @NotNull
    @NotBlank
    private String startingDate;

    @NotNull
    private String graduateDate;

}
