import java.util.Scanner;

public class Caesar {

	public static void main(String[] args) {
		// Variablen-Deklaration
		String wort;
		int wert;

		// Tastatureingabe initialisieren
		Scanner in = new Scanner(System.in);

		System.out.println("Programm zur Verschluesselung durch Caesar\n");
		System.out.print("Bitte geben Sie einen Text ein: ");
		// Wort eingeben
		wort = in.nextLine();
		in.close();

		// Wort zerlegen und jeden Buchstaben prüfen
		for (int i = 0; i < wort.length(); i++) {
			wert = (int) wort.charAt(i);
			// Wert muss im Bereich von A-Z oder a-z liegen. Da andere Zeichen ignoriert werden sollen
			if ((wert >= 'A' && wert <= 'Z') || (wert >= 'a' && wert <= 'z')) {
				switch (wert) {
				case 'Z':
					wert = 'A';
					break;
				case 'z':
					wert = 'a';
					break;
				default:
					wert++;
					break;
				}
			}
			//Ausgabe des Buchstabens
			System.out.print((char) wert);
		}
	}

}