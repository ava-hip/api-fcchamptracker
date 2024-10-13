package fr.avahip.apifcchamptracker.entity;

import fr.avahip.apifcchamptracker.generic.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Team extends BaseEntity {
    private String name;
    private int week;
    @OneToMany()
    private List<Player> players;
}
