package com.example.zpr.repository;

import com.example.zpr.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query(value = "SELECT * FROM ANIMAL A INNER JOIN SECTOR S ON A.SECTOR_ID = S.SECTOR_ID WHERE S.NAME=?1", nativeQuery = true)
    List<Animal> findAllAnimalsWithSectorName(String name);

    @Query(value = "SELECT * FROM ANIMAL WHERE NAME=?1", nativeQuery = true)
    List<Animal> findAllAnimalsByName(String name);

}
