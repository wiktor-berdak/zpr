package com.example.zpr.entity;

import com.example.zpr.AnimalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Animal {

    public Animal(String name, AnimalType type, Sector sector) {
        this.name = name;
        this.type = type;
        this.sector = sector;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ANIMAL_ID")
    private long id;
    private String name;

    private int karmaUnits;

    @Enumerated(value = EnumType.STRING)
    private AnimalType type;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SECTOR_ID")
    private Sector sector;
}