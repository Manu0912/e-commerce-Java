package types_users;

import java.util.ArrayList;
import java.util.Date;

import Instruments.Cart;
import Instruments.CreditCard;
import List.Orders;
import Order.Order;
import Products.Products;

public class Client extends Users {
	private String City;
	private String Address;
	private CreditCard card;
	private Cart cart;
	private Orders orders;

	public Client() {

	}

	public Client(String UserName, String name_lastName, String password, String email) {
		super(UserName, name_lastName, password, email);
	}

	public Client(String UserName, String name_lastName, String password, String email, String city, String address) {
		super(UserName, name_lastName, password, email);
		City = city;
		Address = address;
		card = new CreditCard();
		cart = new Cart();
		orders = new Orders();
	}

	// METHODS

	@Override
	public String toString() {
		return super.toString() + "Ciudad: " + getCity() + "\nDireccion: " + getAddress() + "\tTarjeta de credito: "
				+ getCard().getNumber();
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
	public void enterCard(String name, String number, String dueDate, int segurityCode, float balance) {
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
	public void addToCart(Products product) {
		cart.add(product);
	}

	/**
	 * 
	 * @param product
	 * @apiNote remove product from cart
	 */
	public void removeFromCart(Products product) {
		cart.remove(product);
	}

	/**
	 * @apiNote Verifies if the user has a credit card and if have a balance. If so,
	 *          subtract the final price from the balance
	 * @return
	 */
	public String buy() {
		StringBuilder builder = new StringBuilder();
		float total = cart.calculateSubTotal();
		Order order;
 
		if (card.getBalance() == -1) {
			builder.append("Debe agregar una tarjeta de credito");
			cart.setTotal(0);
		} else if (card.getBalance() < total) {
			builder.append("No tiene saldo suficiente");
			cart.setTotal(0);
		} else {
			order = new Order();
			order.setEmail(super.getEmail());
			order.addProducts(cart);
			orders.addOrder(order);
			total = cart.buy();
			card.setBalance(card.getBalance() - total / 2);
			cart.setTotal(0);
			builder.append("Se realizo la compra por: $" + total / 2);
		}

		return builder.toString();
	}

	// GETTERS

	public String getCity() {
		return City;
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

	public Orders getOrders() {
		return orders;
	}

	// SETTERS

	public void setCity(String city) {
		City = city;
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

	public void setOrders(Orders _orders) {
		orders = _orders;
	}

}
