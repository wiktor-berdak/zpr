package com.example.zpr.service;

import com.example.zpr.entity.Sector;
import com.example.zpr.repository.SectorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
public class SectorServiceTest {

    @Autowired
    private SectorRepository sectorRepository;

    private SectorService sectorService;

    @BeforeEach
    public void setUp() {
        sectorService = new SectorService(sectorRepository);
    }

    @Test
    public void save_shouldCreate_created() {
        //given
        String numenor = "numenor";
        final Sector sector = new Sector(numenor, null);
        //when
        sectorService.save(sector);
        //then
        final Sector expectedSector = sectorService.findByName(numenor);

        assertEquals(expectedSector, sector);
    }

    @Test
    public void save_shouldNotCreateWithNullName_throwIllegalArgException() {
        //given
        final Sector sector = new Sector(null, null);
        //when
        // then
        assertThrows(IllegalArgumentException.class, () -> sectorService.save(sector));
    }

    @Test
    public void save_shouldNotTheSameSector_throwIllegalArgException() {
        //given
        String numenor = "numenor";
        final Sector sector1 = new Sector(numenor, null);
        final Sector sector2 = new Sector(numenor, null);
        sectorService.save(sector1);
        //when
        // then
        assertThrows(IllegalArgumentException.class, () -> sectorService.save(sector2));
    }
}
