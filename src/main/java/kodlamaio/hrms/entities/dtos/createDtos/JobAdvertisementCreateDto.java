package kodlamaio.hrms.entities.dtos.createDtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementCreateDto {

    private int employerId;
    private int jobTitleId;
    private int cityId;


    @NotNull
    @NotBlank
    private String jobAdvertisementName;

    @NotNull
    @NotBlank
    private String jobDescription;

    @NotNull
    @NotBlank
    private String minSalary;

    private boolean isActive;

    @NotNull
    @NotBlank
    private String maxSalary;

    private Date lastDate;

    private Date createDate;

}
