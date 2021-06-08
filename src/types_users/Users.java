package types_users;

public class Users {
private String id;
private	String Name;
private String	LastName;
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

}
