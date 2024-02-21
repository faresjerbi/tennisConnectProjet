package com.esprit.models;

import javafx.beans.binding.BooleanExpression;
import javafx.beans.value.ObservableValue;

import java.util.Date;
import java.util.List;

public class User {

    private int id;
    private String nom;
    private String prenom;
    private String mail ;
    private String password;
    private String genre ;
    private Date date_de_naissance;
    private String role ;


    public User(int id, String nom, String prenom, String mail, String password, String genre, Date date_de_naissance, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.password = password;
        this.genre = genre;
        this.date_de_naissance = date_de_naissance;
        this.role = role;
    }

    public User(String nom, String prenom, String mail, String password, String genre, Date date_de_naissance, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.password = password;
        this.genre = genre;
        this.date_de_naissance = date_de_naissance;
        this.role = role;
    }



    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNom() {return nom;}

    public void setNom(String nom) {this.nom = nom;}

    public String getPrenom() {return prenom;}

    public void setPrenom(String prenom) {this.prenom = prenom;}

    public String getMail() {return mail;}

    public void setMail(String mail) {this.mail = mail;}

    public String getPassword() {return password;}
    public String getGenre() {return genre;}

    public void setGenre(String genre) {this.genre = genre;}
    public void setPassword(String password) {this.password = password;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}


    public Date getDate_de_naissance() {return date_de_naissance;}

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", mail=" + mail +
                ", password=" + password +
                ", genre=" + genre +
                ", date_de_naissance=" + date_de_naissance +
                ", role=" + role +
                '}';
    }


   /*public User(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public User(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String toString() {
        return "User{" +
                "id=" + id +
                ", nom=" + nom +
                ", prenom=" + prenom +
                '}';
    }*/
}
