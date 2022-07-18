package br.com.MyProjectsApp.DTO.Employer.Post;

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
}
