package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employer_update")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "employer_update_id")
    private Integer employerUpdateId;

    @Column(name = "employer_id")
    private Integer employerId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "web_address")
    private String webAddress;

    @Column(name = "create_day")
    @JsonIgnore
    private LocalDate createDate;

    @Column(name = "verify_date")
    @JsonIgnore
    private LocalDate verifyDate;

    @Column(name = "personnel_id")
    @JsonIgnore
    private Integer personnelId;

    @Column(name = "verified")
    @JsonIgnore
    private boolean verified;


}
