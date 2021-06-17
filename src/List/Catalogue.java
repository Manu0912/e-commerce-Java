package List;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Catalogue<T> {
	private ArrayList<T> catalogue;
	
	private final static String file_products = "products.dat";
	
	public Catalogue()
	{
		catalogue = new ArrayList<T>();
	}
	
	/**
	 * 
	 * @param product of type T 
	 * @return true if the product exist or false if not
	 */
	public boolean existProduct(T product)
	{
		boolean exist = false;
		
		for(int i = 0; i < catalogue.size(); i++)
		{
			if(catalogue.get(i).equals(product))
			{
				exist = true;
			}
		}
		
		return exist;
	}
	
	/**
	 * @apiNote add the product to the catalogue
	 * @param product
	 */
	public void add(T product)
	{
		if(existProduct(product))
		{
			catalogue.add(product);
		}
	}
	
	/**
	 * @apiNote remove the product from the catalogue
	 * @param product
	 */
	public void remove(T product)
	{
		if(existProduct(product))
		{
			catalogue.remove(product);
		}
	}
	
	/**
	 * 
	 * @param index of the product
	 * @return the product in the index i
	 */
	public T getElement(int i)
	{
		return catalogue.get(i);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < catalogue.size(); i++)
		{
			builder.append(catalogue.get(i).toString() + "\n");
		}
		
		return builder.toString();
	}
	

	/**
	 * 
	 * @return the size of the catalogue
	 */
	public int count()
	{
		return catalogue.size();
	}
	
	public void write()
	{
		FileOutputStream fos;
		ObjectOutputStream oos = null;
		try 
		{
			fos = new FileOutputStream(file_products);
			oos = new ObjectOutputStream(fos);
			
			for(int i = 0; i < catalogue.size(); i++)
			{
				oos.writeObject(catalogue.get(i));
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
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
	
	public Catalogue<T> read()
	{
		ObjectInputStream ois = null;
		Catalogue<T> catalogue = new Catalogue<T>();
		try 
		{
			ois = new ObjectInputStream(new FileInputStream(file_products));
			T product = null;
			
			while((product = (T) ois.readObject()) != null)
			{
				catalogue.add(product);
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
		finally 
		{
			try 
			{
				ois.close();
			} 
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		return catalogue;
	}
	
}


























