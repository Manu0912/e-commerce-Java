package Products;

public class Clothing extends Products{
	private char size;
	private String colour;
	private String brand;
	
	public Clothing()
	{
		
	}

	public Clothing(String name, double price, int stock) {
		super( name, price, stock);
	}


	public Clothing(String name, double price, int stock, char size, String colour, String brand) {
		super( name, price, stock);
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
		return super.toString() + "Talle: " + getSize() + "\nColor: " + getColour() + "\nMarca: " + getBrand();
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

	@Override
    public double generateDiscountQuantity(double total, int quantity) {

        if(quantity == 3)
        {
            total = total / 2;
        }

        return total;
    }
}
























