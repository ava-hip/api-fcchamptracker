package fr.avahip.apifcchamptracker.service;

import fr.avahip.apifcchamptracker.dto.PlayerDto;
import fr.avahip.apifcchamptracker.entity.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    List<PlayerDto> findAll();
    Optional<PlayerDto> findById(long id);
    Player saveOrUpdate(PlayerDto dto);
    void deleteById(long id);
    List<PlayerDto> findByTeam(long id);
}
