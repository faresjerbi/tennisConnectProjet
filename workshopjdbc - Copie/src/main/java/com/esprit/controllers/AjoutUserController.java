package com.esprit.controllers;

import com.esprit.models.User;
import com.esprit.models.Joueur;
import com.esprit.models.Coach;
import com.esprit.services.CoachService2;
import com.esprit.services.JoueurService2;
import com.esprit.services.UserService2;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Date;
import java.util.List;

public class AjoutUserController {

    @FXML
    private TableColumn<User, Integer> colId;

    @FXML
    private TableColumn<User, String> colNom;

    @FXML
    private TableColumn<User, String> colPrenom;

    @FXML
    private TableColumn<User, String> colMail;

    @FXML
    private TableColumn<User, String> colPassword;

    @FXML
    private TableColumn<User, String> colGenre;

    @FXML
    private TableColumn<User, Date> colDate_de_naissance;

    @FXML
    private TableColumn<User, String> colRole;

    @FXML
    private TableColumn<User, String> colNiveau;

    @FXML
    private TableColumn<User, String> colDisponibilite;

    @FXML
    private DatePicker tfDate_de_naissance;

    @FXML
    private DatePicker tfDate_de_naissance1;

    @FXML
    private TextField tfDisponibilite;

    @FXML
    private TextField tfDisponibilite1;

    @FXML
    private TextField tfGenre;

    @FXML
    private TextField tfGenre1;

    @FXML
    private TextField tfId;

    @FXML
    private TextField tfMail;

    @FXML
    private TextField tfMail1;
    @FXML
    private TextField tfId2;

    @FXML
    private TextField tfNiveau;

    @FXML
    private TextField tfNiveau1;

    @FXML
    private TextField tfNom;

    @FXML
    private TextField tfNom1;

    @FXML
    private TextField tfPassword;

    @FXML
    private TextField tfPassword1;

    @FXML
    private TextField tfPrenom;

    @FXML
    private TextField tfPrenom1;

    @FXML
    private TextField tfRole;

    @FXML
    private TextField tfRole1;

    @FXML
    private TableView<User> tfTableau;

    @FXML
    void initialize() {
        // Initialisez les colonnes avec les valeurs de la classe User
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        colMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colDate_de_naissance.setCellValueFactory(new PropertyValueFactory<>("date_de_naissance"));
        colRole.setCellValueFactory(new PropertyValueFactory<>("role"));
        colNiveau.setCellValueFactory(new PropertyValueFactory<>("niveau"));
        colDisponibilite.setCellValueFactory(new PropertyValueFactory<>("disponibilite"));

        // Chargez les données dans la TableView lors de l'initialisation
        chargerDonneesDansTableView();
    }

    private void chargerDonneesDansTableView() {
        // Remplacez UserService2 par votre service réel
        //UserService2 userService = new UserService2();
        CoachService2 coachService = new CoachService2();
        JoueurService2 joueurService = new JoueurService2();


        // Chargez la liste d'utilisateurs à partir du service
        List<Coach> listecoach = coachService.getAllUsers();
        List<Joueur> listejoueur = joueurService.getAllUsers();


        // Ajoutez les utilisateurs à la TableView
        tfTableau.getItems().addAll(listecoach);
        tfTableau.getItems().addAll(listejoueur);
    }

    @FXML
    void AddUser(ActionEvent event) {
        // Vérification de la saisie
        if (!isInputValid()) {
            return;
        }

        UserService2 ps = new UserService2();

        // Convertir de LocalDate à java.util.Date
        Date dateDeNaissance = java.sql.Date.valueOf(tfDate_de_naissance.getValue());

        if ("coach".equalsIgnoreCase(tfRole.getText())) {
            // Insertion d'un coach
            CoachService2 ps3 = new CoachService2();
            ps3.ajouter(new Coach(tfNom.getText(), tfPrenom.getText(), tfMail.getText(), tfPassword.getText(), tfGenre.getText(), dateDeNaissance, tfRole.getText(), tfDisponibilite.getText()));
        } else {
            // Insertion d'un joueur
            JoueurService2 ps1 = new JoueurService2();
            ps1.ajouter(new Joueur(tfNom.getText(), tfPrenom.getText(), tfMail.getText(), tfPassword.getText(), tfGenre.getText(), dateDeNaissance, tfRole.getText(), tfNiveau.getText()));
        }

        // Rafraîchir la TableView avec les nouvelles données
        tfTableau.getItems().clear();
        chargerDonneesDansTableView();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User ajouté");
        alert.setContentText("User ajouté !");
        alert.show();
    }

    private boolean isInputValid() {
        String nom = tfNom.getText();
        String prenom = tfPrenom.getText();
        String mail = tfMail.getText();
        String password = tfPassword.getText();
        String genre = tfGenre.getText();
        String role = tfRole.getText();

        // Vérification que les champs obligatoires ne sont pas vides
        if (nom.isEmpty() || prenom.isEmpty() || mail.isEmpty() || password.isEmpty() || genre.isEmpty()|| role.isEmpty()) {
            showErrorAlert("Veuillez remplir tous les champs obligatoires.");
            return false;
        }

        // Vérification que le mot de passe a une longueur minimale
        if (password.length() < 5) {
            showErrorAlert("Le mot de passe doit contenir au moins 5 caractères.");
            return false;
        }
        if (!"coach".equalsIgnoreCase(role) && !"joueur".equalsIgnoreCase(role) && !"admin".equalsIgnoreCase(role)) {
            showErrorAlert("Le rôle n est pas valide ");
            return false;
        }

        return true;
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setContentText(message);
        alert.show();
    }

    @FXML
    void UpdateUser(ActionEvent event) {
        UserService2 userService = new UserService2();

        // Récupérer les valeurs des champs de saisie
        int userId = Integer.parseInt(tfId.getText());
        String nom = tfNom1.getText();
        String prenom = tfPrenom1.getText();
        String mail = tfMail1.getText();
        String password = tfPassword1.getText();
        String genre = tfGenre1.getText();
        Date dateDeNaissance = java.sql.Date.valueOf(tfDate_de_naissance1.getValue());
        String role = tfRole1.getText();
        String niveau = tfNiveau1.getText();
        String disponibilite = tfDisponibilite1.getText();

        // Vérifier le rôle pour décider s'il s'agit d'un coach ou d'un joueur
        if ("coach".equalsIgnoreCase(role)) {
            // Mise à jour d'un coach
            CoachService2 coachService = new CoachService2();
            coachService.modifier(new Coach(userId, nom, prenom, mail, password, genre, dateDeNaissance, role, disponibilite));
        } else {
            // Mise à jour d'un joueur
            JoueurService2 joueurService = new JoueurService2();
            joueurService.modifier(new Joueur(userId, nom, prenom, mail, password, genre, dateDeNaissance, role, niveau));
        }

        // Rafraîchir la TableView avec les nouvelles données
        tfTableau.getItems().clear();
        chargerDonneesDansTableView();

        // Afficher une boîte de dialogue d'information
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User modifié");
        alert.setContentText("User modifié !");
        alert.show();
    }
    @FXML
    void DeleteUser(ActionEvent event) {
        UserService2 userService = new UserService2();

        try {
            int userId = Integer.parseInt(tfId2.getText());

            if ("coach".equalsIgnoreCase(tfRole.getText())) {
                CoachService2 coachService = new CoachService2();
                coachService.supprimer(new Coach(userId, null, null, null, null, null, null, null, null));
            } else {
                JoueurService2 joueurService = new JoueurService2();
                joueurService.supprimer(new Joueur(userId, null, null, null, null, null, null, null, null));
            }

            // Rafraîchir la TableView avec les nouvelles données
            tfTableau.getItems().clear();
            chargerDonneesDansTableView();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("User supprimé");
            alert.setContentText("User supprimé !");
            alert.show();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur de suppression");
            alert.setContentText("Veuillez sélectionner un utilisateur à supprimer.");
            alert.show();
        }
    }


}
