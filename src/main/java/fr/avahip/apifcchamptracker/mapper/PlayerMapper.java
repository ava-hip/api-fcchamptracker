package fr.avahip.apifcchamptracker.mapper;

import fr.avahip.apifcchamptracker.dto.PlayerDto;
import fr.avahip.apifcchamptracker.entity.Player;
import fr.avahip.apifcchamptracker.generic.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PlayerMapper extends GenericMapper<PlayerDto, Player> {
}
