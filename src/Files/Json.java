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
	
	

	
}






















