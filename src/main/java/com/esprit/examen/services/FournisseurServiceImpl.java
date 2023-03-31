package com.esprit.examen.services;

import java.util.Date;
import java.util.List;


import com.esprit.examen.entities.dto.FournisseurDTO;
import com.esprit.examen.services.mapper.FournisseurMapper;
import org.mapstruct.Qualifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;

@Service

public class FournisseurServiceImpl implements IFournisseurService {

    Logger log = LoggerFactory.getLogger(FournisseurServiceImpl.class);
    @Autowired
    FournisseurRepository fournisseurRepository;
    @Autowired
    DetailFournisseurRepository detailFournisseurRepository;
    @Autowired
    ProduitRepository produitRepository;
    @Autowired
    SecteurActiviteRepository secteurActiviteRepository;
    @Autowired
    FournisseurMapper fournisseurMapper;





    @Override
    public List<Fournisseur> retrieveAllFournisseurs() {
        List<Fournisseur> fournisseurs = fournisseurRepository.findAll();
        for (Fournisseur fournisseur : fournisseurs) {
            log.info(" fournisseur : " + fournisseur);
        }
        return fournisseurs;
    }


    public FournisseurDTO addFournisseur(FournisseurDTO f) {
        DetailFournisseur df = new DetailFournisseur();
        df.setDateDebutCollaboration(new Date());
        f.setDetailFournisseur(df);
        Fournisseur fournisseur = fournisseurMapper.toEntity(f);
        fournisseurRepository.save(fournisseur);
        return f;
    }

    private DetailFournisseur saveDetailFournisseur(FournisseurDTO f) {
        DetailFournisseur df = f.getDetailFournisseur();
        detailFournisseurRepository.save(df);
        return df;
    }

    public FournisseurDTO updateFournisseur(FournisseurDTO f) {
        DetailFournisseur df = saveDetailFournisseur(f);
        f.setDetailFournisseur(df);
        Fournisseur fournisseur = fournisseurMapper.toEntity(f);
        fournisseurRepository.save(fournisseur);
        return f;
    }

    @Override
    public void deleteFournisseur(Long fournisseurId) {
        fournisseurRepository.deleteById(fournisseurId);
    }

    @Override
    public Fournisseur retrieveFournisseur(Long fournisseurId) {
        return fournisseurRepository.findById(fournisseurId).orElse(null);
    }

    @Override
    public void assignSecteurActiviteToFournisseur(Long idSecteurActivite, Long idFournisseur) {
        Fournisseur fournisseur = fournisseurRepository.findById(idFournisseur).orElse(null);
        SecteurActivite secteurActivite = secteurActiviteRepository.findById(idSecteurActivite).orElse(null);
        if (fournisseur != null) {
            fournisseur.getSecteurActivites().add(secteurActivite);
        }
    }
//    add comment to test webhook
}