package br.com.MyProjectsApp.DTO.Employer;

import br.com.MyProjectsApp.Model.BaseModelEmployer.PersonalData;
import lombok.Data;

@Data
public class EmployerSlimDto {

    private Long id;
    private PersonalDataSlim personalData;
}
