package br.com.MyProjectsApp.Model.BaseModelEmployer;

import br.com.MyProjectsApp.Model.Employer;
import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
public class EnterpriseData {

    private String username;
    private String password;
    private String cargo;

}
