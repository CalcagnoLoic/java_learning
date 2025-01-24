package EpicrafterJourney.Personnage;

import EpicrafterJourney.Interface.IPersonnage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Consumer;

public class SessionJeu {

    private final Set<IPersonnage> personnages = new LinkedHashSet<IPersonnage>();
    private static Logger logger = (Logger) LogManager.getLogger(SessionJeu.class);
    private long debutSession = System.currentTimeMillis();

    public void sauvegarderSession() {
        long duree = System.currentTimeMillis() - debutSession;
        try {
            String nomFichier = "export-" + LocalDate.now().toString();
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier));
            writer.write(personnages.toString()+ "\n" + duree);
            writer.close();
        } catch (IOException e) {
            logger.error("Impossible d'écrire dans le fichier");
        }
    }

    public void ajouterNouveauPersonnage(IPersonnage personnage) {
        if(this.personnages.contains(personnage)) {
            throw new RuntimeException("Le personnage " + personnage.getNom() + " appartient déjà à cette session de jeu.");
        }
        this.personnages.add(personnage);
    }

    public void afficherPersonnageDeLaSession() {
        personnages.forEach(System.out:: println);
    }
}