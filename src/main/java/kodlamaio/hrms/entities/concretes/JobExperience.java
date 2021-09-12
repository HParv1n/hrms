package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experiences")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "job_experience_id")
    private Integer jobExperienceId;

    @Column(name = "work_place_name")
    @NotNull
    @NotBlank
    private String workplaceName;

    @Column(name = "position_name")
    @NotNull
    @NotBlank
    private String positionName;

    @Column(name = "starting_date")
    @NotNull
    @NotBlank
    private String startingDate;

    @Column(name = "end_date", nullable = true)
    @NotNull
    @NotBlank
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
