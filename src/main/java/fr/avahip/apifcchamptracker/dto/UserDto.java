package fr.avahip.apifcchamptracker.dto;

import fr.avahip.apifcchamptracker.generic.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class UserDto extends BaseDto {
    private String username;
    private String email;
}
