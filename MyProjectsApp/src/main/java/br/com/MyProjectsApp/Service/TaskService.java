package br.com.MyProjectsApp.Service;

import br.com.MyProjectsApp.Controller.Form.Task.TaskForm;
import br.com.MyProjectsApp.DTO.TaskDto;
import br.com.MyProjectsApp.Mapper.ProjectMapper;
import br.com.MyProjectsApp.Mapper.TaskMapper;
import br.com.MyProjectsApp.Model.Project;
import br.com.MyProjectsApp.Model.Task;
import br.com.MyProjectsApp.Repositories.ProjectRepository;
import br.com.MyProjectsApp.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private ProjectMapper projectMapper;

    public TaskDto createTask(TaskForm taskForm){
        Optional<Project> optionalProject = projectRepository.findById(taskForm.getProjectId());
        if(optionalProject.isPresent()){
            boolean verifyIfExistProject = verifyIfTaskExist(taskForm.getName(), taskForm.getProjectId());
            Project project = optionalProject.get();
            if(verifyIfExistProject){
                return null;
            }
            TaskDto taskDto = taskForm.taskFormByProjectToDto(project, projectMapper);
            Task taskToSave = taskMapper.taskDtoToTask(taskDto);
            Task taskSaved = taskRepository.save(taskToSave);
            return taskMapper.taskToDto(taskSaved);
        }

        return null;
    }

    public boolean verifyIfTaskExist(String name, @NotNull Long projectId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if (projectOptional.isPresent()){
            for (Task task : projectOptional.get().getTasks()) {
                if (task.getName().equals(name)) return true;
            }
            return false;
        }
        return false;
    }

    public TaskDto deleteTask(Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()){
            TaskDto taskDto = taskMapper.taskToDto(optionalTask.get());
            taskRepository.deleteById(id);
            return taskDto;
        }
        return null;
    }

    public TaskDto updateTask(Long taskId , TaskForm taskForm){
        Optional<Project> projectById = projectRepository.findById(taskForm.getProjectId());
        if (projectById.isPresent()){
            Project project = projectById.get();
            TaskDto taskDto = taskForm.taskFormByProjectToDto(project, projectMapper);
            Optional<Task> optionalTask = taskRepository.findById(taskId);
            if (optionalTask.isPresent()){
                return updatingTask(optionalTask.get(), taskDto);
            }
        }
        return null;
    }

    private TaskDto updatingTask(Task task, TaskDto taskDto) {
        task.setDescription(taskDto.getDescription());
        task.setName(taskDto.getName());
        taskRepository.save(task);
        return taskMapper.taskToDto(task);
    }

    public List<TaskDto> getAll() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::taskToDto)
                .collect(Collectors.toList());
    }

    public TaskDto getById(Long id){
        Optional<TaskDto> taskRepositoryById = taskRepository.findById(id).map(taskMapper::taskToDto);
        return taskRepositoryById.orElse(null);

    }
}
