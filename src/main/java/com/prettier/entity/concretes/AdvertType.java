package com.prettier.entity.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "advert_types")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdvertType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "title", nullable = false)
    @Size(max = 30)
    private String title;
// Relation with Child Advert
    @OneToMany(mappedBy = "advertType")
    private Set<Advert> advertSet;

}
