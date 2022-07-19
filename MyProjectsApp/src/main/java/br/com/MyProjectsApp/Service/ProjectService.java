package br.com.MyProjectsApp.Service;

import br.com.MyProjectsApp.DTO.Employer.Get.EmployerGetDTO;
import br.com.MyProjectsApp.DTO.ProjectDto;
import br.com.MyProjectsApp.Mapper.ProjectMapper;
import br.com.MyProjectsApp.Model.Project;
import br.com.MyProjectsApp.Repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectMapper projectMapper;

    public ProjectDto createProject(ProjectDto projectDto){
        boolean verifyIfExistProject = verifyIfExistProject(projectDto.getId());
        if(verifyIfExistProject){
            return null;
        }
        Project dtoToProject = projectMapper.projectDtoToProject(projectDto);
        Project savedProject = projectRepository.save(dtoToProject);
        return projectMapper.projectToProjectDto(savedProject);
    }

    public boolean verifyIfExistProject(Long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
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
        if(verifyIfExistProject(id)){
        projectRepository.deleteById(id);
        }
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
