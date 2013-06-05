import java.text.SimpleDateFormat;

public class List {
    private ListElement root;

    List() {
        root = null;
    }

    public ListElement getLast() {
        ListElement temp = root;
        if (temp != null) {
            while (temp.next != null) {
                temp = temp.next;
            }
        }
        return temp;
    }

    public void addFirst(TreeNode node) {
        root = new ListElement(node, root);
    }

    public void removeLast() {
        if (root != null) {
            ListElement temp = root;
            if (temp.next != null) {
                while (temp.next.next != null) {
                    temp = temp.next;
                }
                temp.next = null;
            } else {
                root = null;
            }
        }
    }

    public boolean isEmpty() {
        return (root == null);
    }
}
