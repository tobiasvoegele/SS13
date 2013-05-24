import java.text.*;

public class List {

    public static Employee root;

    List() {
        root = null;
    }

    public static boolean isEmpty() {
        return (root == null);
    }

    public static void addFirst(Long id, String firstname, String lastname,
                                SimpleDateFormat birthday, String position) {

        root = new Employee(id, firstname, lastname, birthday, position, root);

    }

    public void addLast(Long id, String firstname, String lastname,
                        SimpleDateFormat birthday, String position) {
        boolean istEnde = false;
        if (root != null) {
            Employee employee = root;
            while (employee.nextEmployee != null) {
                employee = employee.nextEmployee;
            }
            employee.nextEmployee = new Employee(id, firstname, lastname, birthday, position, null);
        } else {
            addFirst(id, firstname, lastname, birthday, position);
        }

    }

    public static Employee getFirst() {
        return root;
    }

    public static Employee getLast() {
        Employee employee = root;
        if (employee != null) {
            while (employee.nextEmployee != null) {
                employee = employee.nextEmployee;
            }
        }
        return employee;
    }

    public static void removeFirst() {
        if (root != null) {
            root = root.nextEmployee;
        }
    }

    public static void removeLast() {
        if (root != null) {
            Employee employee = root;
            if (employee.nextEmployee != null) {
                while (employee.nextEmployee.nextEmployee != null) {
                    employee = employee.nextEmployee;
                }
                employee.nextEmployee = null;
            } else {
                root = null;
            }
        }
    }

    public void concat(List list2) {
        Employee employee = root;
        System.out.println("START: " + employee);
        while (employee.nextEmployee != null) {
            employee = employee.nextEmployee;
        }
        employee.nextEmployee = list2.getFirst();
        /*System.out.println("CHECK1: "+employee);
        System.out.println("CHECK2: "+employee.nextEmployee.nextEmployee);
        System.out.println("CHECK3: "+employee.nextEmployee.nextEmployee.nextEmployee);
        System.out.println("CHECK4: "+employee.nextEmployee.nextEmployee.nextEmployee.nextEmployee);
          */
    }


}
