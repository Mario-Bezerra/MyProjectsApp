package br.com.MyProjectsApp.DTO;

import br.com.MyProjectsApp.DTO.Employer.EmployerSlimDto;
import br.com.MyProjectsApp.Model.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TaskDto {

    @JsonProperty("Id")
    private Long id;
    @NotNull
    @JsonProperty("Project")
    private ProjectDtoSlim project;
    @JsonProperty("Dev")
    private EmployerSlimDto devEncarregado;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("Time created ")
    private LocalDate timeCreated;
    @JsonProperty("Description") @NotNull
    private String description;
    @JsonProperty("Name") @NotNull
    private String name;

    public TaskDto(ProjectDtoSlim projectDtoSlim, String name, String description) {
        this.setProject(projectDtoSlim);
        this.setName(name);
        this.setDescription(description);
    }
}
