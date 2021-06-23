package Products;

public class Vehicle extends Products{
	private String type;
	private boolean isNew;
	private double km;
	
	public Vehicle()
	{
		
	}

	public Vehicle(String name, double price, int stock) {
		super( name, price, stock);
	}

	public Vehicle(String name, double price, int stock, String type, boolean isNew, double km) {
		super( name, price, stock);
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

	public double getKm() {
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
		String isNew = "";
		if(isNew()) isNew = "Si";
		else isNew = "No";
		return super.toString() + "Marca: " + getType() + "\nEs nueva: " + isNew + "\nKilometros: " + getKm();
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
		Vehicle other = (Vehicle) obj;
		if (isNew != other.isNew)
			return false;
		if (Double.doubleToLongBits(km) != Double.doubleToLongBits(other.km))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	
	
}















