package List;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;

import types_users.Users;


public class UserList {
private HashMap<String,Users> listMapUsers;

public UserList() {
	listMapUsers = new HashMap<String,Users>();
}

public void UserListAdd(String category,Users date) {
	listMapUsers.put(category,date);
}

public Users removeUser(String name)
{
	int flag=-1;
	Users us=null;
	Iterator<Entry<String,Users>> it = listMapUsers.entrySet().iterator();
	while(it.hasNext()&&flag==-1)
	{
		Entry<String,Users> entry = it.next();
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
	Iterator<Entry<String,Users>> it = listMapUsers.entrySet().iterator();
	while(it.hasNext()&&flag==-1)
	{
		Entry<String,Users> entry = it.next();
		if(entry.getValue().getName()==name)
		{
			flag=0;
			us=entry.getValue();
		}
	}
	return us;
}
public String getCategory(String name)
{
	int flag=-1;
	String us=null;
	Iterator<Entry<String,Users>> it = listMapUsers.entrySet().iterator();
	while(it.hasNext()&&flag==-1)
	{
		Entry<String,Users> entry = it.next();
		if(entry.getValue().getName()==name)
		{
			flag=0;
			us=entry.getKey();
		}
	}
	return us;
}


public String toString(String category)
{
	int flag=-1;
	StringBuilder retorno = new StringBuilder();
	Iterator<Entry<String,Users>> it = listMapUsers.entrySet().iterator();
	while (it.hasNext()&&flag==-1) {
		Entry<String, Users> entry = it.next();
		if (entry.getKey()== category) {
			flag=0;
			retorno.append(entry.getValue().toString()+"\t"+entry.getKey()+"\n");
		}
	}
	return retorno.toString();
}

}
