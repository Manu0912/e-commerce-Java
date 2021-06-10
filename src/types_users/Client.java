package types_users;

import java.util.ArrayList;

public class Client extends Users{
	private String	City;
	private String State;
	private String	Address;
	//private ArrayList<Orders> orders;
	
	public Client()
	{
		
	}
	
	
	public Client(String id, String name, String lastName, String password, String email) {
		super(id, name, lastName, password, email);
	}



	public Client(String id, String name, String lastName, String password, String email, String city, String state, String address) {
		super(id, name, lastName, password, email);
		City = city;
		State = state;
		Address = address;
		//Orders = orders;
	}

}
