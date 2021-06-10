package types_users;

import java.util.ArrayList;
import java.util.Date;

import Instruments.Cart;
import Instruments.CreditCard;
import List.Orders;
import Products.Products;

public abstract class Users {
	private String id;
	private	String Name;
	private String LastName;
	private String Password;
	private	String Email;
	private CreditCard card;
	private Cart cart;
	private ArrayList<Orders> orders;
	

	public Users() {
		
	}
	
	public Users(String name, String lastName, String password, String email) {
		//this.id ; hay que hacer un generador de id
		Name = name;
		LastName = lastName;
		Password = password;
		Email = email;
		card = new CreditCard();
		cart = new Cart();
		orders = new ArrayList<Orders>();
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











