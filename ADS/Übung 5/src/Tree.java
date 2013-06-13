/**
 * Max Jando - 1312825
 * Patrick Fruh - 1314278
 * <p/>
 * Klasse welche, einen Tree speichern und verwalten kann
 */

public class Tree {

    TreeNode root = null;

    //Konstruktor ohne Parameter
    Tree() {

    }

    //Konstruktor mit Parameter value
    Tree(char value) {
        root = new TreeNode(value, null, null);
    }

    /**
     * Methode, welche eine Methode aufruft um ein Element im Baum hinzuzufügen
     */
    public void addElement(char value) {
        addElementRek(root, value);
    }

    /**
     * Methode, welche ein neues Element zum Baum hinzufügt
     */
    private void addElementRek(TreeNode node, char value) {
        TreeNode add = new TreeNode(value, null, null);
        if (node == null) {
            root = add;
        } else if (value > node.value) {
            if (node.right != null) {
                addElementRek(node.right, value); //Rekursiver Aufruf
            } else {
                node.right = add;
            }
        } else if (value < node.value) {
            if (node.left != null) {
                addElementRek(node.left, value); //Rekursiver Aufruf
            } else {
                node.left = add;
            }
        } else {
            //Nichts machen
        }
    }

    /**
     * Methode, welche prüft ob Baum leer ist
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Methode, welche eine Methode aufruft um die Höhe eines Baumes zu bestimmen
     */
    public int height() {
        return heightRek(root);
    }

    /**
     * Methode, welche die Höhe eines Baumes zurückliefert
     */
    private int heightRek(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math
                    .max(1 + heightRek(node.left), 1 + heightRek(node.right)); // Rekursiver Aufruf
        }
    }

    /**
     * Methode, welche eine Methode aufruft um ein Element im Baunm zu löschen
     */
    public boolean delElement(char value) {
        return delElementRek(root, value);
    }

    /**
     * Methode, welche ein Element im Baum zu löscht
     */
    private boolean delElementRek(TreeNode node, char value) {
        TreeNode temp = node;
        if (temp == null) {
            return false;
        } else if (temp.value == value) {
            root = null;
            return true;
        } else if (value > temp.value) {
            if (temp.right != null) {
                if (temp.right.value == value) {
                    if (temp.right.left == null && temp.right.right == null) {
                        temp.right = null;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    delElementRek(temp.right, value); // Rekursiver Aufruf
                }
            }
        } else {
            if (temp.left != null) {
                if (temp.left.value == value) {
                    if (temp.left.left == null && temp.left.right == null) {
                        temp.left = null;
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    delElementRek(temp.left, value); //Rekursiver Aufruf
                }
            }
        }
        return false;
    }

    /**
     * Methode, welche eine Methode aufruft um zu prüfen ob ein bestimmtes Element im Baun ist
     */
    public boolean isElement() {
        return isElementRek(root);
    }

    /**
     * Methode, welche prüft ob ein bestimmtes Element im Baun ist
     * Beide Teilbäume werden durchlaufen. Bei einem Match wird true geliefert
     */
    private boolean isElementRek(TreeNode node) {
        if (node == null)
            return false;
        if (node.value == 'c')
            return true;
        else if (node.left != null)
            return isElementRek(node.left);//Rekursiver Aufruf
        else
            return isElementRek(node.right);//Rekursiver Aufruf
    }

    /**
     * Methode, welche eine Methode aufruft um zu prüfen was der kleinste Wert im Baum ist
     */
    public char minValue() {
        return minValueRek(root);
    }

    /**
     * Methode, welche prüft was der kleinste Wert im Baum ist.
     * So lange links runter laufen bis nächstes linkes null ist, dann Wert gefunden
     */
    private char minValueRek(TreeNode node) {
        if (node.left == null) {
            return node.value;
        } else {
            return minValueRek(node.left); //Rekursiver Aufruf
        }
    }

    /**
     * Methode, welche eine Methode aufruft um die Anzahl der Elemente im Baum zu zählen
     */
    public int count() {
        return countRek(root);
    }

    /**
     * Methode, welche die Anzahl der Elemente im Baum zu zählt
     * Durchlaufe beide Teilbäume, bei einem Match +1, ansonsten 0
     * Wichtig!!! Nicht hinter beiden rekursiven Aufrufen +1 machen, da man sonst doppelt zählt
     */
    private int countRek(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + countRek(node.left) + countRek(node.right); //Rekursiver Aufruf
        }
    }

    /**
     * Methode, welche die Elemente nach der LevelOrder ausgibt
     * Es existiert leider kein gescheiter Weg das rekursiv zu lösen
     * Dazu brauchen wir eine Liste und ein Listen Element.
     * 1. Speicher Wurzel in Liste (erstes Element)
     * 2. Speicher letztes Element der Liste in Listen Element
     * 3. Entferne das letzte Element der Liste
     * 4. Gebe das monetane Element aus
     * 5. Füge zur Liste den linken und den rechten Knoten von List Element hinzu
     * 6. Gehe zu Schritt 2
     */
    public void levelOrder() {
        List q = new List();
        q.addFirst(root);
        ListElement element;
        //Solange noch Elemente in der Liste sind
        while (!q.isEmpty()) {
            element = q.getLast();
            q.removeLast();
            System.out.print(element.value + " ");
            if (element.value.left != null)
                q.addFirst(element.value.left);
            if (element.value.right != null)
                q.addFirst(element.value.right);
        }
    }

    /**
     * Methode, welche eine Methode aufruft, welche die Elemente nach der postOrder ausgibt
     */
    public void postOrder() {
        postOrderRek(root);
    }

    /**
     * Methode, welche eine Methode aufruft, welche die Elemente nach der inOrder ausgibt
     */
    public void inOrder() {
        inOrderRek(root);
    }

    /**
     * Methode, welche eine Methode aufruft, welche die Elemente nach der preOrder ausgibt
     */
    public void preOrder() {
        preOrderRek(root);
    }

    /**
     * Methode, welche die Elemente nach der preOrder ausgibt
     * Erst Wurzel, dann linker Teilbaum, dann rechter Teilbaum
     */
    private void preOrderRek(TreeNode root) {
        System.out.print(root + " ");
        if (root.left != null) {
            preOrderRek(root.left);
        }
        if (root.right != null) {
            preOrderRek(root.right);
        }
    }

    /**
     * Methode, welche die Elemente nach der postOrder ausgibt
     * Erst linker Teilbaum, dann rechter Teilbaum, dann Wurzel
     */
    private void postOrderRek(TreeNode root) {
        if (root.left != null) {
            postOrderRek(root.left);
        }
        if (root.right != null) {
            postOrderRek(root.right);
        }
        System.out.print(root + " ");
    }

    /**
     * Methode, welche die Elemente nach der inOrder ausgibt
     * Erst linker Teilbaum, dann Wurzel, dann rechter Teilbaum
     */
    private void inOrderRek(TreeNode root) {
        if (root.left != null) {
            inOrderRek(root.left);
        }
        System.out.print(root + " ");
        if (root.right != null) {
            inOrderRek(root.right);
        }
    }


    public String printAsciiArt() {
        if (root == null) {
            return "empty";
        }
        // put tree in "binary-complete" array
        // in level order
        // nodes from ca[1] to ca[h^^2 - 1]
        int h = height();
        TreeNode ca[] = new TreeNode[pow2(h)];
        lin(root, 1, 0, ca);
        // use array to create String
        int be = 6; // width of element box; the box should be at last be
        // the length of the String returned by Node.toString
        // plus two (one space to the left and right each)
        int nelr = pow2(h - 1);
        // number of elements in lowest row
        int width = nelr * be;
        int nea; // number of elements in actual row
        int bea; // width of box of actual element
        String s = ""; // result string
        for (int i = 1; i <= h; i++) {
            nea = pow2(i - 1);
            bea = width / nea;
            for (int j = pow2(i - 1); j <= pow2(i) - 1; j++) {
                if (ca[j] == null) {
                    s += box("--", bea);
                } else {
                    s += box(ca[j].toString(), bea);
                }
            }
            s += "\n";
        }
        return s;
    }

    /**
     * puts binary tree into array in levelorder; complete tree is assumed
     * (every leave with the same height, missing nodes are substituted by null
     * nodes); nodes are used instead of the value type to be able to
     * differentiate between the value 0 and a missing node; recursive
     * implementation
     *
     * @param n        root of the tree -- not null
     * @param level    height of the tree
     * @param position relative position in the slice corresponding to the given
     *                 level (starting with 0)
     * @param a        array of nodes
     */
    void lin(TreeNode n, int level, int position, TreeNode a[]) {
        a[pow2(level - 1) + position] = n;
        if (n.left != null) {
            // start field is the one right to the current start field
            lin(n.left, level + 1, 2 * position, a);
        }
        if (n.right != null) {
            // start field is the one right to the current start field plus
            // the number of nodes in the left sister tree (start + 1 +
            // 2^^(h-1)-1)
            lin(n.right, level + 1, 2 * position + 1, a);
        }
    }

    /**
     * puts a value in a fixed-length string
     *
     * @param value    string value
     * @param boxWidth length of the string
     * @return string string value prolonged to length
     */
    String box(String value, int boxWidth) {
        String filler1 = makeFiller((boxWidth - value.length()) / 2);
        String filler2 = makeFiller(boxWidth - value.length()
                - filler1.length());

        return filler1 + value + filler2;
    }

    /**
     * creates a string of blanks with a given length
     *
     * @param length length of the string
     * @return string blank string of required length
     */
    String makeFiller(int width) {
        String s = "";
        while (width-- > 0) {
            s += " ";
        }
        return s;
    }

    /**
     * computes integer power of 2
     *
     * @param exponent
     * @return 2 to the power of exponent
     */
    int pow2(int a) {
        if (a == 0) {
            return 1;
        } else {
            return 2 * pow2(a - 1);
        }
    }
}
