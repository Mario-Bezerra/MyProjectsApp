package br.com.MyProjectsApp.Model;

import br.com.MyProjectsApp.Model.BaseModelEmployer.EnterpriseData;
import br.com.MyProjectsApp.Model.BaseModelEmployer.PersonalData;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
public class Employer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private PersonalData personalData;
    @Embedded
    private EnterpriseData enterpriseData;
    @ManyToOne
    private Project project;
    @OneToMany
    private Collection<Task> tasks;

    public Employer(PersonalData personalData, EnterpriseData enterpriseData, Project project, Collection<Task> tasks) {
        this.personalData = personalData;
        this.enterpriseData = enterpriseData;
        this.project = project;
        this.tasks = tasks;
    }
}
