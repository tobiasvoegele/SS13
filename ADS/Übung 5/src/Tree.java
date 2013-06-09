public class Tree {

    TreeNode root = null;

    Tree() {

    }

    Tree(char value) {
        root = new TreeNode(value, null, null);
    }

    public int height() {
        return heightRek(root);
    }

    private int heightRek(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return Math
                    .max(1 + heightRek(node.left), 1 + heightRek(node.right));
        }
    }

    public boolean isElement() {
        return isElementRek(root);
    }

    private boolean isElementRek(TreeNode node) {
        if(node == null)
            return false;
        if(node.value == 'c')
            return true;
        else if(node.left!=null)
            return isElementRek(node.left);
        else
            return isElementRek(node.right);
    }


    public char minValue() {
        return minValueRek(root);
    }

    private char minValueRek(TreeNode node) {
        if (node.left == null) {
            return node.value;
        } else {
            return minValueRek(node.left);
        }
    }


    public int count() {
        return countRek(root);
    }

    private int countRek(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + countRek(node.left) + countRek(node.right);
        }
    }

    public void levelOrder() {
        List q = new List();
        q.addFirst(root);
        ListElement element;
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

    public void postOrder() {
        postOrderRek(root);
    }

    public void inOrder() {
        inOrderRek(root);
    }

    public void preOrder() {
        preOrderRek(root);
    }

    private void preOrderRek(TreeNode root) {
        System.out.print(root + " ");
        if (root.left != null) {
            preOrderRek(root.left);
        }
        if (root.right != null) {
            preOrderRek(root.right);
        }
    }

    private void postOrderRek(TreeNode root) {
        if (root.left != null) {
            postOrderRek(root.left);
        }
        if (root.right != null) {
            postOrderRek(root.right);
        }
        System.out.print(root + " ");
    }

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
