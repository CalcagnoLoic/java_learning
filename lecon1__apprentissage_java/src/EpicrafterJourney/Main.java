package EpicrafterJourney;

import EpicrafterJourney.Bloc.*;
import EpicrafterJourney.Exceptions.IllegalBlocException;
import EpicrafterJourney.Exceptions.PorteVerrouilleException;
import EpicrafterJourney.Interface.IBloc;
import EpicrafterJourney.Kit.KitDemarrage;
import EpicrafterJourney.Personnage.Hero;
import EpicrafterJourney.Interface.IPersonnage;
import EpicrafterJourney.Personnage.Joueur;
import EpicrafterJourney.Personnage.Mechant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Lancement du programme Epicrafter's Journey.");

        try {
            // Le programme commence avec un Kit de démarrage.
            KitDemarrage kit = new KitDemarrage(constructionSetBlocs());
            System.out.println("Vous possédez un kit de démarrage !");
            kit.sauvegarder();
            System.out.println("----Lecture du fichier: ----");
            kit.charger();
            System.out.println("----Fin de lecture du fichier: ----");

            System.out.println("Que souhaitez-vous afficher ? 1 - Les idées de constructions. 2 - Le nombre de blocs pour chaque type de blocs présent dans le kit.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String response = reader.readLine();
            if(response.equals("1")){
                System.out.println("Voici quelques idées de constructions avec le Kit de démarrage : ");
                Set<String> motsCles = kit.getMotsCles();
                for(String mot : motsCles) {
                    System.out.println(mot);
                }
            }
            if (response.equals("2")){
                System.out.println("Voici le nombre de blocs de chaque type contenu dans le Kit de démarrage : ");
                Map<Type, Integer> quantiteBloc = new TreeMap<Type, Integer>(); // La TreeMap permet de trier les entrées par ordre alphabétique de la clé.
                for (IBloc bloc : kit.getBlocs()) {
                    Type type = Type.valueOf(bloc.getClass().getSimpleName().toUpperCase());
                    int quantite = quantiteBloc.getOrDefault(type, 0) + 1; // Quantite existante + 1.
                    quantiteBloc.put(type, quantite);
                }
                Set<Type> types = quantiteBloc.keySet();
                for(Type type : types) {
                    System.out.println(type.toString() + " " + quantiteBloc.get(type));
                }
            }
            System.out.println("La valeur saisie est incorrecte");
        } catch (IllegalBlocException e) {
            System.out.println("Impossible de construire le Kit de démarrage.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.info("Arret du programme Epicrafter's Journey.");
    }

    private static Set<IBloc> constructionSetBlocs() throws IllegalBlocException {
        Set<IBloc> blocs = new LinkedHashSet<IBloc>();

        // Le kit contient 4 blocs Mur.
        blocs.add(new Mur(3, 2, 2, true));
        blocs.add(new Mur(3, 2, 2, true));
        blocs.add(new Mur(2, 1, 2, false));
        blocs.add(new Mur(2, 1, 2, false));

        // Le kit contient 1 bloc Porte.
        blocs.add(new Porte(1, 2, 2, true));

        // Le kit contient 4 blocs Toit.
        blocs.add(new Toit(3, 1, 1));
        blocs.add(new Toit(3, 1, 1));
        blocs.add(new Toit(3, 1, 1));
        blocs.add(new Toit(3, 1, 1));

        return blocs;
    }

}