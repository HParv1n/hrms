package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "activation_by_personnel")
public class ActivationByPersonnel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "activation_by_personnel_id")
    private Integer activationByPersonnelId;

    @Column(name = "employe_id")
    private Integer employeeId;

    @Column(name = "personel_id")
    private Integer personnelId;

    @Column(name = "verified")
    private boolean verified;

    @Column(name = "verify_date")
    private LocalDate verifyDate;
}
