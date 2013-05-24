import java.util.Scanner;

/**
 * @author Max Jando
 *         Ein Kaufmann besitzt eine Waage mit zwei Waagschalen und sieben Gewichtssteine:
 *         1 kg, 2kg, 4 kg, 8 kg, 16 kg, 32 kg und 64 kg. Auf die eine Schale legt der Kaufmann jeweils die Ware,
 *         während er auf die andere Schale die Gewichtssteine hinstellt. Er ist mit seinen sieben Gewichtssteinen
 *         in der Lage, alle Gewichte von einem Kilo bis zu 127 kg abzuwägen. Schreiben Sie ein Programm, das ein
 *         Gewicht (0 kg ... 127 kg) entgegennimmt und auf der Konsole ausgibt, welche Gewichtssteine
 *         zu verwenden sind.
 */
public class Waage {

    private static final int[] GEWICHTE = {64, 32, 16, 8, 4, 2, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        short eingabe;
        //Programmstart
        ausgabeHauptprogramm();
        eingabe = in.nextShort();
        if (eingabe <= 127) {
            berechneGewichte(eingabe);
        } else {
            System.out.print("Das eingegebene Gewicht ist leider zu groß");
        }
    }

    private static void berechneGewichte(short eingabe) {
        short zwischenErgebnis = eingabe;
        short gewichteDurchlauf = 0;
        System.out.print("Das eingegebene Gewicht kann mit den folgenden Gewichtssteinen(in KG) gewogen werden: ");
        while (zwischenErgebnis > 0) {
            if (GEWICHTE[gewichteDurchlauf] <= zwischenErgebnis) {
                zwischenErgebnis -= GEWICHTE[gewichteDurchlauf];
                System.out.print(GEWICHTE[gewichteDurchlauf] + " ");
            }
            gewichteDurchlauf++;
        }

    }

    private static void ausgabeHauptprogramm() {
        System.out.println("Programm zum Ausgeben der Gewichtssteine fuer ein Gewicht.");
        System.out.println("Bitte geben Sie eine ganze Zahl fuer Gewicht(0-127) ein: ");
    }

}