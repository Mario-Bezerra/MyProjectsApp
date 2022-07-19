package br.com.MyProjectsApp.Builder;

import br.com.MyProjectsApp.Model.Employer;
import br.com.MyProjectsApp.Model.Project;
import br.com.MyProjectsApp.Model.Status;
import lombok.Builder;



import java.time.LocalDate;

@Builder
public class TaskDtoBuilder {

    @Builder.Default
    private Long id = Long.valueOf(1);
    @Builder.Default
    private Project project = 1;
    @Builder.Default
    private Employer devEncarregado;
    @Builder.Default
    private Status status = Status.AGUARDANDO;
    @Builder.Default
    private LocalDate timeCreated = LocalDate.now();
    @Builder.Default
    private String description = "SpringBootApp";
    @Builder.Default
    private String name = "Spring test";
}

    public TaskDtoBuilder() {


    }
}
