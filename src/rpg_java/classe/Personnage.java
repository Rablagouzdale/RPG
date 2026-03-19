package rpg_java.classe;

public class Personnage {

    private String nom;
    private String classe;
    private int attaque;
    private int defense;
    private int vie;
    private int xp;
    private int lvl;


    // Construcgeur
    public Personnage(String nom, String classe, int attaque, int defense, int vie) {
        this.nom = nom;
        this.classe = classe;
        this.attaque = attaque;
        this.defense = defense;
        this.vie = vie;
        this.xp = 0;
        this.lvl = 1;
    }

    //  GETTERS
    public String getNom() {
        return nom;
    }

    public String getClasse() {
        return classe;
    }

    public int getAttaque() {
        return attaque;
    }

    public int getDefense() {
        return defense;
    }

    public int getVie() {
        return vie;
    }

    public int getXp() {
        return xp;
    }

    public int getLvl() {
        return lvl;
    }


    // Setters

    public void setVie(int vie) {
        this.vie = vie;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    // Augmenter la défense de 2 pour chaque tour
    public void defendre() {
        this.defense += 2;
    }

    public void finDefense() {
        this.defense -= 2;
    }

    // XP gagné
    public void gagnerXp(int xpGagne) {
        this.xp += xpGagne;


        if (xp >= 5) {
            lvl++;
            xp = 0;

            // Amélioration des stats
            attaque += 1;
            defense += 1;
            vie += 3;

            System.out.println(" Félicitation, vous venez de gagner un niveau " + lvl + " !");
            System.out.println("Vos stats augmentent !");
            System.out.println("+1 Attaque, +1 Défense, +3 PV");
        }


    }

    // Attaque des personnages

    public Attaque[] getAttaques() {
        if (classe.equals("Guerrier")) {
            return new Attaque[]{
                    new Attaque("Coup d'épée", 1, 1, 1.1),
                    new Attaque("Arc", 2, 3, 1.0)
            };
        } else if (classe.equals("Mage")) {
            return new Attaque[]{
                    new Attaque("Projectile magique", 1, 2, 1.3),
                    new Attaque("Boule de feu", 2, 5, 1.1)
            };
        } else if (classe.equals("Viking Métalleux")) {
            return new Attaque[]{
                    new Attaque("Skål !", 0, 10, 1.2),
                    new Attaque("Raise Your Horn !", 0, 8, 8.4),
            };
        } else {
            return new Attaque[0];
        }
    }

    ;
}

