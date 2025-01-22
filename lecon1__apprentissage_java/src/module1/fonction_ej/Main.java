package module1.fonction_ej;

public class Main {
    public static void main(String[] args){
        String affiche = Main.affiche();
        String affiche2 = Main.afficheV2("Afficher du texte depuis Main");
        int somme = Main.addition(5, 8);

        System.out.println(affiche);
        System.out.println(affiche2);
        System.out.println(somme);
    }

    public static String affiche(){
        System.out.println("Une fonction en Java a été exécutée” dans la console");
        return null;
    }

    public static String afficheV2(String texte) {
        System.out.println(texte);
        return null;
    }

    public static int addition(int number1, int number2) {
        return number1 + number2;
    }
}
