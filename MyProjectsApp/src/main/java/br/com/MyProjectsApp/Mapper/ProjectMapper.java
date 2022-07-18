package br.com.MyProjectsApp.Mapper;

import br.com.MyProjectsApp.DTO.ProjectDto;
import br.com.MyProjectsApp.DTO.ProjectDtoSlim;
import br.com.MyProjectsApp.Model.Project;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper( componentModel = "spring" )
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectDto projectToProjectDto(Project project);

    Project projectDtoToProject(ProjectDto projectDto);

    ProjectDtoSlim projectToDtoSlim(Project project);

}
