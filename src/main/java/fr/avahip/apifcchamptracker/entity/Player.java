package fr.avahip.apifcchamptracker.entity;

import fr.avahip.apifcchamptracker.generic.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player extends BaseEntity {
    private String imgLink;
    private String position;
    private int goal;
    private int assist;
    @ManyToOne
    private Team team;
}
