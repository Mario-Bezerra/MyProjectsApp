package br.com.MyProjectsApp.Service;

import br.com.MyProjectsApp.DTO.TaskDto;
import br.com.MyProjectsApp.Mapper.TaskMapper;
import br.com.MyProjectsApp.Model.Task;
import br.com.MyProjectsApp.Repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMapper taskMapper;

    public TaskDto addTask(TaskDto taskDto){
        boolean verifyIfTaskExist = verifyIfTaskExist(taskDto.getId());
        if (verifyIfTaskExist){
            return null;
        }
        Task taskDtoToTask = taskMapper.taskDtoToTask(taskDto);
        Task savedTask = taskRepository.save(taskDtoToTask);
        return taskMapper.taskToDto(savedTask);
    }

    public boolean verifyIfTaskExist(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()){
            return true;
        }
        return false;
    }

    public void deleteTask(Long id){
        if (verifyIfTaskExist(id)){
        taskRepository.deleteById(id);
        }
    }

    public void updateTask(Long id , TaskDto taskDto){
        Task taskUpdate = taskMapper.taskDtoToTask(taskDto);
        taskRepository.save(taskUpdate);
    }

    public List<TaskDto> getAll() {
        return taskRepository.findAll()
                .stream()
                .map(taskMapper::taskToDto)
                .collect(Collectors.toList());
    }

    public TaskDto getById(Long id){
        Optional<TaskDto> taskRepositoryById = taskRepository.findById(id).map(taskMapper::taskToDto);
        if(taskRepositoryById.isPresent()){
            return taskRepositoryById.get();
        }

        return null;
    }
}
