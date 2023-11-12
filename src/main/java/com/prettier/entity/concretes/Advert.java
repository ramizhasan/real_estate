package com.prettier.entity.concretes;

import com.prettier.entity.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.swing.*;
import java.time.LocalDateTime;

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
// Relation with Parent User //TODO: burada kaldin iliskiyi tamamla
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    @ManyToOne
//    @JoinColumn(name = "category_id", nullable = false)
//    private Category category;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at"/*, nullable = false*/)
    private LocalDateTime createAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at")
    private LocalDateTime updateAt;



//relations
    //private Integer advert_type_id; //

}