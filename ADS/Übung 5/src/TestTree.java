public class TestTree {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Tree a = binTree('a', null, null);
        Tree e = binTree('e', null, null);
        Tree b = binTree('b', null, null);
        Tree c = binTree('c', a, b);
        Tree g = binTree('g', null, null);
        Tree f = binTree('f', e, g);
        Tree d = binTree('d', c, f);


        System.out.println("Höhe: " + d.height());
        System.out.println(d.printAsciiArt());
        System.out.print("InOrder: ");
        d.inOrder();
        System.out.println();
        System.out.print("PreOrder: ");
        d.preOrder();
        System.out.println();
        System.out.print("PostOrder: ");
        d.postOrder();
        System.out.println();
        System.out.print("LevelOrder: ");
        d.levelOrder();
        System.out.println("\n");
        System.out.print("Anzahl Elemente im Baum: ");
        System.out.println(d.count());
        System.out.println();
        System.out.print("Kleinstes Element im Baum: ");
        System.out.println(d.minValue());
        System.out.println();
        System.out.print("Ist Zeichen c im Baum enthalten? : ");
        System.out.println(d.isElement() ? "Ja" : "Nein");
        System.out.println();
    }

    static Tree binTree(char value, Tree left, Tree right) {
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
