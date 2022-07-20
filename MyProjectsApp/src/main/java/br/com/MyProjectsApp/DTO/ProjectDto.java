package br.com.MyProjectsApp.DTO;

import br.com.MyProjectsApp.DTO.Employer.Get.EmployerGetDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private LocalDate timeCreated = LocalDate.now();

}
