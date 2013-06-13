public class TestTree {

    public static void main(String[] args) {

        //TestBäume anlegen
        Tree c = binTree('c', null, null);
        Tree b = binTree('b', null, c);
        Tree g = binTree('g', null, null);
        Tree h = binTree('h', g, null);
        Tree f = binTree('f', b, h);
        Tree r = binTree('r', null, null);
        Tree p = binTree('p', null, null);
        Tree l = binTree('l', null, null);
        Tree q = binTree('q', p, r);
        Tree o = binTree('o', l, q);
        Tree k = binTree('k', f, o);
        Tree leer = new Tree();
        Tree y = binTree('y', null, null);
        Tree z = binTree('z', y, null);

         //Hilfstext + Methoden ausgeben
        System.out.println("Höhe: " + k.height());
        System.out.println(k.printAsciiArt());
        System.out.print("InOrder: ");
        k.inOrder();
        System.out.println();
        System.out.print("PreOrder: ");
        k.preOrder();
        System.out.println();
        System.out.print("PostOrder: ");
        k.postOrder();
        System.out.println();
        System.out.print("LevelOrder: ");
        k.levelOrder();
        System.out.println("\n");
        System.out.print("Anzahl Elemente im Baum: ");
        System.out.println(k.count());
        System.out.println();
        System.out.print("Kleinstes Element im Baum: ");
        System.out.println(k.minValue());
        System.out.println();
        System.out.print("Ist Zeichen c im Baum enthalten? : ");
        System.out.println(k.isElement() ? "Ja" : "Nein");
        System.out.println();
        System.out.print("Leerer Baum: ");
        System.out.println(leer.isEmpty() ? "Ja" : "Nein");
        System.out.print("Zeichen b löschen: ");
        System.out.println(k.delElement('b') ? "Zeichen erfolgreich gelöscht" : "Zeichen konnte nicht gefunden werden oder ist kein Blatt");
        System.out.println(k.printAsciiArt());
        System.out.print("Zeichen c löschen: ");
        System.out.println(k.delElement('c') ? "Zeichen erfolgreich gelöscht" : "Zeichen konnte nicht gefunden werden oder ist kein Blatt");
        System.out.println(k.printAsciiArt());
        System.out.println(z.delElement('y') ? "Zeichen erfolgreich gelöscht" : "Zeichen konnte nicht gefunden werden oder ist kein Blatt");
        System.out.println(z.printAsciiArt());
        System.out.println(z.delElement('y') ? "Zeichen erfolgreich gelöscht" : "Zeichen konnte nicht gefunden werden oder ist kein Blatt");
        System.out.println(z.printAsciiArt());
        System.out.println(z.delElement('z') ? "Zeichen erfolgreich gelöscht" : "Zeichen konnte nicht gefunden werden oder ist kein Blatt");
        System.out.println(z.printAsciiArt());
        System.out.print("Zeichen a hinzufügen: ");
        k.addElement('a');
        System.out.println(k.printAsciiArt());
        System.out.println("Zeichen m und n hinzufügen: ");
        k.addElement('m');
        k.addElement('n');
        System.out.println(k.printAsciiArt());
    }

    /**
     * Methode liefert einen Tree zurück. Übergeben wird der Wert der
     * im Tree gespeichert werden soll und Knoten(Hierbei ein Baum) links und rechts.
     */
    public static Tree binTree(char value, Tree left, Tree right) {
        Tree t = new Tree(value);

        if (left != null) {
            t.root.left = left.root;
        } else {
            t.root.left = null;
        }

        if (right != null) {
            t.root.right = right.root;
        } else {
            t.root.right = null;
        }

        return t;
    }

}
