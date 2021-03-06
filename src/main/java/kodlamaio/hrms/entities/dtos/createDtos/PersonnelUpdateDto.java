package kodlamaio.hrms.entities.dtos.createDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonnelUpdateDto {

    private int personnelId;
    private String firstName;
    private String lastName;
    private String email;
}
