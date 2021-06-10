package Products;

public class Estate extends Products{
	private String type;
	private int rooms;
	private boolean garage;
	private String city;
	
	public Estate() {
	
	}

	public Estate(int id, String name, float price, int stock) {
		super(id, name, price, stock);
	}

	public Estate(int id, String name, float price, int stock, String type, int rooms, boolean garage, String city) {
		super(id, name, price, stock);
		this.type = type;
		this.rooms = rooms;
		this.garage = garage;
		this.city = city;
	}
	
	// GETTERS

	public String getType() {
		return type;
	}

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

	public void setType(String type) {
		this.type = type;
	}

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
		return super.toString() + "Estate [getType()=" + getType() + ", getRooms()=" + getRooms() + ", isGarage()=" + isGarage()
				+ ", getCity()=" + getCity() + "]";
	}
	
	
}
























