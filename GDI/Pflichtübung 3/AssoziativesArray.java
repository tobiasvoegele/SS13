import java.util.Scanner;

/*
 * Max Jando - 1312825 / Patrick Fruh - 1314827 
 * Klasse, welche ein Assoziatives Array in Java implementiert.
 * String Werte können einem String Index zugeordnet werden.
 */
public class AssoziativesArray {

	public static void main(String[] args) {
		// Variablen-Deklaration
		int schluesselpaare;
		boolean gefunden = false;
		String zuPruefenderWert;

		// Tastatureingabe initialisieren
		Scanner in = new Scanner(System.in);

		System.out.println("Programm zum Generieren einer Tabelle\n");
		System.out.print("Bitte geben Sie die Anzahl der Schlüsselpaare ein: ");
		schluesselpaare = in.nextInt();

		// Entfernen von \n aus dem Input
		in.nextLine();

		String[][] zweiDimArray = new String[schluesselpaare][2];

		// Füllen des zweiDimArray mit eingegebenen Werten
		for (int i = 0; i < schluesselpaare; i++) {
			System.out.print("\nBitte geben Sie den Namen des " + (i + 1)
					+ ". Index an: ");
			zweiDimArray[i][0] = in.nextLine();
			System.out.print("\nBitte geben Sie den Wert des " + (i + 1)
					+ ". Index an: ");
			zweiDimArray[i][1] = in.nextLine();
		}

		// Ausgabe des zweiDimArray in Tabellenform
		for (int i = 0; i <= 1; i++) {
			for (int j = 0; j < schluesselpaare; j++) {
				if (j == 0) {
					System.out.print(zweiDimArray[j][i]);
				} else {
					System.out.print(" | " + zweiDimArray[j][i]);
				}
			}
			System.out.println();
		}

		System.out
				.println("Bitte geben Sie den Index, von welchem Sie den Wert haben möchten: ");

		zuPruefenderWert = in.nextLine();
		in.close();
		int j = 0;

		// Suche im zweiDimArray nach dem eingegebenen Index
		for (int i = 0; i <= 1; i++) {
			while (!gefunden && j < schluesselpaare) {
				if (zweiDimArray[j][i].toString().equals(zuPruefenderWert)) {
					System.out.println("Der dazugehoerige Wert lautet: "
							+ zweiDimArray[j][1]);
					gefunden = true;
				}
				j++;
			}
		}
		if (!gefunden) {
			System.out
					.println("Der gewünschte Index konnte im Array leider nicht gefunden werden - :(");
		}
	}
}