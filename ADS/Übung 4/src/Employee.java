import java.text.SimpleDateFormat;

public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private SimpleDateFormat birthday;
	private String position;
	Employee nextEmployee = null;

	Employee(int id, String firstName, String lastName,
			SimpleDateFormat birthday, String position, Employee nextEmployee) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.position = position;
		this.nextEmployee = nextEmployee;
	}

	Employee(int id, String firstName, String lastName,
			SimpleDateFormat birthday, String position) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.position = position;
	}

	public boolean equalsID(int id) {
		return (this.id == id);
	}

	public boolean equalsLastName(String lastName) {
		return this.lastName.equals(lastName);
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthday="
				+ birthday.toLocalizedPattern() + ", position=" + position
				+ "]";
	}

}
