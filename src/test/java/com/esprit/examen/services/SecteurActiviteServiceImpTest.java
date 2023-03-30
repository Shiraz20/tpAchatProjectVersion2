package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;


class SecteurActiviteServiceTest1 {

    private SecteurActivite[] activite;
    private SecteurActiviteRepository secteurActiviteRepository;

    public void setUp() {
        activite = initSecteurActiviteInstance();
        secteurActiviteRepository = mock(SecteurActiviteRepository.class);
        when(secteurActiviteRepository.count()).thenReturn(Long.valueOf(activite.length));
        when(secteurActiviteRepository.save(activite[0]))
                .thenReturn(activite[0]);
    }

    private SecteurActivite[] initSecteurActiviteInstance() {
        activite = new SecteurActivite[] {
                new SecteurActivite("code1", 1L, "libelle1"),
                new SecteurActivite("code2", 2L, "libelle2"),
                new SecteurActivite("code3", 3L, "libelle3")
        };
        return activite;
    }

    @Test
    void testCount() {
        setUp();
        assertEquals(secteurActiviteRepository.count(), activite.length);
    }

    @Test
    void testSave() {
        setUp();
        SecteurActivite sa = secteurActiviteRepository.save(activite[0]);
        assertNotNull(sa);
    }

}
