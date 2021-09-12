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
@Table(name = "courses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "cours_name")
    @NotNull
    @NotBlank
    private String courseName;

    @Column(name = "department")
    @NotNull
    @NotBlank
    private String department;

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
