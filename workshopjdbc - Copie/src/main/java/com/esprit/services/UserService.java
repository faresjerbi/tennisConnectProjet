/*package com.esprit.services;

import com.esprit.models.User;
import com.esprit.utils.DataSource;

import java.sql.*;
import java.util.*;

public class UserService implements IService<User> {

    private Connection connection;

    public UserService() {
        connection = DataSource.getInstance().getConnection();
    }
    @Override
    public void ajouter(User user) {
        String req = "INSERT into User(nom, prenom,mail,password,role,niveau,diponibilite) values ('" + user.getNom() + "', '" + user.getPrenom() + "','"+user.getMail()+"','"+user.getPassword()+"','"+user.getRole()+"','"+user.getNiveau()+"','"+user.getDisponibilite()+"')";
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(req);
            System.out.println("user ajoutée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modifier(User user) {
        String req = "UPDATE user set nom = '" + user.getNom() + "', prenom = '" + user.getPrenom() + "' where id = " + user.getId() + ";";
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(req);
            System.out.println("User  modifiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void supprimer(User user) {
        String req = "DELETE from user where id = " + user.getId() + ";";
        try {
            Statement st = connection.createStatement();
            st.executeUpdate(req);
            System.out.println("user supprmiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<User> afficher() {
        List<User> users = new ArrayList<>();

        String req = "SELECT * from user";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return users;
    }
}
*/