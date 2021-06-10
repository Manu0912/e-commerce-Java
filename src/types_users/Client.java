package types_users;


public class Client extends Users{
	private String	City;
	private String State;
	private String	Address;

	
	public Client()
	{
		
	}
	
	
	public Client(String name, String lastName, String password, String email) {
		super(name, lastName, password, email);
	}


	public Client(String name, String lastName, String password, String email, String city, String state, String address) {
		super(name, lastName, password, email);
		City = city;
		State = state;
		Address = address;
	}
	
	

}
























