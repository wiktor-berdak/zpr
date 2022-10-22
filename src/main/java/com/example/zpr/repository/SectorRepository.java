package com.example.zpr.repository;

import com.example.zpr.entity.Animal;
import com.example.zpr.entity.Sector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface SectorRepository extends JpaRepository<Sector, Long> {

    Sector findByName(String name);
    @Query(value = "SELECT MAX(total_karma) as TOTAL_KARMA, SECTOR_ID FROM(SELECT SECTOR_ID, SUM(karma_units) AS total_karma FROM ANIMAL GROUP BY SECTOR_ID) as sub_table GROUP BY SECTOR_ID ORDER BY total_karma DESC LIMIT 1", nativeQuery = true)
    List<Map<Integer, Long>> getReportWhichSectorNeedsTheMostFood();

    @Query(value = "SELECT MIN(all_animals) as ALL_ANIMALS, SECTOR_ID FROM (SELECT SECTOR_ID, count(ID) AS all_animals FROM ANIMAL GROUP BY SECTOR_ID) as sub_table GROUP BY SECTOR_ID ORDER BY all_animals ASC LIMIT 1", nativeQuery = true)
    List<Map<Integer, Long>> getReportInWhichSectorIsTheLeastAnimals();
}
