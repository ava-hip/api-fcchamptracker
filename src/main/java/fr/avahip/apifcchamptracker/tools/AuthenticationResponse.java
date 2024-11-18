package fr.avahip.apifcchamptracker.tools;

import fr.avahip.apifcchamptracker.dto.UserDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AuthenticationResponse {
    private String token;
    private List<UserDto> user;
}
