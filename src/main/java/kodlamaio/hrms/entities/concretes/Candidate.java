package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "user_id")
public class Candidate extends User {


    @Column(name = "first_name", nullable = false)
    @NotNull
    @NotBlank
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotNull
    @NotBlank
    private String lastName;

    @Column(name = "identity_number", nullable = false)
    @NotNull
    @NotBlank
    private String identityNumber;

    @Column(name = "email", nullable = false)
    @NotNull
    @NotBlank
    private String email;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

//    @JsonIgnore
//    @OneToOne(mappedBy = "candidate")
//    private Resume resume;
//   ---------------------- BUNA GEREK VAR YA YOX ONU ARASDIR

}
