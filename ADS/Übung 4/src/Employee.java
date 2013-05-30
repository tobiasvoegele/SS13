/**
 * Max Jando 1312825 - Patrick Fruh 1314827
 * Klasse Employee: Speichert einen Employee und verwaltet 
 * verschiedene Methoden um einen Employee zu suchen 
 */ 

import java.text.SimpleDateFormat;

public class Employee {


	//Lokale Variablen-Deklaration
	private int id;
	private String firstName;
	private String lastName;
	private SimpleDateFormat birthday;
	private String position;
	Employee nextEmployee = null; //Objektreferenz der Klasse Employee


	//Konstruktor
	Employee(int id, String firstName, String lastName,
			SimpleDateFormat birthday, String position, Employee nextEmployee) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.position = position;
		this.nextEmployee = nextEmployee;
	}

	//Konstruktor
	Employee(int id, String firstName, String lastName,
			SimpleDateFormat birthday, String position) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.position = position;
	}
	
	
	public boolean equalsID(int id) {
	/**
	 * Suchmethode, die bei übergebener ID-Variable true liefert
	 */
		return (this.id == id);
	}

	public boolean equalsLastName(String lastName) {
	/**
	 * Suchmethode, die bei übergebener LastName-Variable true liefert
	 */
		return this.lastName.equals(lastName);
	}

	@Override
	public String toString() {
		//toString Methode der Klasse Employee überschrieben um Ausgabe zu vereinfachen
		return "Employee [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", birthday="
				+ birthday.toLocalizedPattern() + ", position=" + position
				+ "]";
	}

}
