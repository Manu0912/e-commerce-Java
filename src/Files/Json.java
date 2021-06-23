package Files;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Products.Clothing;
import Products.Estate;
import Products.HomeAppliances;
import Products.Products;
import Products.Vehicle;

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






















