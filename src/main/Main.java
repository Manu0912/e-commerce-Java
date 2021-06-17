package main;

import GraphicInterface.LogIn;
import List.UserList;
import types_users.Users;

public class Main {

	public static void main(String[] args) {
		LogIn inicio = new LogIn();
		//Signup signup = new Signup();
		//Principal principal = new Principal();

		
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
