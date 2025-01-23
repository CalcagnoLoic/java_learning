package EpicrafterJourney.Bloc;

import EpicrafterJourney.Enum.Couleur;
import EpicrafterJourney.Exceptions.IllegalBlocException;
import EpicrafterJourney.Exceptions.PorteVerrouilleException;

public class Porte extends Bloc {
    private boolean verrouile;

    public Porte(final int longueur, final int largeur, final int hauteur, final boolean verrouile) throws IllegalBlocException {
        super(longueur, largeur, hauteur);
        this.verrouile = verrouile;
        this.couleur = Couleur.BLEU;
    }

    public boolean estVerrouilee() {
        return this.verrouile;
    }

    public void verrouiller() throws PorteVerrouilleException {
        if(verrouile){
            throw new PorteVerrouilleException();
        } else {
            this.verrouile = true;
        }
    }
}
