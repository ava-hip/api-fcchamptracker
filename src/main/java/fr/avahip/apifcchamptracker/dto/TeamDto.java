package fr.avahip.apifcchamptracker.dto;

import fr.avahip.apifcchamptracker.entity.Player;
import fr.avahip.apifcchamptracker.generic.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class TeamDto extends BaseDto {
    String name;
    LocalDateTime createdAt;
    List<Player> players;
}
