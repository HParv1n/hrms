package kodlamaio.hrms.entities.dtos.createDtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCreateDto {

    private String email;
    private String password;
    private String ConfirmPassword;
    private String firstName;
    private String lastName;
    private String identityNumber;
    private Date birthDate;
}
