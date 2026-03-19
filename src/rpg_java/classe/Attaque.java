package rpg_java.classe;

public class Attaque {

    private String nom;
    private int porteeMin;
    private int porteeMax;
    private double bonusdegat;

    public Attaque(String nom, int porteeMin, int porteeMax, double multiplicateur) {
        this.nom = nom;
        this.porteeMin = porteeMin;
        this.porteeMax = porteeMax;
        this.bonusdegat = multiplicateur;
    }

    public String getNom() { return nom; }
    public int getPorteeMin() { return porteeMin; }
    public int getPorteeMax() { return porteeMax; }
    public double getMultiplicateur() { return bonusdegat; }
}
