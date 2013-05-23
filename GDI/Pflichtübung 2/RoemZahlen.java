import java.util.Scanner;

public class RoemZahlen {

	public static void main(String[] args) {
		// Variablen-Deklaration
		int[] dezimalwerte = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5,
				4, 1 };
		String[] roemwerte = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		int zahl;
		int zaehler = 0;

		// Tastatureingabe initialisieren
		Scanner in = new Scanner(System.in);

		System.out.println("Programm zur Ausgabe von römischen Zahlen\n");
		System.out
				.print("Bitte geben Sie eine ganze Zahl > 0 und < 4000 ein: ");
		// Ganzen Zahl eingeben
		zahl = in.nextInt();
		in.close();

		// Zahl mit größtem römischen Wert vergleichen und anschließend Zahl
		// verkleinern uns ausgeben
		if (zahl > 0 && zahl < 4000) {
			while (zaehler < dezimalwerte.length) {
				if (zahl - dezimalwerte[zaehler] >= 0) {
					zahl -= dezimalwerte[zaehler];
					System.out.print(roemwerte[zaehler]);
				} else {
					zaehler++;
				}
			}
		} else {
			System.out.println("Fehler: Zahl nicht im vorgegebenen Bereich!");
		}
	}

}