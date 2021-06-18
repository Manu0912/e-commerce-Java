package types_users;

import java.io.Serializable;

public abstract class Users implements Serializable{
	private int id;
	private	String Name;
	private String LastName;
	private String Password;
	private	String Email;

	
	public Users() {
		
	}
	
	public Users(String name, String lastName, String password, String email) {
		id = generateRandomId();
		Name = name;
		LastName = lastName;
		Password = password;
		Email = email;
	}
	
	// GETTERS
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getLastName() {
		return LastName;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public String getEmail() {
		return Email;
	} 
	
	// SETTERS

	public void setName(String name) {
		Name = name;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
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
		return "Nombre de usuario: " + getName() + "\tApellido: " + getLastName() + "\nEmail: " + getEmail() + "\t";
	}
	
	public int generateRandomId() // hacer bien la funcion
	{
		float id = (float) Math.random() * 10;
		int id1 = (int) id;
		
		return id1;
	}
	
}











