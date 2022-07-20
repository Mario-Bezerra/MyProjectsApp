package br.com.MyProjectsApp.Service;

import br.com.MyProjectsApp.Controller.Form.EmployerForm;
import br.com.MyProjectsApp.DTO.Employer.Post.EmployerPostDTO;
import br.com.MyProjectsApp.Mapper.EmployerMapper;
import br.com.MyProjectsApp.Model.Employer;
import br.com.MyProjectsApp.Repositories.EmployerRepository;
import br.com.MyProjectsApp.DTO.Employer.Get.EmployerGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private EmployerMapper employerMapper;

    public EmployerGetDTO createEmployer(@Valid EmployerForm form){
        EmployerPostDTO employerPostDto = form.getEmployerPostDto();
        Employer employerForSave = employerMapper.employerDtoToEmployer(employerPostDto);
        Employer savedEmployer = employerRepository.save(employerForSave);
        return employerMapper.employerToDto(savedEmployer);
    }

    public void updateAEmployer(Long id , EmployerPostDTO employer){
        Employer employerDtoToEmployer = employerMapper.employerDtoToEmployer(employer);
        employerRepository.save(employerDtoToEmployer);
    }

    public void deleteEmployer(Long id){
        if(verifyIfExistEmployer(id)){
            employerRepository.deleteById(id);
        }
        return;

    }

    public List<EmployerGetDTO> getAll() {
        return employerRepository.findAll()
                .stream()
                .map(employerMapper::employerToDto)
                .collect(Collectors.toList());
    }

    public EmployerGetDTO getById(Long id){
        Optional<EmployerGetDTO> employerGetDTO = employerRepository.findById(id).map(employerMapper::employerToDto);
        if (employerGetDTO.isPresent()){
            return employerGetDTO.get();
        }
        return null;
    }

    public boolean verifyIfExistEmployer(Long id) {
        Optional<Employer> employerOptional = employerRepository.findById(id);
        if (employerOptional.isPresent()){
            return true;
        }

        return false;
    }
}

