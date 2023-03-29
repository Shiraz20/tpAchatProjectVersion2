package com.esprit.examen.services;

import com.esprit.examen.entities.*;
import com.esprit.examen.entities.dto.FournisseurDTO;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import com.esprit.examen.services.mapper.FournisseurMapper;
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
        fournisseurServiceImplUnderTest.fournisseurMapper = mock(FournisseurMapper.class);
    }

    @Test
    void testRetrieveAllFournisseurs() {
        // Setup
        // Configure FournisseurRepository.findAll(...).
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
        facture.setDetailsFacture(new HashSet<>(Arrays.asList(detailFacture)));
        fournisseur.setFactures(new HashSet<>(Arrays.asList(facture)));
        final SecteurActivite secteurActivite = new SecteurActivite();
        fournisseur.setSecteurActivites(new HashSet<>(Arrays.asList(secteurActivite)));
        final List<Fournisseur> fournisseurs = Arrays.asList(fournisseur);
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
        final FournisseurDTO f = new FournisseurDTO();
        f.setIdFournisseur(0L);
        f.setCode("code");
        f.setLibelle("libelle");
        final DetailFournisseur detailFournisseur = new DetailFournisseur();
        detailFournisseur.setIdDetailFournisseur(0L);
        detailFournisseur.setEmail("email");
        detailFournisseur.setDateDebutCollaboration(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        detailFournisseur.setAdresse("adresse");
        detailFournisseur.setMatricule("matricule");
        final Fournisseur fournisseur = new Fournisseur();
        fournisseur.setIdFournisseur(0L);
        fournisseur.setCode("code");
        fournisseur.setLibelle("libelle");
        fournisseur.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        final Facture facture = new Facture();
        fournisseur.setFactures(new HashSet<>(Arrays.asList(facture)));
        detailFournisseur.setFournisseur(fournisseur);
        f.setDetailFournisseur(detailFournisseur);

        // Configure FournisseurMapper.toEntity(...).
        final Fournisseur fournisseur1 = new Fournisseur();
        fournisseur1.setIdFournisseur(0L);
        fournisseur1.setCode("code");
        fournisseur1.setLibelle("libelle");
        fournisseur1.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        final Facture facture1 = new Facture();
        facture1.setIdFacture(0L);
        facture1.setMontantRemise(0.0f);
        facture1.setMontantFacture(0.0f);
        facture1.setDateCreationFacture(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        facture1.setDateDerniereModificationFacture(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        facture1.setArchivee(false);
        final DetailFacture detailFacture = new DetailFacture();
        detailFacture.setIdDetailFacture(0L);
        detailFacture.setQteCommandee(0);
        facture1.setDetailsFacture(new HashSet<>(Arrays.asList(detailFacture)));
        fournisseur1.setFactures(new HashSet<>(Arrays.asList(facture1)));
        final SecteurActivite secteurActivite = new SecteurActivite();
        fournisseur1.setSecteurActivites(new HashSet<>(Arrays.asList(secteurActivite)));
        when(fournisseurServiceImplUnderTest.fournisseurMapper.toEntity(any(FournisseurDTO.class)))
                .thenReturn(fournisseur1);

        // Configure FournisseurRepository.save(...).
        final Fournisseur fournisseur2 = new Fournisseur();
        fournisseur2.setIdFournisseur(0L);
        fournisseur2.setCode("code");
        fournisseur2.setLibelle("libelle");
        fournisseur2.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        final Facture facture2 = new Facture();
        facture2.setIdFacture(0L);
        facture2.setMontantRemise(0.0f);
        facture2.setMontantFacture(0.0f);
        facture2.setDateCreationFacture(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        facture2.setDateDerniereModificationFacture(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        facture2.setArchivee(false);
        final DetailFacture detailFacture1 = new DetailFacture();
        detailFacture1.setIdDetailFacture(0L);
        detailFacture1.setQteCommandee(0);
        facture2.setDetailsFacture(new HashSet<>(Arrays.asList(detailFacture1)));
        fournisseur2.setFactures(new HashSet<>(Arrays.asList(facture2)));
        final SecteurActivite secteurActivite1 = new SecteurActivite();
        fournisseur2.setSecteurActivites(new HashSet<>(Arrays.asList(secteurActivite1)));
        when(fournisseurServiceImplUnderTest.fournisseurRepository.save(any(Fournisseur.class)))
                .thenReturn(fournisseur2);

        // Run the test
        final FournisseurDTO result = fournisseurServiceImplUnderTest.addFournisseur(f);

        // Verify the results
        verify(fournisseurServiceImplUnderTest.fournisseurRepository).save(any(Fournisseur.class));
    }

    @Test
    void testUpdateFournisseur() {
        // Setup
        final FournisseurDTO f = new FournisseurDTO();
        f.setIdFournisseur(0L);
        f.setCode("code");
        f.setLibelle("libelle");
        final DetailFournisseur detailFournisseur = new DetailFournisseur();
        detailFournisseur.setIdDetailFournisseur(0L);
        detailFournisseur.setEmail("email");
        detailFournisseur.setDateDebutCollaboration(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        detailFournisseur.setAdresse("adresse");
        detailFournisseur.setMatricule("matricule");
        final Fournisseur fournisseur = new Fournisseur();
        fournisseur.setIdFournisseur(0L);
        fournisseur.setCode("code");
        fournisseur.setLibelle("libelle");
        fournisseur.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        final Facture facture = new Facture();
        fournisseur.setFactures(new HashSet<>(Arrays.asList(facture)));
        detailFournisseur.setFournisseur(fournisseur);
        f.setDetailFournisseur(detailFournisseur);

        // Configure DetailFournisseurRepository.save(...).
        final DetailFournisseur detailFournisseur1 = new DetailFournisseur();
        detailFournisseur1.setIdDetailFournisseur(0L);
        detailFournisseur1.setEmail("email");
        detailFournisseur1.setDateDebutCollaboration(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        detailFournisseur1.setAdresse("adresse");
        detailFournisseur1.setMatricule("matricule");
        final Fournisseur fournisseur1 = new Fournisseur();
        fournisseur1.setIdFournisseur(0L);
        fournisseur1.setCode("code");
        fournisseur1.setLibelle("libelle");
        fournisseur1.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        final Facture facture1 = new Facture();
        facture1.setIdFacture(0L);
        facture1.setMontantRemise(0.0f);
        facture1.setMontantFacture(0.0f);
        facture1.setDateCreationFacture(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        fournisseur1.setFactures(new HashSet<>(Arrays.asList(facture1)));
        detailFournisseur1.setFournisseur(fournisseur1);
        when(fournisseurServiceImplUnderTest.detailFournisseurRepository.save(any(DetailFournisseur.class)))
                .thenReturn(detailFournisseur1);

        // Configure FournisseurMapper.toEntity(...).
        final Fournisseur fournisseur2 = new Fournisseur();
        fournisseur2.setIdFournisseur(0L);
        fournisseur2.setCode("code");
        fournisseur2.setLibelle("libelle");
        fournisseur2.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        final Facture facture2 = new Facture();
        facture2.setIdFacture(0L);
        facture2.setMontantRemise(0.0f);
        facture2.setMontantFacture(0.0f);
        facture2.setDateCreationFacture(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        facture2.setDateDerniereModificationFacture(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        facture2.setArchivee(false);
        final DetailFacture detailFacture = new DetailFacture();
        detailFacture.setIdDetailFacture(0L);
        detailFacture.setQteCommandee(0);
        facture2.setDetailsFacture(new HashSet<>(Arrays.asList(detailFacture)));
        fournisseur2.setFactures(new HashSet<>(Arrays.asList(facture2)));
        final SecteurActivite secteurActivite = new SecteurActivite();
        fournisseur2.setSecteurActivites(new HashSet<>(Arrays.asList(secteurActivite)));
        when(fournisseurServiceImplUnderTest.fournisseurMapper.toEntity(any(FournisseurDTO.class)))
                .thenReturn(fournisseur2);

        // Configure FournisseurRepository.save(...).
        final Fournisseur fournisseur3 = new Fournisseur();
        fournisseur3.setIdFournisseur(0L);
        fournisseur3.setCode("code");
        fournisseur3.setLibelle("libelle");
        fournisseur3.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        final Facture facture3 = new Facture();
        facture3.setIdFacture(0L);
        facture3.setMontantRemise(0.0f);
        facture3.setMontantFacture(0.0f);
        facture3.setDateCreationFacture(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        facture3.setDateDerniereModificationFacture(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        facture3.setArchivee(false);
        final DetailFacture detailFacture1 = new DetailFacture();
        detailFacture1.setIdDetailFacture(0L);
        detailFacture1.setQteCommandee(0);
        facture3.setDetailsFacture(new HashSet<>(Arrays.asList(detailFacture1)));
        fournisseur3.setFactures(new HashSet<>(Arrays.asList(facture3)));
        final SecteurActivite secteurActivite1 = new SecteurActivite();
        fournisseur3.setSecteurActivites(new HashSet<>(Arrays.asList(secteurActivite1)));
        when(fournisseurServiceImplUnderTest.fournisseurRepository.save(any(Fournisseur.class)))
                .thenReturn(fournisseur3);

        // Run the test
        final FournisseurDTO result = fournisseurServiceImplUnderTest.updateFournisseur(f);

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
        final Fournisseur fournisseur1 = new Fournisseur();
        fournisseur1.setIdFournisseur(0L);
        fournisseur1.setCode("code");
        fournisseur1.setLibelle("libelle");
        fournisseur1.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
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
        facture.setDetailsFacture(new HashSet<>(Arrays.asList(detailFacture)));
        fournisseur1.setFactures(new HashSet<>(Arrays.asList(facture)));
        final SecteurActivite secteurActivite = new SecteurActivite();
        fournisseur1.setSecteurActivites(new HashSet<>(Arrays.asList(secteurActivite)));
        final Optional<Fournisseur> fournisseur = Optional.of(fournisseur1);
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
        final Fournisseur fournisseur1 = new Fournisseur();
        fournisseur1.setIdFournisseur(0L);
        fournisseur1.setCode("code");
        fournisseur1.setLibelle("libelle");
        fournisseur1.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
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
        facture.setDetailsFacture(new HashSet<>(Arrays.asList(detailFacture)));
        fournisseur1.setFactures(new HashSet<>(Arrays.asList(facture)));
        final SecteurActivite secteurActivite = new SecteurActivite();
        fournisseur1.setSecteurActivites(new HashSet<>(Arrays.asList(secteurActivite)));
        final Optional<Fournisseur> fournisseur = Optional.of(fournisseur1);
        when(fournisseurServiceImplUnderTest.fournisseurRepository.findById(0L)).thenReturn(fournisseur);

        // Configure SecteurActiviteRepository.findById(...).
        final SecteurActivite secteurActivite2 = new SecteurActivite();
        secteurActivite2.setIdSecteurActivite(0L);
        secteurActivite2.setCodeSecteurActivite("codeSecteurActivite");
        secteurActivite2.setLibelleSecteurActivite("libelleSecteurActivite");
        final Fournisseur fournisseur2 = new Fournisseur();
        fournisseur2.setIdFournisseur(0L);
        fournisseur2.setCode("code");
        fournisseur2.setLibelle("libelle");
        fournisseur2.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
        final Facture facture1 = new Facture();
        facture1.setIdFacture(0L);
        facture1.setMontantRemise(0.0f);
        facture1.setMontantFacture(0.0f);
        facture1.setDateCreationFacture(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        facture1.setDateDerniereModificationFacture(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        facture1.setArchivee(false);
        fournisseur2.setFactures(new HashSet<>(Arrays.asList(facture1)));
        secteurActivite2.setFournisseurs(new HashSet<>(Arrays.asList(fournisseur2)));
        final Optional<SecteurActivite> secteurActivite1 = Optional.of(secteurActivite2);
        when(fournisseurServiceImplUnderTest.secteurActiviteRepository.findById(0L)).thenReturn(secteurActivite1);

        // Run the test
        fournisseurServiceImplUnderTest.assignSecteurActiviteToFournisseur(0L, 0L);

        // Verify the results
    }

    @Test
    void testAssignSecteurActiviteToFournisseur_FournisseurRepositoryReturnsAbsent() {
        // Setup
        when(fournisseurServiceImplUnderTest.fournisseurRepository.findById(0L)).thenReturn(Optional.empty());

        // Configure SecteurActiviteRepository.findById(...).
        final SecteurActivite secteurActivite1 = new SecteurActivite();
        secteurActivite1.setIdSecteurActivite(0L);
        secteurActivite1.setCodeSecteurActivite("codeSecteurActivite");
        secteurActivite1.setLibelleSecteurActivite("libelleSecteurActivite");
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
        fournisseur.setFactures(new HashSet<>(Arrays.asList(facture)));
        secteurActivite1.setFournisseurs(new HashSet<>(Arrays.asList(fournisseur)));
        final Optional<SecteurActivite> secteurActivite = Optional.of(secteurActivite1);
        when(fournisseurServiceImplUnderTest.secteurActiviteRepository.findById(0L)).thenReturn(secteurActivite);

        // Run the test
        fournisseurServiceImplUnderTest.assignSecteurActiviteToFournisseur(0L, 0L);

        // Verify the results
    }

    @Test
    void testAssignSecteurActiviteToFournisseur_SecteurActiviteRepositoryReturnsAbsent() {
        // Setup
        // Configure FournisseurRepository.findById(...).
        final Fournisseur fournisseur1 = new Fournisseur();
        fournisseur1.setIdFournisseur(0L);
        fournisseur1.setCode("code");
        fournisseur1.setLibelle("libelle");
        fournisseur1.setCategorieFournisseur(CategorieFournisseur.ORDINAIRE);
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
        facture.setDetailsFacture(new HashSet<>(Arrays.asList(detailFacture)));
        fournisseur1.setFactures(new HashSet<>(Arrays.asList(facture)));
        final SecteurActivite secteurActivite = new SecteurActivite();
        fournisseur1.setSecteurActivites(new HashSet<>(Arrays.asList(secteurActivite)));
        final Optional<Fournisseur> fournisseur = Optional.of(fournisseur1);
        when(fournisseurServiceImplUnderTest.fournisseurRepository.findById(0L)).thenReturn(fournisseur);

        when(fournisseurServiceImplUnderTest.secteurActiviteRepository.findById(0L)).thenReturn(Optional.empty());

        // Run the test
        fournisseurServiceImplUnderTest.assignSecteurActiviteToFournisseur(0L, 0L);

        // Verify the results
    }
}
