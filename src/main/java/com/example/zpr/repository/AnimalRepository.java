package com.example.zpr.repository;

import com.example.zpr.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query(value = "SELECT * FROM ANIMAL WHERE SECTOR_ID=?1", nativeQuery = true)
    List<Animal> findAllBySectorId(Long id);
    List<Animal> findAllByName(String name);

    Animal findByName(String name);
}
