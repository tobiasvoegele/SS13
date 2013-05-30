/**
 * Max Jando 1312825 - Patrick Fruh 1314827
 * Klasse TestList: Hauptprogramm + Ausabe.
 */ 

import java.text.SimpleDateFormat;

public class TestList {

    public static void main(String[] args) {
		SimpleDateFormat birthdate = new SimpleDateFormat("19.11.1991");
		SimpleDateFormat birthdate2 = new SimpleDateFormat("23.09.1994");

		// Anlegen Liste 1 + Ausgabe
		List list1 = new List();
		list1.addFirst(4, "Patrick", "Fruh", birthdate, "Geschaeftsfuehrer");
		list1.addLast(5, "Max", "Jando", birthdate, "Arbeiter 1");
		list1.addLast(6, "Mayer", "Patrick", birthdate, "Arbeiter 2");
		list1.addLast(7, "Hek", "Vogt", birthdate2, "Arbeiter 3");
		list1.addFirst(3, "Hek", "Vogt", birthdate, "Arbeiter 3");
		outputInfos("list1", list1);

		// Anlegen Liste 2 + Ausgabe
		List list2 = new List();
		list2.addFirst(8, "Patrick", "Fruh", birthdate, "Geschaeftsfuehrer");
		list2.addLast(9, "Max", "Jando", birthdate, "Arbeiter 1");
		list2.addLast(10, "Mayer", "Patrick", birthdate, "Arbeiter 2");
		list2.addFirst(11, "Hek", "Vogt", birthdate2, "Arbeiter 3");
		list2.addFirst(12, "Hek", "Vogt", birthdate, "Arbeiter 3");
		outputInfos("list2", list2);

		// Liste 1 concat Liste 2 + Ausgabe
		list1.concat(list2);
		outputInfos("list1.concat(list2)", list1);

		// Anlegen Liste 3, Elemente entfernen + Ausgabe
		List list3 = new List();
		list3.addFirst(8, "Patrick", "Fruh", birthdate, "Geschaeftsfuehrer");
		list3.addLast(9, "Max", "Jando", birthdate2, "Arbeiter 1");
		list3.removeLast();
		list3.removeFirst();
		outputInfos("list3", list3);

		System.out.println("--- Suche ---");
		System.out.println("list2.searchID(12): " + list2.searchID(12));
		System.out.println("list1.searchLastName(\"Vogt\"): "
				+ list1.searchLastName("Vogt"));
		System.out.println("list2.searchID(1): " + list2.searchID(1));
		System.out.println("list2.searchLastName(\"Müller\"): "
				+ list2.searchLastName("Müller"));
	}

	public static void outputInfos(String name, List liste) {
		/**
		 * Methode, welche zur Vereinfachung den aktuellen Status von Methoden der Klasse
		 * , sowie den aktuellen Status der Listen ausgibt
		 */
		System.out.println("--- " + name + " ---");
		System.out.println(liste);
		System.out.println(name + ".getFirst: " + liste.getFirst());
		System.out.println(name + ".getLast: " + liste.getLast());
		System.out.println(name + ".getLength: " + liste.getLength());
		System.out.println(name + ".isEmpty: " + liste.isEmpty());
		System.out.println("\n");
	}

}
