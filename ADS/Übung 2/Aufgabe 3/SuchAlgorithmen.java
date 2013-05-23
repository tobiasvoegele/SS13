import java.util.*;

public class SuchAlgorithmen {

	public static void main(String[] args) {
		int anzahlZufall = 1;
		int anzahlZufallsZahl;
		int zuSuchendeZahl;
		int ergebnis;
		long zstVorher;
		long zstNachher;

		int suchAlgorithmus;
		Scanner in = new Scanner(System.in);
		System.out.println("Bitte geben Sie eine Anzahl der Zufallszahlen ein");
		anzahlZufallsZahl = in.nextInt();
		System.out
				.println("Bitte geben Sie eine Zahl ein die gesucht werden soll. Bereich 1-100");
		zuSuchendeZahl = in.nextInt();

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
		int[] zahlenliste = new int[anzahlZufallsZahl];
		for (int i = 1; i <= anzahlZufallsZahl; i++) {
			zahlenliste[i - 1] = (int) ((Math.random() * 100) + 1);
		}

		switch (suchAlgorithmus) {
		case 1:
			zstVorher = System.currentTimeMillis();
			ergebnis = lineareSucheFor(zahlenliste, zuSuchendeZahl);
			zstNachher = System.currentTimeMillis();
			System.out.println("Zeit benötigt: "
					+ ((zstNachher - zstVorher)) + " Millisekunden");
			if (ergebnis == -1) {
				System.out.println("Es wurde leider nichts gefunden");
			} else {
				System.out
						.println("Die Zahl wurde im Array an der Indexstelle "
								+ ergebnis + " gefunden");
			}
			break;
		case 2:
			zstVorher = System.currentTimeMillis();
			ergebnis = lineareSucheWhile(zahlenliste, zuSuchendeZahl);
			zstNachher = System.currentTimeMillis();
			System.out.println("Zeit benötigt: "
					+ ((zstNachher - zstVorher)) + " Millisekunden");
			if (ergebnis == -1) {
				System.out.println("Es wurde leider nichts gefunden");
			} else {
				System.out
						.println("Die Zahl wurde im Array an der Indexstelle "
								+ ergebnis + " gefunden");
			}
			break;
		case 3:
			zstVorher = System.currentTimeMillis();
			ergebnis = lineareSucheRekursiv(zahlenliste, zuSuchendeZahl);
			zstNachher = System.currentTimeMillis();
			System.out.println("Zeit benötigt: "
					+ ((zstNachher - zstVorher)) + " Millisekunden");
			if (ergebnis == -1) {
				System.out.println("Es wurde leider nichts gefunden");
			} else {
				System.out
						.println("Die Zahl wurde im Array an der Indexstelle "
								+ ergebnis + " gefunden");
			}
			break;
		case 4:
			Arrays.sort(zahlenliste);
			zstVorher = System.currentTimeMillis();
			ergebnis = binSearch(zahlenliste, 0, zahlenliste.length - 1,
					zuSuchendeZahl);
			zstNachher = System.currentTimeMillis();
			System.out.println("Zeit benötigt: " + ((zstNachher - zstVorher))
					+ " Millisekunden");
			if (ergebnis == -1) {
				System.out.println("Es wurde leider nichts gefunden");
			} else {
				System.out
						.println("Die Zahl wurde im Array an der Indexstelle "
								+ ergebnis + " gefunden");
			}
			break;
		}

	}

	public static int lineareSucheFor(int[] liste, int wert) {
		int tmpErgebnis = -1;
		for (int i = 0; i < liste.length; i++) {
			if (liste[i] == wert) {
				tmpErgebnis = i;
			}
		}
		return tmpErgebnis;
	}

	public static int lineareSucheWhile(int[] liste, int wert) {
		int tmpErgebnis = -1;
		boolean found = false;
		int i = 0;
		while (!found && i < liste.length) {
			if (liste[i] == wert) {
				found = true;
				tmpErgebnis = i;
			}
			i++;
		}
		return tmpErgebnis;
	}

	public static int lineareSucheRekursiv(int[] liste, int wert) {
		int tmpErgebnis = -1;
		if (liste.length == 0) {
			return tmpErgebnis;
		} else {
			if (liste[liste.length - 1] == wert) {
				return liste.length - 1;
			} else {
				// rest gibt Array ohne letztes Element zurï¿½ck
				return lineareSucheRekursiv(
						removeOneElement(liste, liste.length - 1), wert);
			}
		}
	}

	public static int binSearch(int[] liste, int lower, int upper, int wert) {

		if (lower > upper) {
			return -1;
		} else {
			int middle = (lower + upper) / 2;
			if (liste[middle] == wert) {
				return middle;
			} else if (liste[middle] < wert) {
				return binSearch(liste, middle + 1, upper, wert);
			} else {
				return binSearch(liste, lower, middle - 1, wert);
			}
		}
	}

	public static int[] removeOneElement(int[] currentArray, int removeIndex) {
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

}
