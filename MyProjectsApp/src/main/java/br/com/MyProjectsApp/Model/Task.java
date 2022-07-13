package br.com.MyProjectsApp.Model;

import br.com.MyProjectsApp.Model.Employers.Desenvolvedor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "task")
@Data
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @ManyToOne
    private Project project;
    @ManyToOne(fetch = FetchType.LAZY)
    private Employer devEncarregado ;
    @Enumerated(EnumType.STRING)
    private Status status = Status.AGUARDANDO;
}
