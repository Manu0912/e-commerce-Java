package main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import Files.CatalogueUtiles;
import Files.UserUtiles;
import GraphicInterface.LogIn;
import GraphicInterface.Perfil;
import GraphicInterface.Principal;
import List.Catalogue;
import List.UserList;
import types_users.Admin;
import types_users.Client;
import types_users.Users;

public class Main {

	public static void main(String[] args) {
		LogIn inicio = new LogIn(); // ERROR EN EL LOGIN SOLO COMPARA CON EL ULTIMO USER INGRESADO
		//Signup signup = new Signup();
		//Principal principal = new Principal(new Client());
		//Perfil perfil = new Perfil(new Client("Matias", "Morilla", "123", "matias@gmail.com", "Mar del Plata", "Patagones 834"));
		//Perfil perfil = new Perfil(new Admin("Matias", "Morilla", "123", "matias@gmail.com"));

		/*HashMap<Integer, Users> hashMap = UserUtiles.read();
		System.out.println(hashMap.size());
		Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
		
		while(it.hasNext())
		{
			Entry<Integer, Users> entry = it.next();
			int i = 0;
			System.out.println(i+ 1);
			System.out.println(entry.getKey() + "/"+ entry.getValue());

		}*/
		
		
	}
	
}
