package com.esprit.models;

import java.util.Date;

public class Coach extends User {
    private String disponibilite ;

    public Coach(int id, String nom, String prenom, String mail, String password, String genre, Date date_de_naissance, String role, String disponibilite) {
        super(id, nom, prenom, mail, password, genre, date_de_naissance, role);
        this.disponibilite = disponibilite;
    }

    public Coach(String nom, String prenom, String mail, String password, String genre, Date date_de_naissance, String role, String disponibilite) {
        super(nom, prenom, mail, password, genre, date_de_naissance, role);
        this.disponibilite = disponibilite;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "disponibilite='" + disponibilite + '\'' +
                '}';
    }
}
