package br.com.MyProjectsApp.DTO.Employer;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EnderecoDto {

    @NotNull
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;
}
