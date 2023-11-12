package com.prettier.entity.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "countries")
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
// Relation with Child Advert
    @OneToMany(mappedBy = "country")
    private Set<Advert> advertSet;

//Relation with Child City
    @OneToMany(mappedBy = "country")
    private Set<City> citySet;


}