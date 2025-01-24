package EpicrafterJourney.Bloc;

import EpicrafterJourney.Enum.Couleur;
import EpicrafterJourney.Exceptions.IllegalBlocException;
import EpicrafterJourney.Interface.IBloc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Bloc implements IBloc {
    protected int longueur;
    protected int largeur;
    protected int hauteur;
    protected Couleur couleur;

    private static Logger logger = LogManager.getLogger(Bloc.class);

    public Bloc(final int longueur, final int largeur, final int hauteur) throws IllegalBlocException {
        if (longueur < MIN_LONGUEUR || largeur < MIN_LARGEUR || hauteur < MIN_HAUTEUR) {
            throw new IllegalBlocException();
        }
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;

        logger.info("Le bloc " + this.getClass().getName() + " a été construit");
    }

    public int getLongueur(){
        return longueur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
}
