package fr.avahip.apifcchamptracker.service;

import fr.avahip.apifcchamptracker.entity.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    List<Player> findAll();
    Optional<Player> findById(long id);
    Player saveOrUpdate(Player player);
    void deleteById(long id);
}
