package main;

import List.Catalogue;
import List.UserList;
import Products.Clothing;
import Products.Estate;
import Products.HomeAppliances;
import Products.Products;
import Products.Vehicle;
import types_users.Users;

public class Main {

	public static void main(String[] args) {
		UserList userList = new UserList();

		// boolean autentificated = login(userList,"pepito","1234");

		Catalogue<Products> catalogue = new Catalogue<Products>();
		Products e = new HomeAppliances(1, "Cafetera", 20000, 80, 50, 20, 20);
		Products v = new Vehicle(2, "Ford", 800000, 10, "Auto", true, 0);
		Products i = new Estate(3, "Casa", 150000, 1, 4, true, "Mar del Plata");
		Products c = new Clothing(4, "Remera", 1200, 40, 'M', "Verde", "Addidas");

		catalogue.add(e);
		catalogue.add(v);
		catalogue.add(i);
		catalogue.add(c);

		catalogue.write();

		Catalogue<Products> c2 = new Catalogue<Products>();
		c2 = catalogue.read();

		System.out.println(c2.getElement(0));

	}

	public static boolean login(UserList userList, String username, String password) {
		Users user = userList.getUser(username);
		if (user == null) {
			System.out.println("Usuario no encontrado");
			return false;
		} else {
			if (user.getPassword() == password) {
				System.out.println("Ha ingresado correctamente");
				return true;
			} else {
				System.out.println("El password ingresado no coincide con el usuario");
				return false;
			}
		}
	}
}
