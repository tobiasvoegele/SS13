/**
 * Max Jando - 1312825
 * Patrick Fruh - 1314278
 * Klasse welche, eine Liste speichern und verwalten kann
 */

import java.text.SimpleDateFormat;

public class List {
    private ListElement root;

    //Konstruktor ohne Parameter
    List() {
        root = null;
    }

    /**
     * Methode, welche ein das letzte Element der Liste zurückliefert
     */
    public ListElement getLast() {
        ListElement temp = root;
        if (temp != null) {
            //Schleife durchläuft solange bis nächstes ListenElement null ist
            while (temp.next != null) {
                temp = temp.next;
            }
        }
        // temp ist nun letztes Element
        return temp;
    }

    /**
     * Methode, welche vorne an der Liste ein Element hinzufügt
     */
    public void addFirst(TreeNode node) {
        root = new ListElement(node, root);
    }

    /**
     * Methode, welche das letzte Element der Liste löscht
     */
    public void removeLast() {
        if (root != null) {
            ListElement temp = root;
            if (temp.next != null) {
                //Schleife durchläuft solange bis übernächstes ListenElement null ist
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                //Dann nächster auf null setzen
                temp.next = null;
            } else {
                root = null;
            }
        }
    }

    /**
     * Methode, welche prüft ob Liste leer ist
     */
    public boolean isEmpty() {
        return (root == null);
    }
}
