package fr.avahip.apifcchamptracker.dto;

import fr.avahip.apifcchamptracker.generic.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class TeamDto extends BaseDto implements Serializable {
    String name;
    int week;
}
