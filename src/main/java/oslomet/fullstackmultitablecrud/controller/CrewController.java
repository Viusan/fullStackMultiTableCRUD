package oslomet.fullstackmultitablecrud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oslomet.fullstackmultitablecrud.repository.CrewRepository;

@RestController
@RequestMapping("/api/Crew")
public class CrewController {
    private final CrewRepository repository;

    public CrewController(CrewRepository repository){
        this.repository = repository;
    }


}
