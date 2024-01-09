package com.demo.vip.metier;

public class Personne {

    private String prenom;
    private String nom;
    private boolean isVip;

    public Personne(String prenom, String nom, boolean isVip) {
        this.prenom = prenom;
        this.nom = nom;
        this.isVip = isVip;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }
}
