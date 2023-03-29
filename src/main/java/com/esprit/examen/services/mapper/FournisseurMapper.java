package com.esprit.examen.services.mapper;

import com.esprit.examen.entities.DTO.FournisseurDTO;
import com.esprit.examen.entities.Fournisseur;
import org.mapstruct.Mapper;

@Mapper
public interface FournisseurMapper extends EntityMapper<FournisseurDTO, Fournisseur> {
}
