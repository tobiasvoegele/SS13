//Author: Max Jando - 1312825
//UIB SS2013 - GDI - Prof. Dr. Sven Klaus
//Freiwillige Uebung 1

// Lösungsversuch: Berechnung der Exponentialfunktion exp(x)

import java.util.Scanner;

public class Exponentialfunktion {

	public static void main(String[] args) {
		// Deklaration der Variablen
		double epsilon; // Genauigkeit
		double x; // Eingabe Zahl
		double fakultaet = 1; // Variable zur Berechnung der Fakultaet
		double potenz = 1; // Variable zur Berecnung der Potenz
		double rechner = 1.0; // Variable zur Berechnung der Formel
		double zahlSchrittPlusEins = 0.0; // Variable zur Berechnung der Formel
											// einen Schritt weiter

		Scanner in = new Scanner(System.in);

		System.out
				.println("Programm zur Berechnung der Exponentialfunktion - exp(x)\n");
		System.out
				.print("Bitte geben Sie die Zahl ein für welche Sie die exp(x) berechnen wollen: \n");
		x = in.nextDouble();
		System.out.print("Bitte geben Sie die Genauigkeit ein(z.B. 0,00001): ");
		epsilon = in.nextDouble();
		in.close();

		// Ausgabe des Wertes von Math.exp(x)
		System.out.println(Math.exp(x));

		int i = 1; // Schleifezähler setzen
		
		// Bei Zahl = 0 wird Schleife übersprungen, da Ergebnis = 1 (Default-Wert)
		if (x > 0) {
			do {
				fakultaet *= i;//Falkutaet-Schritt
				potenz *= x;//Potenz-Schritt
				rechner += (potenz / fakultaet); // Formel ausführen
				i++; // Zähler erhöhen
				zahlSchrittPlusEins = potenz * x / fakultaet * i; // Nächsten Schritt errechnen
			} while (Math.abs((zahlSchrittPlusEins - rechner) / rechner) > epsilon); //Schleifenbedingung
		}
		System.out.println("Ergebnis ist: " + rechner); // Ausgabe Ergebnis

	}
}
