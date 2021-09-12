package kodlamaio.hrms.entities.dtos.createDtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CityCreateDto {


    @NotNull
    @NotBlank
    private String cityName;
}
