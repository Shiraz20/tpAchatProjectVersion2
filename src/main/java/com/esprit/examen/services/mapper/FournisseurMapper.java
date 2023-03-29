package com.esprit.examen.services.mapper;

import com.esprit.examen.entities.dto.FournisseurDTO;
import com.esprit.examen.entities.Fournisseur;
import org.mapstruct.Mapper;

@Mapper
public interface FournisseurMapper extends EntityMapper<FournisseurDTO, Fournisseur> {
    Fournisseur toEntity(FournisseurDTO fournisseurDTO);
}
