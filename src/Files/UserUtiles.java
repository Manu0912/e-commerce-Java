package Files;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;

import types_users.Client;
import types_users.Users;

public class UserUtiles {
	
	private final static String file_users = "Users.dat";
	
	/**
     * @param hashMap of type HashMap<Integer, Users>
     * @apiNote open a file and write an object, from a map
     */
	public static void write(HashMap<Integer, Users> hashMap)
	{
		ObjectOutputStream oos = null;
		FileOutputStream fos;
		try 
		{
			fos = new FileOutputStream(file_users);
			oos = new ObjectOutputStream(fos);
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
	/**
     * @param user of type Users
     * @apiNote open a file and copy the users object to a map. it copies it to a file
     */
	public static void write(Users user)
	{
		ObjectOutputStream oos = null;
		FileOutputStream fos;
		HashMap<Integer, Users> hashMap = UserUtiles.read();
		hashMap.put(user.getId(), user);
	
		try 
		{
			fos = new FileOutputStream(file_users);
			oos = new ObjectOutputStream(fos);
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
	
	/**
     * @apiNote open a file, and copy all Users objects to a map, and return it
     * @return HashMap<Integer, Users>
     */
	public static HashMap<Integer, Users> read()
	{
		HashMap<Integer, Users> hashMap = new HashMap<Integer, Users>();
		ObjectInputStream ois = null;
		FileInputStream fis;
		try 
		{
			fis = new FileInputStream(file_users);
			ois = new ObjectInputStream(fis);
			Users user;
			
			while((user = (Users) ois.readObject()) != null) 
			{
				hashMap.put(user.getId(),user);
			}
		} 
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(NoSuchElementException e)
		{
			System.out.println(e.getMessage());
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



























