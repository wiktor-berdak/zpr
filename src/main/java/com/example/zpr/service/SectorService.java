package com.example.zpr.service;

import com.example.zpr.Report;
import com.example.zpr.entity.Sector;
import com.example.zpr.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SectorService {

    private final SectorRepository sectorRepository;

    @Autowired
    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public void save(Sector sector) {
        if(Objects.isNull(sector.getName())){
            throw new IllegalArgumentException("Name can not be null.");
        }
        String name = sector.getName().toLowerCase();
        sector.setName(name);

        if(findByName(sector.getName()) != null){
            throw new IllegalArgumentException("Sector with this name already exists.");
        }
        sectorRepository.save(sector);
    }
    public Sector findByName(String name) {
        name = name.toLowerCase();
        return sectorRepository.findByName(name);
    }

    public Report getReportWhichSectorNeedsTheMostFood() {
        return new Report(sectorRepository.getReportWhichSectorNeedsTheMostFood());
    }

    public Report getReportInWhichSectorIsTheLeastAnimals() {
        return new Report(sectorRepository.getReportInWhichSectorIsTheLeastAnimals());
    }
}
