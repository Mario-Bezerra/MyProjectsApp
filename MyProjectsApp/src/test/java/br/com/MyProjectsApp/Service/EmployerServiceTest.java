/*
package br.com.MyProjectsApp.Service;

import br.com.MyProjectsApp.DTO.Employer.Get.EmployerGetDTO;
import br.com.MyProjectsApp.DTO.Employer.Post.EmployerPostDTO;
import br.com.MyProjectsApp.Mapper.EmployerMapper;
import br.com.MyProjectsApp.Model.Employer;
import br.com.MyProjectsApp.Repositories.EmployerRepository;
import br.com.MyProjectsApp.Service.Builder.EmployerBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class EmployerServiceTest {

    @Mock
    private EmployerRepository employerRepository;
    private EmployerMapper employerMapper = EmployerMapper.INSTANCE;

    @InjectMocks
    private EmployerService employerService;

    @Test
    public void shouldReturnTheSavedEmployer(){
        EmployerPostDTO expectedEmployer = new EmployerBuilder().EmployerBuilder();
        Employer expectedSavedEmployer = employerMapper.employerDtoToEmployer(expectedEmployer);

        Mockito.when(employerRepository.findById(expectedEmployer.getId())).thenReturn(Optional.empty());
        Mockito.when(employerRepository.save(expectedSavedEmployer)).thenReturn(expectedSavedEmployer);

        EmployerGetDTO createdEmployer = employerService.createEmployer(expectedEmployer);

        Assertions.assertEquals(createdEmployer.getId(), expectedEmployer.getId());
        Assertions.assertEquals(createdEmployer.getEnterpriseData().getCargo(), expectedEmployer.getEnterpriseData().getCargo());
        Assertions.assertEquals(createdEmployer.getPersonalData().getName(), expectedEmployer.getPersonalData().getName());
    }
}*/
