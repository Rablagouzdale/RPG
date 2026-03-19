package rpg_java;

import rpg_java.classe.Monstre;
import rpg_java.classe.Personnage;
import rpg_java.exceptions.MonstreIntrouvableException;

import java.util.ArrayList;
import java.util.Random;


public class GénérerMonstre {

    // Monstre tiré au hasard depuis le monstres.csv selon le niveau
    public Monstre hasard(Personnage joueur, ArrayList<Monstre> monstres)
            throws MonstreIntrouvableException {



        // Liste des monstres possibles
        ArrayList<Monstre> monstresPossibles = new ArrayList<>();

        // monstres adaptés en fonction du niveau du joueur
        for (Monstre m : monstres) {
            int niveauJoueur = joueur.getLvl();
            int min = m.getNiveauMin();
            int max = m.getNiveauMax();

            if (niveauJoueur >= min && niveauJoueur <= max) {
                monstresPossibles.add(m);
            }
        }

        // Si aucun monstre ne correspond ça renvoie une erreur
            if (monstresPossibles.isEmpty()) {
                throw new MonstreIntrouvableException(
                        "Aucun monstre disponible pour le niveau " + joueur.getLvl()
                );
            }

        // Tirage au hasard
        Random random = new Random();
        int indexAleatoire = random.nextInt(monstresPossibles.size());

        Monstre monstreChoisi = monstresPossibles.get(indexAleatoire);

        return monstreChoisi;
    }
}



