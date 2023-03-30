package com.esprit.examen.services;


import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.entities.dto.FournisseurDTO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurServiceImplTest {

    @Autowired
    private IFournisseurService fournisseurService;



    @Test
    public void TestRetrieveAllFournisseurs(){
        List<Fournisseur> fournisseur=fournisseurService.retrieveAllFournisseurs();
        Assertions.assertNotNull(fournisseur);
    }

//    @Test
//    public void testAddFournisseur() {
//        // Setup
//        final FournisseurDTO f = new FournisseurDTO();
//        f.setIdFournisseur(0L);
//        f.setCode("code");
//        f.setLibelle("libelle");
//        final DetailFournisseur detailFournisseur = new DetailFournisseur();
//        detailFournisseur.setIdDetailFournisseur(0L);
//        detailFournisseur.setEmail("email");
//        detailFournisseur.setDateDebutCollaboration(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
//        detailFournisseur.setAdresse("adresse");
//        detailFournisseur.setMatricule("matricule");
//        final Fournisseur fournisseur = new Fournisseur();
//        fournisseur.setIdFournisseur(0L);
//        fournisseur.setCode("code");
//        fournisseur.setLibelle("libelle");
//        fournisseur.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
//        final Facture facture = new Facture();
//        fournisseur.setFactures(new HashSet<>(Arrays.asList(facture)));
//        detailFournisseur.setFournisseur(fournisseur);
//        f.setDetailFournisseur(detailFournisseur);
//
//        Assertions.assert
//    }
}
