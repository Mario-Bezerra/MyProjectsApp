package br.com.MyProjectsApp.Repositories;

import br.com.MyProjectsApp.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findByName(String name);
}