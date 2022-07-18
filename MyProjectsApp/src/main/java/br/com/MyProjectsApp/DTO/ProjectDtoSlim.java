package br.com.MyProjectsApp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;
@Data
public class ProjectDtoSlim {

    @JsonProperty("Id ")
    private Long id;
    @JsonProperty("Name ")
    private String name;
    @JsonProperty("Time created ")
    private LocalDate timeCreated;


}
