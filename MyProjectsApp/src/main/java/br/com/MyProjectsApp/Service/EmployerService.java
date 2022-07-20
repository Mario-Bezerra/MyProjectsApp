package br.com.MyProjectsApp.Service;

import br.com.MyProjectsApp.Controller.Form.Employer.EmployerForm;
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
        boolean verifyIfExistEmployer = verifyIfExistEmployer(form.getCpf());
        if(verifyIfExistEmployer){
            return null;
        }
        EmployerPostDTO employerPostDto = form.getEmployerPostDto();
        Employer employerForSave = employerMapper.employerDtoToEmployer(employerPostDto);
        Employer savedEmployer = employerRepository.save(employerForSave);
        return employerMapper.employerToDto(savedEmployer);
    }

    public EmployerGetDTO updateAEmployer(Long id , EmployerPostDTO employerPostDto){
        Optional<Employer> optionalEmployer = employerRepository.findById(id);
        if(optionalEmployer.isPresent()){
            EmployerGetDTO employerGetDTO = updatingEmployer(optionalEmployer.get(), employerPostDto);
            return employerGetDTO;
        }
        return null;
    }

    private EmployerGetDTO updatingEmployer(Employer employer, EmployerPostDTO employerPostDto) {
        Employer employerToUpdate = employerMapper.employerDtoToEmployer(employerPostDto);
        employer.setEnterpriseData(employerToUpdate.getEnterpriseData());
        employer.setPersonalData(employerToUpdate.getPersonalData());
        Employer savedEmployer = employerRepository.save(employer);
        return employerMapper.employerToDto(savedEmployer);
    }

    public EmployerGetDTO deleteEmployer(Long id){
        Optional<Employer> employerById = employerRepository.findById(id);
        if(employerById.isPresent()){
            employerRepository.deleteById(id);
            return employerMapper.employerToDto(employerById.get());
        }
        return null;
    }

    public List<EmployerGetDTO> getAll() {
        return employerRepository.findAll()
                .stream()
                .map(employerMapper::employerToDto)
                .collect(Collectors.toList());
    }

    public EmployerGetDTO getById(Long id){
        Optional<EmployerGetDTO> employerGetDTO = employerRepository.findById(id).map(employerMapper::employerToDto);
        return employerGetDTO.orElse(null);
    }

    public boolean verifyIfExistEmployer(String cpf) {
        Optional<Employer> employerOptional = Optional.ofNullable(employerRepository.findByPersonalDataCpf(cpf));
        return employerOptional.isPresent();
    }
}

