package com.esprit.examen.entities.DTO;


import com.esprit.examen.entities.DetailFournisseur;

public class FournisseurDTO {
    private Long idFournisseur;
    private String code;
    private String libelle;
    private DetailFournisseur detailFournisseur;


    public Long getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public DetailFournisseur getDetailFournisseur() {
        return detailFournisseur;
    }

    public void setDetailFournisseur(DetailFournisseur detailFournisseur) {
        this.detailFournisseur = detailFournisseur;
    }
}
