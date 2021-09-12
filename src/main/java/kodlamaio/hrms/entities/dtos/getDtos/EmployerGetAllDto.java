package kodlamaio.hrms.entities.dtos.getDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerGetAllDto {

    private String companyName;
    private String webAddress;
    private String phoneNumber;
    private String email;

}
