package br.com.MyProjectsApp.Controller;

import br.com.MyProjectsApp.Service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employer")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    /*@GetMapping
    public ResponseEntity<Collection<EmployerGetDTO>> getAll(){
        Collection<EmployerGetDTO> employerGetDTOS = employerService.getAll();
        return ResponseEntity.ok(employerGetDTOS);
    }*/
}
