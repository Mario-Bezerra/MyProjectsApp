package br.com.MyProjectsApp.Service;

import br.com.MyProjectsApp.Model.Employer;
import br.com.MyProjectsApp.Repositories.EmployerRepository;
import br.com.MyProjectsApp.Service.DTO.EmployerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    public void addEmployer(Employer employer){
        employerRepository.save(employer);
    }

    public void updateAEmployer(Long id , EmployerDTO employer){

    }

    public void deleteEmployer(Long id){
        employerRepository.deleteById(id);
    }


}

