package fr.avahip.apifcchamptracker.service;

import fr.avahip.apifcchamptracker.entity.Team;
import fr.avahip.apifcchamptracker.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository repository;

    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Team> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Team> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public Team saveOrUpdate(Team team) {
        return repository.saveAndFlush(team);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
