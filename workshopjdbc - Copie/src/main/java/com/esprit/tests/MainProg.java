package com.esprit.tests;
import com.esprit.models.Coach;
import com.esprit.models.Joueur;
import com.esprit.models.User;
import com.esprit.services.UserService2;

import com.esprit.services.CoachService2;
import com.esprit.services.JoueurService2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


public class MainProg {

    public static void main(String[] args) {
        JoueurService2 ps2 = new JoueurService2();
      CoachService2 ps3 = new CoachService2();
        UserService2 ps1 = new UserService2();



//         ps.ajouter(new Personne("Ahmed", "Med"));
//        ps.supprimer(new Personne(3, "Ahmed", "Med"));
//        ps.modifier(new Personne(1, "Emma", "Zouaoui"));
//        System.out.println(ps.afficher());
       // UserService2 ps2 = new UserService2();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       Date date_de_naissance = null;

        try {
            date_de_naissance = dateFormat.parse("22/01/2021");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ps2.supprimer(new Joueur(17,"sasuke", "ghribi","aziz.ghribi@esprit.tn","llll","femme", date_de_naissance,"joueur", "mardi"));
       // ps3.supprimer(new Coach(5,"amani", "jerbi","ameni.jerbi@esprit.tn","llll","femme", date_de_naissance,"coach", "mardi"));
       //ps3.modifier(new Coach(6,"fares", "jerbi","ameni.jerbi@esprit.tn","llll","femme", date_de_naissance,"coach", "mardi"));
        //System.out.println(ps3.afficher());
        // ps3.ajouter(new Coach(5,"amani", "jerbi","ameni.jerbi@esprit.tn","llll","femme", date_de_naissance,"coach", "mardi"));

       //   ps2.modifier(new Joueur(6,"fares", "jerbbi","ahmed.jerbi@esprit.tn","llll","femme", date_de_naissance,"joueur", "avance"));
     //   ps2.supprimer(new Joueur(5,"amani", "jerbi","ameni.jerbi@esprit.tn","llll","femme", date_de_naissance,"joueur", "debutant"));
        //ps2.modifier(new Joueur(12,"skander", "jerbi","ameni.jerbi@esprit.tn","llll","femme", date_de_naissance,"joueur","avance"));
       //System.out.println(ps3.afficher());


    }
}
