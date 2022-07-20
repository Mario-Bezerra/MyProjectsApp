package br.com.MyProjectsApp.Repositories;

import br.com.MyProjectsApp.Model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {

    Employer findByPersonalDataCpf(String cpf);
}