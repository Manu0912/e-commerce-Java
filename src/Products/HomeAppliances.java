package Products;

public class HomeAppliances extends Products{
	private int voltage;
	private float width;
	private float weight;
	
	public HomeAppliances()
	{
		
	}

	public HomeAppliances(int id, String name, float price, int stock) {
		super(id, name, price, stock);
	}

	public HomeAppliances(int id, String name, float price, int stock, int voltage, float width, float weight) {
		super(id, name, price, stock);
		this.voltage = voltage;
		this.width = width;
		this.weight = weight;
	}
	
	// GETTERS

	public int getVoltage() {
		return voltage;
	}

	public float getWidth() {
		return width;
	}

	public float getWeight() {
		return weight;
	}
	
	// SETTERS

	public void setVoltage(int voltage) {
		this.voltage = voltage;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
	// METHODS

	@Override
	public String toString() {
		return super.toString() + "HomeAppliances [getVoltage()=" + getVoltage() + ", getWidth()=" + getWidth() + ", getWeight()="
				+ getWeight() + "]";
	}
	
	
}
