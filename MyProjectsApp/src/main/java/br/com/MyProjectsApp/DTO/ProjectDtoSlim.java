package br.com.MyProjectsApp.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDtoSlim {

    @JsonProperty("Id")
    private Long id;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("TimeCreated")
    private LocalDate timeCreated;
    @JsonProperty("Description")
    private String description;

}
