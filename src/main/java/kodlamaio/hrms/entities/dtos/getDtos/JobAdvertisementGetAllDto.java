package kodlamaio.hrms.entities.dtos.getDtos;

import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementGetAllDto {


    private String jobDescription;

    private String minSalary;

    private String maxSalary;

    private Date lastDate;

    private Date createDate;

    private String jobAdvertisementName;

    private JobTitle jobTitleName;

    private Employer employerName;

    private City cityName;
}
