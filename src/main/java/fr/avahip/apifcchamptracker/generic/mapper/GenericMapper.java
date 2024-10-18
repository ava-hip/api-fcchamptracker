package fr.avahip.apifcchamptracker.generic.mapper;

import org.mapstruct.*;

public interface GenericMapper<D, E> {
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    D toDto(E entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    E toEntity(D dto);
}
