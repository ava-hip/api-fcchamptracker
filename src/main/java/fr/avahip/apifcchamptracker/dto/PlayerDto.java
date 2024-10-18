package fr.avahip.apifcchamptracker.dto;

import fr.avahip.apifcchamptracker.generic.dto.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PlayerDto extends BaseDto {
    String imgLink;
    int goal;
    int assist;
}
