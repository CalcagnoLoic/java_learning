package EpicrafterJourney.Personnage;

import EpicrafterJourney.Interface.IPersonnage;

public abstract class Personnage implements IPersonnage {
    protected String nom;

    public Personnage(final String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
