package br.com.MyProjectsApp.Service;

import br.com.MyProjectsApp.Mapper.EmployerMapper;
import br.com.MyProjectsApp.Model.Employer;
import br.com.MyProjectsApp.Repositories.EmployerRepository;
import br.com.MyProjectsApp.DTO.Employer.Get.EmployerGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private EmployerMapper employerMapper;

    public void addEmployer(Employer employer){
        employerRepository.save(employer);
    }

    public void updateAEmployer(Long id , EmployerGetDTO employer){

    }

    public void deleteEmployer(Long id){
        employerRepository.deleteById(id);
    }
    /*public Collection<EmployerGetDTO> getAll() {
        return employerRepository.findAll()
                .stream()
                .map(mapper::employerToGetEmployer)
                .collect(Collectors.toList());
    }*/
}

