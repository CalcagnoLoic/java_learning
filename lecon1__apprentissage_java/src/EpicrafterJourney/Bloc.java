package EpicrafterJourney;

public abstract class Bloc {
    protected int longueur;
    protected int largeur;
    protected int hauteur;

    public Bloc(final int longueur, final int largeur, final int hauteur){
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
    }
}
