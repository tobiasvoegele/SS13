// Demo Programm f�r die erste �bung

import java.util.Scanner;

// Programm zur Berechnung der Celsius Temperatur 
// bei bekannter Fahrenheit Temperatur
public class FahrenheitUmlaute {

	public static void main(String[] args) {
		
		// Ben�tigte Variablen deklarieren
		double epsilon = 0.005;
		double f, c;
		
		// F�r die Eingabe von der Tastatur
		Scanner in = new Scanner(System.in);
		
		// Berechnungsschleife
		do {
			// Anleitung
			System.out.println("Programm endet durch Eingabe von 1");
			System.out.println("Eingabe der Fahrenheit-Temperatur: ");
			// Eingabe, Double-Wert einlesen
			f = in.nextDouble();
			// Umrechnen in Celsius
			c = (f-32) /9*5; 
			// Ausgabe des Ergebnis
			System.out.println("... in Celsius: " + c + " � \n");
		// Schleife durch Eingabe von 1 verlassen?
		} while (Math.abs(1-f) > epsilon);
		
		System.out.println("... und tsch�ss");
		in.close();
	}
}
