package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.esprit.examen.entities.SecteurActivite;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class SecteurActiviteControllerTest1 {

    private ISecteurActiviteService secteurActiviteService;

    private SecteurActivite[] activite;

    public void setUp() {
        activite = initSecteurActiviteInstance();
        secteurActiviteService = mock(SecteurActiviteServiceImpl.class);
        when(secteurActiviteService.addSecteurActivite(activite[0])).thenReturn(activite[0]);
    }

    private SecteurActivite[] initSecteurActiviteInstance() {
        activite = new SecteurActivite[] {
                new SecteurActivite("code1", 1L, "libelle1"),new SecteurActivite("code2", 2L, "libelle2"),new SecteurActivite("code3", 3L, "libelle3")
        };
        return activite;
    }

    @Test
    void testAddition() {
        setUp();
        SecteurActivite newValue = secteurActiviteService.addSecteurActivite(activite[0]);
        assertNotNull(newValue);
    }

}
