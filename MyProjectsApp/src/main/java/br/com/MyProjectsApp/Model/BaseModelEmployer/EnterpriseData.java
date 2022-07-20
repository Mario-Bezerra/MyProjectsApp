package br.com.MyProjectsApp.Model.BaseModelEmployer;

import br.com.MyProjectsApp.Model.Employer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class EnterpriseData {

    private String username;
    private String password;
    private String cargo;
}
