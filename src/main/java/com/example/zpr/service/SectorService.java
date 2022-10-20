package com.example.zpr.service;

import com.example.zpr.Report;
import com.example.zpr.entity.Sector;
import com.example.zpr.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SectorService {

    private final SectorRepository sectorRepository;

    @Autowired
    public SectorService(SectorRepository sectorRepository) {
        this.sectorRepository = sectorRepository;
    }

    public void save(Sector sector) {
        sectorRepository.save(sector);
    }

    public Report getReportWhichSectorNeedsTheMostFood() {
        return new Report(new ArrayList<>(sectorRepository.getReportWhichSectorNeedsTheMostFood()));
    }

    public Report getReportInWhichSectorIsTheLeastAnimals() {
        return new Report(new ArrayList<>(sectorRepository.getReportInWhichSectorIsTheLeastAnimals()));
    }
}
