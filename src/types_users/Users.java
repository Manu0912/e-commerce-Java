package types_users;

public abstract class Users {
	private String id;
	private	String Name;
	private String LastName;
	private String Password;
	private	String Email;



	public Users() {
	}
	
	public Users(String id, String name, String lastName, String password, String email) {
		this.id = id;
		Name = name;
		LastName = lastName;
		Password = password;
		Email = email;
	}
	
	// GETTERS
	
	public String getId() {
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
		return "Users [getId()=" + getId() + ", getName()=" + getName() + ", getLastName()=" + getLastName()
				+ ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail() + "]";
	}
	

}











