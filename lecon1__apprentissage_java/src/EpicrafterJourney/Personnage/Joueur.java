package EpicrafterJourney.Personnage;

import EpicrafterJourney.Interface.IBloc;

public class Joueur extends Personnage {

    private int pointsDeVie;

    public Joueur(final String nom, final int pointsDeVie){
        super(nom);
        this.pointsDeVie = pointsDeVie;
    }

    public int getPointsDeVie() {
        return pointsDeVie;
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
}
