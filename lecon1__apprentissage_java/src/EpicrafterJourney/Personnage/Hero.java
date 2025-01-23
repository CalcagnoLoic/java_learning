package EpicrafterJourney.Personnage;

import EpicrafterJourney.Interface.IBloc;

public class Hero extends Personnage  {

    private int pointsDAttaques;

    public Hero(final String nom, final int pointsDAttaques) {
        super(nom);
        this.pointsDAttaques = pointsDAttaques;
    }

    public int getPointsDAttaques() {
        return pointsDAttaques;
    }

    @Override
    public String getNom() {
        return super.getNom();
    }


    @Override
    public void construireUnBloc(IBloc bloc) {

    }
}

