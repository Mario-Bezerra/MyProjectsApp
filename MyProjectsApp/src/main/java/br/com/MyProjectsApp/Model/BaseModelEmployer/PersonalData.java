package br.com.MyProjectsApp.Model.BaseModelEmployer;

import br.com.MyProjectsApp.Model.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PersonalData {

    private String name;
    private String cpf;
    @Embedded
    private Endereco endereco;
    private LocalDate dataDeNascimento;

}
