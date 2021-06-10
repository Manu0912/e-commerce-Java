package Products;

public class Clothing extends Products{
	private char size;
	private String colour;
	private String brand;
	
	public Clothing()
	{
		
	}

	public Clothing(int id, String name, float price, int stock) {
		super(id, name, price, stock);
	}


	public Clothing(int id, String name, float price, int stock, char size, String colour, String brand) {
		super(id, name, price, stock);
		this.size = size;
		this.colour = colour;
		this.brand = brand;
	}

	// GETTERS
	
	public char getSize() {
		return size;
	}

	public String getColour() {
		return colour;
	}

	public String getBrand() {
		return brand;
	}
	
	// SETTERS

	public void setSize(char size) {
		this.size = size;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	// METHODS

	@Override
	public String toString() {
		return super.toString() + "Clothing [getSize()=" + getSize() + ", getColour()=" + getColour() + ", getBrand()=" + getBrand() + "]";
	}
	
	
}
























