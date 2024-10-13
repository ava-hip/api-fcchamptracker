package fr.avahip.apifcchamptracker.service;

import fr.avahip.apifcchamptracker.entity.Player;
import fr.avahip.apifcchamptracker.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository repository;

    public PlayerServiceImpl(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Player> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Player> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public Player saveOrUpdate(Player player) {
        return repository.saveAndFlush(player);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
