package br.com.MyProjectsApp.DTO.Employer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class EnderecoDto {

    @NotNull
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;

    public EnderecoDto(String cep) {
        this.cep = cep;
    }
}
