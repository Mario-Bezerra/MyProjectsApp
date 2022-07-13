package br.com.MyProjectsApp.Service.DTO.Employer.Get;

import br.com.MyProjectsApp.Service.DTO.Employer.PersonalDataDto;
import br.com.MyProjectsApp.Service.DTO.ProjectDto;
import br.com.MyProjectsApp.Service.DTO.ProjectDtoSlim;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class EmployerGetDTO {

    private Long id;
    @NotNull @JsonProperty("Personal Data")
    private PersonalDataDto personalData;
    @NotNull @JsonProperty("Enterprise Data")
    private EnterpriseDataGetDto enterpriseData;
    @JsonProperty("Project")
    private ProjectDtoSlim project;
}
