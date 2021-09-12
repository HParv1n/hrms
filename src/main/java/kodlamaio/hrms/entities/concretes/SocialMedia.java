package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "social_media")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "resume"})
public class SocialMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "social_media_id")
    private Integer socialMediaId;

    @Column(name = "github_address")
    @NotNull
    private String githubAddress;

    @Column(name = "linkedin_address")
    @NotNull
    private String linkedinAdress;

    @Column(name = "facebook_address")
    @NotNull
    private String facebookAddress;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Resume resume;

}
