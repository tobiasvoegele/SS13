import java.util.Random;

class Held {
	// Eigenschaften des Helden:
	private String Name;
	private Klassen Klasse;
	private int Erfahrungspunkte;
	private int Lebenspunkte;
	private int Stufe;

	public enum Klassen {
		Zauberer, Krieger, Schuetze
	}

	Held(String name, Klassen klasse) {
		// Konstruktor der Klasse
		Name = name;
		Klasse = klasse;
		Erfahrungspunkte = 0;
		Lebenspunkte = 100;
		Stufe = 1;
	}

	public int getLebenspunkte() {
		// gibt die Lebenspunkte des Helden wieder
		return Lebenspunkte;
	}

	public int getErfahrung() {
		// gibt die Erfahrungspunkte des Helden wieder
		return Erfahrungspunkte;
	}

	public Klassen getKlasse() {
		// gibt die Klasse des Helden zurück
		return Klasse;
	}

	public String getName() {
		// gibt den Namen des Spielers zurück
		return Name;
	}

	public String angriffMonster(Monster gegner) {
		// Hier soll der Angriff AUF ein Monster stattfinden, sowie dessen
		// Konter und
		// ist die wichtigste. Dabei wird das Monster übergeben und hier
		// entscheidet
		// sich, ob der Spieler weiterlebt und Erfahrung erhält oder stirbt.
		// Das Ergebnis wird in Textform zurückgegeben.

		int wuerfel = (Stufe / 10) + 1;
		// TODO Seitenberechnung für Angriff implementieren.
		int seiten = 6;

		int schaden = wuerfeln(wuerfel, seiten);

		int erfahrungspunkte = gegner.createSchaden(berechneSchaden(schaden,
				gegner));

		if (erfahrungspunkte == 0) {
			int eigenerSchaden = gegner.getKonter(Stufe);

			Lebenspunkte -= eigenerSchaden;

			if (Lebenspunkte > 0) {
				/*
				 * return "Du hast " + schaden +
				 * " Schaden dem Monster zugefügt und selbst " + eigenerSchaden
				 * + " Schaden erlitten.";
				 */
				return "Du hast " + schaden + " Schaden dem/der "
						+ gegner.getArt() + " zugefügt und selbst "
						+ eigenerSchaden + " Schaden erlitten.";
			} else {
				return "Du bist tot.";
			}
		} else {
			Erfahrungspunkte += erfahrungspunkte;

			/*
			 * return "Du hast das Monster mit " + schaden +
			 * " Schaden niedergestreckt und erhälst " + erfahrungspunkte +
			 * " Erfahrungspunkte.";
			 */
			return "Du hast den/die " + gegner.getArt() + " mit " + schaden
					+ " Schaden niedergestreckt und erhälst "
					+ erfahrungspunkte + " Erfahrungspunkte.";

		}

	}

	// TODO ungeil, muss optimiert werden
	public int berechneSchaden(int schaden, Monster gegner) {
		switch (gegner.getArt()) {
		case Goblin:
			switch (Klasse) {
			case Zauberer:
				return Math.round(schaden * 0.5F);
			case Krieger:
				return schaden;
			case Schuetze:
				return schaden;
			}
			break;
		case Zombie:
			switch (Klasse) {
			case Zauberer:
				return schaden;
			case Krieger:
				return Math.round(schaden * 0.5F);
			case Schuetze:
				return Math.round(schaden * 0.75F);
			}
			break;
		case Skelett:
			switch (Klasse) {
			case Zauberer:
				return schaden;
			case Krieger:
				return Math.round(schaden * 0.75F);
			case Schuetze:
				return Math.round(schaden * 0.5F);
			}
			break;
		case Harpyie:
			switch (Klasse) {
			case Zauberer:
				return Math.round(schaden * 0.75F);
			case Krieger:
				return Math.round(schaden * 0.5F);
			case Schuetze:
				return schaden;
			}
			break;
		case Ork:
			switch (Klasse) {
			case Zauberer:
				return Math.round(schaden * 0.5F);
			case Krieger:
				return schaden;
			case Schuetze:
				return Math.round(schaden * 0.75F);
			}
			break;
		case Troll:
			switch (Klasse) {
			case Zauberer:
				return Math.round(schaden * 0.75F);
			case Krieger:
				return Math.round(schaden * 0.75F);
			case Schuetze:
				return Math.round(schaden * 0.5F);
			}
			break;
		}
		return schaden;
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