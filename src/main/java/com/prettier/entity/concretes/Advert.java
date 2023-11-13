package com.prettier.entity.concretes;

import com.prettier.entity.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "adverts")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 5, max = 150)
    private String title;

    @Column(name = "\"desc\"")
    @Size(max = 300)
    private String desc;

    @Column(nullable = false)
    @Size(min = 5, max = 200)
    private String slug; //title with url encoded

    @Column(nullable = false)
    private Double price;



    @NotNull  //TODO: Enum olarakmi kalmali dinamik olma ile bir alakasi varmi? tablomu olmali?
    private Status status = Status.PENDING;

    @Column(nullable = false, name = "built_in")
    private boolean builtIn;  // default 0 , 1 can be deleted, or updated

    @Column(nullable = false, name = "is_active")
    private boolean isActive  = true; //default true, false: Not published true: published (for users)

    @Column(nullable = false)
    private int view_count;

    private String location; //Google embed code
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at"/*, nullable = false*/)
    private LocalDateTime createAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at")
    private LocalDateTime updateAt;

//------------------RELATIONS ----------------------------------
// Relation with Parent AdvertTpe
    @ManyToOne
    @JoinColumn(name = "advert_type_id", nullable = false)
    private AdvertType advertType;
// Relation with Parent Country
    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
// Relation with Parent City
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
// Relation with Parent District
    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;
// Relation with Parent User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
//Relation With Parent Category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

// Relation with Child 'category_property-values'
    @OneToMany(mappedBy = "advert")
    private Set<CategoryPropertyValue> categoryPropertyValueSet; //TODO: document da yer almamis
// Relation with Child TourRequest
    @OneToMany(mappedBy = "advert")
    private Set<TourRequest> tourRequestSet;

// Relations with Child "images" table
    @OneToMany(mappedBy = "advert")
    private Set<Image> imageSet;
//Relation with Child Log table
    @OneToMany(mappedBy = "advert", targetEntity = Log.class)
    private Set<Log> logSet;

}