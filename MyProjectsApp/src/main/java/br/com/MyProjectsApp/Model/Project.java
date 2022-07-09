package br.com.MyProjectsApp.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "projects")
@Data
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
    private Collection<Task> tasks;
    @OneToMany(fetch = FetchType.LAZY )
    private Collection<Employer> employers;


}
