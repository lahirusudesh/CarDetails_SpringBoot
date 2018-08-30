package com.io.developer.testapp2;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

import com.io.developer.testapp2.Car;
import com.io.developer.testapp2.CoolCarController;

@RestController
public class CoolCarController {
    private CarRepository repository;

    public CoolCarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewUser (@RequestParam Long id
            , @RequestParam String name) {

        Car n = new Car();
        n.setId(id);
        n.setName(name);
        repository.save(n);
        return "Saved";
    }
    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public Car create(@RequestBody Car car){
        return repository.save(car);
    }
    @GetMapping(path="/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    Iterable<Car> getAllUsers() {
        // This returns a JSON or XML with the users
        return repository.findAll();
    }
}
