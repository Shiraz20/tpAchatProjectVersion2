package com.esprit.examen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;

@Service
public class SecteurActiviteServiceImpl implements ISecteurActiviteService{

	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;
	@Override
	public List<SecteurActivite> retrieveAllSecteurActivite() {
		return (List<SecteurActivite>) secteurActiviteRepository.findAll();
	}

	@Override
	public SecteurActivite addSecteurActivite(SecteurActivite sa) {
		secteurActiviteRepository.save(sa);
		return sa;
	}

	@Override
	public void deleteSecteurActivite(Long id) {
		secteurActiviteRepository.deleteById(id);

	}


	@Override
	public SecteurActivite updateSecteurActivite(SecteurActivite sa) {
		Optional<SecteurActivite> existingSecteurActivite = secteurActiviteRepository.findById(sa.getIdSecteurActivite());
		if (existingSecteurActivite.isPresent()) {
			SecteurActivite updatedSecteurActivite = existingSecteurActivite.get();
			updatedSecteurActivite.setLibelleSecteurActivite(sa.getLibelleSecteurActivite());
			updatedSecteurActivite.setCodeSecteurActivite(sa.getCodeSecteurActivite());
			secteurActiviteRepository.save(updatedSecteurActivite);
			return updatedSecteurActivite;
		} else {
			// handle error when secteurActivite with given id is not found
			return null;
		}
	}

	@Override
	public SecteurActivite retrieveSecteurActivite(Long id) {
		return secteurActiviteRepository.findById(id).orElse(null);
	}
//ons


}
