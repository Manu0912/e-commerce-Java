package List;

import java.util.ArrayList;

import Products.Products;


public class Catalogue {
	private ArrayList<Products> catalogue;

	
	public Catalogue()
	{
		catalogue = new ArrayList<Products>();
	}
	
	/**
	 * 
	 * @param product of type T 
	 * @return true if the product exist or false if not
	 */
	public boolean existProduct(Products product)
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
	public void add(Products product)
	{
		if(!existProduct(product))
		{
			catalogue.add(product);
		}
	}
	
	/**
	 * @apiNote remove the product from the catalogue
	 * @param product
	 */
	public void remove(Products product)
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
	public Products getElement(int i)
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
	
	
}


























