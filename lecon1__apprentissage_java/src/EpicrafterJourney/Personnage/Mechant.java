package EpicrafterJourney.Personnage;

import EpicrafterJourney.Interface.IBloc;
import EpicrafterJourney.Exceptions.MechantElimineException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Mechant extends Personnage {

    private int pointsDeDefense;

    public Mechant(final String nom){
        super(nom);
        this.pointsDeDefense = pointsDeDefense;
    }

    public int getPointsDeDefense() {
        return pointsDeDefense;
    }

    public boolean subiUneAttaque(final int pointDAttaques) throws MechantElimineException {
        if (pointsDeDefense < 0){
            throw new MechantElimineException();
        }

        pointsDeDefense = pointsDeDefense - pointDAttaques;
        return pointsDeDefense < 0;
    }

    @Override
    public String getNom() {
        return super.getNom();
    }

    @Override
    public void subiAttaque(int pointsDAttaques) {

    }

    @Override
    public void construireUnBloc(IBloc bloc){

    }

    public List<Mechant> appelerLesSbires() throws InterruptedException {
        List<Mechant> mechants = new ArrayList<>();

        try (ExecutorService service = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Callable<Mechant>> taskList = new ArrayList<>();

            for (int i = 1; i <= 10; i++) {
                int finalI = i;
                taskList.add(() -> new Mechant("Sbire" + finalI));
            }

            List<Future<Mechant>> futureMechants = service.invokeAll(taskList);

            futureMechants.forEach(futureMechant -> {
                try {
                    mechants.add(futureMechant.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        return mechants;
    }

}
