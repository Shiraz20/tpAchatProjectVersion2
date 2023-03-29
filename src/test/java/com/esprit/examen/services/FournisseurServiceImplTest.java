package com.esprit.examen.services;

import com.esprit.examen.entities.*;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FournisseurServiceImplTest {

    private FournisseurServiceImpl fournisseurServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        fournisseurServiceImplUnderTest = new FournisseurServiceImpl();
        fournisseurServiceImplUnderTest.fournisseurRepository = mock(FournisseurRepository.class);
        fournisseurServiceImplUnderTest.detailFournisseurRepository = mock(DetailFournisseurRepository.class);
        fournisseurServiceImplUnderTest.produitRepository = mock(ProduitRepository.class);
        fournisseurServiceImplUnderTest.secteurActiviteRepository = mock(SecteurActiviteRepository.class);
    }

    @Test
    void testRetrieveAllFournisseurs() {
        // Setup
        // Configure FournisseurRepository.findAll(...).
        final List<Fournisseur> fournisseurs = Arrays.asList(
                new Fournisseur(0L, "code", "libelle", CategorieFournisseur.ORDINAIRE, new HashSet<>(Arrays.asList(
                        new Facture(0L, 0.0f, 0.0f, new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), false, new HashSet<>(
                                Arrays.asList(new DetailFacture(0L, 0, 0.0f, 0, 0.0f,
                                        new Produit(0L, "codeProduit", "libelleProduit", 0.0f,
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                new Stock(0L, "libelleStock", 0, 0, new HashSet<>()), new HashSet<>(),
                                                new CategorieProduit(0L, "codeCategorie", "libelleCategorie",
                                                        new HashSet<>())), null))), null, new HashSet<>(Arrays.asList(
                                new Reglement(0L, 0.0f, 0.0f, false,
                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), null)))))),
                        new HashSet<>(Arrays.asList(
                                new SecteurActivite(0L, "codeSecteurActivite", "libelleSecteurActivite",
                                        new HashSet<>()))),
                        new DetailFournisseur(0L, "email", new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                "adresse", "matricule", null)));
        when(fournisseurServiceImplUnderTest.fournisseurRepository.findAll()).thenReturn(fournisseurs);

        // Run the test
        final List<Fournisseur> result = fournisseurServiceImplUnderTest.retrieveAllFournisseurs();

        // Verify the results
    }

    @Test
    void testRetrieveAllFournisseurs_FournisseurRepositoryReturnsNoItems() {
        // Setup
        when(fournisseurServiceImplUnderTest.fournisseurRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Fournisseur> result = fournisseurServiceImplUnderTest.retrieveAllFournisseurs();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testAddFournisseur() {
        // Setup
        final Fournisseur f = new Fournisseur(0L, "code", "libelle", CategorieFournisseur.ORDINAIRE, new HashSet<>(
                Arrays.asList(new Facture(0L, 0.0f, 0.0f, new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), false, new HashSet<>(Arrays.asList(
                        new DetailFacture(0L, 0, 0.0f, 0, 0.0f, new Produit(0L, "codeProduit", "libelleProduit", 0.0f,
                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                new Stock(0L, "libelleStock", 0, 0, new HashSet<>()), new HashSet<>(),
                                new CategorieProduit(0L, "codeCategorie", "libelleCategorie", new HashSet<>())),
                                null))), null, new HashSet<>(Arrays.asList(
                        new Reglement(0L, 0.0f, 0.0f, false, new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                null)))))), new HashSet<>(Arrays.asList(
                new SecteurActivite(0L, "codeSecteurActivite", "libelleSecteurActivite", new HashSet<>()))),
                new DetailFournisseur(0L, "email", new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                        "adresse", "matricule", null));

        // Configure FournisseurRepository.save(...).
        final Fournisseur fournisseur = new Fournisseur(0L, "code", "libelle", CategorieFournisseur.ORDINAIRE,
                new HashSet<>(Arrays.asList(
                        new Facture(0L, 0.0f, 0.0f, new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), false, new HashSet<>(
                                Arrays.asList(new DetailFacture(0L, 0, 0.0f, 0, 0.0f,
                                        new Produit(0L, "codeProduit", "libelleProduit", 0.0f,
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                new Stock(0L, "libelleStock", 0, 0, new HashSet<>()), new HashSet<>(),
                                                new CategorieProduit(0L, "codeCategorie", "libelleCategorie",
                                                        new HashSet<>())), null))), null, new HashSet<>(Arrays.asList(
                                new Reglement(0L, 0.0f, 0.0f, false,
                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), null)))))),
                new HashSet<>(Arrays.asList(
                        new SecteurActivite(0L, "codeSecteurActivite", "libelleSecteurActivite", new HashSet<>()))),
                new DetailFournisseur(0L, "email", new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                        "adresse", "matricule", null));
        when(fournisseurServiceImplUnderTest.fournisseurRepository.save(any(Fournisseur.class)))
                .thenReturn(fournisseur);

        // Run the test
        final Fournisseur result = fournisseurServiceImplUnderTest.addFournisseur(f);

        // Verify the results
        verify(fournisseurServiceImplUnderTest.fournisseurRepository).save(any(Fournisseur.class));
    }

    @Test
    void testUpdateFournisseur() {
        // Setup
        final Fournisseur f = new Fournisseur(0L, "code", "libelle", CategorieFournisseur.ORDINAIRE, new HashSet<>(
                Arrays.asList(new Facture(0L, 0.0f, 0.0f, new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), false, new HashSet<>(Arrays.asList(
                        new DetailFacture(0L, 0, 0.0f, 0, 0.0f, new Produit(0L, "codeProduit", "libelleProduit", 0.0f,
                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                new Stock(0L, "libelleStock", 0, 0, new HashSet<>()), new HashSet<>(),
                                new CategorieProduit(0L, "codeCategorie", "libelleCategorie", new HashSet<>())),
                                null))), null, new HashSet<>(Arrays.asList(
                        new Reglement(0L, 0.0f, 0.0f, false, new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                null)))))), new HashSet<>(Arrays.asList(
                new SecteurActivite(0L, "codeSecteurActivite", "libelleSecteurActivite", new HashSet<>()))),
                new DetailFournisseur(0L, "email", new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                        "adresse", "matricule", null));

        // Configure DetailFournisseurRepository.save(...).
        final DetailFournisseur detailFournisseur = new DetailFournisseur(0L, "email",
                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), "adresse", "matricule",
                new Fournisseur(0L, "code", "libelle", CategorieFournisseur.ORDINAIRE, new HashSet<>(Arrays.asList(
                        new Facture(0L, 0.0f, 0.0f, new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), false, new HashSet<>(
                                Arrays.asList(new DetailFacture(0L, 0, 0.0f, 0, 0.0f,
                                        new Produit(0L, "codeProduit", "libelleProduit", 0.0f,
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                new Stock(0L, "libelleStock", 0, 0, new HashSet<>()), new HashSet<>(),
                                                new CategorieProduit(0L, "codeCategorie", "libelleCategorie",
                                                        new HashSet<>())), null))), null, new HashSet<>(Arrays.asList(
                                new Reglement(0L, 0.0f, 0.0f, false,
                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), null)))))),
                        new HashSet<>(Arrays.asList(
                                new SecteurActivite(0L, "codeSecteurActivite", "libelleSecteurActivite",
                                        new HashSet<>()))), null));
        when(fournisseurServiceImplUnderTest.detailFournisseurRepository.save(any(DetailFournisseur.class)))
                .thenReturn(detailFournisseur);

        // Configure FournisseurRepository.save(...).
        final Fournisseur fournisseur = new Fournisseur(0L, "code", "libelle", CategorieFournisseur.ORDINAIRE,
                new HashSet<>(Arrays.asList(
                        new Facture(0L, 0.0f, 0.0f, new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), false, new HashSet<>(
                                Arrays.asList(new DetailFacture(0L, 0, 0.0f, 0, 0.0f,
                                        new Produit(0L, "codeProduit", "libelleProduit", 0.0f,
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                new Stock(0L, "libelleStock", 0, 0, new HashSet<>()), new HashSet<>(),
                                                new CategorieProduit(0L, "codeCategorie", "libelleCategorie",
                                                        new HashSet<>())), null))), null, new HashSet<>(Arrays.asList(
                                new Reglement(0L, 0.0f, 0.0f, false,
                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), null)))))),
                new HashSet<>(Arrays.asList(
                        new SecteurActivite(0L, "codeSecteurActivite", "libelleSecteurActivite", new HashSet<>()))),
                new DetailFournisseur(0L, "email", new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                        "adresse", "matricule", null));
        when(fournisseurServiceImplUnderTest.fournisseurRepository.save(any(Fournisseur.class)))
                .thenReturn(fournisseur);

        // Run the test
        final Fournisseur result = fournisseurServiceImplUnderTest.updateFournisseur(f);

        // Verify the results
        verify(fournisseurServiceImplUnderTest.detailFournisseurRepository).save(any(DetailFournisseur.class));
        verify(fournisseurServiceImplUnderTest.fournisseurRepository).save(any(Fournisseur.class));
    }

    @Test
    void testDeleteFournisseur() {
        // Setup
        // Run the test
        fournisseurServiceImplUnderTest.deleteFournisseur(0L);

        // Verify the results
        verify(fournisseurServiceImplUnderTest.fournisseurRepository).deleteById(0L);
    }

    @Test
    void testRetrieveFournisseur() {
        // Setup
        // Configure FournisseurRepository.findById(...).
        final Optional<Fournisseur> fournisseur = Optional.of(
                new Fournisseur(0L, "code", "libelle", CategorieFournisseur.ORDINAIRE, new HashSet<>(Arrays.asList(
                        new Facture(0L, 0.0f, 0.0f, new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), false, new HashSet<>(
                                Arrays.asList(new DetailFacture(0L, 0, 0.0f, 0, 0.0f,
                                        new Produit(0L, "codeProduit", "libelleProduit", 0.0f,
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                new Stock(0L, "libelleStock", 0, 0, new HashSet<>()), new HashSet<>(),
                                                new CategorieProduit(0L, "codeCategorie", "libelleCategorie",
                                                        new HashSet<>())), null))), null, new HashSet<>(Arrays.asList(
                                new Reglement(0L, 0.0f, 0.0f, false,
                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), null)))))),
                        new HashSet<>(Arrays.asList(
                                new SecteurActivite(0L, "codeSecteurActivite", "libelleSecteurActivite",
                                        new HashSet<>()))),
                        new DetailFournisseur(0L, "email", new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                "adresse", "matricule", null)));
        when(fournisseurServiceImplUnderTest.fournisseurRepository.findById(0L)).thenReturn(fournisseur);

        // Run the test
        final Fournisseur result = fournisseurServiceImplUnderTest.retrieveFournisseur(0L);

        // Verify the results
    }

    @Test
    void testRetrieveFournisseur_FournisseurRepositoryReturnsAbsent() {
        // Setup
        when(fournisseurServiceImplUnderTest.fournisseurRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        final Fournisseur result = fournisseurServiceImplUnderTest.retrieveFournisseur(0L);

        // Verify the results
        assertThat(result).isNull();
    }

    @Test
    void testAssignSecteurActiviteToFournisseur() {
        // Setup
        // Configure FournisseurRepository.findById(...).
        final Optional<Fournisseur> fournisseur = Optional.of(
                new Fournisseur(0L, "code", "libelle", CategorieFournisseur.ORDINAIRE, new HashSet<>(Arrays.asList(
                        new Facture(0L, 0.0f, 0.0f, new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), false, new HashSet<>(
                                Arrays.asList(new DetailFacture(0L, 0, 0.0f, 0, 0.0f,
                                        new Produit(0L, "codeProduit", "libelleProduit", 0.0f,
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                new Stock(0L, "libelleStock", 0, 0, new HashSet<>()), new HashSet<>(),
                                                new CategorieProduit(0L, "codeCategorie", "libelleCategorie",
                                                        new HashSet<>())), null))), null, new HashSet<>(Arrays.asList(
                                new Reglement(0L, 0.0f, 0.0f, false,
                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), null)))))),
                        new HashSet<>(Arrays.asList(
                                new SecteurActivite(0L, "codeSecteurActivite", "libelleSecteurActivite",
                                        new HashSet<>()))),
                        new DetailFournisseur(0L, "email", new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                "adresse", "matricule", null)));
        when(fournisseurServiceImplUnderTest.fournisseurRepository.findById(0L)).thenReturn(fournisseur);

        // Configure SecteurActiviteRepository.findById(...).
        final Optional<SecteurActivite> secteurActivite = Optional.of(
                new SecteurActivite(0L, "codeSecteurActivite", "libelleSecteurActivite", new HashSet<>(Arrays.asList(
                        new Fournisseur(0L, "code", "libelle", CategorieFournisseur.ORDINAIRE, new HashSet<>(
                                Arrays.asList(new Facture(0L, 0.0f, 0.0f,
                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), false,
                                        new HashSet<>(Arrays.asList(new DetailFacture(0L, 0, 0.0f, 0, 0.0f,
                                                new Produit(0L, "codeProduit", "libelleProduit", 0.0f,
                                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                        new Stock(0L, "libelleStock", 0, 0, new HashSet<>()),
                                                        new HashSet<>(),
                                                        new CategorieProduit(0L, "codeCategorie", "libelleCategorie",
                                                                new HashSet<>())), null))), null, new HashSet<>(
                                        Arrays.asList(new Reglement(0L, 0.0f, 0.0f, false,
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), null)))))),
                                new HashSet<>(), new DetailFournisseur(0L, "email",
                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), "adresse", "matricule",
                                null))))));
        when(fournisseurServiceImplUnderTest.secteurActiviteRepository.findById(0L)).thenReturn(secteurActivite);

        // Run the test
        fournisseurServiceImplUnderTest.assignSecteurActiviteToFournisseur(0L, 0L);

        // Verify the results
    }

    @Test
    void testAssignSecteurActiviteToFournisseur_FournisseurRepositoryReturnsAbsent() {
        // Setup
        when(fournisseurServiceImplUnderTest.fournisseurRepository.findById(0L)).thenReturn(Optional.empty());

        // Configure SecteurActiviteRepository.findById(...).
        final Optional<SecteurActivite> secteurActivite = Optional.of(
                new SecteurActivite(0L, "codeSecteurActivite", "libelleSecteurActivite", new HashSet<>(Arrays.asList(
                        new Fournisseur(0L, "code", "libelle", CategorieFournisseur.ORDINAIRE, new HashSet<>(
                                Arrays.asList(new Facture(0L, 0.0f, 0.0f,
                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), false,
                                        new HashSet<>(Arrays.asList(new DetailFacture(0L, 0, 0.0f, 0, 0.0f,
                                                new Produit(0L, "codeProduit", "libelleProduit", 0.0f,
                                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                        new Stock(0L, "libelleStock", 0, 0, new HashSet<>()),
                                                        new HashSet<>(),
                                                        new CategorieProduit(0L, "codeCategorie", "libelleCategorie",
                                                                new HashSet<>())), null))), null, new HashSet<>(
                                        Arrays.asList(new Reglement(0L, 0.0f, 0.0f, false,
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), null)))))),
                                new HashSet<>(), new DetailFournisseur(0L, "email",
                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), "adresse", "matricule",
                                null))))));
        when(fournisseurServiceImplUnderTest.secteurActiviteRepository.findById(0L)).thenReturn(secteurActivite);

        // Run the test
        fournisseurServiceImplUnderTest.assignSecteurActiviteToFournisseur(0L, 0L);

        // Verify the results
    }

    @Test
    void testAssignSecteurActiviteToFournisseur_SecteurActiviteRepositoryReturnsAbsent() {
        // Setup
        // Configure FournisseurRepository.findById(...).
        final Optional<Fournisseur> fournisseur = Optional.of(
                new Fournisseur(0L, "code", "libelle", CategorieFournisseur.ORDINAIRE, new HashSet<>(Arrays.asList(
                        new Facture(0L, 0.0f, 0.0f, new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), false, new HashSet<>(
                                Arrays.asList(new DetailFacture(0L, 0, 0.0f, 0, 0.0f,
                                        new Produit(0L, "codeProduit", "libelleProduit", 0.0f,
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                                new Stock(0L, "libelleStock", 0, 0, new HashSet<>()), new HashSet<>(),
                                                new CategorieProduit(0L, "codeCategorie", "libelleCategorie",
                                                        new HashSet<>())), null))), null, new HashSet<>(Arrays.asList(
                                new Reglement(0L, 0.0f, 0.0f, false,
                                        new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(), null)))))),
                        new HashSet<>(Arrays.asList(
                                new SecteurActivite(0L, "codeSecteurActivite", "libelleSecteurActivite",
                                        new HashSet<>()))),
                        new DetailFournisseur(0L, "email", new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime(),
                                "adresse", "matricule", null)));
        when(fournisseurServiceImplUnderTest.fournisseurRepository.findById(0L)).thenReturn(fournisseur);

        when(fournisseurServiceImplUnderTest.secteurActiviteRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        fournisseurServiceImplUnderTest.assignSecteurActiviteToFournisseur(0L, 0L);

        // Verify the results
    }
}
