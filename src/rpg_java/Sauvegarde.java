package rpg_java;

import rpg_java.classe.Personnage;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Scanner;

public class Sauvegarde {

    public static void sauvegarder(Personnage joueur) {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream("save.txt"))
            );

            writer.write("nom=" + joueur.getNom());
            writer.newLine();
            writer.write("classe=" + joueur.getClasse());
            writer.newLine();
            writer.write("attaque=" + joueur.getAttaque());
            writer.newLine();
            writer.write("defense=" + joueur.getDefense());
            writer.newLine();
            writer.write("vie=" + joueur.getVie());
            writer.newLine();
            writer.write("xp=" + joueur.getXp());
            writer.newLine();
            writer.write("lvl=" + joueur.getLvl());
            writer.newLine();

            writer.close();
            System.out.println(" Sauvegarde effectuée !");
        } catch (Exception e) {
            System.out.println("Erreur lors de la sauvegarde.");
        }
    }

    public static Personnage charger() {
        try {
            File file = new File("save.txt");
            if (!file.exists()) return null;

            Scanner scanner = new Scanner(file);

            String nom = "";
            String classe = "";
            int attaque = 0, defense = 0, vie = 0, xp = 0, lvl = 1;

            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();
                String[] parts = ligne.split("=");

                switch (parts[0]) {
                    case "nom": nom = parts[1]; break;
                    case "classe": classe = parts[1]; break;
                    case "attaque": attaque = Integer.parseInt(parts[1]); break;
                    case "defense": defense = Integer.parseInt(parts[1]); break;
                    case "vie": vie = Integer.parseInt(parts[1]); break;
                    case "xp": xp = Integer.parseInt(parts[1]); break;
                    case "lvl": lvl = Integer.parseInt(parts[1]); break;
                }
            }

            Personnage joueur = new Personnage(nom, classe, attaque, defense, vie);

            // Remettre l'XP
            joueur.gagnerXp(xp);

            // Remettre le niveau
            for (int i = 1; i < lvl; i++) joueur.gagnerXp(5);

            return joueur;

        } catch (Exception e) {
            System.out.println("Erreur lors du chargement.");
            return null;
        }
    }
}
