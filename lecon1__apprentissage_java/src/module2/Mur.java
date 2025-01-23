package module2;

public class Mur extends Bloc{
    private boolean porteur;

    public Mur (final int longueur, final int largeur, final int hauteur, final boolean porteur){
        super(longueur, largeur, hauteur);
        this.porteur = porteur;
    }

    public void afficherBloc() {
        System.out.println(
                super.longueur + " " + super.largeur + " " + super.hauteur + " " + this.porteur
        );
    }

    @Override
    public void afficherDescription() {
        System.out.println("Je suis un mur");
    }
}
