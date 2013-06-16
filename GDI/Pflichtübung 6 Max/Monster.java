import java.util.Random;

class Monster {
    // Eigenschaften des Monsters:
    private Monsterarten Art;
    private int Lebenspunkte;
    private int Erfahrungspunkte;

    public enum Monsterarten {
        Goblin, Zombie, Skelett, Harpyie, Ork, Troll;
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

    public void setLebenspunkte(int wert) {
        if (this.getLebenspunkte() - wert > 0) {
            this.Lebenspunkte = getLebenspunkte() - wert;
        } else {
            this.Lebenspunkte = 0;
        }
    }

    public int createSchaden(int schaden) {
        this.setLebenspunkte(schaden);
        return this.Erfahrungspunkte;
    }

    public Monsterarten getArt() {
        // gibt die Art des Monsters zurück
        return Art;
    }

    public int getKonter(int stufe) {
        return berechneMonsterSchaden(stufe);
    }

    private int berechneMonsterSchaden(int stufe) {
        int heldenStufe = 1;
        int wuerfel = 6;
        int wuerfelAnzahl = 1;
        int rechner = 0;
        int verechnungsWert = 0;
        int obergrenze = 0;
        int schaden=0;
        boolean ende = false;
        while (!ende && heldenStufe < 1000) {
            obergrenze = heldenStufe + 2;
            verechnungsWert = 0;
            while (heldenStufe <= obergrenze && !ende) {
                while ((wuerfel * wuerfelAnzahl) < rechner) {
                   wuerfelAnzahl++;
                }
                if (stufe == heldenStufe) {
                    schaden = würfeln(wuerfelAnzahl, wuerfel);
                    ende = true;
                }
                verechnungsWert += 2;
                wuerfel += verechnungsWert;
                heldenStufe++;
            }
        }
        return schaden;
    }

    private int würfeln(int anzahlWuerfel, int augen) {
        int ergebnis = 0;
        for (int wuerfel = 1; wuerfel <= anzahlWuerfel; wuerfel++) {
            ergebnis += (int) (Math.random() * augen + 1);
        }
        return ergebnis;
    }
}