package br.com.MyProjectsApp.Service.DTO;

import br.com.MyProjectsApp.Model.Employer;
import br.com.MyProjectsApp.Model.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TaskDtoSlim {
    @JsonProperty("Id")
    private Long id;
    @NotNull
    @JsonProperty("Dev")
    private Employer devEncarregado;
    @JsonProperty("Status")
    private Status status;
}
