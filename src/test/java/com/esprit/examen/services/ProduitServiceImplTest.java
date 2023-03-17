/*
package com.esprit.examen.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.StockRepository;

@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplTest {

    @InjectMocks
    ProduitServiceImpl produitService;

    @Mock
    ProduitRepository produitRepository;

    @Mock
    StockRepository stockRepository;

    @Mock
    CategorieProduitRepository categorieProduitRepository;

    @Test
    public void testRetrieveAllProduits() {
        // Given
        Produit produit1 = new Produit(1L, "Produit 1", "Description 1", new Date(), new CategorieProduit(), new Stock());
        Produit produit2 = new Produit(2L, "Produit 2", "Description 2", new Date(), new CategorieProduit(), new Stock());
        List<Produit> produits = new ArrayList<>();
        produits.add(produit1);
        produits.add(produit2);
        when(produitRepository.findAll()).thenReturn(produits);

        // When
        List<Produit> result = produitService.retrieveAllProduits();

        // Then
        assertThat(result).hasSize(2);
        assertThat(result).containsExactly(produit1, produit2);
    }

    @Test
    public void testAddProduit() {
        // Given
        Produit produit = new Produit(1L, "Produit 1", "Description 1", new Date(), new CategorieProduit(), new Stock());
        when(produitRepository.save(any(Produit.class))).thenReturn(produit);

        // When
        Produit result = produitService.addProduit(produit);

        // Then
        assertThat(result).isEqualTo(produit);
    }

    @Test
    public void testDeleteProduit() {
        // Given
        Long produitId = 1L;
        doNothing().when(produitRepository).deleteById(produitId);

        // When
        produitService.deleteProduit(produitId);

        // Then
        // No exception should be thrown
    }

    @Test
    public void testUpdateProduit() {
        // Given
        Produit produit = new Produit(1L, "Produit 1", "Description 1", new Date(), new CategorieProduit(), new Stock());
        when(produitRepository.save(any(Produit.class))).thenReturn(produit);

        // When
        Produit result = produitService.updateProduit(produit);

        // Then
        assertThat(result).isEqualTo(produit);
    }

   
    @Test
    public void testRetrieveProduit() {
        // Given
        Produit produit = new Produit();
        produit.setNom("Produit Test");
        produit.setPrix(100.0);
        produit.setDateCreation(new Date());
        produit.setDescription("Description produit Test");
        produit.setReference("Ref-Test");
        produitService.addProduit(produit);

        // When
        Produit produitResult = produitService.retrieveProduit(produit.getId());

        // Then
        assertNotNull(produitResult);
        assertEquals(produit.getNom(), produitResult.getNom());
        assertEquals(produit.getPrix(), produitResult.getPrix());
        assertEquals(produit.getDateCreation(), produitResult.getDateCreation());
        assertEquals(produit.getDescription(), produitResult.getDescription());
        assertEquals(produit.getReference(), produitResult.getReference());

        // Clean-up
        produitService.deleteProduit(produit.getId());
    }

    @Test
    public void testAssignProduitToStock() {
        // Given
        Produit produit = new Produit();
        produit.setNom("Produit Test");
        produit.setPrix(100.0);
        produit.setDateCreation(new Date());
        produit.setDescription("Description produit Test");
        produit.setReference("Ref-Test");
        produitService.addProduit(produit);

        Stock stock = new Stock();
        stock.setAdresse("Adresse Test");
        stock.setCapacite(100);
        produitService.getStockRepository().save(stock);

        // When
        produitService.assignProduitToStock(produit.getId(), stock.getId());

        // Then
        Produit produitResult = produitService.retrieveProduit(produit.getId());
        assertEquals(stock.getId(), produitResult.getStock().getId());

        // Clean-up
        produitService.deleteProduit(produit.getId());
        produitService.getStockRepository().delete(stock);
    }
*/
