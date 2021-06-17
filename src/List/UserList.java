package List;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import types_users.Users;

public class UserList {
	private HashMap<Integer, Users> listMapUsers;

	public UserList() {
		listMapUsers = new HashMap<Integer, Users>();
	}
	
	public HashMap<Integer, Users> getHashMap()
	{
		return listMapUsers;
	}
	
	/**
	 * @param date of type Users
	 * @apiNote add the User to the listMapUsers
	 */
	public void UserListAdd(Users date) {
		listMapUsers.put(date.getId(), date);
	}
	
	// GETTERS
		/**
		 * @param id of type Integer
	     * @apiNote check if the user exists,using the name passed by parameter
		 * @return returns a Users, if it does not find it a null
		 */
	public Users getUser(String name) {
		int flag = -1;
		Users us = null;
		Iterator<Entry<Integer, Users>> it = listMapUsers.entrySet().iterator();
		while (it.hasNext() && flag == -1) {
			Entry<Integer, Users> entry = it.next();
			if (entry.getValue().getName().equals(name)) {
				flag = 0;
				us = entry.getValue();
			}
		}
		return us;
	}
	
	/**
	 * @param name of type String
     * @apiNote check if the user exists,using the name passed by parameter
	 * @return returns a Integer, If it finds it, it returns the key, if it does not find it, it returns a -1
	 */
	public Integer getId(String name) {
		int flag = -1;
		int us = -1;
		Iterator<Entry<Integer, Users>> it = listMapUsers.entrySet().iterator();
		while (it.hasNext() && flag == -1) {
			Entry<Integer, Users> entry = it.next();
			if (entry.getValue().getName() == name) {
				flag = 0;
				us = entry.getKey();
			}
		}
		return us;
	}
	
	/**
	 * @param id of type Integer
	 * @apiNote converts the Orders object to a string
	 * @return String,if it does not find null
	 */
	public String toString(Integer id) {
		int flag = -1;
		StringBuilder retorno = new StringBuilder();
		Iterator<Entry<Integer, Users>> it = listMapUsers.entrySet().iterator();
		while (it.hasNext() && flag == -1) {
			Entry<Integer, Users> entry = it.next();
			if (entry.getKey() == id) {
				flag = 0;
				retorno.append(entry.getValue().toString() + "\t" + entry.getKey() + "\n");
			}
		}
		return retorno.toString();
	}
	
	/**
	 * @param id of type Integer
	 * @apiNote remove a specific product
	 * @return returns an object of type Users, otherwise a null finds it
	 */
	public Users removeUser(Integer id) {
		int flag = -1;
		Users us = null;
		Iterator<Entry<Integer, Users>> it = listMapUsers.entrySet().iterator();
		while (it.hasNext() && flag == -1) {
			Entry<Integer, Users> entry = it.next();
			if (entry.getValue().getId() == id) {
				flag = 0;
				us = entry.getValue();
				it.remove();
			}
		}
		return us;
	}
	
	public int count()
	{
		return listMapUsers.size();
	}
}






















