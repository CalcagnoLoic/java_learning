package EpicrafterJourney;

import EpicrafterJourney.Bloc.*;
import EpicrafterJourney.Enum.Type;
import EpicrafterJourney.Exceptions.IllegalBlocException;
import EpicrafterJourney.Interface.IBloc;
import EpicrafterJourney.Kit.KitDemarrage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        logger.info("Lancement du programme Epicrafter's Journey.");

        try {
            Porte porte = new Porte(1,1,1,true);
            porte.forcerSerrure(cle ->{
                return cle.matches("[A-Za-z]{3}]");
            });
            porte.forcerSerrure(cle -> {
                return cle.matches("#[A-Za-z]{6}123");
            });
        } catch (IllegalBlocException e) {
            throw new RuntimeException(e);
        }

        try {
            // Le programme commence avec un Kit de démarrage.
            KitDemarrage kit = new KitDemarrage(constructionSetBlocs());
            kit.afficherKit();
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
                motsCles.forEach(motsCle -> System.out.println(motsCle + " "));
            }
            if (response.equals("2")){
                System.out.println("Voici le nombre de blocs de chaque type contenu dans le Kit de démarrage : ");
                Map<Type, Integer> quantiteBloc = new TreeMap<Type, Integer>(); // La TreeMap permet de trier les entrées par ordre alphabétique de la clé.
                kit.getBlocs().forEach(bloc ->{
                    Type type = Type.valueOf(bloc.getClass().getSimpleName().toUpperCase());
                    int quantite = quantiteBloc.getOrDefault(type, 0) + 1; // Quantite existante + 1.
                    quantiteBloc.put(type, quantite);
                });
                Set<Type> types = quantiteBloc.keySet();
                types.forEach(type ->System.out.println(type.toString() + " " + quantiteBloc.get(type)));
            }
             if (!response.equals("1") && !response.equals("2")) {
                 System.out.println("La valeur saisie est incorrecte");
             }
        } catch (IllegalBlocException e) {
            System.out.println("Impossible de construire le Kit de démarrage.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.info("Arret du programme Epicrafter's Journey.");
        long end = System.currentTimeMillis();
        long executionTime = end - start;
        logger.debug(executionTime + " milliseconds");
    }

    private static Set<IBloc> constructionSetBlocs() throws IllegalBlocException {
        Set<IBloc> blocs = new LinkedHashSet<IBloc>();

        try {
            blocs.addAll(Fabrique.creerMur(4));
            blocs.addAll(Fabrique.creerPorte(2));
            blocs.addAll(Fabrique.creerToit(3));
        } catch (Exception e) {
            logger.error("Erreur pendant la création des blocs: {}", e);
        }

        return blocs;
    }
}