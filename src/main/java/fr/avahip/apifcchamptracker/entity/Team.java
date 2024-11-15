package fr.avahip.apifcchamptracker.entity;

import fr.avahip.apifcchamptracker.generic.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Team extends BaseEntity {
    private String name;
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "team", cascade = CascadeType.REMOVE)
    private List<Player> players;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email", referencedColumnName = "email", nullable = false)
    private User user;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

}
