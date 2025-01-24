package EpicrafterJourney.Interface;

public interface IPersonnage {
    public void construireUnBloc(IBloc bloc);

    String getNom();

    void subiAttaque(int pointsDAttaques);
}
