package rpg_java;

import rpg_java.classe.Guerrier;
import rpg_java.classe.Mage;
import rpg_java.classe.Monstre;
import rpg_java.classe.Personnage;

import java.util.ArrayList;
import java.util.Scanner;

// j'importe mes 2 exceptions personalisés
import rpg_java.exceptions.MonstreIntrouvableException;

public class Jeu {
    // Fonction qui lance le jeu


    public Personnage creationPersonnage(Scanner scanner) {
        System.out.println("Bienvenue dans le jeu");


        System.out.print("Entrez votre nom : ");
        String nom = scanner.nextLine();

        System.out.println("Choisissez une classe :");
        System.out.println("1) Guerrier");
        System.out.println("2) Mage");

        String choix = scanner.nextLine();

        Personnage joueur;

        if (choix.equals("1")) {
            joueur = new Guerrier(nom);
            System.out.println("Vous avez choisi Guerrier !");
        } else {
            joueur = new Mage(nom);
            System.out.println("Vous avez choisi Mage !");
        }

        // J'affiche les caractéristiques des personnages
        System.out.println("Votre personnage");
        System.out.println("Nom : " + joueur.getNom());
        System.out.println("Classe : " + joueur.getClasse());
        System.out.println("Attaque : " + joueur.getAttaque());
        System.out.println("Défense : " + joueur.getDefense());
        System.out.println("Vie : " + joueur.getVie());
        System.out.println("Niveau : " + joueur.getLvl());
        System.out.println("XP : " + joueur.getXp());

        return joueur;
    }

    public void lancer(Personnage joueur) {


        Scanner scanner = new Scanner(System.in);
        String continuer = "o";

        while (continuer.equalsIgnoreCase("o")) {

        // Charge les monstres
        ArrayList<Monstre> monstres = new ChargerMonstre().chargerMonstres();

            // Tirer un monstre adapté au niveau du joueur
            Monstre monstre = null;

            try {
                monstre = new GénérerMonstre().hasard(joueur, monstres);
            } catch (MonstreIntrouvableException e) {
                System.out.println("Erreur : " + e.getMessage());
                return; // On arrête proprement
            }

        // Afficher le monstre tiré
        System.out.println("=== Monstre rencontré ===");
        System.out.println("Nom : " + monstre.getNom());
        System.out.println("PV : " + monstre.getPv());
        System.out.println("Attaque : " + monstre.getAttaque());
        System.out.println("Défense : " + monstre.getDefense());


        // Système de plateau
        Plateau plateau = new Plateau();

        // (exception d'Action si le joueur entre une commande invalide
            Deplacement deplacement = new Deplacement();
            deplacement.deplacement(plateau, joueur, monstre);


            // Mise à jour finale du plateau avant combat
        plateau.affiche();

        //Test pour debug
        //System.out.println("DEBUG joueur=" + plateau.getPositionJoueur());
        //System.out.println("DEBUG monstre=" + plateau.getPositionMonstre());

        // Lancer le combat
        Combat combat = new Combat();
        combat.lancerlecombat(joueur, monstre, plateau);

        // Sauvegarde après le combat
        Sauvegarde.sauvegarder(joueur);

        // Demander si on continue
        System.out.println("Voulez-vous continuer ? (o/n)");
        continuer = scanner.nextLine();

    }

        System.out.println("Merci d'avoir joué !");
    }
}