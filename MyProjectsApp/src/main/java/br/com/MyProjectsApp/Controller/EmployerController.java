package br.com.MyProjectsApp.Controller;

import br.com.MyProjectsApp.Controller.Form.EmployerForm;
import br.com.MyProjectsApp.DTO.Employer.Get.EmployerGetDTO;
import br.com.MyProjectsApp.DTO.Employer.Post.EmployerPostDTO;
import br.com.MyProjectsApp.Model.Employer;
import br.com.MyProjectsApp.Service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1/employer")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @GetMapping
    public ResponseEntity<Collection<EmployerGetDTO>> getAll(){
        Collection<EmployerGetDTO> employerGetDTOS = employerService.getAll();
        return ResponseEntity.ok(employerGetDTOS);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployerGetDTO> postEmployer(@RequestBody @Valid EmployerForm form){
        EmployerGetDTO employerSaved = employerService.createEmployer(form);
        return ResponseEntity.ok(employerSaved);
    }
}
