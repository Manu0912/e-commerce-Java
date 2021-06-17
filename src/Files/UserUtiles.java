package Files;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import types_users.Client;
import types_users.Users;

public class UserUtiles {
	
	private final static String file_users = "users.dat";
	
	public static void write(HashMap<Integer, Users> hashMap)
	{
		ObjectOutputStream oos = null;
		
		try 
		{
			oos = new ObjectOutputStream(new FileOutputStream(file_users));
			Iterator<Entry<Integer, Users>> it = hashMap.entrySet().iterator();
			
			while(it.hasNext())
			{
				Entry<Integer, Users> entry = it.next(); 
				oos.writeObject(entry.getValue());
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally {
			try 
			{
				oos.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void write(Users user)
	{
		ObjectOutputStream oos = null;
		
		try 
		{
			oos = new ObjectOutputStream(new FileOutputStream(file_users));
			oos.writeObject(user);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally {
			try 
			{
				oos.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	
	public static HashMap<Integer, Users> read()
	{
		HashMap<Integer, Users> hashMap = new HashMap<Integer, Users>();
		ObjectInputStream ois = null;
		
		try 
		{
			ois = new ObjectInputStream(new FileInputStream(file_users));
			Client client;
			
			while((client = (Client) ois.readObject()) != null)
			{
				hashMap.put(client.getId(),client);
			}
		} 
		catch (EOFException e) 
		{
			System.out.println("Fin del archivo");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		
		return hashMap;
	}
}



























