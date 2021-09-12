package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cover_letters")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
public class CoverLetter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "cover_letter_id")
    private Integer coverLetterId;

    @Column(name = "resume_description")
    private String ResumeDescription;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;
}
