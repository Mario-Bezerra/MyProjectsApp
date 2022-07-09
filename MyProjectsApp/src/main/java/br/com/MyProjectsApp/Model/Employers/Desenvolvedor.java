package br.com.MyProjectsApp.Model.Employers;

import br.com.MyProjectsApp.Model.Employer;
import br.com.MyProjectsApp.Model.Task;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.OneToMany;

@Data
@EqualsAndHashCode(callSuper=false)
public class Desenvolvedor extends Employer {

    @OneToMany(mappedBy = "devEncarregado")
    private Task task;

    public Desenvolvedor() {
        this.getEnterpriseData().setCargo("developer");
    }
}
