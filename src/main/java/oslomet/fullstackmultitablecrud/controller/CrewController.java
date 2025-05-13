package oslomet.fullstackmultitablecrud.controller;

import org.springframework.web.bind.annotation.*;
import oslomet.fullstackmultitablecrud.models.Crew;
import oslomet.fullstackmultitablecrud.repository.CrewRepository;

@RestController
@RequestMapping("/api/Crew")
public class CrewController {
    private final CrewRepository repository;

    public CrewController(CrewRepository repository){
        this.repository = repository;
    }

    @GetMapping("/getCrew")
    public void getAllCrew(){
        repository.getAllCrew();
    }

    @PostMapping("/createCrew")
    public void createCrew(@PathVariable int id, @RequestBody Crew crew){
        repository.insertCrew(id,crew);
    }

    @PutMapping("/updateCrew/{id}")
    public void updateCrew(@PathVariable int id, @RequestBody Crew crew){
        repository.updateCrew(id, crew);
    }

    @DeleteMapping("/deleteCrew")
    public void deleteCrew(@RequestBody Crew crew){
        repository.deleteCrew(crew);
    }
}
