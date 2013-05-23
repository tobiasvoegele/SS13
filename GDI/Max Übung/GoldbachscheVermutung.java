/**
 * @author Max Jando
 * Programm zum Ueberpruefen der Goldbachschen Vermutung
 *
 * Im Jahr 1742 hat Christian Goldbach eine Vermutung aufgestellt, nach der jede ungerade Zahl groeßer als fuenf als 
 * Summe dreier Primzahlen dargestellt werden kann. Die nach ihm benannte Goldbachsche Vermutung lautet in einer 
 * staerkeren, heute gebraeuchlichen Version: Jede gerade natuerliche Zahl (groeßer als zwei) kann als Summe 
 * zweier Primzahlen repraesentiert werden.
 * 
 * Beispiele sind: 4 = 2 + 2, 6 = 3 + 3, 8 = 3 + 5, …
 * Die Summe muß nicht eindeutig sein: 5 + 5 = 3 + 7 = 10 .
 * Die Vermutung wurde bisher nicht bewiesen. Sie wurde fuer alle Zahlen bis 10^18 (Stand 2007) bestaetigt.
 */

import java.util.Scanner;

public class GoldbachscheVermutung {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int untergrenze = 4;
        long obergrenze;
        System.out.println("Programm zum Uberpruefen der Goldbachschen Vermutung.");
        System.out
                .println("Bitte geben Sie eine ganze gerade Zahl fuer die Obergrenze ein: ");
        obergrenze = in.nextLong();
        giugaRechner(untergrenze, obergrenze);
        in.close();
    }

    public static void giugaRechner(long untergrenze, long obergrenze) {
        for (long i = untergrenze; i <= obergrenze; i = i + 2) {
            pruefeZahlen(i, untergrenze, obergrenze);
        }
    }

    public static void pruefeZahlen(long geradeZahl, long untergrenze, long obergrenze) {
        boolean ersterCheck = false;
        boolean zweiterCheck = false;
        boolean gefunden = false;
        long erstePrim = 2;
        long zweitePrim = 2;

        while (erstePrim < obergrenze - 2 && !gefunden) {
            ersterCheck = pruefeAufPrimzahl(erstePrim);
            if (ersterCheck) {
                zweitePrim = 2;
                while (zweitePrim < geradeZahl && !gefunden) {
                    zweiterCheck = pruefeAufPrimzahl(zweitePrim);
                    if (zweiterCheck) {
                        if (erstePrim + zweitePrim == geradeZahl) {
                            gefunden = true;
                            System.out.println(erstePrim + " + " + zweitePrim
                                    + " == " + geradeZahl);
                        }
                    }
                    zweitePrim++;
                }
            }
            erstePrim++;
        }
    }

    public static boolean pruefeAufPrimzahl(long erstePrim) {
        boolean prim = true;
        long teiler = erstePrim - 1;
        while (teiler > 1 && prim) {
            if (erstePrim % teiler == 0) {
                prim = false;
            }
            teiler--;
        }
        return prim;
    }

}
