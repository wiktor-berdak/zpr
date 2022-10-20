package com.example.zpr.contoller;

import com.example.zpr.Report;
import com.example.zpr.entity.Sector;
import com.example.zpr.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SectorController {

    private final SectorService sectorService;
    @Autowired
    public SectorController(SectorService service) {
        this.sectorService = service;
    }

    @PostMapping("/sectors")
    public void createSector(@RequestBody Sector sector) {
        sectorService.save(sector);
    }

    @GetMapping("/sectors/report/karma")
    public Report getReportWhichSectorNeedsTheMostFood(){
        return sectorService.getReportWhichSectorNeedsTheMostFood();
    }

    @GetMapping("/sectors/report/animals")
    public Report getReportInWhichSectorIsTheLeastAnimals(){
        return sectorService.getReportInWhichSectorIsTheLeastAnimals();
    }
}
