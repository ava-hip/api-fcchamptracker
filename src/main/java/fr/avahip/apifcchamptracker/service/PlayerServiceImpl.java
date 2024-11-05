package fr.avahip.apifcchamptracker.service;

import fr.avahip.apifcchamptracker.dto.PlayerDto;
import fr.avahip.apifcchamptracker.entity.Player;
import fr.avahip.apifcchamptracker.mapper.PlayerMapper;
import fr.avahip.apifcchamptracker.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository repository;
    private final PlayerMapper mapper;

    public PlayerServiceImpl(PlayerRepository repository, PlayerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PlayerDto> findAll() {
        return toDto(repository.findAll());
    }

    @Override
    public Optional<PlayerDto> findById(long id) {
        return repository.findById(id).map(this::toDto);
    }

    @Override
    public Player saveOrUpdate(PlayerDto dto) {
        return repository.saveAndFlush(toEntity(dto));
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<PlayerDto> findByTeam(long id) {
        return toDto(repository.findByTeam_Id(id));
    }

    public PlayerDto toDto(Player entity) {
        return mapper.toDto(entity);
    }

    public Player toEntity(PlayerDto dto) {
        return mapper.toEntity(dto);
    }

    public List<PlayerDto> toDto(List<Player> entities) {
        return entities.stream().map(this::toDto).toList();
    }
}
