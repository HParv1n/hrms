package kodlamaio.hrms.entities.dtos.createDtos;

import kodlamaio.hrms.entities.concretes.JobTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JobAdvertisementFilterDto {
    List<Integer> cityId;
    List<Integer> jobtitleId;

}
