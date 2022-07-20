package br.com.MyProjectsApp.Controller;

import br.com.MyProjectsApp.Controller.Form.Employer.EmployerForm;
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

    @GetMapping("/{id}")
    public ResponseEntity<EmployerGetDTO> getById(@PathVariable(name = "id") Long id ){
        EmployerGetDTO employerGetById = employerService.getById(id);
        if (employerGetById == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employerGetById);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployerGetDTO> postEmployer(@RequestBody @Valid EmployerForm form){
        EmployerGetDTO employerSaved = employerService.createEmployer(form);
        return ResponseEntity.ok(employerSaved);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<EmployerGetDTO> updateEmployer(@PathVariable(name = "id") Long id,
                                                         @RequestBody @Valid EmployerForm employerForm){
        EmployerPostDTO employerPostDTO = employerForm.getEmployerPostDto();
        EmployerGetDTO employerGetDTO = employerService.updateAEmployer(id, employerPostDTO);
        return ResponseEntity.ok(employerGetDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployerGetDTO> deleteEmployer(@PathVariable(name = "id") Long id){
        EmployerGetDTO employerGetDTO = employerService.deleteEmployer(id);
        if(employerGetDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employerGetDTO);
    }

}
