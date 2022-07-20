package br.com.MyProjectsApp.Model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name = "tb_project")
@Data
@NoArgsConstructor
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    private Collection<Task> tasks;
    @OneToMany(fetch = FetchType.LAZY )
    private Collection<Employer> employers;
    private LocalDate timeCreated = LocalDate.now();
    private String description;

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
