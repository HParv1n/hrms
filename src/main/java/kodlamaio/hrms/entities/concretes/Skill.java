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
@Table(name = "skills")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "skill_id")
    private Integer skillId;

    @Column(name = "skill_name")
    @NotNull
    @NotBlank
    private String skillName;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
