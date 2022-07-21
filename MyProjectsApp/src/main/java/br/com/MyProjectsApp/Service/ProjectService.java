package br.com.MyProjectsApp.Service;

import br.com.MyProjectsApp.Controller.Form.Project.ProjectForm;
import br.com.MyProjectsApp.DTO.ProjectDto;
import br.com.MyProjectsApp.Mapper.ProjectMapper;
import br.com.MyProjectsApp.Model.Project;
import br.com.MyProjectsApp.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectMapper projectMapper;

    //create project
    public ProjectDto createProject(@Valid ProjectForm projectForm){
        boolean verifyIfExistProject = verifyIfExistProject(projectForm.getName());
        if(verifyIfExistProject){
            return null;
        }
        ProjectDto projectDto = projectForm.formToProjectDto();
        Project projectForSave = projectMapper.projectDtoToProject(projectDto);
        Project savedProject = projectRepository.save(projectForSave);
        return projectMapper.projectToProjectDto(savedProject);
    }

    public boolean verifyIfExistProject(String name) {
        Optional<Project> optionalProject = Optional.ofNullable(projectRepository.findByName(name));
        if(optionalProject.isPresent()){
            return true;
        }
        return false;
    }

    //update project
    public ProjectDto updateProject(Long id , ProjectDto projectDto){
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()){
            ProjectDto projectDtoUpdated = updatingProject(optionalProject.get(), projectDto);
            return projectDtoUpdated;
        }
        return null;
    }

    private ProjectDto updatingProject(Project project, ProjectDto projectDto) {
        Project projectDtoToProject = projectMapper.projectDtoToProject(projectDto);
        project.setDescription(projectDtoToProject.getDescription());
        project.setName(projectDtoToProject.getName());
        Project updatedProject = projectRepository.save(project);
        return projectMapper.projectToProjectDto(updatedProject);
    }

    //return all projects
    public List<ProjectDto> getAll() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::projectToProjectDto)
                .collect(Collectors.toList());
    }

    //return a project by id
    public ProjectDto getById(Long id){
        Optional<ProjectDto> projectOptional = projectRepository.findById(id).map(projectMapper::projectToProjectDto);
        if (projectOptional.isPresent()){
            return projectOptional.get();
        }
        return null;
    }

    //delete a project by id
    public ProjectDto deleteById(Long id){
        Optional<Project> projectRepositoryById = projectRepository.findById(id);
        if (projectRepositoryById.isPresent()){
            projectRepository.deleteById(id);
            return projectMapper.projectToProjectDto(projectRepositoryById.get());
        }
        return null;
    }
}
