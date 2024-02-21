package com.esprit.services;
import com.esprit.models.Coach;
import com.esprit.models.User;
import com.esprit.utils.DataSource;
import java.util.ArrayList;
import java.util.List;
import com.esprit.models.Joueur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JoueurService2  implements IService<Joueur> {

    private Connection connection;
    private List<Joueur> joueurList;

    public JoueurService2() {
        connection = DataSource.getInstance().getConnection();
    }
    @Override
    public void ajouter(Joueur joueur) {
        String req = "INSERT into user(nom, prenom,mail,password,genre,date_de_naissance,role,niveau) values (?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            java.sql.Date date_de_naissanceSQL = new java.sql.Date(joueur.getDate_de_naissance().getTime());

            pst.setString(2, joueur.getPrenom());
            pst.setString(1, joueur.getNom());
            pst.setString(3, joueur.getMail());
            pst.setString(4, joueur.getPassword());
            pst.setString(5, joueur.getGenre());
            pst.setString(7, joueur.getRole());
            pst.setDate(6, date_de_naissanceSQL);
            pst.setString(8, joueur.getNiveau());




            pst.executeUpdate();
            System.out.println("joueur ajoutée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modifier(Joueur joueur) {
        String req = "UPDATE user SET nom = ?, prenom = ?, mail = ?, password = ?, genre = ?, date_de_naissance = ?, role = ?, niveau = ? WHERE id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            java.sql.Date dateDeNaissanceSQL = new java.sql.Date(joueur.getDate_de_naissance().getTime());

            pst.setString(1, joueur.getNom());
            pst.setString(2, joueur.getPrenom());
            pst.setString(3, joueur.getMail());
            pst.setString(4, joueur.getPassword());
            pst.setString(5, joueur.getGenre());
            pst.setDate(6, dateDeNaissanceSQL);
            pst.setString(7, joueur.getRole());
            pst.setString(8, joueur.getNiveau());
            pst.setInt(9, joueur.getId());  // ID en dernier

            pst.executeUpdate();
            System.out.println("Joueur modifié !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void supprimer(Joueur joueur) {
        String req = "DELETE from user where id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1, joueur.getId());
            pst.executeUpdate();
            System.out.println("joueur supprmiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Joueur> afficher() {
        List<Joueur> joueurs = new ArrayList<>();

        String req = "SELECT * FROM user WHERE role = 'joueur'";
        try (PreparedStatement pst = connection.prepareStatement(req);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Joueur joueur = new Joueur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("mail"),
                        rs.getString("password"),
                        rs.getString("genre"),
                        rs.getDate("date_de_naissance"),
                        rs.getString("role"),
                        rs.getString("niveau")
                );
                joueurs.add(joueur);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des joueurs : " + e.getMessage());
        }

        return joueurs;
    }


    public List<Joueur> getAllUsers() {
        return afficher(); // Mettez à jour userList si nécessaire
    }
}
