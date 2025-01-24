package EpicrafterJourney;

import EpicrafterJourney.Bloc.Bloc;
import EpicrafterJourney.Bloc.Mur;
import EpicrafterJourney.Bloc.Porte;
import EpicrafterJourney.Exceptions.IllegalBlocException;
import EpicrafterJourney.Exceptions.PorteVerrouilleException;
import EpicrafterJourney.Personnage.Hero;
import EpicrafterJourney.Interface.IPersonnage;
import EpicrafterJourney.Personnage.Joueur;
import EpicrafterJourney.Personnage.Mechant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        logger.error("test de logging");

        try {
            Mur mur = new Mur(1,1,1,true);
            Porte porte = new Porte(1,1,1,false);
            mur.estTraversable();
            porte.verrouiller();
        } catch (IllegalBlocException | PorteVerrouilleException e) {
            throw new RuntimeException(e);
        }
    }
}