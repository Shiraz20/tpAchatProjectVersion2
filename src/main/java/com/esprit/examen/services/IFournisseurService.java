package com.esprit.examen.services;

import java.util.List;

import com.esprit.examen.entities.DTO.FournisseurDTO;
import com.esprit.examen.entities.Fournisseur;
import org.springframework.stereotype.Service;

public interface IFournisseurService {

	List<Fournisseur> retrieveAllFournisseurs();

	FournisseurDTO addFournisseur(FournisseurDTO f);

	void deleteFournisseur(Long id);

	FournisseurDTO updateFournisseur(FournisseurDTO f);

	Fournisseur retrieveFournisseur(Long id);
	
	void assignSecteurActiviteToFournisseur(Long idSecteurActivite, Long idFournisseur);

}
