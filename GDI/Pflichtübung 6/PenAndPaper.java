import java.util.Random;
import java.util.Scanner;

public class PenAndPaper {

	public static Held Spieler1;
	public static Scanner in = new Scanner(System.in);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		klassenwahl();
		System.out.println("\n\n\n");
		printGeschichte();
		monsterAngriff();
		printGeschichteEnde();
	}

	public static void printGeschichte() {
		System.out
				.println("--- Du bist auf dem Weg von Moredor nach Isagur und trägst ein wichtiges Paket bei dir");
	}

	public static void printGeschichteEnde() {
		if (Spieler1.getLebenspunkte() > 0) {
			System.out
					.println("Du hast es bis nach Isagur geschafft!\nGewonnen!");
		} else {
			System.out.println("Game Over");
		}
	}

	public static void klassenwahl() {

		System.out.print("Bitte wähle einen Namen: ");
		String name = in.nextLine();

		System.out.println("\nBitte wähle eine Klasse:");
		System.out.println("1: Zauberer\n2: Krieger\n3: Schütze\n");
		System.out.print("Auswahl: ");

		int auswahl = in.nextInt();
		in.nextLine();

		switch (auswahl) {
		case 1:
			Spieler1 = new Held(name, Held.Klassen.Zauberer);
			break;
		case 2:
			Spieler1 = new Held(name, Held.Klassen.Krieger);
			break;
		case 3:
			Spieler1 = new Held(name, Held.Klassen.Schuetze);
			break;
		default:
			klassenwahl();
			break;
		}
	}

	public static void monsterAngriff() {
		Random r = new Random();
		int anzahlMonster = wuerfeln(1, 4);

		System.out.println("--- Auf deinem Weg greifen dich " + anzahlMonster
				+ " Monster an!");

		int lebenMonster = Math.round((Spieler1.getLebenspunkte() * 0.75F)
				/ anzahlMonster);

		Monster[] Gegner = new Monster[anzahlMonster];

		for (int i = 0; i < anzahlMonster; i++) {
			Monster.Monsterarten art = Monster.Monsterarten.values()[r
					.nextInt(Monster.Monsterarten.values().length)];
			Gegner[i] = new Monster(art, lebenMonster);
		}

		boolean kampf = true;

		while (kampf) {
			kampf = false;

			for (Monster aktuellerGegner : Gegner) {
				if (aktuellerGegner.getLebenspunkte() > 0
						&& Spieler1.getLebenspunkte() > 0) {

					System.out
							.println(Spieler1.angriffMonster(aktuellerGegner));

					if (aktuellerGegner.getLebenspunkte() > 0
							&& Spieler1.getLebenspunkte() > 0)
						kampf = true;
					if (Spieler1.getLebenspunkte() <= 0)
						kampf = false;
				}
			}
			System.out.println("- Runde zu Ende -");
			System.out.println("LP: " + Spieler1.getLebenspunkte() + " | EP: "
					+ Spieler1.getErfahrung());
			in.nextLine();
		}
	}

	public static int wuerfeln(int count, int wuerfel) {
		Random r = new Random();
		int wert = 0;

		for (int i = 0; i < count; i++) {
			wert += r.nextInt(wuerfel) + 1;
		}

		return wert;
	}
}
