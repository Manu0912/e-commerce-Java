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
	private final static String nombreArchivo = "json.json";

	public static void write(JSONArray lista) {
		try {
			FileWriter file = new FileWriter(nombreArchivo);
			file.write(lista.toString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void write(JSONObject objeto) {
		try {
			FileWriter file = new FileWriter(nombreArchivo);
			file.write(objeto.toString());
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String read()
	{
		String con="";
		try {
			con= new String(Files.readAllBytes(Paths.get(nombreArchivo)));
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
	public static JSONObject productToJson(Products product)
	{
		JSONObject jsonObject = new JSONObject();
		try 
		{
			if(product instanceof HomeAppliances)
			{
				HomeAppliances ha = (HomeAppliances) product;
				jsonObject.put("id", ha.getId());
				jsonObject.put("name", ha.getName());
				jsonObject.put("price", ha.getPrice());
				jsonObject.put("stock", ha.getStock());
				jsonObject.put("voltage", ha.getVoltage());
				jsonObject.put("width", ha.getWidth());
				jsonObject.put("height", ha.getHeight());
			}
			else if(product instanceof Vehicle)
			{
				Vehicle v = (Vehicle) product;
				jsonObject.put("id", v.getId());
				jsonObject.put("name", v.getName());
				jsonObject.put("price", v.getPrice());
				jsonObject.put("stock", v.getStock());
				jsonObject.put("type", v.getType());
				jsonObject.put("isNew", v.isNew());
				jsonObject.put("km", v.getKm());
			}
			else if(product instanceof Estate)
			{
				Estate e = (Estate) product;
				jsonObject.put("id", e.getId());
				jsonObject.put("name", e.getName());
				jsonObject.put("price", e.getPrice());
				jsonObject.put("stock", e.getStock());
				jsonObject.put("rooms", e.getRooms());
				jsonObject.put("garage", e.isGarage());
				jsonObject.put("city", e.getCity());
			}
			else if(product instanceof Clothing)
			{
				Clothing c = (Clothing) product;
				jsonObject.put("id", c.getId());
				jsonObject.put("name", c.getName());
				jsonObject.put("price", c.getPrice());
				jsonObject.put("stock", c.getStock());
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
	
	public static Products JsonToProdutc(String json) // Falta hacerla bien
	{
		Products p = null;
		
		try 
		{
			JSONObject jsonObject = new JSONObject(json);
			
			if(p instanceof HomeAppliances)
			{
				int id = jsonObject.getInt("id");
				String name = jsonObject.getString("name");
				double price = jsonObject.getDouble("price");
				int stock = jsonObject.getInt("stock");
				int voltage = jsonObject.getInt("voltage");
				double width = jsonObject.getDouble("width");
				double height = jsonObject.getDouble("height");

				p = new HomeAppliances(id, name, price, stock, voltage, width, height);
			}
			else if(p instanceof Vehicle)
			{
				int id = jsonObject.getInt("id");
				String name = jsonObject.getString("name");
				double price = jsonObject.getDouble("price");
				int stock = jsonObject.getInt("stock");
				String type = jsonObject.getString("type");
				boolean isNew = jsonObject.getBoolean("isNew");
				double km = jsonObject.getDouble("km");
				
				p = new Vehicle(id, name, price, stock, type, isNew, km);
			}
			else if(p instanceof Estate)
			{
				int id = jsonObject.getInt("id");
				String name = jsonObject.getString("name");
				double price = jsonObject.getDouble("price");
				int stock = jsonObject.getInt("stock");
				int rooms = jsonObject.getInt("rooms");
				boolean garage = jsonObject.getBoolean("garage");
				String city = jsonObject.getString("city");

				p = new Estate(id, name, price, stock, rooms, garage, city);
			}
			else if(p instanceof Clothing)
			{
				int id = jsonObject.getInt("id");
				String name = jsonObject.getString("name");
				double price = jsonObject.getDouble("price");
				int stock = jsonObject.getInt("stock");
				char size = (char) jsonObject.get("size");
				String colour = jsonObject.getString("colour");
				String brand = jsonObject.getString("brand");
				
				p = new Clothing(id, name, price, stock, size, colour, brand);
			}
		} 
		catch (JSONException e) 
		{
			e.printStackTrace();
		}
		
		
		return p;
	}
	
}






















