package Products;

public abstract class Products {
	private int id;
	private String name;
	private float price;
	private int stock;
	
	public Products()
	{
		
	}

	public Products(int id, String name, float price, int stock) {
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

	public float getPrice() {
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
		return "Products [getId()=" + getId() + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ ", getStock()=" + getStock() + "]";
	}
	
	
	
}
















