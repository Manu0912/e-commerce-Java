package main;

import GraphicInterface.LogIn;
import GraphicInterface.Perfil;
import GraphicInterface.Principal;
import List.UserList;
import types_users.Admin;
import types_users.Client;
import types_users.Users;

public class Main {

	public static void main(String[] args) {
		//LogIn inicio = new LogIn();
		//Signup signup = new Signup();
		//Principal principal = new Principal(new Client());
		Perfil perfil = new Perfil(new Client("Matias", "Morilla", "123", "matias@gmail.com", "Mar del Plata", "Patagones 834"));
		//Perfil perfil = new Perfil(new Admin("Matias", "Morilla", "123", "matias@gmail.com"));

		
	}

	public static boolean login(UserList userList, String userName, String password) {
		Users user = userList.getUser(userName);
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
