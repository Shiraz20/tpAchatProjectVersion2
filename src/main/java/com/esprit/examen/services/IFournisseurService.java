package com.esprit.examen.services;

import java.util.List;

import com.esprit.examen.entities.dto.FournisseurDTO;
import com.esprit.examen.entities.Fournisseur;

public interface IFournisseurService {

	List<Fournisseur> retrieveAllFournisseurs();

	FournisseurDTO addFournisseur(FournisseurDTO f);

	void deleteFournisseur(Long id);

	FournisseurDTO updateFournisseur(FournisseurDTO f);

	Fournisseur retrieveFournisseur(Long id);
	
	void assignSecteurActiviteToFournisseur(Long idSecteurActivite, Long idFournisseur);

}
