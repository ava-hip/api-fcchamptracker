package fr.avahip.apifcchamptracker.dto;

import fr.avahip.apifcchamptracker.generic.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class PlayerDto extends BaseDto {
    String imgLink;
    String position;
    int goal;
    int assist;
    TeamDto team;

    @Value
    public static class TeamDto implements Serializable {
        long id;
        int version;
        String name;
        LocalDateTime createdAt;
    }
}
