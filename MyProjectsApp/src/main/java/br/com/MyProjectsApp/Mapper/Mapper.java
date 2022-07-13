package br.com.MyProjectsApp.Mapper;

import br.com.MyProjectsApp.Model.BaseModelEmployer.Endereco;
import br.com.MyProjectsApp.Model.BaseModelEmployer.EnterpriseData;
import br.com.MyProjectsApp.Model.BaseModelEmployer.PersonalData;
import br.com.MyProjectsApp.Model.Employer;
import br.com.MyProjectsApp.Model.Project;
import br.com.MyProjectsApp.Model.Task;
import br.com.MyProjectsApp.Service.DTO.Employer.EnderecoDto;
import br.com.MyProjectsApp.Service.DTO.Employer.Get.EmployerGetDTO;
import br.com.MyProjectsApp.Service.DTO.Employer.Get.EnterpriseDataGetDto;
import br.com.MyProjectsApp.Service.DTO.Employer.PersonalDataDto;
import br.com.MyProjectsApp.Service.DTO.Employer.Post.EmployerPostDTO;
import br.com.MyProjectsApp.Service.DTO.Employer.Post.EnterpriseDataPostDto;
import br.com.MyProjectsApp.Service.DTO.ProjectDto;
import br.com.MyProjectsApp.Service.DTO.ProjectDtoSlim;
import br.com.MyProjectsApp.Service.DTO.TaskDto;
import br.com.MyProjectsApp.Service.DTO.TaskDtoSlim;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper( componentModel = "spring" )
public interface Mapper {

    Mapper INSTANCE = Mappers.getMapper(Mapper.class);

    EmployerGetDTO employerToGetEmployer(Employer employer);
    EnterpriseDataGetDto enterpriseDataToGetEmployer(EnterpriseData enterpriseData);

    Employer employerToPostEmployer(EmployerPostDTO employerPostDTO);
    EnterpriseData enterpriseDataToPostEmployer(EnterpriseDataPostDto enterpriseDataPostDto);

    EnderecoDto enderecoToDto(Endereco endereco);

    PersonalDataDto personalDataToDto(PersonalData personalData);

    ProjectDto projectToDto(Project project);
    ProjectDtoSlim projectDtoSlim(Project project);

    Project projectDtoToProject(ProjectDto projectDto);
    Project projectDtoSlimToProject(ProjectDtoSlim projectDtoSlim);


    TaskDto taskToDto(Task task);
    Task dtoToTask(TaskDto taskDto);

    TaskDtoSlim taskDtoSlim(Task task);

}
