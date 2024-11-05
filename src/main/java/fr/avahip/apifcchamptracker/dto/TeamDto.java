package fr.avahip.apifcchamptracker.dto;

import fr.avahip.apifcchamptracker.generic.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class TeamDto extends BaseDto {
    String name;
    LocalDateTime createdAt;
    List<PlayerDto> players;

    @Value
    public static class PlayerDto implements Serializable {
        long id;
        int version;
        String imgLink;
        String position;
        int goal;
        int assist;
    }
}
