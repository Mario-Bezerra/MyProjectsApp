package br.com.MyProjectsApp.Model;

import br.com.MyProjectsApp.Model.BaseModelEmployer.EnterpriseData;
import br.com.MyProjectsApp.Model.BaseModelEmployer.PersonalData;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
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

}
