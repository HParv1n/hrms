package kodlamaio.hrms.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_ad_activation")
public class JobAdActivation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "jobad_activation_id")
    private Integer jobAdActivationId;

    @Column(name = "personnel_id")
    private Integer personnelId;

    @Column(name = "confirm")
    private boolean confirm;

    @Column(name = "confirm_date")
    private LocalDate confirmDate;

}
