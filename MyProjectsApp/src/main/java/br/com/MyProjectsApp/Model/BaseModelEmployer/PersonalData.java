package br.com.MyProjectsApp.Model.BaseModelEmployer;

import br.com.MyProjectsApp.Model.Employer;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class PersonalData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String cpf;
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    private LocalDate dataDeNascimento;
    @OneToOne
    private Employer employer;


    public PersonalData() {
    }
}
