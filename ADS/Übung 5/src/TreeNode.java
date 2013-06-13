/**
 * Max Jando - 1312825
 * Patrick Fruh - 1314278
 * Klasse welche, einen TreeNode speichern kann
 */
public class TreeNode {

    char value;
    public TreeNode right;
    public TreeNode left;

    //Konstruktor mit 3 Parametern
    TreeNode(char v, TreeNode r, TreeNode l) {
        // Konstruktor
        value = v;
        right = r;
        left = l;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
