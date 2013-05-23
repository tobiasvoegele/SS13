import java.util.Scanner;

public class Eratosthenes {

	public static void main(String[] args) {

		int eingabe;

		Scanner in = new Scanner(System.in);

		System.out.println("Programm zur Ermittlung der Primzahlen\n");
		System.out.print("Bitte geben Sie eine ganze Zahl > 1 ein: ");

		eingabe = in.nextInt();
		in.close();

		// Initialisierung des Zahlenarrays
		int[] liste = new int[eingabe - 1];
		for (int i = 2; i != eingabe + 1; i++) {
			liste[i - 2] = i;
		}

		// Ausgabe des Arrays
		System.out.print("Liste der Zahlen:");
		for (int q : liste) {
			System.out.print(" " + q);
		}
		System.out.println("");

		// Streichung der nicht-Primzahlen und Ausgabe des Arrays
		for (int j = 2; j <= Math.sqrt(eingabe); j++) {
				for (int k = j; k <= eingabe; k = k + j) {
					if (k != j) {
						liste[k - 2] = 0;
					}
				}
		}
		System.out.print("Liste der Ergebnisse:");
		for (int p : liste) {
			System.out.print(" " + p);
		}

		// Ausgabe des Arrays ohne gestrichene Zahlen
		System.out.println();
		System.out.print("Liste der Ergebnisse ohne 0:");
		for (int r : liste) {
			if (r != 0) {
				System.out.print(" " + r);
			}
		}
	}
}