package br.com.MyProjectsApp.Model.BaseModelEmployer;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Data
@Embeddable
@NoArgsConstructor
public class Endereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;

    public Endereco(String cep, String localidade, String uf) {
        this.cep = cep;
        this.localidade = localidade;
        this.uf = uf;
    }
}
