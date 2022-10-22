package com.example.zpr.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class Sector {

    public Sector(String name, Set<Animal> animals) {
        this.name = name;
        this.animals = animals;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SECTOR_ID")
    private long id;

    private String name;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, mappedBy = "sector")
    private Set<Animal> animals = new HashSet<>();
}
