/**
 * Max Jando - 1312825
 * Patrick Fruh - 1314278
 * Klasse welche, einen ListElement speichern kann
 */
public class ListElement {

    ListElement next;
    TreeNode value;

    //Konstruktor mit 2 Parametern
    ListElement(TreeNode value, ListElement next) {
        this.next = next;
        this.value = value;
    }

}
