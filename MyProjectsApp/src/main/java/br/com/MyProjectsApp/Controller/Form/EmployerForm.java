package br.com.MyProjectsApp.Controller.Form;

import br.com.MyProjectsApp.DTO.Employer.EnderecoDto;
import br.com.MyProjectsApp.DTO.Employer.PersonalDataDto;
import br.com.MyProjectsApp.DTO.Employer.Post.EmployerPostDTO;
import br.com.MyProjectsApp.DTO.Employer.Post.EnterpriseDataPostDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class EmployerForm {

    //Personal data
    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
    @NotBlank
    private String cep;
    @NotBlank
    private String birthDate;
    //Enterprise data
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String cargo;

    public EmployerPostDTO getEmployerPostDto() {
        return new EmployerPostDTO(new PersonalDataDto(name,
                                                       cpf ,
                                                       new EnderecoDto(cep),
                                                       LocalDate.parse(birthDate)),
                                  new EnterpriseDataPostDto(username,
                                                            password,
                                                            cargo));
    }
}
