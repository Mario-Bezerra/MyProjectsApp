package br.com.MyProjectsApp.Service.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Collection;
@Data
public class ProjectDtoSlim {

    @JsonProperty("Id")
    private Long id;
    @JsonProperty("Name")
    private String name;


}
