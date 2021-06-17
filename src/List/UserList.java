package List;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import types_users.Users;


public class UserList {
	private HashMap<Integer,Users> listMapUsers;
	
	public UserList() {
		listMapUsers = new HashMap<Integer,Users>();
	}
	
	public void UserListAdd(Integer id,Users date) {
		listMapUsers.put(id,date);
		// listMapuser.put(date.getId(), date); recomendacion para no tener que pedir el ID
	}
	
	public Users removeUser(String name)
	{
		int flag=-1;
		Users us=null;
		Iterator<Entry<Integer,Users>> it = listMapUsers.entrySet().iterator();
		while(it.hasNext()&&flag==-1)
		{
			Entry<Integer,Users> entry = it.next();
			if(entry.getValue().getName()==name)
			{
				flag=0;
				us=entry.getValue();
				it.remove();
			}
		}
		return us;
	}
	public Users getUser(String name)
	{
		int flag=-1;
		Users us=null;
		Iterator<Entry<Integer,Users>> it = listMapUsers.entrySet().iterator();
		while(it.hasNext()&&flag==-1)
		{
			Entry<Integer,Users> entry = it.next();
			if(entry.getValue().getName()==name)
			{
				flag=0;
				us=entry.getValue();
			}
		}
		return us;
	}
	
	
	public Integer getId(String name)
	{
		int flag=-1;
		int us=-1;
		Iterator<Entry<Integer,Users>> it = listMapUsers.entrySet().iterator();
		while(it.hasNext()&&flag==-1)
		{
			Entry<Integer,Users> entry = it.next();
			if(entry.getValue().getName()==name)
			{
				flag=0;
				us=entry.getKey();
			}
		}
		return us;
	}
	
	
	public String toString(Integer id)
	{
		int flag=-1;
		StringBuilder retorno = new StringBuilder();
		Iterator<Entry<Integer,Users>> it = listMapUsers.entrySet().iterator();
		while (it.hasNext()&&flag==-1) {
			Entry<Integer, Users> entry = it.next();
			if (entry.getKey()== id) {
				flag=0;
				retorno.append(entry.getValue().toString()+"\t"+entry.getKey()+"\n");
			}
		}
		return retorno.toString();
	}

}
