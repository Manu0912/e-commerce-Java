package Products;

public class HomeAppliances extends Products{
	private int voltage;
	private double width;
	private double height;
	
	public HomeAppliances()
	{
		
	}

	public HomeAppliances(String name, double price, int stock) {
		super( name, price, stock);
	}

	public HomeAppliances(String name, double price, int stock, int voltage2, double width2, double height2) {
		super( name, price, stock);
		this.voltage = voltage2;
		this.width = width2;
		this.height = height2;
	}
	
	// GETTERS

	public int getVoltage() {
		return voltage;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	
	// SETTERS

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setHeight(float Height) {
		this.height = Height;
	}
	
	// METHODS

	@Override
	public String toString() {
		return super.toString() + "Voltage: " + getVoltage() + "\nAncho: " + getWidth() + "\nAlto: "	+ getHeight();
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
		HomeAppliances other = (HomeAppliances) obj;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (voltage != other.voltage)
			return false;
		if (Double.doubleToLongBits(width) != Double.doubleToLongBits(other.width))
			return false;
		return true;
	}

	
	
	
}
