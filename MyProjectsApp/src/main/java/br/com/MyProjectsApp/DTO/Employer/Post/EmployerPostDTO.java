package br.com.MyProjectsApp.DTO.Employer.Post;

import br.com.MyProjectsApp.DTO.Employer.PersonalDataDto;
import br.com.MyProjectsApp.DTO.ProjectDtoSlim;
import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class EmployerPostDTO {

    private Long id;
    @NotNull
    private PersonalDataDto personalData;
    @NotNull
    private EnterpriseDataPostDto enterpriseData;
    private ProjectDtoSlim project;
}
