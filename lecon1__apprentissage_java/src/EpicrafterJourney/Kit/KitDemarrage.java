package EpicrafterJourney.Kit;

import EpicrafterJourney.Bloc.Bloc;
import EpicrafterJourney.Bloc.Mur;
import EpicrafterJourney.Bloc.Porte;
import EpicrafterJourney.Exceptions.IllegalBlocException;
import EpicrafterJourney.Interface.IBloc;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class KitDemarrage {

    private Set<IBloc> blocs = new LinkedHashSet<IBloc>();
    private Set<String> motsCles = new LinkedHashSet<String>();

    public Set<IBloc> getBlocs() {
        return blocs;
    }

    public Set<String> getMotsCles() {
        return motsCles;
    }

    public KitDemarrage(final Set<IBloc> blocs) throws IllegalBlocException {
        this.blocs.addAll(blocs);

        motsCles.add("Cabane");
        motsCles.add("Muraille");
        motsCles.add("Maison");
    }
}
