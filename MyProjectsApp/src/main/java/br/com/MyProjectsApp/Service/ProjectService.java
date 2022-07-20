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

    public void updateAEmployer(Long id , ProjectDto projectDto){
        Project projectUpdated = projectMapper.projectDtoToProject(projectDto);
        projectRepository.save(projectUpdated);
    }

    public void deleteEmployer(Long id){
       return;
    }

    public List<ProjectDto> getAll() {
        return projectRepository.findAll()
                .stream()
                .map(projectMapper::projectToProjectDto)
                .collect(Collectors.toList());
    }

    public ProjectDto getById(Long id){
        Optional<ProjectDto> projectOptional = projectRepository.findById(id).map(projectMapper::projectToProjectDto);
        if (projectOptional.isPresent()){
            return projectOptional.get();
        }
        return null;
    }
}
