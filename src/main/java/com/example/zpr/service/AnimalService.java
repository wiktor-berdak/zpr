package com.example.zpr.service;

import com.example.zpr.entity.Animal;
import com.example.zpr.entity.AnimalType;
import com.example.zpr.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void save(Animal animal) {
        if(Objects.isNull(animal.getName()) || Objects.isNull(animal.getSector()) || Objects.isNull(animal.getType())){
            throw new IllegalArgumentException("Name, sector and type can not be null.");
        }

        //here we have method where we can easily set karmaUnits depends on which type of animal it is
        setKarmaUnits(animal);

        String name = animal.getName().toLowerCase();
        animal.setName(name);

        if(findByName(name) != null && findByName(name).getSector().equals(animal.getSector())){
            throw new IllegalArgumentException("This animal already exists in this sector.");
        }
        animalRepository.save(animal);
    }

    public Animal findByName(String name){
        name = name.toLowerCase();
        return animalRepository.findByName(name);
    }

    public List<Animal> findAllAnimalsByName(String name) {
        return animalRepository.findAllByName(name);
    }

    public List<Animal> findAllBySectorId(Long id) {
        return new ArrayList<>(animalRepository.findAllBySectorId(id));
    }

    private void setKarmaUnits(Animal animal){

        AnimalType elephant = AnimalType.ELEPHANT;
        AnimalType lion = AnimalType.LION;
        AnimalType rabbit = AnimalType.RABBIT;

        if(animal.getType().equals(elephant)){
            animal.setKarmaUnits(elephant.getKarmaUnits());
        } else if (animal.getType().equals(lion)) {
            animal.setKarmaUnits(lion.getKarmaUnits());
        } else {
            animal.setKarmaUnits(rabbit.getKarmaUnits());
        }
    }
}
