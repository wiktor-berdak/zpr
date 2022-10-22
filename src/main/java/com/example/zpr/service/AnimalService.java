package com.example.zpr.service;

import com.example.zpr.entity.Animal;
import com.example.zpr.entity.Sector;
import com.example.zpr.repository.AnimalRepository;
import com.example.zpr.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;
    private final SectorRepository sectorRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository, SectorRepository sectorRepository) {
        this.animalRepository = animalRepository;
        this.sectorRepository = sectorRepository;
    }

    public void save(Animal animal) {
        if (Objects.isNull(animal.getName()) || Objects.isNull(animal.getSector()) || Objects.isNull(animal.getType())) {
            throw new IllegalArgumentException("Name, sector and type can not be null.");
        }

        String name = animal.getName().toLowerCase();
        animal.setName(name);

        if (findByName(name) != null) {
            boolean isSectorsEquals = findByName(name).getSector().getName().equals(animal.getSector().getName());
            boolean isTypesEquals = animal.getType().equals(findByName(name).getType());
            if (isSectorsEquals && isTypesEquals) {
                throw new IllegalArgumentException("This animal already exists in this sector.");
            }
        }
        animal.setKarmaUnits(animal.getType().getKarmaUnits());

        String sectorName = animal.getSector().getName().toLowerCase();
        Sector sector = sectorRepository.findByName(sectorName);
        animal.setSector(sector);
        animalRepository.save(animal);
    }

    public Animal findByName(String name) {
        name = name.toLowerCase();
        return animalRepository.findByName(name);
    }

    public List<Animal> findAllAnimalsByName(String name) {
        return new ArrayList<>(animalRepository.findAllAnimalsByName(name));
    }

    public List<Animal> findAllBySectorName(String name) {
        return new ArrayList<>(animalRepository.findAllAnimalsWithSectorName(name));
    }
}
