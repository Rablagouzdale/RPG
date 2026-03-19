package rpg_java;

import java.util.Scanner;
import rpg_java.classe.Personnage;
import rpg_java.classe.Monstre;
import rpg_java.classe.Attaque;

public class Deplacement {

    public void deplacement(Plateau plateau, Personnage joueur, Monstre monstre) {

        Scanner scanner = new Scanner(System.in);

        // Tant que la distance est supérieur à  1, on continue
        while (true) {

            // Calcul de la distance
            int distance;
            if (plateau.getPositionJoueur() > plateau.getPositionMonstre()) {
                distance = plateau.getPositionJoueur() - plateau.getPositionMonstre();
            } else {
                distance = plateau.getPositionMonstre() - plateau.getPositionJoueur();
            }

            // Si la distance est égal à 1 ou moins, le joueur et le monstre sont côte à côte.
            if (distance <= 1) {
                break;
            }


            plateau.affiche();

            System.out.println("Actions :");
            System.out.println("1) Avancer");
            System.out.println("2) Reculer");
            System.out.println("3) Attendre");
            System.out.println("4) Attaquer");

            String action = scanner.next();

            switch (action) {
                case "1":
                    plateau.avancerJoueur();
                    break;

                case "2":
                    plateau.reculerJoueur();
                    break;

                case "3":
                    break;

                case "4":
                    menuAttaque(joueur, monstre, plateau);
                    break;

                default:
                    System.out.println("Erreur : commande inconnue, choisissez entre 1 et 4.");
                    continue; // On reste dans la boucle
            }

            // calcul si la distance entre le joueur et le monstre
            if (plateau.getPositionJoueur() > plateau.getPositionMonstre()) {
                distance = plateau.getPositionJoueur() - plateau.getPositionMonstre();
            } else {
                distance = plateau.getPositionMonstre() - plateau.getPositionJoueur();
            }



            // Le monstre avance
            plateau.avancerMonstre();
        }

        System.out.println("⚔️ Le combat commence !");
    }

    private void menuAttaque(Personnage joueur, Monstre monstre, Plateau plateau) {

        Scanner scanner = new Scanner(System.in);
        Attaque[] attaques = joueur.getAttaques();

        System.out.println("Choisissez une attaque :");
        System.out.println("1) " + attaques[0].getNom());
        System.out.println("2) " + attaques[1].getNom());
        System.out.println("3) Retour");

        String choix = scanner.next();

        switch (choix) {
            case "1":
                tenterAttaque(joueur, monstre, plateau, attaques[0]);
                break;

            case "2":
                tenterAttaque(joueur, monstre, plateau, attaques[1]);
                break;

            case "3":
                return;

            default:
                System.out.println("Choix invalide");
        }
    }

    private void tenterAttaque(Personnage joueur, Monstre monstre, Plateau plateau, Attaque attaque) {

        int distance;

        if (plateau.getPositionJoueur() > plateau.getPositionMonstre()) {
            distance = plateau.getPositionJoueur() - plateau.getPositionMonstre();
        } else {
            distance = plateau.getPositionMonstre() - plateau.getPositionJoueur();
        }

        if (distance < attaque.getPorteeMin() || distance > attaque.getPorteeMax()) {
            System.out.println(" Hors portée !");
            return;


        }

        // Si l'attaque est possible → on arrête le déplacement et on lance le combat
        System.out.println("Vous engagez le combat !");
        plateau.setPositionJoueur(plateau.getPositionMonstre()); // ils se touchent

        int degats = (int) ((joueur.getAttaque() - monstre.getDefense()) * attaque.getMultiplicateur());
        if (degats < 1) degats = 1;

        monstre.setPv(monstre.getPv() - degats);

        System.out.println("Vous utilisez " + attaque.getNom() + " !");
        System.out.println("Vous infligez " + degats + " dégâts !");
    }
}
