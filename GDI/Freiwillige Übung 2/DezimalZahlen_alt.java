import java.util.Scanner;

public class DezimalZahlen {

	public static void main(String[] args) {
		// Variablen-Deklaration
		String[] dezimalwerte = { "1000", "900", "500", "400", "100", "90",
				"50", "40", "10", "9", "5", "4", "1" };
		String[] roemwerte = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		String roem;
		int ergebnis = 0;
		String[][] test = new String[13][13];
		// Tastatureingabe initialisieren
		Scanner in = new Scanner(System.in);

		System.out.println("Programm zur Ausgabe von Dezimal-Zahlen\n");
		System.out.print("Bitte geben Sie eine roemische Zahl ein: ");
		// Roemishe Zahl eingeben
		roem = in.nextLine();
		in.close();
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j <= 1; j++) {
					test[i][j] = test[][i];
			}
		}
		
		for (int i = 0; i <= 2; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(test[j][i]);
			}
			System.out.println();
		}

		System.out.println(ergebnis);
		// Zahl mit größtem römischen Wert vergleichen und anschließend Zahl
		// verkleinern uns ausgeben
		/*
		 * if (zahl > 0 && zahl < 4000) { while (zaehler < dezimalwerte.length)
		 * { if (zahl - dezimalwerte[zaehler] >= 0) { zahl -=
		 * dezimalwerte[zaehler]; System.out.print(roemwerte[zaehler]); } else {
		 * zaehler++; } } } else {
		 * System.out.println("Fehler: Zahl nicht im vorgegebenen Bereich!"); }
		 */
	}

}