package br.com.MyProjectsApp.DTO;

import br.com.MyProjectsApp.Model.Status;
import br.com.MyProjectsApp.DTO.Employer.Get.EmployerGetDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class TaskDto {

    @JsonProperty("Id")
    private Long id;
    @NotNull
    @JsonProperty("Project")
    private ProjectDtoSlim project;
    @JsonProperty("Dev")
    private EmployerGetDTO devEncarregado;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("Time created ")
    private LocalDate timeCreated;
    @JsonProperty("Description") @NotNull
    private String description;
    @JsonProperty("Name") @NotNull
    private String name;

}
