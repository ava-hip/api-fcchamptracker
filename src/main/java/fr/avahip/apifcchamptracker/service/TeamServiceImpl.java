package fr.avahip.apifcchamptracker.service;

import fr.avahip.apifcchamptracker.dto.TeamDto;
import fr.avahip.apifcchamptracker.entity.Team;
import fr.avahip.apifcchamptracker.mapper.TeamMapper;
import fr.avahip.apifcchamptracker.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository repository;
    private final TeamMapper mapper;

    public TeamServiceImpl(TeamRepository repository, TeamMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<TeamDto> findAll() {return toDto(repository.findAll());}

    @Override
    public Optional<TeamDto> findById(long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    @Override
    public Team saveOrUpdate(TeamDto dto) {
        return repository.saveAndFlush(toEntity(dto));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TeamDto> findByUserEmail(String email) {
        return toDto(repository.findByUser_Email(email));
    }

    public TeamDto toDto(Team entity) {
        return mapper.toDto(entity);
    }

    public Team toEntity(TeamDto dto) {
        return mapper.toEntity(dto);
    }

    public List<TeamDto> toDto(List<Team> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}
