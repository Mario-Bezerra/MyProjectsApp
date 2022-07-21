/*package br.com.MyProjectsApp.Controller;

import br.com.MyProjectsApp.Controller.Form.Project.ProjectForm;
import br.com.MyProjectsApp.DTO.ProjectDto;
import br.com.MyProjectsApp.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAll(){
        List<ProjectDto> allProjects = projectService.getAll();
        return ResponseEntity.ok(allProjects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable(name = "id") Long id ){
        ProjectDto projectByid = projectService.getById(id);
        if (projectByid == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projectByid);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProjectDto> postEmployer(@RequestBody @Valid ProjectForm form){

        ProjectDto employerSaved = projectService.createProject(form);
        return ResponseEntity.ok(employerSaved);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectDto> updateEmployer(@PathVariable(name = "id") Long id,
                                                     @RequestBody @Valid EmployerForm employerForm){
        EmployerPostDTO employerPostDTO = employerForm.getEmployerPostDto();
        ProjectDto projectDto =
        return ResponseEntity.ok(projectDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ProjectDto> deleteEmployer(@PathVariable(name = "id") Long id){
        ProjectDto projectDto =
        if(projectDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(projectDto);
    }
}*/
