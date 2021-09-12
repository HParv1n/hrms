package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisement")
public class JobAdvertisement {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "job_advert_id")
    private Integer jobAdvertId;

    @Column(name = "job_advertisement_name", nullable = false)
    @NotNull
    @NotBlank
    private String jobAdvertisementName;

    @Column(name = "job_description", nullable = false)
    @NotNull
    @NotBlank
    private String jobDescription;

    @Column(name = "min_salary", nullable = false)
    @NotNull
    private String minSalary;

    @Column(name = "max_salary", nullable = false)
    @NotNull
    private String maxSalary;

    @Column(name = "create_date", nullable = false)
    private LocalDate createDate;

    @Column(name = "last_date", nullable = false)
    private LocalDate lastDate;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    private boolean confirmed;

    @ManyToOne()
    @JoinColumn(name = "jobtitle_id")
    private JobTitle jobTitle;


    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;


    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

}
