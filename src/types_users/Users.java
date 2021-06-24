package types_users;

import java.io.Serializable;

public abstract class Users implements Serializable {
	private int id;
	private String userName;
	private String name_lastName;
	private String Password;
	private String Email;

	public Users() {

	}

	public Users(String name, String lastName, String password, String email) {
		id = generateRandomId();
		userName = name;
		name_lastName = lastName;
		Password = password;
		Email = email;
	}

	// GETTERS

	public int getId() {
		return id;
	}

	public String getName() {
		return userName;
	}

	public String getName_lastName() {
		return name_lastName;
	}

	public String getPassword() {
		return Password;
	}

	public String getEmail() {
		return Email;
	}

	// SETTERS

	public void setName(String name) {
		userName = name;
	}

	public void setName_lastName(String lastName) {
		name_lastName = lastName;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setEmail(String email) {
		Email = email;
	}

	// METHODS

	@Override
	public String toString() {
		return "Nombre de usuario: " + getName() + "\tNombre y Apellido: " + getName_lastName() + "\nEmail: "
				+ getEmail() + "\t";
	}

	/**
	 * @apiNote generate random id
	 * @return a random id
	 */
	public int generateRandomId() {

		float id = 0;
		int idINT = 0;

		id = (float) Math.random() * 1000000;
		idINT = (int) id;

		return idINT;
	}

}
