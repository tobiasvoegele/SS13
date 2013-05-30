/**
 * Max Jando 1312825 - Patrick Fruh 1314827
 * Klasse List: Speichert Referenzen der Klasse Employee.
 * "root" dient hier als Wurzelelement der Liste
 */ 


import java.text.SimpleDateFormat;

public class List {

    //Lokale Variablen Deklaration
    private Employee root;
	
	//Konstruktor
	List() {
		root = null;
	}



	public Employee getFirst() {
	/**
	 * Methode liefert die Referenz auf das erste Element in der Liste
	 */
		return root;
	}

	public Employee getLast() {
	/**
	 * Methode liefert die Referenz auf das letzte Element in der Liste
	 * Das letzte Element ist ereicht wenn das nächste Element (nextEmployee "null" ist)
	 */
		Employee temp = root;
		if (temp != null) {
			//Schleife durchläuft die Employees.
			while (temp.nextEmployee != null) {
				temp = temp.nextEmployee;
			}
		}
		return temp;
	}

	public void addFirst(int id, String firstName, String lastName,
			SimpleDateFormat birthday, String position){
		 /**
		 * Methode fügt an der ersten Stelle der Liste einen Employee hinzu
		 */
		root = new Employee(id, firstName, lastName, birthday, position, root);
	}

	public void addLast(int id, String firstName, String lastName,
			SimpleDateFormat birthday, String position) {
	         /**
		 * Methode fügt an der letzten Stelle der Liste einen Employee hinzu
		 */
		if (root != null) {
			Employee temp = root;
			//Schleife durchläuft die Employees.
			while (temp.nextEmployee != null) {
				temp = temp.nextEmployee;
			}
			//Bei next.Employee == null wurde das Ende erreicht 
			//und ein neuer Employee wird hinzugefügt
			temp.nextEmployee = new Employee(id, firstName, lastName, birthday,
					position);
		} else {
			//Im Falle von root==null wird addFirst, da in diesem Fall die Liste leer ist
			addFirst(id, firstName, lastName, birthday, position);
		}
	}

	public void removeFirst() {
		/**
		 * Methode löscht das erste Element der Liste, 
		 * indem root auf das nächste Element gesetzt wird.
		 * Somit hat das "alte root" keine Referenz mehr und der
		 * Garbage Collector wird aktiv! :-)
		 */
		if (root != null) {
			root = root.nextEmployee;
		}
	}

	public void removeLast() {
		/**
		 * Methode löscht das letzte Element der Liste
		 */
		if (root != null) {
			Employee temp = root;
			if (temp.nextEmployee != null) {
				//Schleife durchläuft die Employees
				while (temp.nextEmployee.nextEmployee != null) {
					temp = temp.nextEmployee;
				}
				//Wenn das letzte Element ereicht ist wird null gesetzt 
				temp.nextEmployee = null;
			} else {
				//Ist das letzte Element das erste Element, wird root auf null gesetzt 
				root = null;
			}
		}
	}

	public void concat(List liste2) {
		/**
		 * Methode um 2 Listen zusammenzufuegen
		 */
		if (root != null) {
			Employee temp = root;
			/*Schleife durchläuft die Employees,
			solange bis das letzte Element ereicht ist,
			dann wird das root Element von Liste2 an das Ende
			von Liste 1 angehängt. Somit werden beide verkettet
			*/
			while (temp.nextEmployee != null) {
				temp = temp.nextEmployee;
			}
			temp.nextEmployee = liste2.root;
		} else {
		// Wenn liste1 leer ist ist erstes Element von liste1 
		// gleich erstes Element von liste2
			root = liste2.root;
		}
	}

	public boolean isEmpty() {
	/**
	 * Methode die überprüft ob Liste leer ist
	 */
		return (root == null);
	}

	public int getLength() {
	/**
	* Methode die überprüft ob Liste leer ist
	*/
		int count = 0;
		if (root != null) {
			Employee temp = root;
			//Schleife durchläuft die Employees.
			//Count zählt Einträge
			while (temp != null) {
				count++;
				temp = temp.nextEmployee;
			}
		}

		return count;
	}

	@Override
	public String toString() {
	/**
	* toStirng() Methode überschrieben um die Ausgabe der Liste zu vereinfachen
	*/
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
	/**
	* Such-Methode welche überprüft ob gesuchte ID
	* in der Liste vorhanden ist. Ob die gesuchte ID wirklich die gleiche ist
	* wie die in der Liste ist, prüft die Methode .equalsID
	*/
		if (root != null) {
			Employee temp = root;
			//Schleife durchläuft die Employees
			while (temp != null) {
				if (temp.equalsID(id))
					return temp;
				temp = temp.nextEmployee;
			}
		}
		return null;
	}

	public Employee searchLastName(String lastname) {
	/**
	* Such-Methode welche überprüft ob gesuchter Name
	* in der Liste vorhanden ist. Ob der gesuchte Name wirklich der gleiche ist
	* wie der in der Liste ist, prüft die Methode .equalsName
	*/
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
