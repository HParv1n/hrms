package kodlamaio.hrms.entities.dtos.createDtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerCreateDto {


    @NotNull
    @NotBlank
    private String companyName;

    @NotNull
    @NotBlank
    private String webAddress;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^(05)([0-9])\\s?([0-9]{3})\\s?([0-9]{2})\\s?([0-9]{2})$")
    private String phoneNumber;

    @NotNull
    @NotBlank
    @Email(message = "{hrms.constraints.Email.message}")
    private String email;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "{hrms.constraint.password.Pattern.messsage}")
    private String password;

    @NotNull
    @NotBlank
    private String confirmPassword;

}
