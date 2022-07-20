package br.com.MyProjectsApp.DTO.Employer.Post;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class EnterpriseDataPostDto {

    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String cargo;

    public EnterpriseDataPostDto(String username, String password, String cargo) {
        this.username = username;
        this.password = password;
        this.cargo = cargo;
    }
}
