/**
 * @author Max Jando - 1312825 / Patrick Fruh - 1314827
 * Klasse, welche die Zahl 10 in vorgegebenen Arrays sucht.
 * Es wird Menü mit verschiedenen Suchalgorithmen ausgegeben.
 * Der User sucht sich dann durch Auswahl einen Suchalgorithmus aus.
 * Anschließend werden die Versuche und arrays ausgegeben 
 *
 */

import java.util.*;

public class SuchAlgorithmen {
	public static final int SUCHZAHL = 10;
	public static int versuchsZaehler = 0;

	public static void main(String[] args) {
		int ergebnisGut = 0;
		int ergebnisSchlecht = 0;

		int suchAlgorithmus;
		Scanner in = new Scanner(System.in);
		System.out.println("Welchen Suchalgorithmus wollen Sie verwenden?");
		System.out.println();
		System.out.println("Bitte geben Sie eine Zahl von 1-4 ein");
		System.out.println();
		System.out.println("1: Lineare Suche mit gesamter Folge");
		System.out.println();
		System.out.println("2: Lineare Suche mit Rückkehr");
		System.out.println();
		System.out.println("3: Rekursive lineare Suche");
		System.out.println();
		System.out.println("4: Rekursive binaere Suche");
		suchAlgorithmus = in.nextInt();
		// Initialisierung der Arrays für besten und schlechtesten Fall
		int[] zahlenlisteLinearSchlecht = { 1, 2, 4, 6, 8, 9, 10 };
		int[] zahlenlisteLinearGut = { 10, 9, 8, 6, 4, 2, 1 };
		int[] zahlenlisteLinRekGut = { 1, 2, 4, 6, 8, 9, 10 };
		int[] zahlenlisteLinRekSchlecht = { 10, 9, 8, 6, 4, 2, 1 };
		int[] zahlenlisteBinaerGut = { 6, 9, 8, 10, 4, 2, 1 };
		int[] zahlenlisteBinaerSchlecht = { 1, 2, 4, 6, 8, 9, 10 };

		// MENUE - Auswahl
		// Aufruf der Funktionen und Ausgabe der Arrays und Ausgabe der
		// Vergleiche
		switch (suchAlgorithmus) {
		case 1:
			ergebnisSchlecht = lineareSucheFor(zahlenlisteLinearSchlecht,
					SUCHZAHL);
			System.out.print("ArraySchlecht: ");
			printArray(zahlenlisteLinearSchlecht);
			System.out.println();
			ergebnisGut = lineareSucheFor(zahlenlisteLinearGut, SUCHZAHL);
			System.out.print("ArrayGut: ");
			printArray(zahlenlisteLinearGut);
			System.out.println();
			break;
		case 2:
			ergebnisSchlecht = lineareSucheWhile(zahlenlisteLinearSchlecht,
					SUCHZAHL);
			System.out.print("ArraySchlecht: ");
			printArray(zahlenlisteLinearSchlecht);
			System.out.println();
			ergebnisGut = lineareSucheWhile(zahlenlisteLinearGut, SUCHZAHL);
			System.out.print("ArrayGut: ");
			printArray(zahlenlisteLinearGut);
			System.out.println();
			break;
		case 3:
			ergebnisGut = lineareSucheRekursiv(zahlenlisteLinRekGut, SUCHZAHL);
			System.out.print("ArrayGut: ");
			printArray(zahlenlisteLinRekGut);
			System.out.println();
			ergebnisSchlecht = lineareSucheRekursiv(zahlenlisteLinRekSchlecht,
					SUCHZAHL);
			System.out.print("ArraySchlecht: ");
			printArray(zahlenlisteLinRekSchlecht);
			System.out.println();
			break;
		case 4:
			ergebnisGut = binSearch(zahlenlisteBinaerGut, 0,
					zahlenlisteBinaerGut.length - 1, SUCHZAHL);
			System.out.print("ArrayGut: ");
			printArray(zahlenlisteBinaerGut);
			System.out.println();
			ergebnisSchlecht = binSearch(zahlenlisteBinaerSchlecht, 0,
					zahlenlisteBinaerSchlecht.length - 1, SUCHZAHL);
			System.out.print("ArraySchlecht: ");
			printArray(zahlenlisteBinaerSchlecht);
			System.out.println();
			break;
		}
		System.out.println("Bester Fall: " + ergebnisGut + " Vergleiche");
		System.out.println("Schlechtester Fall: " + ergebnisSchlecht
				+ " Vergleiche");
	}

	public static int lineareSucheFor(int[] liste, int wert) {
		/**
		 * Lineare Suche ohne Rückkehr Zählt Vergleiche und git diese zurück
		 */
		int tmpErgebnis = -1;
		int anzahlVergleiche = 0;
		for (int i = 0; i < liste.length; i++) {
			anzahlVergleiche++;
			if (liste[i] == wert) {
				tmpErgebnis = i;
			}
		}
		return anzahlVergleiche;
	}

	public static int lineareSucheWhile(int[] liste, int wert) {
		/**
		 * Lineare Suche mit Rückkehr Zählt Vergleiche und git diese zurück
		 */
		int tmpErgebnis = -1;
		int anzahlVergleiche = 0;
		boolean found = false;
		int i = 0;
		while (!found && i < liste.length) {
			anzahlVergleiche++;
			if (liste[i] == wert) {
				found = true;
				tmpErgebnis = i;
			}
			i++;
		}
		return anzahlVergleiche;
	}

	public static int lineareSucheRekursiv(int[] liste, int wert) {
		/**
		 * Lineare Suche Rekursiv. Zählt Vergleiche und git diese zurück
		 */
		int tmpErgebnis = -1;
		if (liste.length == 0) {
			return 0;
		} else {
			if (liste[liste.length - 1] == wert) {
				return 1;
			} else {
				// rest gibt Array ohne letztes Element zurï¿½ck
				return 1 + lineareSucheRekursiv(
						removeOneElement(liste, liste.length - 1), wert);
			}
		}
	}

	public static int binSearch(int[] liste, int lower, int upper, int wert) {
		/**
		 * Binäre Suche. Zählt Vergleiche und git diese zurück
		 */
		if (lower > upper) {
			return 0;
		} else {
			int middle = (lower + upper) / 2;
			if (liste[middle] == wert) {
				return 1;
			} else if (liste[middle] < wert) {
				return 1 + binSearch(liste, middle + 1, upper, wert);
			} else {
				return 1 + binSearch(liste, lower, middle - 1, wert);
			}
		}
	}

	public static int[] removeOneElement(int[] currentArray, int removeIndex) {
		/**
		 * Methoden um neues Array zu erstellen ohne das übergebendes Element
		 */
		int groesse = currentArray.length;
		int[] ergebnisArray = new int[groesse - 1];
		int ergebnisArrayZaehler = 0;
		for (int i = 0; i < groesse; i++) {
			if (i != removeIndex) {
				ergebnisArray[ergebnisArrayZaehler] = ergebnisArray[i];
				ergebnisArrayZaehler++;
			}
		}
		return ergebnisArray;
	}

	public static void printArray(int[] ausgebendesArray) {
		/**
		 * Methoden um Array auszugeben
		 */
		for (int i : ausgebendesArray) {
			System.out.print(i + ", ");
		}
	}

}
