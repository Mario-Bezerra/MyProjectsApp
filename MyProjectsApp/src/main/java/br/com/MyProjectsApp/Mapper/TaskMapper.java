package br.com.MyProjectsApp.Mapper;

import br.com.MyProjectsApp.DTO.TaskDto;
import br.com.MyProjectsApp.DTO.TaskDtoSlim;
import br.com.MyProjectsApp.Model.Task;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper( componentModel = "spring" )
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDto taskToDto(Task task);
    Task taskDtoToTask(TaskDto taskDto);
    TaskDtoSlim taskToDtoSlim(Task task);

}
