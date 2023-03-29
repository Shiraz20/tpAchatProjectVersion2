package com.esprit.examen.services.mapper;


public interface EntityMapper <D,E>{
    E toEntity(D dto);
}
