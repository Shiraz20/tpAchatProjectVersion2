package com.esprit.examen.services;


import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.FournisseurRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


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
}
