package EpicrafterJourney.Bloc;

import EpicrafterJourney.Enum.Couleur;
import EpicrafterJourney.Exceptions.IllegalBlocException;
import EpicrafterJourney.Exceptions.PorteVerrouilleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Porte extends Bloc {
    private boolean verrouile;
    private static Logger logger = LogManager.getLogger(Porte.class);

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
            logger.error("La porte est déjà verrouillée");
            throw new PorteVerrouilleException();
        } else {
            logger.info("La porte n'est pas verrouillée, je vais la fermer de ce pas!");
            this.verrouile = true;
        }
    }
}
