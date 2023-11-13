package com.prettier.entity.concretes;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "contacts")
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    @Size(max = 30)
    private String firstName;

    @Column(nullable = false)
    @Size(max = 30)
    private String lastName;

    @Column(nullable = false)
    @Size(max = 60)
    private String email;

    @Column(nullable = false)
    @Size(max = 300)
    private String message;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_at", nullable = false)
    private LocalDateTime createAt;

}
