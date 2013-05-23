import java.lang.String;import java.text.*;import java.text.SimpleDateFormat;

public class Employee {

    private long id;
    private String firstname;
    private String lastname;
    private SimpleDateFormat birthday;
    private String position;
    public Employee nextEmployee;

    public String toString() {
        return "Employee [id="+id+", firstname="+firstname+", lastname="+lastname+", birthday="+birthday.toLocalizedPattern()+", position="+position+"]";
    }

    public Employee(long id, String firstname, String lastname,
                    SimpleDateFormat birthday, String position, Employee nextEmployee) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.position = position;
        this.nextEmployee = nextEmployee;
    }

	/**/

}
