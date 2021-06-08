package types_users;

import java.util.ArrayList;

public class Client extends Users{
private String	City;
private String State;
private String	Address;
private boolean Cart;
private ArrayList	Orders;

public Client(String city, String state, String address, boolean cart, ArrayList orders) {
	super();
	City = city;
	State = state;
	Address = address;
	Cart = cart;
	Orders = orders;
}

}
