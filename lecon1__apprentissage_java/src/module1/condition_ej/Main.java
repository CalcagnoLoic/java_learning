package module1.condition_ej;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Main.meteo(true);
        System.out.println(Main.commentaireMeteo("soleil"));
        System.out.println(Main.commentaireMeteo(""));
        System.out.println("------------");
        Main.afficher5Nombres();
        System.out.println("------------");
        Main.compteJusqua10();
        System.out.println("------------");
        Main.listeDeLangages();
        System.out.println("------------");
        System.out.println(Main.exercice());
    }

    public static void meteo(final boolean beauTemps){
        if(beauTemps){
            System.out.println("le temps est beau");
        } else {
            System.out.println("Le temps n'est pas beau");
        }
    }

    public static String commentaireMeteo(final String temps){
        return switch (temps){
            case "soleil" ->"Beau temps d'été";
            case "pluie" -> "Il fait moche ajd";
            case "neige" -> "C'est l'hiver";
            default -> "Météo actuellement indisponible";
        };
    }

    public static void afficher5Nombres(){
        int chiffre = 5;
        while (chiffre > 0){
            System.out.println(chiffre);
            chiffre--;
        }
    }

    public static void compteJusqua10(){
        for (int i = 0; i < 11; i++) {
            System.out.println(i);
        }
    }

    public static void listeDeLangages() {
        List<String> nomDeLangages = Arrays.asList("Java", "Python", "PHP");
        for(String langage: nomDeLangages){
            System.out.println(langage);
        }
    }

    public static int exercice(){
        int cpt = 0;
        List<Integer> mesChiffres = Arrays.asList(15,0,78,5,0,19,256);

        for (Integer chiffre: mesChiffres){
            if (chiffre.equals(0)){
                cpt++;
            }
        }

        return cpt;
    }
}