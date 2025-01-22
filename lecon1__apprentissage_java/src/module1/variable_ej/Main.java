package module1.variable_ej;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        String langage = "Java";
        String phrase = langage + " est un langage de programmation.";

        System.out.println(phrase);

        int[] unTableauDEntier = {5,10,15,20};

        String[] unTableauDeChar = new String[3];
        unTableauDeChar[0] = "a";
        unTableauDeChar[1] = "n";
        unTableauDeChar[2] = "z";

        System.out.println(Arrays.toString(unTableauDeChar));
        System.out.println(Arrays.toString(unTableauDEntier));

        String variable = "Hello, World!";
        System.out.println(variable);
    }
}
