package kodlamaio.hrms.entities.dtos.createDtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceCreateDto {

    private int resumeId;

    @NotNull
    @NotBlank
    private String workplaceName;

    @NotNull
    @NotBlank
    private String positionName;

    @NotNull
    @NotBlank
    private String startingDate;

    @NotNull
    @NotBlank
    private String endDate;
}
