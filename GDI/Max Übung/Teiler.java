import java.util.Scanner;

/**
 * @author Max Jando
 *         Programm zum Ausgeben aller Teiler einer Zahl.
 */

public class Teiler {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int eingabe;

        //Programmstart
        ausgabeHauptprogramm();
        eingabe = in.nextInt();
        berechneTeiler(eingabe);
    }

    private static void berechneTeiler(int eingabe) {
        System.out.print("Teiler der Zahl " + eingabe + " sind : ");
        for (int teiler = eingabe; teiler > 0; teiler--) {
            if (eingabe % teiler == 0) {
                System.out.print(teiler + " ");
            }
        }

    }

    private static void ausgabeHauptprogramm() {
        System.out.println("Programm zum Ausgeben aller Teiler einer Zahl.");
        System.out.println("Bitte geben Sie eine ganze Zahl ein, für welche Sie die Teiler ausgeben moechten: ");
    }


}
