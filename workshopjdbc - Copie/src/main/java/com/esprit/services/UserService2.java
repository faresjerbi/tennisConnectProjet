package com.esprit.services;

import com.esprit.models.User;
import com.esprit.utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService2 implements IService<User> {

    private Connection connection;
    private List<User> userList;

    public UserService2() {
        connection = DataSource.getInstance().getConnection();
    }
    @Override
    public void ajouter(User user) {
        String req = "INSERT into user(nom, prenom,mail,password,genre,date_de_naissance,role) values (?,?,?,?,?,?,?);";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            java.sql.Date date_de_naissanceSQL = new java.sql.Date(user.getDate_de_naissance().getTime());

            pst.setString(2, user.getPrenom());
            pst.setString(1, user.getNom());
            pst.setString(3, user.getMail());
            pst.setString(4, user.getPassword());
            pst.setString(5, user.getGenre());
            pst.setDate(6, date_de_naissanceSQL);
            pst.setString(7, user.getRole());


            pst.executeUpdate();
            System.out.println("user ajoutée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modifier(User user) {
        String req = "UPDATE user set nom = ?, prenom = ?,mail = ?, password = ?, genre = ? ,date_de_naissance = ?,role = ? where id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            java.sql.Date date_de_naissanceSQL = new java.sql.Date(user.getDate_de_naissance().getTime());

            pst.setInt(3, user.getId());
            pst.setString(1, user.getNom());
            pst.setString(2, user.getPrenom());
            pst.setString(4, user.getMail());
            pst.setString(5, user.getPassword());
            pst.setString(6, user.getGenre());
            pst.setDate(7, date_de_naissanceSQL);
            pst.setString(8, user.getRole());
            pst.executeUpdate();
            System.out.println("user modifiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void supprimer(User user) {
        String req = "DELETE from user where id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1, user.getId());
            pst.executeUpdate();
            System.out.println("User supprmiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> afficher() {
        List<User> users = new ArrayList<>();

        String req = "SELECT * FROM user";
        try (PreparedStatement pst = connection.prepareStatement(req);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("mail"),
                        rs.getString("password"),
                        rs.getString("genre"),
                        rs.getDate("date_de_naissance"),
                        rs.getString("role")


                );
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des utilisateurs : " + e.getMessage());
        }

        return users;
    }

    public List<User> getAllUsers() {
        return afficher(); // Mettez à jour userList si nécessaire
    }
}
