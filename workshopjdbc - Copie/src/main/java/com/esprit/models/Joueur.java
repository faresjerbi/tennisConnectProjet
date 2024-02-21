package com.esprit.models;

import java.util.Date;

public class Joueur extends User {
    private String niveau;

    public Joueur(String nom, String prenom, String mail, String password, String genre, Date  date_de_naissance, String role, String niveau) {
        super(nom, prenom, mail, password, genre, date_de_naissance, role);
        this.niveau = niveau;
    }

    public Joueur(int  id, String nom, String prenom, String mail, String password, String genre,Date date_de_naissance, String role , String niveau) {
        super(id,nom, prenom, mail, password, genre, date_de_naissance, role);
        this.niveau = niveau;

    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "niveau='" + niveau + '\'' +
                '}';
    }

}
