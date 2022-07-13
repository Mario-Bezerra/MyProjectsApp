package br.com.MyProjectsApp.Service.DTO.Employer;

import br.com.MyProjectsApp.Model.BaseModelEmployer.Endereco;
import br.com.MyProjectsApp.Model.Employer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
public class PersonalDataDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("cpf")
    @NotNull
    private String cpf;

    @JsonProperty("adress")
    private EnderecoDto endereco;

    @JsonProperty("birthDate")
    @NotNull
    private LocalDate dataDeNascimento;
}
