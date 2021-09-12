package kodlamaio.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resumes")
public class Resume {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "resume_id")
    private Integer resumeId;

    @OneToMany(mappedBy = "resume")
    private List<Skill> skills;

    @OneToMany(mappedBy = "resume")
    private List<SocialMedia> socialMedia;

    @OneToMany(mappedBy = "resume")
    private List<Photo> photos;

    @OneToMany(mappedBy = "resume")
    private List<Language> languages;

    @OneToMany(mappedBy = "resume")
    private List<JobExperience> jobExperiences;

    @OneToMany(mappedBy = "resume")
    private List<University> universities;

    @OneToMany(mappedBy = "resume")
    private List<Course> courses;

    @OneToMany(mappedBy = "resume")
    private List<CoverLetter> coverLetters;

    @OneToOne
    @NotNull
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;


}
