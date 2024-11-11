package fr.avahip.apifcchamptracker.entity;

import fr.avahip.apifcchamptracker.generic.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token extends BaseEntity {
    private String token;
    private LocalDateTime createAt;
    private LocalDateTime expiresAt;
    private LocalDateTime validatedAt;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
}
