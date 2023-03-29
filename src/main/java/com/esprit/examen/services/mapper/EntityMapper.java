package com.esprit.examen.services.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface EntityMapper <D,E>{
    E toEntity(D dto);
    D toDto(E entity);

}
