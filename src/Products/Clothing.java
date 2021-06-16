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

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clothing other = (Clothing) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (colour == null) {
			if (other.colour != null)
				return false;
		} else if (!colour.equals(other.colour))
			return false;
		if (size != other.size)
			return false;
		return true;
	}
	
	
}
























