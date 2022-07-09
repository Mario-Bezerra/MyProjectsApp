package br.com.MyProjectsApp.Model.BaseModelEmployer;

import br.com.MyProjectsApp.Model.Employer;
import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class EnterpriseData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String password;
    private String cargo;
    @OneToOne
    private Employer employer;
    public EnterpriseData() {
    }
}
