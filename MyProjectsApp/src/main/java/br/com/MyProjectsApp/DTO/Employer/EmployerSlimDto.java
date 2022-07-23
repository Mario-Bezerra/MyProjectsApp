package br.com.MyProjectsApp.DTO.Employer;

import br.com.MyProjectsApp.DTO.Employer.Get.EnterpriseDataGetDto;
import br.com.MyProjectsApp.Model.BaseModelEmployer.PersonalData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EmployerSlimDto {

    private Long id;
    @JsonProperty("Personal Data")
    private PersonalDataSlim personalData;
    @JsonProperty("Enterprise Data")
    private EnterpriseDataSlimDto enterpriseData;
}
