// Aufgabe 3
// Jando, Max -- 1312825
// Fruh, Patrick -- 1314827

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
		// Variablen
		int zahl, count=0, sum=0, modulo;
		Boolean run = true;

		// Möglichkeit der Tastatureingabe
		Scanner in = new Scanner(System.in);
		
		do {
			// Nachricht und Eingabe der Zahl
			System.out.println("Zahl < 0 zum Beenden");
			System.out.print("Bitte ganze Zahl eingeben: ");
			zahl = in.nextInt();
			
			// Bei positiver Zahl erhöhung der Gesamtanzahl
			// Bei gerader Zahl zusätzlich aufaddieren zur Gesamtsumme
			// Bei negativer Zahl abbruch der Schleife
			if(zahl >=0) {
				count++;
				
				modulo = zahl % 2;
				if(modulo == 0) {
					sum += zahl;
				}
			} else { run = false; }
		} while (run);
		System.out.println();
		System.out.println("Gesamtsumme gerader Zahlen: " + sum);
		System.out.println("Anzahl der Zahlen: " + count);
	}

}