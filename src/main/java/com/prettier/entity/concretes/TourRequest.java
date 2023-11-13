package com.prettier.entity.concretes;

import com.prettier.entity.enums.TourStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "tour_requests")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TourRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tour_date", nullable = false)
    private LocalDateTime tourDate; //todo: tarih formati yazilacak

    @Column(name = "tour_time", nullable = false)
    private LocalDateTime tourTime; //todo: gezinti suresimi olacak?


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TourStatus tourStatus = TourStatus.PENDING; // ilan status ile karismamasi icin tourStatus olarak yazildi

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at")
    private LocalDateTime updateAt;

//-----------RELATIONS------------------------------------------
// Relation with Parent Advert
    @ManyToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;

    /** TODO: Asagida ki owner ve quest_user_id  leri arasinda ki baglantilarin nasil yapilacagina
     *  dair tekrar gorusulmeli tam olarak ayrismanin nasil yapilacagini anlayamadim?
     */
//Relation with User For owner_user_id

    @ManyToOne
    @JoinColumn(name = "owner_user_id")
    private User ownerUser;
//Relation with User For guest_user_id

    @ManyToOne
    @JoinColumn(name = "guest_user_id")
    private User guestUser;



}
