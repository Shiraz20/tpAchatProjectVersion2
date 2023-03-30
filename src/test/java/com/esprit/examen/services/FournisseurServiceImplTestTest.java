package com.esprit.examen.services;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.DetailFacture;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.entities.Fournisseur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FournisseurServiceImplTestTest {

    @Mock
    private IFournisseurService mockFournisseurService;

    @InjectMocks
    private FournisseurServiceImplTest fournisseurServiceImplTestUnderTest;

    @Test
    void testTestRetrieveAllFournisseurs() {

        final Fournisseur fournisseur = new Fournisseur();
        fournisseur.setIdFournisseur(0L);
        fournisseur.setCode("code");
        fournisseur.setLibelle("libelle");
        fournisseur.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        final Facture facture = new Facture();
        facture.setIdFacture(0L);
        facture.setMontantRemise(0.0f);
        facture.setMontantFacture(0.0f);
        facture.setDateCreationFacture(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        facture.setDateDerniereModificationFacture(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        facture.setArchivee(false);
        final DetailFacture detailFacture = new DetailFacture();
        detailFacture.setIdDetailFacture(0L);
        detailFacture.setQteCommandee(0);
        detailFacture.setPrixTotalDetail(0.0f);
        facture.setDetailsFacture(new HashSet<>(Arrays.asList(detailFacture)));
        fournisseur.setFactures(new HashSet<>(Arrays.asList(facture)));
        final List<Fournisseur> fournisseurs = Arrays.asList(fournisseur);
        when(mockFournisseurService.retrieveAllFournisseurs()).thenReturn(fournisseurs);

        // Run the test
        fournisseurServiceImplTestUnderTest.TestRetrieveAllFournisseurs();
        Assertions.assertNotNull(fournisseur);

        // Verify the results
    }

    @Test
    void testTestRetrieveAllFournisseurs_IFournisseurServiceReturnsNoItems() {
        // Setup
        when(mockFournisseurService.retrieveAllFournisseurs()).thenReturn(Collections.emptyList());

        // Run the test
        fournisseurServiceImplTestUnderTest.TestRetrieveAllFournisseurs();

        // Verify the results
    }
}
