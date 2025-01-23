package module2;

public class Bloc implements IBloc {
    protected int longueur;
    protected int largeur;
    protected int hauteur;

    public Bloc(final int longueur, final int largeur, final int hauteur){
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.longueur = longueur;
    }

    public void afficherDescription() {
        System.out.println("Je suis un bloc");
    }
}