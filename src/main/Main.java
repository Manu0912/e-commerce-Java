package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

import Files.CatalogueUtiles;
import Files.Json;
import Files.UserUtiles;
// import Files.CatalogueUtiles;
// import Files.UserUtiles;
import GraphicInterface.LogIn;
import List.Catalogue;
// import List.Catalogue;
// import Products.Clothing;
// import Products.Estate;
// import Products.HomeAppliances;
// import Products.Products;
// import Products.Vehicle;
// import types_users.Admin;
import types_users.Admin;
import types_users.Users;

public class Main {

	public static void main(String[] args) {
		LogIn inicio = new LogIn();
		
		// SI POR ALGUNA RAZON EL ARCHIVO DE CLIENTES SE ROMPE SE DEBERA CREAR DEVUELTA LOS CLIENTES 
		//Y SI SUCEDE LO MISMO CON LOS PRODUCTOS TAMBIEN :)
		// LOS ADMIN SE CREAN POR CONSOLA.
		
		// Signup signup = new Signup();
		// Principal principal = new Principal(new Client());
		// Perfil perfil = new Perfil(new Client("Matias", "Morilla", "123",
		// "matias@gmail.com", "Mar del Plata", "Patagones 834"));
		// Perfil perfil = new Perfil(new Admin("Matias", "Morilla", "123",
		// "matias@gmail.com"));
		// CartInterface cart = new CartInterface(new Client("Matias", "Morilla", "123",
		// "matias@gmail.com", "Mar del Plata", "Patagones 834"));

		// Products p1 = new HomeAppliances("Cafetera", 20000, 40, 60, 20, 20);
		// Products p2 = new Vehicle("Ford", 800000d, 10, "Auto", true, 0);
		// Products p3 = new Clothing("Remera", 1200, 80, 'M', "Azul", "Addidas");
		// Products p4 = new Estate("Casa", 1000000, 1, 4, true, "Mar del Plata");

		// Catalogue c = new Catalogue();

		// c.add(p1);
		// c.add(p2);
		// c.add(p3);
		// c.add(p4);

		// CatalogueUtiles.write(c);

		/*HashMap<Integer, Users> hm = UserUtiles.read();
		JSONArray jsonArray = new JSONArray();
		
		Iterator<Entry<Integer, Users>> it = hm.entrySet().iterator();
		while(it.hasNext()) 
		{
			Entry<Integer, Users> entry = it.next();
			JSONObject jsonObject = Json.UsertoJson(entry.getValue());
			jsonArray.put(jsonObject);
		}
		
		
		Json.writeUsers(jsonArray);*/

		/*Admin a = new Admin("MatiasAdmin", "Matias Morilla", "123", "matias1@gmail.com");

		UserUtiles.write(a);*/

		
	}

}



