package EpicrafterJourney.Kit;

import EpicrafterJourney.Bloc.Bloc;
import EpicrafterJourney.Bloc.Mur;
import EpicrafterJourney.Bloc.Porte;
import EpicrafterJourney.Exceptions.IllegalBlocException;
import EpicrafterJourney.Interface.IBloc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class KitDemarrage {

    private Set<IBloc> blocs = new LinkedHashSet<IBloc>();
    private Set<String> motsCles = new LinkedHashSet<String>();
    private Logger logger = LogManager.getLogger(KitDemarrage.class);

    public Set<IBloc> getBlocs() {
        return blocs;
    }

    public Set<String> getMotsCles() {
        return motsCles;
    }

    public void afficherKit() {
        System.out.println("Nombre de blocs dans le kit : " + blocs.size());
        System.out.println("Liste des mots clés du kit : ");

        this.motsCles.forEach(System.out::print);
    }

    public KitDemarrage(final Set<IBloc> blocs) throws IllegalBlocException {
        this.blocs.addAll(blocs);

        motsCles.add("Cabane");
        motsCles.add("Muraille");
        motsCles.add("Maison");
    }

    public void sauvegarder() {
        StringBuilder builder = new StringBuilder();
        builder.append("Kit de démarrage\n");
        for(String motCle : motsCles){
            builder.append(motCle).append(" ");
        }

        String cheminFichier = "lecon1__apprentissage_java/kit.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier));
            writer.write(builder.toString());
            logger.info("Fichier sauvegardé dans : {}", cheminFichier);
            writer.close();
        } catch (IOException e) {
            logger.error("Impossible d'écrire dans le fichier...");
        }
    }

    public void charger(){
        String cheminFichier = "lecon1__apprentissage_java/kit.txt";
        try {
          BufferedReader reader = new BufferedReader(new FileReader(cheminFichier));
          String line = null;
          while((line = reader.readLine()) != null) {
              System.out.println(line);
          }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
