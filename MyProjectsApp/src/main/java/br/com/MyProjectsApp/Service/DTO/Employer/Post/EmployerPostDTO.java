package br.com.MyProjectsApp.Service.DTO.Employer.Post;

import br.com.MyProjectsApp.Service.DTO.Employer.PersonalDataDto;
import br.com.MyProjectsApp.Service.DTO.ProjectDto;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class EmployerPostDTO {

    private Long id;
    @NotNull
    private PersonalDataDto personalData;
    @NotNull
    private EnterpriseDataPostDto enterpriseData;
    private ProjectDto project;
}
