package EpicrafterJourney.Bloc;

import EpicrafterJourney.Enum.Couleur;
import EpicrafterJourney.Exceptions.IllegalBlocException;
import EpicrafterJourney.Interface.IBloc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Bloc implements IBloc {

    private static Logger logger = LogManager.getLogger(Bloc.class);

    protected int longueur;
    protected int largeur;
    protected int hauteur;
    protected Couleur couleur;

    public Bloc(final int longueur, final int largeur, final int hauteur, final Couleur couleur) throws IllegalBlocException {
        if (longueur < MIN_LONGUEUR || largeur < MIN_LARGEUR || hauteur < MIN_HAUTEUR) {
            logger.error("Les valeurs minimales pour longueur, largeur et hauteur n'ont pas été respectées.");
            throw new IllegalBlocException();
        }
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.couleur = couleur;

        logger.debug("Un bloc de type {} a été construit.", this.getClass().getSimpleName());
    }

    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

}