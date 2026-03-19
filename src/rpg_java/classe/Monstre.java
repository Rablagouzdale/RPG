package rpg_java.classe;

public class Monstre {

    private String nom;
    private int pv;
    private int attaque;
    private int defense;
    private int niveauMin;
    private int niveauMax;



    public Monstre(String nom, int niveauMin, int niveauMax, int pv, int attaque, int defense) {
        this.nom = nom;
        this.niveauMin = niveauMin;
        this.niveauMax = niveauMax;
        this.pv = pv;
        this.attaque = attaque;
        this.defense = defense;
    }

    public boolean estVivant() {
        return pv > 0;
    }

    public void prendreDegats(int degats) {
        pv -= degats;
        if (pv < 0) pv = 0;
    }

    public String getNom() { return nom; }
    public int getPv() { return pv; }
    public int getAttaque() { return attaque; }
    public int getDefense() { return defense; }
    public int getNiveauMin(){return niveauMin;}
    public int getNiveauMax(){return niveauMax;}

    // Setter
    public void setPv(int pv) {
        this.pv = pv;
    }
}
