package com.example.zpr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sector {

    public Sector(String name, Set<Animal> animals) {
        this.name = name;
        this.animals = animals;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SECTOR_ID")
    private long id;

    @Column(unique=true)
    private String name;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Set<Animal> animals = new HashSet<>();
}
