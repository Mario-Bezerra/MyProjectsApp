package br.com.MyProjectsApp.Controller.Form.Project;

import br.com.MyProjectsApp.DTO.ProjectDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class ProjectForm {

    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public ProjectDto formToProjectDto(){
        return new ProjectDto(name, description);
    }
}
