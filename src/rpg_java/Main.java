package rpg_java;

import java.util.Scanner;
import rpg_java.classe.Personnage;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("1) Nouvelle partie");
        System.out.println("2) Charger sauvegarde");

        String choix = scanner.nextLine();

        Personnage joueur;

        if (choix.equals("2")) {
            joueur = Sauvegarde.charger();
            if (joueur != null) {
                System.out.println("Sauvegarde chargée !");
            } else {
                System.out.println("Aucune sauvegarde trouvée. Nouvelle partie.");
                joueur = new Jeu().creationPersonnage(scanner);
            }
        } else {
            joueur = new Jeu().creationPersonnage(scanner);
        }

        new Jeu().lancer(joueur);
    }
}
