package br.com.MyProjectsApp.Repositories;

import br.com.MyProjectsApp.Model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}