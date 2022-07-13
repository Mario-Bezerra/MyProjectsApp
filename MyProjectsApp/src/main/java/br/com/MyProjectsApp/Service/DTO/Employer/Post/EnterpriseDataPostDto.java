package br.com.MyProjectsApp.Service.DTO.Employer.Post;

import br.com.MyProjectsApp.Service.DTO.Employer.Get.EmployerGetDTO;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EnterpriseDataPostDto {

    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String cargo;
    @NotNull
    private EmployerGetDTO employer;
}
