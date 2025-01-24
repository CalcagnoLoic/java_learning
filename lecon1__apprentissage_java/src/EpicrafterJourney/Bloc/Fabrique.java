package EpicrafterJourney.Bloc;

import EpicrafterJourney.Interface.IBloc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class Fabrique {

    private static ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
    private static Logger logger = LogManager.getLogger(Fabrique.class);

    public static Set<IBloc> creerMur(final int quantiteBlocs){
        Callable<IBloc> taskMur = () -> {return new Mur(1,1,1,true);};
        return creerBloc(taskMur, quantiteBlocs);
    }

    public static Set<IBloc> creerPorte (final int quantiteBlocs) {
        Callable<IBloc> taskPorte = () -> {return new Porte(1,1,1,false);};
        return creerBloc(taskPorte, quantiteBlocs);
    }

    public static Set<IBloc> creerToit(final int quantiteBlocs) {
        Callable<IBloc> taskToit = () -> {return new Toit(1,1,1);};
        return creerBloc(taskToit, quantiteBlocs);
    }

    public static Set<IBloc> creerBloc(final Callable<IBloc> task, final int quantite){
        Set<IBloc> blocs = new LinkedHashSet<IBloc>();
        List<Callable<IBloc>> tasks = new ArrayList<Callable<IBloc>>();

        for (int i = 0; i < quantite; i++) {
            tasks.add(task);
        }

        try{
            List<Future<IBloc>> resultats = executorService.invokeAll(tasks);
            resultats.forEach(resulat -> {
                try {
                    blocs.add(resulat.get());
                } catch (InterruptedException | ExecutionException e) {
                    logger.error("Erreur pendant la création des blocs: {}", e);
                }
            });
        } catch (InterruptedException e) {
            logger.error("Erreur pendant la création des blocs: {}", e);
        }

        return blocs;
    }
}
