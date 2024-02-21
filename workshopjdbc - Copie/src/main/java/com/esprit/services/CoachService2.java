package com.esprit.services;
import com.esprit.models.User;
import com.esprit.utils.DataSource;
import java.util.ArrayList;
import java.util.List;
import com.esprit.models.Coach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoachService2  implements IService<Coach> {


    private Connection connection;
    private List<Coach> coachList;


    public CoachService2() {
        connection = DataSource.getInstance().getConnection();
    }
    @Override
    public void ajouter(Coach coach) {
        String req = "INSERT into user(nom, prenom,mail,password,genre,date_de_naissance,role,disponibilite) values (?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            java.sql.Date date_de_naissanceSQL = new java.sql.Date(coach.getDate_de_naissance().getTime());

            pst.setString(2, coach.getPrenom());
            pst.setString(1, coach.getNom());
            pst.setString(3, coach.getMail());
            pst.setString(4, coach.getPassword());
            pst.setString(5, coach.getGenre());
            pst.setString(7, coach.getRole());
            pst.setDate(6, date_de_naissanceSQL);
            pst.setString(8, coach.getDisponibilite());




            pst.executeUpdate();
            System.out.println("coach ajoutée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void modifier(Coach coach) {
        String req = "UPDATE user set nom = ?, prenom = ?, mail = ?, password = ?, genre = ?, date_de_naissance = ?, role = ?, disponibilite = ? where id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            java.sql.Date date_de_naissanceSQL = new java.sql.Date(coach.getDate_de_naissance().getTime());

            pst.setString(1, coach.getNom());
            pst.setString(2, coach.getPrenom());
            pst.setString(3, coach.getMail());
            pst.setString(4, coach.getPassword());
            pst.setString(5, coach.getGenre());
            pst.setDate(6, date_de_naissanceSQL);
            pst.setString(7, coach.getRole());
            pst.setString(8, coach.getDisponibilite());
            pst.setInt(9, coach.getId());  // Correction : placer l'ID en dernier

            pst.executeUpdate();
            System.out.println("coach modifiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void supprimer(Coach coach) {
        String req = "DELETE from user where id = ?;";
        try {
            PreparedStatement pst = connection.prepareStatement(req);
            pst.setInt(1, coach.getId());
            pst.executeUpdate();
            System.out.println("coach supprmiée !");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Coach> afficher() {
        List<Coach> coachs = new ArrayList<>();

        String req = "SELECT * FROM user WHERE role = 'coach'";
        try (PreparedStatement pst = connection.prepareStatement(req);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Coach coach = new Coach(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("mail"),
                        rs.getString("password"),
                        rs.getString("genre"),
                        rs.getDate("date_de_naissance"),
                        rs.getString("role"),
                        rs.getString("disponibilite")
                );
                coachs.add(coach);
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'affichage des coachs : " + e.getMessage());
        }

        return coachs;
    }



    public List<Coach> getAllUsers() {
        return afficher(); // Mettez à jour userList si nécessaire
    }
}


