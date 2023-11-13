package com.prettier.entity.concretes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    private byte[] data;// TODO: in document it is written as  Oid (uniq identifier for db object)

    @Column(nullable = false)
    private String name;

    private String type;

    @Column(nullable = false)
    private boolean featured;


//*-----------------------Relations-----------------------------
    //Relations with parent adverts table
    @ManyToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;

}