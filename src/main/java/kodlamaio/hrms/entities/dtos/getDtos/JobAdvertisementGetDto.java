package kodlamaio.hrms.entities.dtos.getDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementGetDto {

    private String employerName;
    private String jobTitleTitle;
    private Date createdDate;
    private Date lastDate;

}
