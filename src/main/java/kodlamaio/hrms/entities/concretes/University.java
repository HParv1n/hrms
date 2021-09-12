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
@Table(name = "university")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "university_id")
    private Integer universityId;


    @Column(name = "university_name")
    @NotNull
    @NotBlank
    private String universityName;

    @Column(name = "department_name")
    @NotNull
    @NotBlank
    private String departmentName;

    @Column(name = "starting_date")
    @NotNull
    @NotBlank
    private String startingDate;

    @Column(name = "graduate_date", nullable = true)
    @NotNull
    private String graduateDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
