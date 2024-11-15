package fr.avahip.apifcchamptracker.service;

import fr.avahip.apifcchamptracker.dto.TeamDto;
import fr.avahip.apifcchamptracker.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    List<TeamDto> findAll();
    Optional<TeamDto> findById(long id);
    Team saveOrUpdate(TeamDto dto);
    void deleteById(long id);
    List<TeamDto> findByUserEmail(String email);
}
