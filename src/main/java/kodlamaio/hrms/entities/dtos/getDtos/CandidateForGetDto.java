package kodlamaio.hrms.entities.dtos.getDtos;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class CandidateForGetDto {

    private String firstName;
    private String lastName;
    private String email;
    private int birthDate;
}
