package EpicrafterJourney.Personnage;

import EpicrafterJourney.Interface.IBloc;
import EpicrafterJourney.Exceptions.MechantElimineException;

public class Mechant extends Personnage {

    private int pointsDeDefense;

    public Mechant(final String nom, final int pointsDeDefense){
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
    public void construireUnBloc(IBloc bloc){

    }
}
