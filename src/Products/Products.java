package Products;

import java.io.Serializable;

public abstract class Products implements Serializable{
	private int id;
	private String name;
	private double price;
	private int stock;
	
	public Products()
	{
		
	}

	public Products(int id, String name, double price, int stock) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	
	// GETTERS

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}
	
	// SETTERS

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	// METHODS

	@Override
	public String toString() {
		return getName() + " \nPrecio: " + getPrice() + "\nStock: " + getStock() + "\n";
	}
	
	
	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (stock != other.stock)
			return false;
		return true;
	}

	/**
	 * @apiNote subtract 1 from the stock
	 */
	public void substractStock()
	{
		if(stock > 0)
			this.stock--;
	}
	
	/**
	 * @apiNote subtract quantity from the stock
	 */
	public void substractStock(int quantity)
	{
		if(stock > quantity)
			this.stock -= quantity;
	}
}
















