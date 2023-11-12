package com.prettier.entity.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cities")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(max = 30)
    private String name;
//Creating relation with parent Country
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

// Creating relation with Child District
    @OneToMany(mappedBy = "city")
    private Set<District> districtSet;
// Creating relation with Child Advert
    @OneToMany(mappedBy = "city")
    private Set<Advert> advertSet;

}