package br.com.MyProjectsApp.Controller.Form.Task;

import br.com.MyProjectsApp.DTO.ProjectDtoSlim;
import br.com.MyProjectsApp.DTO.TaskDto;
import br.com.MyProjectsApp.Mapper.ProjectMapper;
import br.com.MyProjectsApp.Model.Project;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class TaskForm {
    @NotNull
    private String description;
    @NotNull
    private String name;
    @NotNull
    private Long projectId;
    public TaskDto taskFormByProjectToDto(Project project, ProjectMapper mapper){
        ProjectDtoSlim projectDtoSlim = mapper.projectToDtoSlim(project);
        return new TaskDto(projectDtoSlim , name , description);
    }
}
