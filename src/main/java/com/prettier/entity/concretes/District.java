package com.prettier.entity.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "districts")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;
// Relation With Parent City
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
//Relation With Child Advert
    @OneToMany(mappedBy = "district")
    private Set<Advert> advertSet;
}