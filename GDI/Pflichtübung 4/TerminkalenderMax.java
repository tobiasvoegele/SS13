/**
@author Max Jando(1312825), Patrick Fruh()
Programm zum Verwalten von Terminen

 */
import java.util.Scanner;

public class TerminkalenderMax {

	// Deklaration globaler Variablen
	static String[] termine = new String[24];
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		// Deklaration lokaler Variablen
		int eingabe = 0;

		/*
		 * Schleifendurchlaeufe richten Sie je nach Eingabe des Benutzers.
		 * Durchlaufen wird das Hauptmenue, je nach Eingabe 1 - (N-Mal)
		 */
		do {
			// Menueausgabe
			System.out.println("Terminkalender v. 1.0");
			System.out.println("Programm zum Verwalten von Terminen");
			System.out.println("\n---- Hauptmenue -----");
			System.out
					.println("\nFolgende Menuepunkte stehen Ihnen zur Auswahl: ");
			System.out.println("\n 1: Termin erstellen");
			System.out.println("\n 2: Termine anzeigen");
			System.out.println("\n 3. Programm beenden");
			eingabe = in.nextInt();

			switch (eingabe) {
			case 1:
				terminErstellen();
				break;
			case 2:
				termineAnzeigen();
				break;
			default:
				programBeenden();
				break;

			}
		} while (eingabe != 3);
	}

	public static void terminErstellen() {
		/**
		 * Methode zum Erstellen von Terminen. Moegliche Stundenangabe : 0-23
		 */
		// Deklaration lokaler Variablen
		String uhrzeit = "";
		String terminname = "";
		boolean check = false;

		// Anzahl der Durchlaeufe beschraenkt sich die Fehlerhafte Eingabe des
		// Benutzers
		do {
			System.out
					.println("Bitte geben Sie eine Uhrzeit(0-23), fuer welche Sie einen Termin anlegen moechten: ");
			uhrzeit = in.next();
			uhrzeit = String.valueOf(uhrzeit);
			in.nextLine();
			// Abfangen von Zahlen ausserhalb des Bereichs von 0-23, inklusive
			// Buchstaben
			if (uhrzeit.matches("[0-9]|1[0-9]|2[0-3]")) {
				System.out.println("Bitte geben Sie einen Terminname ein: ");
				terminname = in.nextLine();
				check = true;
			} else {
				System.out
						.println("Das ist keine gueltige Uhrzeit-Angabe \n Bitte wiederholen Sie Ihre Eingabe\n");
			}
		} while (!check);
		// Bei erfolgreicher Eingabe wird der Termine gespeichert
		termine[Integer.parseInt(uhrzeit)] = terminname;
	}

	public static void termineAnzeigen() {
		/**
		 * Methode zum Anzeigen von Terminen
		 */
		// Deklaration lokaler Variablen
		String ausgabe = "";
		for (int i = 0; i < termine.length; i++) {
			// Mit Hilfe des Konvergenzoperators den NULL Pointer des String
			// Arrays ausblenden
			ausgabe = ((termine[i] == null) ? " " : termine[i]);
			System.out.println(i + " Uhr: " + ausgabe);
		}
	}

	public static void programBeenden() {
		/**
		 * Methode, welche das Programm beendet und eine Ausgabe auf dem
		 * Bildschirm ausgibt
		 */
		System.out.println("... und tschuess!");
	}
}
