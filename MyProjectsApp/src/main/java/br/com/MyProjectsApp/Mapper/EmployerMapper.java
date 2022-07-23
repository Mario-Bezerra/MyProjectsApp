package br.com.MyProjectsApp.Mapper;

import br.com.MyProjectsApp.DTO.Employer.EmployerSlimDto;
import br.com.MyProjectsApp.Model.BaseModelEmployer.Endereco;
import br.com.MyProjectsApp.Model.BaseModelEmployer.EnterpriseData;
import br.com.MyProjectsApp.Model.BaseModelEmployer.PersonalData;
import br.com.MyProjectsApp.Model.Employer;
import br.com.MyProjectsApp.DTO.Employer.EnderecoDto;
import br.com.MyProjectsApp.DTO.Employer.Get.EmployerGetDTO;
import br.com.MyProjectsApp.DTO.Employer.Get.EnterpriseDataGetDto;
import br.com.MyProjectsApp.DTO.Employer.PersonalDataDto;
import br.com.MyProjectsApp.DTO.Employer.Post.EmployerPostDTO;
import br.com.MyProjectsApp.DTO.Employer.Post.EnterpriseDataPostDto;
import org.mapstruct.factory.Mappers;

@org.mapstruct.Mapper( componentModel = "spring" )
public interface EmployerMapper {

    EmployerMapper INSTANCE = Mappers.getMapper(EmployerMapper.class);

    // Employers Mapper

    EmployerGetDTO employerToDto(Employer employer);
    Employer employerDtoToEmployer(EmployerPostDTO employerPostDTO);
    EnterpriseDataGetDto enterpriseToDto(EnterpriseData enterpriseData);
    EnterpriseData enterpriseDtoToEnterprise(EnterpriseDataPostDto enterpriseDataPostDto);
    PersonalDataDto personalDataToDto(PersonalData personalData);
    PersonalData personalDtoTopersonal(PersonalDataDto personalDataDto);
    EnderecoDto enderecoToDto(Endereco endereco);
    Endereco enderecoDtoToEndereco(EnderecoDto enderecoDto);

    EmployerPostDTO employerGetToPost(EmployerPostDTO employerPostDTO);

    EmployerSlimDto employerSlim(Employer employer);


}
