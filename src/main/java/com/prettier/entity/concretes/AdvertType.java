package com.prettier.entity.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "advert_types")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
/**
 *  KONUT
 *  IS YERI
 *  ARSA
 *  KONUT PROJELERI
 *  BINA
 *  DEVRE MULK
 *  TURISTIK TESIS
 */
}
