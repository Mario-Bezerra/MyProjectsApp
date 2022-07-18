package br.com.MyProjectsApp.Model;

import br.com.MyProjectsApp.Model.Employers.Desenvolvedor;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "task")
@Data
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Project project;
    @ManyToOne
    private Employer devEncarregado ;
    @Enumerated(EnumType.STRING)
    private Status status = Status.AGUARDANDO;
    private LocalDate timeCreated;
    private String description;
    private String name;
}
