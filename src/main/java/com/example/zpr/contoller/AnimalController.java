package com.example.zpr.contoller;

import com.example.zpr.entity.Animal;
import com.example.zpr.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animals/name/{name}")
    public List<Animal> getAllAnimalsByName(@PathVariable String name){
        return animalService.findAllAnimalsByName(name);
    }

    @PostMapping("/animals")
    public void saveAnimal(@RequestBody Animal animal){
        animalService.save(animal);
    }

    @GetMapping("/animals/sector/{id}")
    public List<Animal> getAllAnimalsBySectorId(@PathVariable Long id) {
        return animalService.findAllBySectorId(id);
    }
}
