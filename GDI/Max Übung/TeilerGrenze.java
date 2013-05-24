import java.util.Scanner;

/**
 * @author Max Jando
 *         Programm zum Ausgeben jeweils aller Teiler jeder Zahl bis zu einer Grenze.
 *         Zusätzlich wird bei jeder Zahl ausgegeben ob diese eine Primzahl ist.
 */

public class TeilerGrenze {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long eingabe;

        //Programmstart
        ausgabeHauptprogramm();
        eingabe = in.nextLong();
        berechneTeiler(eingabe);
    }

    private static void berechneTeiler(long eingabe) {
        int counter;
        for (int zahl = 1; zahl <= eingabe; zahl++) {
            counter =0;
            System.out.print(zahl + " --> ");
            for (int teiler = 1; teiler <= zahl; teiler++) {
                if (zahl % teiler == 0) {
                    System.out.print(teiler + " ");
                    counter++;
                }
            }
            if (counter == 2) {
                System.out.print(" --- Primzahl!");
            }
            System.out.println();
        }

    }

    private static void ausgabeHauptprogramm() {
        System.out.println("Programm zum Ausgeben jeweils aller Teiler jeder Zahl bis zu einer Grenze.");
        System.out.println("Zusaetzlich wird bei jeder Zahl ausgegeben ob diese eine Primzahl ist");
        System.out.println("Bitte geben Sie eine ganze Zahl als Grenze ein: ");
    }


}
