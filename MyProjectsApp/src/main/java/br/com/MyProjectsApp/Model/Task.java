package br.com.MyProjectsApp.Model;

import br.com.MyProjectsApp.Model.Employers.Desenvolvedor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
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

    public Task(Project project, Employer devEncarregado, Status status, LocalDate timeCreated, String description, String name) {
        this.project = project;
        this.devEncarregado = devEncarregado;
        this.status = status;
        this.timeCreated = timeCreated;
        this.description = description;
        this.name = name;
    }
}
