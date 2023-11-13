package com.prettier.entity.concretes;


import com.prettier.entity.enums.LogAction;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "logs")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private LogAction logAction;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt;

//====== RELATIONS --------------------------------
// Relations with Parent User
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
//Relation with Parent Advert table
    @ManyToOne
    @JoinColumn(name = "advert_id")
    private Advert advert;
}
