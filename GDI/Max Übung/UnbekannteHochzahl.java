import java.util.Scanner;


public class UnbekannteHochzahl {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        double zahl;
        double basis;
        double exponent = 0.0;

        //Programmstart
        ausgabeHauptprogramm();
        zahl = in.nextLong();
        basis = in.nextLong();
        exponent = berechneHochzahl(zahl, basis);
        System.out.println(exponent);
    }

    private static double berechneHochzahl(double zahl, double basis) {
        return (Math.log(zahl) / Math.log(basis));
    }

    private static void ausgabeHauptprogramm() {
        System.out.println("Programm zum Ausgeben der unbekannten Hochzahl, bei bekannter Basis und Zahl.");
        System.out.println("Bitte geben Sie eine ganze Zahl ein: ");
        System.out.println("Bitte geben Sie eine ganze Basis ein: ");
    }
}
