package List;


import java.util.ArrayList;

import types_users.Client;


public class UserList extends Client {
private ArrayList<Client> list;

public UserList() {
	 list = new ArrayList<Client>();
}

public int userPosition(String name)
{
	int i=-1;
	while(list.size()>i)
	{
		if(list.get(i).getName() == name&&i==-1)
		{
			
		}
		++i;
	}
	return i;
}

}
