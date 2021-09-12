package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "employer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "JobAdvertisement"})
public class Employer extends User {


    @Column(name = "company_name", nullable = false)
    @NotNull
    @NotBlank
    private String companyName;

    @Column(name = "web_address", nullable = false)
    @NotNull
    @NotBlank
    private String webAddress;

    @Column(name = "phone_number", nullable = false)
    @NotNull
    @NotBlank
    private String phoneNumber;

    @Column(name = "is_actived")
    @NotNull
    private boolean isActive;

    @Column(name = "waiting_update")
    @NotNull
    private boolean waitingUpdate;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;
}
