package oslomet.fullstackmultitablecrud.controller;

import org.springframework.web.bind.annotation.*;
import oslomet.fullstackmultitablecrud.models.Ships;

import oslomet.fullstackmultitablecrud.repository.ShipRepository;

@RestController
@RequestMapping("/api/Ships")
public class ShipController {
    private final ShipRepository repository;

    public ShipController(ShipRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getShips")
    public void getAllShip(){
        repository.getAllShips();
    }

    @PostMapping("/createShip")
    public void createShip(@RequestBody Ships ship){
        repository.createShip(ship);
    }

    @PutMapping("/updateShip/{id}")
    public void updateShip(@PathVariable int id, @RequestBody Ships ship){
        repository.updateShip(id, ship);
    }

    @DeleteMapping("/deleteShip/{id}")
    public void deleteShip(@PathVariable int id){
        repository.deleteShip(id);
    }
}
