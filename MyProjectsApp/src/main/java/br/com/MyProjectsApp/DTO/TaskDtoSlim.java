package br.com.MyProjectsApp.DTO;

import br.com.MyProjectsApp.DTO.Employer.EmployerSlimDto;
import br.com.MyProjectsApp.Model.Employer;
import br.com.MyProjectsApp.Model.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class TaskDtoSlim {
    @JsonProperty("Id")
    private Long id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("Dev")
    private EmployerSlimDto devEncarregado;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("Time created ")
    private LocalDate timeCreated;
}
