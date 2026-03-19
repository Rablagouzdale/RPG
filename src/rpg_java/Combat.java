package rpg_java;

import rpg_java.classe.Personnage;
import rpg_java.classe.Monstre;
import rpg_java.classe.Attaque;

import java.util.Scanner;

public class Combat {

    public void lancerlecombat(Personnage joueur, Monstre monstre, Plateau plateau) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Début du combat ===");

        //  Tant que les deux sont vivants
        while (joueur.getVie() > 0 && monstre.getPv() > 0) {

            // --- MENU AVEC TES ATTAQUES ---
            Attaque[] attaques = joueur.getAttaques();

            System.out.println("\n--- Tour du joueur ---");
            System.out.println("1) " + attaques[0].getNom());
            System.out.println("2) " + attaques[1].getNom());
            System.out.println("3) Défendre");

            String choix = scanner.next();

            switch (choix) {

                case "1":
                    attaquer(joueur, monstre, plateau, attaques[0]);
                    break;

                case "2":
                    attaquer(joueur, monstre, plateau, attaques[1]);
                    break;

                case "3":
                    joueur.defendre();
                    System.out.println("Vous vous défendez !");
                    break;

                default:
                    System.out.println("Choix invalide");
                    continue;
            }

            // Vérifier si le monstre est mort
            if (monstre.getPv() <= 0) break;

            //  Monstre
            System.out.println(" Tour du monstre ");

            int degatsMonstre = monstre.getAttaque() - joueur.getDefense();
            if (degatsMonstre < 1) degatsMonstre = 1;

            joueur.setVie(joueur.getVie() - degatsMonstre);

            System.out.println(monstre.getNom() + " vous attaque et inflige " + degatsMonstre + " dégâts !");
            System.out.println("Vos PV restants : " + joueur.getVie());

            joueur.finDefense();
        }

        // Fin du combat
        if (joueur.getVie() <= 0) {
            System.out.println("💀 Vous êtes mort !");
        } else {
            System.out.println(" GG !");
            joueur.gagnerXp(1);
            System.out.println("Vous gagnez 1 XP !");
            joueur.gagnerXp(1);
            System.out.println("XP actuelle : " + joueur.getXp() + "/5");
        }
    }



    private void attaquer(Personnage joueur, Monstre monstre, Plateau plateau, Attaque attaque) {

        // Calcul distance
        int distance;
        if (plateau.getPositionJoueur() > plateau.getPositionMonstre()) {
            distance = plateau.getPositionJoueur() - plateau.getPositionMonstre();
        } else {
            distance = plateau.getPositionMonstre() - plateau.getPositionJoueur();
        }

        // Vérifier portée
        if (distance < attaque.getPorteeMin() || distance > attaque.getPorteeMax()) {
            System.out.println(" Hors portée !");
            return;
        }

        // Calcul dégâts
        int degats = (int) ((joueur.getAttaque() - monstre.getDefense()) * attaque.getMultiplicateur());
        if (degats < 1) degats = 1;

        monstre.setPv(monstre.getPv() - degats);

        System.out.println("Vous utilisez " + attaque.getNom() + " !");
        System.out.println("Vous infligez " + degats + " dégâts !");
        System.out.println("PV restants du monstre : " + monstre.getPv());
    }
}
