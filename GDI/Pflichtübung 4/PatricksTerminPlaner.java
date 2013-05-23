import java.util.Scanner;

public class PatricksTerminPlaner {
	public static boolean runProgram = true;
	public static String[] terminArray = new String[24];
	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		while (runProgram) {
			zeigeHauptmenue();
			bildschirmLeeren();
		}
		in.close();
	}

	public static void zeigeHauptmenue() {
		System.out.println("TerminPlaner 1.0\n\n - Hauptmenü -");
		System.out.println("\t1) Neuen Termin erstellen");
		System.out.println("\t2) Termine anzeigen");
		System.out.println("\t3) Programm beenden");

		int auswahl = in.nextInt();
		in.nextLine();

		switch (auswahl) {
		case 1:
			neuerTermin();
			break;
		case 2:
			termineAnzeigen();
			break;
		default:
			runProgram = false;
			break;
		}
	}

	public static void bildschirmLeeren() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
	}

	public static void neuerTermin() {
		boolean runMethod = true;

		while (runMethod) {
			try {
				System.out.print("\tBitte Uhrzeit angeben (0 - 23 Uhr): ");
				int uhrzeit = in.nextInt();
				in.nextLine();

				if (uhrzeit >= 0 && uhrzeit <= 23) {
					System.out.print("\tBitte Termin für " + uhrzeit
							+ " Uhr angeben: ");
					terminArray[uhrzeit] = in.nextLine();
					runMethod = false;
				} else {
					System.out
							.println("\tFehler! Uhrzeit nicht zwischen 0 Uhr und 23 Uhr!\n");
				}
			} catch (Exception e) {
				System.out.println("\tFehler: " + e.getMessage());
				in.nextLine();
			}
		}
	}

	public static void termineAnzeigen() {
		for (int i = 0; i < terminArray.length; i++) {
			String ausgabe = (terminArray[i] == null) ? "" : terminArray[i];
			System.out.println(i + " Uhr: " + ausgabe);
		}
		System.out.println("Mit Enter zurück zum Hauptmenü");
		in.nextLine();
	}

}
