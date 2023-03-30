package com.esprit.examen.services;



import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
import java.util.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplMockTest {

    @Mock
    ProduitRepository produitRepository;

    @InjectMocks
    IProduitService produitService = new ProduitServiceImpl();


    @Test
    public void TestretrieveAllProduits(){
        List<Produit> produits = new ArrayList();
        produits.add(new Produit(100L, "COS","cosmetique", new Date(), new Date()));
        produitRepository = mock(ProduitRepository.class);
        when(produitRepository.findAll()).thenReturn(produits);
        List<Produit> expected = produitService.retrieveAllProduits();
        Assertions.assertEquals(expected, produits);
        verify(produitRepository).findAll();
    }
    @Test
    public void testCreateProduit() {
        Produit obj = new Produit(100L, "COS","cosmetique", new Date(), new Date());

        produitRepository = mock(ProduitRepository.class);
        when(produitRepository.save(isA(Produit.class))).thenAnswer(invocation -> (Produit) invocation.getArguments()[0]);
        Produit returnedObj = produitRepository.save(obj);
        ArgumentCaptor<Produit> savedObjectArgument = ArgumentCaptor.forClass(Produit.class);
        verify(produitRepository, times(1)).save(savedObjectArgument.capture());
        verifyNoMoreInteractions(produitRepository);

        Produit savedRestObject = savedObjectArgument.getValue();
        Assertions.assertNotNull(savedRestObject);

    }
    @Test
    public void testDeleteProduit() {
        Produit produit = new Produit(1L, "COS","cosmetique", new Date(), new Date());
        produit.setCodeProduit("new test");
        produitRepository = mock(ProduitRepository.class);

        when(produitRepository.findById(produit.getIdProduit())).thenReturn(Optional.of(produit));
        Produit produitq = produitRepository.findById(1L).orElse(null);
        assert produitq != null;
        produitRepository.deleteById(produitq.getIdProduit());
        verify(produitRepository).deleteById(produitq.getIdProduit());
    }

}
