public class TreeNode {

    char value;
    public TreeNode right;
    public TreeNode left;

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
