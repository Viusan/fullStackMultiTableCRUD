package oslomet.fullstackmultitablecrud.controller;

import oslomet.fullstackmultitablecrud.models.Ships;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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


}
