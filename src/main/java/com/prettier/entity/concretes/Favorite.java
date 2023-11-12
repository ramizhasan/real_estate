package com.prettier.entity.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "favorites")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime create_at;

// Many to One relation with User
    @ManyToOne
    @JoinColumn(name = "user_id"/*, nullable = false*/)
    private User user;

// ManyToOne Relation with Adverts
    @ManyToOne
    @JoinColumn(name = "advert_id"/*,nullable = false*/)
    private Advert advert;


}
