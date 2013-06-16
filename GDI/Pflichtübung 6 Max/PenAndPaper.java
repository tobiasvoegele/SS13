import java.util.Scanner;
import java.util.Random;

class PenAndPaper {


    public static Scanner in = new Scanner(System.in);
    public static Held Spieler1;

    public static void main(String[] args) {
        //Lokale Variablen Deklaration
        byte anzahlBegegnungen;

        klassenwahl();
        ausgabeGeschichte();
        fuehreKaempfeAus(würfeln(1, 4));
        storyEnde(Spieler1);

    }

    private static void storyEnde(Held spieler1) {
        if (Spieler1.getLebenspunkte() > 0) {
            System.out.println("Du bist sicher in Bree im Gasthaus zum tänzelnden Ponny angekommen!");
            System.out.println("Doch wo ist Gandalf??");
            System.out.println("Du hast gewonnen");
        } else {
            System.out.println("Leider waren die Scharen des dunklen Herrschers Sauron stärker!");
            System.out.println("Sauron wird über alles Leben auf dieser Welt herrschen! Auch über das Ende der Welt!");
            System.out.println("Du hast verloren");
        }
    }

    private static void fuehreKaempfeAus(int anzahlBegegnungen) {
        int anzahlMonster = 0;
        boolean monsterTot = false;
        while (Spieler1.getLebenspunkte() > 0 && anzahlBegegnungen > 0) {
            anzahlMonster = würfeln(1, 4);
            Monster[] monsterListe = generiereMonster(berechneArt(würfeln(1, 6)), berechneMonsterPunkte(anzahlMonster), anzahlMonster);
            int monsterZaehler = 0;
            while (monsterZaehler < monsterListe.length && Spieler1.getLebenspunkte() > 0) {
                monsterTot = false;
                System.out.println("---------------------");
                System.out.println("Gebt acht, aus dem grauen Zwiellicht, greift dich die Monsterart " + monsterListe[monsterZaehler].getArt() + " an ");
                System.out.println("Haltet eure Stellung! Kääämpft!");
                while (!monsterTot && Spieler1.getLebenspunkte() > 0) {
                    System.out.println(Spieler1.angriffMonster(monsterListe[monsterZaehler]));
                    if (monsterListe[monsterZaehler].getLebenspunkte() <= 0) {
                        monsterTot = true;
                    }
                }
                System.out.println("---------------------");
                System.out.println();
                monsterZaehler++;
            }
            anzahlBegegnungen--;
        }
    }

    private static Monster[] generiereMonster(Monster.Monsterarten monsterarten, int monsterPunkte, int anzahlMonster) {
        Monster[] monsterListe = new Monster[anzahlMonster];
        for (int monsterZaehler = 0; monsterZaehler < monsterListe.length; monsterZaehler++) {
            monsterListe[monsterZaehler] = new Monster(monsterarten, monsterPunkte);
        }
        return monsterListe;
    }

    private static int berechneMonsterPunkte(int anzahlMonster) {
        return (int) (Math.round((Spieler1.getLebenspunkte() * 0.75F) / anzahlMonster));
    }

    private static Monster.Monsterarten berechneArt(int würfeln) {
        Monster.Monsterarten art;
        switch (würfeln) {
            case 1:
                art = Monster.Monsterarten.Goblin;
                break;
            case 2:
                art = Monster.Monsterarten.Zombie;
                break;
            case 3:
                art = Monster.Monsterarten.Skelett;
                break;
            case 4:
                art = Monster.Monsterarten.Harpyie;
                break;
            case 5:
                art = Monster.Monsterarten.Ork;
                break;
            case 6:
                art = Monster.Monsterarten.Troll;
                break;
            default:
                art = Monster.Monsterarten.Goblin;
        }
        return art;
    }

    private static int würfeln(int anzahlWuerfel, int augen) {
        int ergebnis = 0;
        for (int wuerfel = 1; wuerfel <= anzahlWuerfel; wuerfel++) {
            ergebnis += (int) (Math.random() * augen + 1);
        }
        return ergebnis;
    }

    private static void ausgabeGeschichte() {
        System.out.println("\n\n\n");
        System.out.println(Spieler1.getName()+", dir wurde eine sehr wichtige Aufgabe übertragen.");
        System.out.println("Du sollst den einen Ring nach Bree zum Gasthaus zum tänzelnden Pony bringen.");
        System.out.println("Doch vorsicht der Weg ist lang und es lauern viele Gefahren");
        System.out.println("Nun mach dich auf den Weg!");
    }

    public static void klassenwahl() {

        String eingabeString = "";
        int eingabe = 0;
        boolean check = false;
        String name;
        System.out.println("Willkommen zum Der Herr der Ringe-Rollenspiel");
        System.out.println("Bitte geben Sie als erstes einen Namen für Ihren Helden ein:");
        name = in.nextLine();
        System.out.println("Seid gegrüßt " + name + "! Bitte wählen als nächstes eine Klasse aus");
        System.out.println("Durch Eingabe einer Zahl können Sie eine Klasse wählen");
        System.out.println("1. Zauberer");
        System.out.println("2. Krieger");
        System.out.println("3. Schuetze");
        do {
            eingabeString = in.next();
            if (eingabeString.matches("1|2|3")) {
                check = true;
            } else {
                System.out.println("Keine gültige Eingabe. Bitte wiederholen Sie Ihre Eingabe");
            }
        } while (!check);
        eingabe = Integer.parseInt(eingabeString);

        switch (eingabe) {
            case 1:
                Spieler1 = new Held(name, Held.Klassen.Zauberer);
                break;
            case 2:
                Spieler1 = new Held(name, Held.Klassen.Krieger);
                break;
            case 3:
                Spieler1 = new Held(name, Held.Klassen.Schuetze);
                break;
        }
    }

}