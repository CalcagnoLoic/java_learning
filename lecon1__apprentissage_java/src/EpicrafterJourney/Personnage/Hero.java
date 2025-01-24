package EpicrafterJourney.Personnage;

import EpicrafterJourney.Interface.IBloc;
import EpicrafterJourney.Interface.IPersonnage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Hero extends Personnage  {

    private final int pointsDAttaques;

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
    public void subiAttaque(int pointsDAttaques) {

    }


    @Override
    public void construireUnBloc(IBloc bloc) {

    }

    public void choixMechantAAttaquer(List<IPersonnage> mechants) throws IOException {
        System.out.println("Voici les méchants à attaquer :");
        mechants.forEach(System.out::println);
        System.out.println("Ecrivez le nom du méchant à attaquer");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nom = reader.readLine();
        for(IPersonnage mechant : mechants) {
            if(mechant.getNom().equals(nom)) {
                mechant.subiAttaque(this.pointsDAttaques);
            }
        }
    }
}

