package kodlamaio.hrms.entities.dtos.createDtos;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class SocialMediaCreateDto {

    private int resumeId;

    @NotNull
    private String githubAddress;

    @NotNull
    private String linkedinAdress;

    @NotNull
    private String facebookAddress;
}
