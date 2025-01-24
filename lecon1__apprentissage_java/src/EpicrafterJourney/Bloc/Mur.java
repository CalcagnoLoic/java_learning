package EpicrafterJourney.Bloc;

import EpicrafterJourney.Enum.Couleur;
import EpicrafterJourney.Exceptions.IllegalBlocException;

public class Mur extends Bloc {

    private boolean porteur;

    public Mur(final int longueur, final int largeur, final int hauteur, final boolean porteur)
            throws IllegalBlocException {
        super(longueur, largeur, hauteur, Couleur.GRIS);
        this.porteur = porteur;
    }

    public boolean estTraversable() {
        return !porteur;
    }

}