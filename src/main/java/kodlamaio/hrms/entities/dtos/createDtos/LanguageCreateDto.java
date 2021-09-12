package kodlamaio.hrms.entities.dtos.createDtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageCreateDto {

    private int resumeId;

    @NotNull
    @NotBlank
    private String languageName;

    @NotNull
    @NotBlank
    private String languageLevel;
}
