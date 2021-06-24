package Products;

public class Estate extends Products{
	private int rooms;
	private boolean garage;
	private String city;
	
	public Estate() {
	
	}

	public Estate(String name, double price, int stock) {
		super( name, price, stock);
	}

	public Estate(String name, double price, int stock, int rooms, boolean garage, String city) {
		super( name, price, stock);
		this.rooms = rooms;
		this.garage = garage;
		this.city = city;
	}
	
	// GETTERS

	public int getRooms() {
		return rooms;
	}

	public boolean isGarage() {
		return garage;
	}

	public String getCity() {
		return city;
	}
	
	// SETTERS

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public void setGarage(boolean garage) {
		this.garage = garage;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	// METHODS

	@Override
	public String toString() {
		String garage = "";
		if(isGarage()) garage = "Si";
		else garage = "No";
		return super.toString() + "Ambientes: " + getRooms() + "\nGarage: " + garage + "\nCiudad: " + getCity();
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
		Estate other = (Estate) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (garage != other.garage)
			return false;
		if (rooms != other.rooms)
			return false;
		return true;
	}

	@Override
	public double generateDiscountQuantity(double total, int quantity) {
		
		if(quantity == 2)
		{
			total = total * 0.8;
		}
		
		return total;
	}

	
	
}
























