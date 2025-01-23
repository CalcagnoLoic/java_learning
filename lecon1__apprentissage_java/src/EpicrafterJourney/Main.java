package EpicrafterJourney;

import java.util.*;

public class Main {

    public static void  main(String[] args) {
        try{
            Porte porte = new Porte(1,5,1,true);
            porte.verrouiller();
        } catch (PorteVerrouilleException e) {
            System.out.println("La porte est déjà verrouillée");
        } catch (IllegalBlocException e) {
            System.out.println("Impossible de construire le bloc");
        }
    }
}
