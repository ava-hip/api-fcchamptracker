package fr.avahip.apifcchamptracker.mapper;

import fr.avahip.apifcchamptracker.dto.TeamDto;
import fr.avahip.apifcchamptracker.entity.Team;
import fr.avahip.apifcchamptracker.generic.mapper.GenericMapper;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TeamMapper extends GenericMapper<TeamDto, Team> {

}
