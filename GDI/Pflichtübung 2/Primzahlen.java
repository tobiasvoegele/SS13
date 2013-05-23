import java.util.Scanner;

public class Primzahlen {

	public static void main(String[] args) {
		// Variablen-Deklaration
		int zahl;
		boolean prim;
		int j;

		// Tastatureingabe initialisieren
		Scanner in = new Scanner(System.in);

		System.out
				.println("Programm zur Berechnung der kleineren Primzahlen\n");
		System.out.print("Bitte geben Sie eine ganze Zahl ein: ");
		// Ganzen Zahl eingeben
		zahl = in.nextInt();
		in.close();

		System.out.print("Primzahlen <= " + zahl + ": ");

		// Algorithmus zur Berechnung der Primzahlen
		for (int i = zahl; i > 1; i--) {
			prim = true;
			j = i / 2;
			while (j > 1 && prim) {
				if (i % j == 0) {
					prim = false;
				}
				j--;
			}
			if (prim) {
				System.out.print(i + " ");
			}
		}
	}
}