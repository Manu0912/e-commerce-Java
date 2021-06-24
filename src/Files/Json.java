package Files;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Instruments.Cart;
import Instruments.CreditCard;
import List.Orders;
import Products.Clothing;
import Products.Estate;
import Products.HomeAppliances;
import Products.Products;
import Products.Vehicle;
import types_users.Client;
import types_users.Users;

public class Json {
	private final static String productsFile = "products.json";
	private final static String usersFile = "users.json";

	public static void writeProducts(JSONArray lista) {
		try {
			FileWriter file = new FileWriter(productsFile);
			file.write(lista.toString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeProducts(JSONObject objeto) {
		try {
			FileWriter file = new FileWriter(productsFile);
			file.write(objeto.toString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeUsers(JSONArray lista) {
		try {
			FileWriter file = new FileWriter(usersFile);
			file.write(lista.toString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeUsers(JSONObject objeto) {
		try {
			FileWriter file = new FileWriter(usersFile);
			file.write(objeto.toString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static JSONObject UsertoJson(Users user) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("getId", user.getId());
			jsonObject.put("email", user.getEmail());
			jsonObject.put("Password", user.getPassword());
			jsonObject.put("userName", user.getName());
			jsonObject.put("name_lastName", user.getName_lastName());
			if (user instanceof Client) {
				int i = 0;
				Client client = (Client) user;
				JSONArray array = new JSONArray();
				jsonObject.put("address", client.getAddress());
				jsonObject.put("cart", client.getCart());
				jsonObject.put("city", client.getCity());
				JSONObject card = new JSONObject();
				CreditCard creditCard = (CreditCard) client.getCard();
				card.put("name", creditCard.getName());
				card.put("number", creditCard.getNumber());
				card.put("date", creditCard.getDueDate());
				card.put("balance", creditCard.getBalance());
				card.put("seguritycode", creditCard.getSegurityCode());
				jsonObject.put("card", card);

				JSONObject cart = new JSONObject();
				JSONArray quantity = new JSONArray();
				Cart cartclass = (Cart) client.getCart();
				i = 0;
				while (cartclass.sizeInteger() > i) {
					
					quantity.put(cartclass.getQuantity());
					i++;
				}
				cart.put("quantity", quantity);
				JSONArray products = new JSONArray();
				while (cartclass.sizeProducts() > i) 
				{
					products.put(cartclass.getProducts());
				}
				cart.put("prducts",products);
				cart.put("total", cartclass.getTotal());
				jsonObject.put("cart", cart);
				Orders order = ((Client) user).getOrders();
				while (order.getSize() > i) {
					array.put(order);
				}
				jsonObject.put("Orders",array);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
		
	public static JSONObject productToJson(Products product)
	{
		JSONObject jsonObject = new JSONObject();
		try 
		{
			jsonObject.put("id", product.getId());
			jsonObject.put("name", product.getName());
			jsonObject.put("price", product.getPrice());
			jsonObject.put("stock", product.getStock());
			jsonObject.put("quantity", product.getQuantity());
			
			if(product instanceof HomeAppliances)
			{
				HomeAppliances ha = (HomeAppliances) product;
				jsonObject.put("voltage", ha.getVoltage());
				jsonObject.put("width", ha.getWidth());
				jsonObject.put("height", ha.getHeight());
			}
			else if(product instanceof Vehicle)
			{
				Vehicle v = (Vehicle) product;
				jsonObject.put("type", v.getType());
				jsonObject.put("isNew", v.isNew());
				jsonObject.put("km", v.getKm());
			}
			else if(product instanceof Estate)
			{
				Estate e = (Estate) product;
				jsonObject.put("rooms", e.getRooms());
				jsonObject.put("garage", e.isGarage());
				jsonObject.put("city", e.getCity());
			}
			else if(product instanceof Clothing)
			{
				Clothing c = (Clothing) product;
				jsonObject.put("size", c.getSize());
				jsonObject.put("colour", c.getColour());
				jsonObject.put("brand", c.getBrand());
			}
			
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		
		return jsonObject;
	}

	
}






















