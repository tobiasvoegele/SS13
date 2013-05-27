/**
 * @author Max Jando - 1312825 / Patrick Fruh - 1314827 Klasse, welche die 2
 *         vorgegebene Arrays mit verschiedenen BubbleSort Implementierungen
 *         sortiert.
 * 
 */

public class BubbleSort {

	public static void main(String[] args) {

		int[] zahlenArray = { 0, -4, -9, 3, 8, 12, 13, 45, 89, 56, 46, 14, 87,
				55, 11, 2, 5, 1, 7, 44 };

		int[] zahlenArrayVorgabe = { 10, 6, 7, 7, 8, 2, 45, 11, 100, 1000,
				1000, 56, 0, 1 };
		/*
		 * int eingabe; boolean sortierrichtung;
		 * 
		 * Scanner in = new Scanner(System.in); System.out .println(
		 * "Bitte geben Sie eine Suchrichtung(1 für links nach rechts, 2 für rechts nach links) ein: "
		 * ); eingabe = in.nextInt(); in.close();
		 */
		// true ist sortierrichtung von links nach rechts
		// false ist sortierrichtung von rechts nach links
		/*
		 * sortierrichtung = (eingabe == 1) ? true : false;
		 * ausgabeBubbleSortMod2(zahlenArray, sortierrichtung);
		 * System.out.println(); ausgabeBubbleSortMod2(zahlenArrayVorgabe,
		 * sortierrichtung);
		 */

		// ausgabeBubbleSort(zahlenArray);
		// System.out.println();
		// ausgabeBubbleSort(zahlenArrayVorgabe);

		// ausgabeBubbleSortMod1(zahlenArray);
		// System.out.println();
		// ausgabeBubbleSortMod1(zahlenArrayVorgabe);

		ausgabeBubbleSortMod1Verbessert(zahlenArray);
		System.out.println();
		ausgabeBubbleSortMod1Verbessert(zahlenArrayVorgabe);

	}

	public static void bubbleSort(int[] zahlenArray) {
		/**
		 * Methode um das Sortierverfahren Bubble Sort zu implementieren
		 */
		int durchgang = 0;
		int durchlaufweite = zahlenArray.length;
		int tempweite;
		int vertauschungen = 0;
		int vergleiche = 0;

		// Wiederholen bis alle sortiert
		while (durchlaufweite > 1) {
			tempweite = 1;
			// Durchlaufen jeder Stelle im zahlenArray
			for (int i = 0; (i < durchlaufweite - 1); i++) {
				// Vertauschung von Zahl mit Nachfolgender wenn Zahl größer.
				vergleiche++;
				if (zahlenArray[i] > zahlenArray[i + 1]) {
					swap(zahlenArray, i, i + 1);
					vertauschungen++;
					tempweite = i + 1;
				}
			}
			// Neue Durchlaufweite bis vor sortierten Zahlen am Ende
			durchlaufweite = tempweite;
			durchgang++;
			System.out.print(durchgang + " - ");
			printArray(zahlenArray);
		}

		System.out.println("Vertauschunge: " + vertauschungen);
		System.out.println("Vergleiche: " + vergleiche);
	}

	public static void bubbleSortMod1(int[] zahlenArray) {
		/**
		 * Methode um das Sortierverfahren Bubble Sort Modifiziert Möglichkeit 1
		 * zu implementieren
		 */
		int durchgang = 0;
		int vertauschungen = 0;
		int vergleiche = 0;

		boolean getauscht = true;

		// Wiederholen bis nicht mehr getauscht wird
		while (getauscht) {
			getauscht = false;
			// Durchlaufen jeder Stelle im zahlenArray
			for (int i = 0; (i < zahlenArray.length - 2); i++) {
				// Vertauschung von Zahl mit 2. Nachfolgender wenn Zahl größer.
				vergleiche++;
				if (zahlenArray[i] > zahlenArray[i + 2]) {
					swap(zahlenArray, i, i + 2);
					vertauschungen++;
					getauscht = true;
				}
				// Vertauschung von Zahl mit Nachfolgender wenn Zahl größer.
				vergleiche++;
				if (zahlenArray[i] > zahlenArray[i + 1]) {
					swap(zahlenArray, i, i + 1);
					vertauschungen++;
					getauscht = true;
				}
			}
			durchgang++;
			System.out.print(durchgang + " - ");
			printArray(zahlenArray);
		}

		System.out.println("Vertauschunge: " + vertauschungen);
		System.out.println("Vergleiche: " + vergleiche);
	}

	public static void bubbleSortMod1Verbessert(int[] zahlenArray) {
		/**
		 * Methode um das Sortierverfahren Bubble Sort Modifiziert Möglichkeit 1 verbessert
		 * zu implementieren
		 */
		int durchgang = 0;
		int vertauschungen = 0;

		int durchlaufweite = zahlenArray.length;
		int tempweite;

		int vergleiche = 0;

		// Wiederholen bis alle sortiert
		while (durchlaufweite > 1) {
			tempweite = 1;
			// Durchlaufen jeder Stelle im zahlenArray
			for (int i = 0; (i < durchlaufweite - 2); i++) {
				// Vertauschung von Zahl mit 2. Nachfolgender wenn Zahl größer.
				vergleiche++;
				if (zahlenArray[i] > zahlenArray[i + 2]) {
					swap(zahlenArray, i, i + 2);
					vertauschungen++;
					tempweite = i + 2;
				}
				vergleiche++;
				// Vertauschung von Zahl mit Nachfolgender wenn Zahl größer.
				if (zahlenArray[i] > zahlenArray[i + 1]) {
					swap(zahlenArray, i, i + 1);
					vertauschungen++;
					// Überprüfung ob tempweite schon erhöht.
					if (tempweite == 1)
						tempweite = i + 1;
				}
			}
			durchlaufweite = tempweite;
			durchgang++;
			System.out.print(durchgang + " - ");
			printArray(zahlenArray);
		}

		System.out.println("Vertauschunge: " + vertauschungen);
		System.out.println("Vergleiche: " + vergleiche);
	}

	public static void bubbleSortMod2(int[] zahlenArray, boolean sortierrichtung) {
		/**
		 * Methode um das Sortierverfahren Bubble Sort Modifiert Möglichkeit 2
		 * zu implementieren
		 */
		if (sortierrichtung) {
			for (int i = 0; i < (zahlenArray.length - 1); i++) {
				for (int j = 0; j < (zahlenArray.length - 1); j++) {
					if (zahlenArray[j] > zahlenArray[j + 1]) {
						swap(zahlenArray, j, j + 1);
					}
				}
				System.out.print(i + 1 + " - ");
				printArray(zahlenArray);
			}
		} else {
			for (int i = (zahlenArray.length - 1); i > 0; i--) {
				for (int j = (zahlenArray.length - 1); j > 0; j--) {
					if (zahlenArray[j - 1] > zahlenArray[j]) {
						swap(zahlenArray, j - 1, j);
					}
				}
				System.out.print(i + 1 + " - ");
				printArray(zahlenArray);
			}
		}
	}

	public static void swap(int[] zahlenArray, int index1, int index2) {
		/**
		 * Methode um in einem Array zwei Zahlen zu tauschen
		 */
		int tmp = zahlenArray[index1];
		zahlenArray[index1] = zahlenArray[index2];
		zahlenArray[index2] = tmp;
	}

	public static void printArray(int[] ausgebendesArray) {
		/**
		 * Methode um Array auszugeben
		 */
		for (int i : ausgebendesArray) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	public static void ausgabeBubbleSort(int[] zahlenArray) {
		/**
		 * Methode um BubbleSort auszugeben
		 */
		System.out.print("Unsortiertes Array: ");
		printArray(zahlenArray);
		System.out.println();
		bubbleSort(zahlenArray);
		System.out.println();
		System.out.print("Sortiertes Array: ");
		printArray(zahlenArray);
	}

	public static void ausgabeBubbleSortMod1Verbessert(int[] zahlenArray) {
		/**
		 * Methode um BubbleSortMod1 auszugeben
		 */
		System.out.print("Unsortiertes Array: ");
		printArray(zahlenArray);
		System.out.println();
		bubbleSortMod1Verbessert(zahlenArray);
		System.out.println();
		System.out.print("Sortiertes Array: ");
		printArray(zahlenArray);
	}

	public static void ausgabeBubbleSortMod1(int[] zahlenArray) {
		/**
		 * Methode um BubbleSortMod1 auszugeben
		 */
		System.out.print("Unsortiertes Array: ");
		printArray(zahlenArray);
		System.out.println();
		bubbleSortMod1(zahlenArray);
		System.out.println();
		System.out.print("Sortiertes Array: ");
		printArray(zahlenArray);
	}

	public static void ausgabeBubbleSortMod2(int[] zahlenArray,
			boolean sortierrichtung) {
		/**
		 * Methode um BubbleSortMod2 auszugeben
		 */
		System.out.print("Unsortiertes Array: ");
		printArray(zahlenArray);
		System.out.println();
		bubbleSortMod2(zahlenArray, sortierrichtung);
		System.out.println();
		System.out.print("Sortiertes Array: ");
		printArray(zahlenArray);
	}

}
