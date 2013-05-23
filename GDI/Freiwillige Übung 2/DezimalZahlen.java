/*
@author: Max Jando - 1312825 
UIB SS2013 - GDI - Prof. Dr. Sven Klaus
Freiwillige Uebung 2

Lösungsversuch: Umrechnung einer roemischen Zahl in eine Dezimalzahl
*/

import java.util.Scanner;

public class DezimalZahlen {

	public static void main(String[] args) {
		// Variablen-Deklaration
		int[] dezimalwerte = { 1, 5, 10, 50, 100, 500, 1000 };
		String roemwerte = "IVXLCDM";
		boolean gueltig = true;
		int ergebnis = 0;
		String roem;
		int momentanerWert, naechsterWert = 0;
		// Tastatureingabe initialisieren
		Scanner in = new Scanner(System.in);
		System.out.println("Programm zur Ausgabe von Dezimal-Zahlen\n");
		System.out.print("Bitte geben Sie eine roemische Zahl ein: ");
		// Roemishe Zahl eingeben
		roem = in.nextLine();

		in.close();

		/*
		 * Durchlaufe alle Zeichen der eingegebenen römischen Zahl, bis auf die
		 * letzte und errechne an Hand den Rechenregeln die Dezimalzahl
		 */
		if (roem.length() > 1) {
			for (int i = 0; i < roem.length(); i++) {
				momentanerWert = roemwerte.indexOf(roem.charAt(i + 0), 0);
				if (momentanerWert != -1) {//Wert ist eine römische Zahl 
					if (i != roem.length() - 1) {
						naechsterWert = roemwerte
								.indexOf(roem.charAt(i + 1), 0);
						/*
						 * System.out.println("momentanerWert: " +
						 * momentanerWert); System.out.println("naechsterWert: "
						 * + naechsterWert);
						 */
						if (momentanerWert < naechsterWert) {
							ergebnis += Math.abs(dezimalwerte[momentanerWert]
									- dezimalwerte[naechsterWert]);
							i++;
						} else {
							ergebnis += dezimalwerte[momentanerWert];
						}
					} else if (i == roem.length() - 1) {
						ergebnis += dezimalwerte[roemwerte.indexOf(
								roem.charAt(roem.length() - 1), 0)];
					}
				} else {//Wert ist keine römische Zahl
					gueltig = false;
				}
			}
		} else {
			ergebnis = dezimalwerte[roemwerte.indexOf(roem.charAt(0), 0)];
		}
		if (gueltig) {
			System.out.println(ergebnis);
		} else {
			System.out
					.println("Sie haben leider keine gueltige Roemische Zahl eingegeben. \nRoemische Zahlen bestehen aus den Zeichen: I V X L C D M");
		}

	}
}