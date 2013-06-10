import java.util.Random;

class Monster {
	// Eigenschaften des Monsters:
	private Monsterarten Art;
	private int Lebenspunkte;
	private int Erfahrungspunkte;

	public enum Monsterarten {
		Goblin, Zombie, Skelett, Harpyie, Ork, Troll
	}

	Monster(Monsterarten art, int lebenspunkte) {
		// Konstruktor der Klasse, Erstellung des Monsters, Festlegung der
		// Erfahrungspunkte
		Art = art;
		Lebenspunkte = lebenspunkte;
		Erfahrungspunkte = 10;
	}

	public int getLebenspunkte() {
		// gibt die Lebenspunkte des Helden wieder
		return Lebenspunkte;
	}

	public int createSchaden(int schaden) {
		// richtet Schaden beim Monster an, und das Monster stirbt bei 0 und
		// gibt
		// Erfahrungspunkte != 0 zurück

		Lebenspunkte -= schaden;

		if (Lebenspunkte > 0) {
			return 0;
		} else {
			return Erfahrungspunkte;
		}
	}

	public Monsterarten getArt() {
		// gibt die Art des Monsters zurück
		return Art;
	}

	public int getKonter(int stufe) {
		// gibt den vom Monster verursachten Schaden anhand der
		// Stufe des Helden zurück

		// TODO Würfel- und Seitenberechnung für Konter implementieren.
		int wuerfel = 1;
		int seiten = 6;

		return wuerfeln(wuerfel, seiten);
	}

	public int wuerfeln(int count, int wuerfel) {
		Random r = new Random();
		int wert = 0;

		for (int i = 0; i < count; i++) {
			wert += r.nextInt(wuerfel) + 1;
		}

		return wert;
	}
}