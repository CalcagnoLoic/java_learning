package EpicrafterJourney;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Kit {

    private List<Bloc> nouveauxBlocs = new ArrayList<Bloc>();
    private Set<String> motsCles = new LinkedHashSet<String>();

    public Kit() throws IllegalBlocException {
        nouveauxBlocs.add(new Mur(3,2,2,true));
        nouveauxBlocs.add(new Mur(3,2,2,true));
        nouveauxBlocs.add(new Mur(2,1,2, false));
        nouveauxBlocs.add(new Mur(2,1,2,false));
        nouveauxBlocs.add(new Porte(1,2,2,true));

        motsCles.add("Cabane");
        motsCles.add("Muraille");
    }

    public void afficherKit(){
        System.out.println("Nombre de bloc dans le kit: " + nouveauxBlocs.size());
        System.out.println("Liste des mots clés du kit: " );
        for(String motcle: motsCles){
            System.out.println(motcle + " ");
        }
    }
}
