package br.com.MyProjectsApp.DTO.Employer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Data
public class PersonalDataDto {

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
