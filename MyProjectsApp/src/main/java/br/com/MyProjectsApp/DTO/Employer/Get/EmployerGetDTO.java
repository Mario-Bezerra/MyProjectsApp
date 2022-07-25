package br.com.MyProjectsApp.DTO.Employer.Get;

import br.com.MyProjectsApp.DTO.Employer.PersonalDataDto;
import br.com.MyProjectsApp.DTO.ProjectDtoSlim;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class EmployerGetDTO {

    private Long id;
    @NotNull @JsonProperty("PersonalData")
    private PersonalDataDto personalData;
    @NotNull @JsonProperty("EnterpriseData")
    private EnterpriseDataGetDto enterpriseData;
    @JsonProperty("Project")
    private ProjectDtoSlim project;
}
