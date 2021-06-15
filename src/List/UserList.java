package List;


import java.util.HashSet;
import java.util.Iterator;
import types_users.Users;


public class UserList extends Users {
private HashSet<Users> list;

public UserList() {
	 list = new HashSet<Users>();
}

public void UserListAdd(Users date) {
	 list.add(date);
}

public Users removeUser(String name)
{
	int flag=-1;
	Users us=null;
	Iterator <Users>iterator= list.iterator();
	while(iterator.hasNext()&&flag==-1)
	{
		if(iterator.next().getName()==name)
		{
			flag=0;
			iterator.remove();
			us=iterator.next();
		}
	}
	return us;
}
public Users getUser(String name)
{
	int flag=-1;
	Users us=null;
	Iterator <Users>iterator= list.iterator();
	while(iterator.hasNext()&&flag==-1)
	{
		if(iterator.next().getName()==name)
		{
			flag=0;
			us=iterator.next();
		}
	}
	return us;
}



public int userPosition(String name)
{
	int i=-1,flag=-1;
	Iterator <Users>iterator= list.iterator();
	while(iterator.hasNext()&&flag==-1)
	{
		if(iterator.next().getName()==name)
		{
			flag=0;
		}
		++i;
	}
	return i;
}
public String toString()
{
	int flag=-1;
	StringBuilder stri= new StringBuilder();
	Iterator <Users>iterator= list.iterator();
	while(iterator.hasNext()&&flag==-1)
	{
			stri.append(iterator.next().toString());
	}
	return stri.toString();
}
}
