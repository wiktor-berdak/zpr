package com.example.zpr.service;

import com.example.zpr.AnimalType;
import com.example.zpr.entity.Animal;
import com.example.zpr.entity.Sector;
import com.example.zpr.repository.AnimalRepository;
import com.example.zpr.repository.SectorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AnimalServiceTest {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private SectorRepository sectorRepository;

    private AnimalService animalService;
    private Sector sahara = new Sector("sahara", null);

    @BeforeEach
    public void setUp() {
        animalService = new AnimalService(animalRepository, sectorRepository);
    }

    @Test
    public void save_shouldCreate_created() {
        //given
        final Animal animal = new Animal("burek", AnimalType.LION, sahara);
        //when
        animalService.save(animal);
        //then
        final Animal expectedAnimal = animalService.findAllAnimalsByName("burek").stream().findFirst().get();
        assertEquals(expectedAnimal, animal);
    }
    @Test
    public void save_shouldNotCreateTheSameAnimal_throwIllegalArgException() {
        //given
        final Animal animal = new Animal("burek", AnimalType.LION, sahara);
        //when
        animalService.save(animal);
        //then
        assertThrows(IllegalArgumentException.class, ()-> animalService.save(animal));

    }

    @Test
    public void findAllAnimalsByName_shouldFindAllAnimalsWithName_animalsFounded() {
        //given
        //default animals in db - we have to animals with name "wici"

        //when
        List<Animal> animalsWithName = animalService.findAllAnimalsByName("wici");
        //then
        assertEquals(2, animalsWithName.size());
        assertNotEquals(3, animalsWithName.size());
    }

    @Test
    public void findAllBySectorName_shouldFindAllAnimalsBySectorName_animalsFounded() {
        //given
        //default animals in db - we have 3 animals in "sahara"

        //when
        List<Animal> animalsWithName = animalService.findAllBySectorName("sahara");
        //then
        assertEquals(3, animalsWithName.size());
        assertNotEquals(12, animalsWithName.size());
    }
    @Test
    public void findAllBySectorName_wrongSectorName_throwNoSuchElementException() {
        //given
        //default animals in db - we have no sector name: "desert"

        //when
        //then
        assertThrows(NoSuchElementException.class, ()-> animalService.findAllBySectorName("desert"));
    }

}
