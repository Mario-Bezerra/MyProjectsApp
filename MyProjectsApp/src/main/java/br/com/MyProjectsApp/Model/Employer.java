package br.com.MyProjectsApp.Model;

import br.com.MyProjectsApp.Model.BaseModelEmployer.EnterpriseData;
import br.com.MyProjectsApp.Model.BaseModelEmployer.PersonalData;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Employer {

    @Id @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_data_id")
    private PersonalData personalData;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enterprise_data_id")
    private EnterpriseData enterpriseData;
    @ManyToOne
    private Project project;

}
