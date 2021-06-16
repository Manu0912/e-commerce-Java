package types_users;

import java.util.ArrayList;
import java.util.Date;

import Instruments.Cart;
import Instruments.CreditCard;
import List.Orders;
import Products.Products;

public class Client extends Users{
	private String	City;
	private String State;
	private String	Address;
	private CreditCard card;
	private Cart cart;
	private ArrayList<Orders> orders;
	
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
	
	// GETTERS
	
	public String getCity() {
		return City;
	}


	public String getState() {
		return State;
	}


	public String getAddress() {
		return Address;
	}


	public CreditCard getCard() {
		return card;
	}


	public Cart getCart() {
		return cart;
	}


	public ArrayList<Orders> getOrders() {
		return orders;
	}
	
	// SETTERS
	
	public void setCity(String city) {
		City = city;
	}


	public void setState(String state) {
		State = state;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public void setCard(CreditCard card) {
		this.card = card;
	}


	public void setCart(Cart cart) {
		this.cart = cart;
	}


	public void setOrders(ArrayList<Orders> orders) {
		this.orders = orders;
	}


	// METHODS

		
	/**
	 * 
	 * @param name
	 * @param number
	 * @param dueDate
	 * @param segurityCode
	 * @apiNote It create a Credit Card
	 */
	@SuppressWarnings("deprecation")
	public void enterCard(String name, String number, String dueDate, int segurityCode, float balance)
	{
		Date date = new Date(); // 02/04/22
		date.setDate(dueDate.charAt(0) + dueDate.charAt(1));
		date.setMonth(dueDate.charAt(3) + dueDate.charAt(4));
		date.setYear(dueDate.charAt(6) + dueDate.charAt(7));
		
		this.card = new CreditCard(name, number, date, segurityCode, balance);
	}
	

	/**
	 * 
	 * @param product
	 * @param quantity
	 * @apiNote add product to cart
	 */
	public void addToCart(Products product, Integer quantity)
	{
		cart.add(product, quantity);
	}
	
	/**
	 * 
	 * @param product
	 * @apiNote remove product from cart
	 */
	public void removeFromCart(Products product)
	{
		cart.remove(product);
	}
	
	/**
	 * @apiNote Verifies if the user has a credit card and if have a balance. If so, subtract the final price from the balance
	 * @return
	 */
	public StringBuilder buy()
	{
		StringBuilder builder = new StringBuilder();
		float total = cart.calculateSubTotal();
		
		if(card.getBalance() == -1)
		{
			builder.append("Debe agregar una tarjeta de credito");
		}
		else if(card.getBalance() < total)
		{
			builder.append("No tiene saldo suficiente");
		}
		else
		{
			total = cart.buy();
			card.setBalance(card.getBalance() - total);
			builder.append("Se realizo la compra por: $" + total);
		}
		
		return builder;
	}

}
























