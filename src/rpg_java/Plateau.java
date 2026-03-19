package rpg_java;

public class Plateau {

    private int positionJoueur = 0; // Le joueur commence à la case 0
    private int positionMonstre = 9; // Le monstre commence à la case 9
    final int Taille = 10; // La taille du plateau

    public void affiche(){

        String Plateau = ""; // Affichage du Plateau

        // Boucle qui permet de voir ou est le monstre et le joueur sinon si l'un des personnage
        // n'ai pas , on mets un .
        for (int i = 0; i < Taille; i++) {
            if (i == positionJoueur) {
                Plateau += "J";
            } else if (i == positionMonstre) {
                Plateau += "M";
            } else {
                Plateau += ".";
            }
        }

        System.out.println(Plateau);
    }

    // Le joueur avec d'une case , en ne dépassant pas la 9ème case
    public void avancerJoueur() {
        if (positionJoueur < 9) {
            positionJoueur++;
        }
    }

    // Le joueur recule d'une case
    public void reculerJoueur() {
        if (positionJoueur > 0) {
            positionJoueur--;
        }
    }

    public void avancerMonstre() {
        if (positionMonstre > 0) {
            positionMonstre--;
        }
    }


    // Retourne vrai si les deux personnages sont sur la même case
    public boolean sontEnCombat() {
        return positionJoueur == positionMonstre;
    }


    public int getPositionJoueur() {
        return positionJoueur;
    }

    public int getPositionMonstre() {
        return positionMonstre;
    }


    // Setter

    public void setPositionJoueur(int position) {
        this.positionJoueur = position;
    }

    public void setPositionMonstre(int position) {
        this.positionMonstre = position;
    }
}


