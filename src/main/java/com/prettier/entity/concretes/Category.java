package com.prettier.entity.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "categories")
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    @Size(max = 150)
    private String title;//Ex: Konut, İş yeri, Villa vs.
    @Column(name = "icon", nullable = false)
    @Size(max = 50)
    private String icon;

    @Column(name = "built_in", nullable = false)
    private boolean builtIn;

    @Column(name = "seq", nullable = false)
    private int seq; // defines display order

    @Column(name = "slug", nullable = false)
    @Size(min = 5, max = 200)
    private String slug; //title with url encodedencoded,

    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;// false: not published

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at",nullable = false)
    private LocalDateTime createAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at")
    private LocalDateTime updateAt;

 // REALTIONS-----------------------------------------------------------------
 // Relation With Child Advert
    @OneToMany(mappedBy = "category", targetEntity = Advert.class)
    private Set<Advert> advertSet;
//Relation with Child category_property_key
    @OneToMany(mappedBy = "category")
    private Set<CategoryPropertyKey> categoryPropertyKeySet;


}
