package EpicrafterJourney;

public class Bloc {
    private int longueur;
    private int largeur;
    private int hauteur;

    public Bloc(final int longueur, final int largeur, final int hauteur){
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getLongueur() {
        return longueur;
    }
}
