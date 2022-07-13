package br.com.MyProjectsApp.Service.DTO;

import br.com.MyProjectsApp.Service.DTO.Employer.Get.EmployerGetDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
public class ProjectDto {

    @JsonProperty("Id")
    private Long id;
    @NotNull
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Tasks")
    private Collection<TaskDto> tasks;
    @JsonProperty("Employers")
    private Collection<EmployerGetDTO> employers;
}
