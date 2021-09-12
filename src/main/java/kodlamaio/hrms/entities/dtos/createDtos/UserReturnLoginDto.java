package kodlamaio.hrms.entities.dtos.createDtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReturnLoginDto {

    private int userReturnLoginId;
    private String name;
    private String email;
    private int userType;

}
