package Instruments;

import java.util.ArrayList;

import Products.Products;

public class Cart {
	private ArrayList<Integer> quantity;
	private float total;
	private ArrayList<Products> products;
	
	public Cart()
	{
		total = 0;
	}


	// GETTERS

	public ArrayList<Integer> getQuantity() {
		return quantity;
	}

	public float getTotal() {
		return total;
	}

	public ArrayList<Products> getProducts() {
		return products;
	}
	
	
	// METHODS

	@Override
	public String toString() {
		return "Cart [getQuantity()=" + getQuantity() + ", getTotal()=" + getTotal() + ", getProducts()="
				+ getProducts() + "]";
	}
	
	/**
	 * 
	 * @param product
	 * @return  -1 if no exist /or the index of the product
	 */
	public int existProduct(Products p)
	{
		int pos = -1;
		
		for(int i = 0; i < products.size(); i++)
		{
			if(products.get(i).getId() == p.getId())
			{
				pos = i;
			}
		}
				
		return pos;
	}
	
	/**
	 * 
	 * @param product
	 * @param quantity
	 * @apiNote If the product exist, just sum the quantity. If it doesn't exist, add the product and the quantity
	 */
	public void add(Products product, Integer quantity)
	{
		int posProduct = existProduct(product);
		if(posProduct == -1)
		{
			this.products.add(product);
			this.quantity.add(quantity);
		}
		else
		{
			this.quantity.set(posProduct, this.quantity.get(posProduct) + quantity);
		}
	}

	/**
	 * 
	 * @param product
	 * @apiNote If quantity is greater than 1, quantity -= 1. Else, it is removed.
	 */
	public void remove(Products product)
	{
		int posProduct = existProduct(product);
		
		if(posProduct != -1)
		{
			if(this.quantity.get(posProduct) > 1)
			{
				this.quantity.set(posProduct, this.quantity.get(posProduct) - 1);
			}
			else
			{
				this.quantity.remove(posProduct);
				this.products.remove(posProduct);
			}
		}
	}
	
	/**
	 * 
	 * @return The sum of price of all products or -1 if there is an error
	 */
	public float calculateSubTotal()
	{
		float total = 0;
		
		if(quantity.size() == products.size())
		{
			for(int i = 0; i < products.size(); i++)
			{
				total += products.get(i).getPrice() * quantity.get(i);
			}
		}
		else
		{
			total = -1;
		}
		
		return total;
	}
	
	/**
	 * @apiNote subtract the quantity from stock and remove the product
	 * @return The final price
	 */
	public float buy()
	{
		float totalPrice = calculateSubTotal(); // falta agregar descuentos, si es que los hay.
		
		if(quantity.size() == products.size())
		{
			for(int i = 0; i < products.size(); i++)
			{
				products.get(i).substractStock(quantity.get(i));
				
				remove(products.get(i));
			}
		}
		
		return totalPrice;
	}
}


















