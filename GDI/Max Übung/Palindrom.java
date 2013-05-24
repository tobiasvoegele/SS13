/**
 * @author Max Jando
 *         Programm zum Ueberpruefen eines Palindroms
 *         Ein Palindrom ist ein Wort, welches vorwärts und rückwärts gelesen identisch ist.
 *         Beispiele: "ABBA", "lagerregal". Die Gross- und Kleinschreibung braucht nicht berücksichtigt
 *         zu werden: "Lagerregal" muss also nicht als Palindrom erkannt werden.
 */

import java.util.*;

public class Palindrom {

    public static void main(String[] args) {
        //Deklaration lokaler Variablen
        Scanner in = new Scanner(System.in);
        String eingabe;
        String ausgabe;
        Boolean istPalindrom;

        //Programmstart
        ausgabeHauptprogramm();
        eingabe = in.next().toLowerCase();
        istPalindrom = palindromUeberpruefen(eingabe);
        ausgabe = istPalindrom ? "ein" : "kein";
        System.out.println("Das eingegebene Wort ist " + ausgabe + " Palindrom!");
        in.close();

    }

    private static void ausgabeHauptprogramm() {
        System.out.println("Programm zum Uberpruefen eines Palindroms.");
        System.out.println("Bitte geben Sie ein Wort ein, welches Sie ueberpruefen moechten: ");
    }

    private static boolean palindromUeberpruefen(String eingabe) {
        /**
         * Funktion welche überprüft ob das eingegebene Wort ein Palindrom ist.
         */
        int zaehlerVorwaerts = 0;
        boolean istPalindrom = true;
        int zaehlerRueckwaerts = eingabe.length();

        // Schleife durchlaeuft das eingegebene Wort mit 2 Zaehlern welche entgegenlaufen.
        // Bei durchgängiger Gleichheit der Indexstellen handelt es sich um ein Palindrom
        while (zaehlerVorwaerts < eingabe.length() && istPalindrom) {
            if (eingabe.charAt(zaehlerVorwaerts) != eingabe.charAt(zaehlerRueckwaerts - 1)) {
                istPalindrom = false;
            }
            zaehlerRueckwaerts--;
            zaehlerVorwaerts++;
        }
        return istPalindrom;
    }
}
