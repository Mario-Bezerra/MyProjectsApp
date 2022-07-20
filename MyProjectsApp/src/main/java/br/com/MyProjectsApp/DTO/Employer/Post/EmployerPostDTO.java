package br.com.MyProjectsApp.DTO.Employer.Post;

import br.com.MyProjectsApp.DTO.Employer.PersonalDataDto;
import br.com.MyProjectsApp.DTO.ProjectDtoSlim;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployerPostDTO {

    private Long id;
    @NotBlank
    private PersonalDataDto personalData;
    @NotBlank
    private EnterpriseDataPostDto enterpriseData;
    private ProjectDtoSlim project;

    public EmployerPostDTO(PersonalDataDto personalData, EnterpriseDataPostDto enterpriseData) {
        this.personalData = personalData;
        this.enterpriseData = enterpriseData;
    }
}
