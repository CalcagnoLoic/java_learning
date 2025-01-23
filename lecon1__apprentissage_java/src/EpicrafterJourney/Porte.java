package EpicrafterJourney;

public class Porte extends Bloc {
    private boolean verrouile;

    public Porte(final int longueur, final int largeur, final int hauteur, final boolean verrouile){
        super(longueur, largeur, hauteur);
        this.verrouile = verrouile;
    }

    public boolean estVerrouilee() {
        return this.verrouile;
    }
}
