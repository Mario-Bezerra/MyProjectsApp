package br.com.MyProjectsApp.Controller;

import br.com.MyProjectsApp.Controller.Form.Task.TaskForm;
import br.com.MyProjectsApp.DTO.TaskDto;
import br.com.MyProjectsApp.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAll(){
        List<TaskDto> allProjects = taskService.getAll();
        return ResponseEntity.ok(allProjects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getById(@PathVariable(name = "id") Long id ){
        TaskDto taskDto = taskService.getById(id);
        if (taskDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(taskDto);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TaskDto> postTask(@RequestBody @Valid TaskForm form){

        TaskDto taskDto = taskService.createTask(form);
        return ResponseEntity.ok(taskDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TaskDto> updateEmployer(@PathVariable(name = "id") Long id,
                                                     @RequestBody @Valid TaskForm form){
        TaskDto projectDtoUpdated = taskService.updateTask(id, form);
        if (projectDtoUpdated == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(projectDtoUpdated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TaskDto> deleteEmployer(@PathVariable(name = "id") Long id){
        TaskDto taskDto = taskService.deleteTask(id);
        if(taskDto == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(taskDto);
    }
}
