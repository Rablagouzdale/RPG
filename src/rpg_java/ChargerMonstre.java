package rpg_java;

import rpg_java.classe.Monstre;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import rpg_java.exceptions.FichierMonstresInvalideException; // Importe la classe personnalisé pour l'exception

public class ChargerMonstre {
    // Charger les monstres
    public ArrayList<Monstre> chargerMonstres() {
        ArrayList<Monstre> liste = new ArrayList<>();

        try {
            File file = new File("src/rpg_java/monstre.csv");
            Scanner lecteur = new Scanner(file);

            while (lecteur.hasNextLine()) {
                String ligne = lecteur.nextLine();
                //System.out.println("Ligne lue : " + ligne);

                // On mets une virgule comme séparateur pour le csv
                String[] parts = ligne.split(",");

                // Un monstre doit avoir  6 informations :
                if (parts.length != 6) {
                    throw new FichierMonstresInvalideException(
                            "Ligne invalide dans le fichier monstres : " + ligne
                    );
                }

                // Si la valeur n'est pas un nombre on lève l'exception.
                int niveauMin, niveauMax, pv, attaque, defense;

                try {
                    niveauMin = Integer.parseInt(parts[1]);
                    niveauMax = Integer.parseInt(parts[2]);
                    pv = Integer.parseInt(parts[3]);
                    attaque = Integer.parseInt(parts[4]);
                    defense = Integer.parseInt(parts[5]);
                } catch (NumberFormatException e) {
                    throw new FichierMonstresInvalideException(
                            "Valeur non numérique dans le fichier monstres : " + ligne
                    );
                }

                // Le niveau minimum ne doit jamais être supérieur au niveau maximum
                if (niveauMin > niveauMax) {
                    throw new FichierMonstresInvalideException(
                            "Niveau min supérieur au niveau max : " + ligne
                    );
                }

                // Si tout est ok on crée le monstre
                String nom = parts[0];
                liste.add(new Monstre(nom, niveauMin, niveauMax, pv, attaque, defense));
               // System.out.println("Monstre chargé : " + nom);
            }

            lecteur.close();

        } catch (FichierMonstresInvalideException e) {
            // On remonte l’erreur au jeu
            System.out.println("Erreur fichier monstres : " + e.getMessage());

        } catch (Exception e) {
            // Erreur générique (fichier introuvable, etc.)
            System.out.println("Erreur lors du chargement du fichier monstres.");
        }

        return liste;
    }
}
