import java.text.*;

public class List {
    private Employee root;

    List() {
        root = null;
    }

    public Employee getFirst() {
        return root;
    }

    public Employee getLast() {
        Employee temp = root;
        if (temp != null) {
            while (temp.nextEmployee != null) {
                temp = temp.nextEmployee;
            }
        }
        return temp;
    }

    public void addFirst(int id, String firstName, String lastName,
                         SimpleDateFormat birthday, String position) {
        root = new Employee(id, firstName, lastName, birthday, position, root);
    }

    public void addLast(int id, String firstName, String lastName,
                        SimpleDateFormat birthday, String position) {
        if (root != null) {
            Employee temp = root;
            while (temp.nextEmployee != null) {
                temp = temp.nextEmployee;
            }
            temp.nextEmployee = new Employee(id, firstName, lastName, birthday,
                    position);
        } else {
            addFirst(id, firstName, lastName, birthday, position);
        }
    }

    public void removeFirst() {
        if (root != null) {
            root = root.nextEmployee;
        }
    }

    public void removeLast() {
        if (root != null) {
            Employee temp = root;
            if (temp.nextEmployee != null) {
                while (temp.nextEmployee.nextEmployee != null) {
                    temp = temp.nextEmployee;
                }
                temp.nextEmployee = null;
            } else {
                root = null;
            }
        }
    }

    public void concat(List liste2) {
        if (root != null) {
            Employee temp = root;
            while (temp.nextEmployee != null) {
                temp = temp.nextEmployee;
            }
            temp.nextEmployee = liste2.root;
        } else {
            root = liste2.root;
        }
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int getLength() {
        int count = 0;

        if (root != null) {
            Employee temp = root;
            while (temp != null) {
                count++;
                temp = temp.nextEmployee;
            }
        }

        return count;
    }

    @Override
    public String toString() {
        String output = "";

        if (root != null) {
            Employee temp = root;
            while (temp != null) {
                output += temp + "\n";
                temp = temp.nextEmployee;
            }
        } else {
            output = null;
        }

        return output;
    }

    public Employee searchID(int id) {
        if (root != null) {
            Employee temp = root;
            while (temp != null) {
                if (temp.equalsID(id))
                    return temp;
                temp = temp.nextEmployee;
            }
        }
        return null;
    }

    public Employee searchLastName(String lastname) {
        if (root != null) {
            Employee temp = root;
            while (temp != null) {
                if (temp.equalsLastName(lastname))
                    return temp;
                temp = temp.nextEmployee;
            }
        }
        return null;
    }
}
