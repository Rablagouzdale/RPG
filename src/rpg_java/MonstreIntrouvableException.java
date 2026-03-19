package rpg_java.exceptions;

//Exception lorsque aucun monstre n'est disponible pour le niveau actuel du joueur.

public class MonstreIntrouvableException extends Exception {
    public MonstreIntrouvableException(String message) {
        super(message);
    }
}
