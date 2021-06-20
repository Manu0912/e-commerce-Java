package types_users;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import Files.UserUtiles;

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
	
	/*public int generateRandomId()
	{
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		boolean flag = true;
		float id = 0;
		int idINT = 0;
		
		while(it.hasNext() || flag == true)
		{
			Entry<Integer, Users> entry = it.next();
			id = (float) Math.random() * 1000000;
			idINT = (int) id;
			
			if(entry.getKey() == idINT) flag = true;
			else flag = false;
		}
		return idINT;
	}*/
	
	public int generateRandomId()
	{

		float id = 0;
		int idINT = 0;

		id = (float) Math.random() * 1000000;
		idINT = (int) id;

		return idINT;
	}
	
}











