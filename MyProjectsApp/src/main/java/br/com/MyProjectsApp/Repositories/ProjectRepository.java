package br.com.MyProjectsApp.Repositories;

import br.com.MyProjectsApp.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}