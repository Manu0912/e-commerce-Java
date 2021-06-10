package Products;

public class Vehicle extends Products{
	private String type;
	private boolean isNew;
	private float km;
	
	public Vehicle()
	{
		
	}

	public Vehicle(int id, String name, float price, int stock) {
		super(id, name, price, stock);
	}

	public Vehicle(int id, String name, float price, int stock, String type, boolean isNew, float km) {
		super(id, name, price, stock);
		this.type = type;
		this.isNew = isNew;
		this.km = km;
	}
	
	// GETTERS

	public String getType() {
		return type;
	}

	public boolean isNew() {
		return isNew;
	}

	public float getKm() {
		return km;
	}
	
	// SETTERS

	public void setType(String type) {
		this.type = type;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public void setKm(float km) {
		this.km = km;
	}
	
	// METHODS

	@Override
	public String toString() {
		return super.toString() + "Vehicle [getType()=" + getType() + ", isNew()=" + isNew() + ", getKm()=" + getKm() + "]";
	}
	
	
}















