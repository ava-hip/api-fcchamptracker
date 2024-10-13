package fr.avahip.apifcchamptracker.service;

import fr.avahip.apifcchamptracker.entity.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    List<Team> findAll();
    Optional<Team> findById(long id);
    Team saveOrUpdate(Team team);
    void deleteById(long id);
}
