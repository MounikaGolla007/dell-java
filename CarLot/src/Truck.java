/**
 *  Truck subclass
 */

/**
 * @author Mounika_Golla
 *
 */
public class Truck extends Vehicle {

	int bedSize;
	String type;

	/*
	 * (non-Javadoc) super class method override
	 * 
	 * @see Vehicle#printDescription()
	 */
	@Override
	void printDescription() {
		System.out.println("Vehicle Type: " + this.type);
		System.out.println("BedSize:" + this.bedSize);
		System.out.println("License#:" + this.licenseNumber);
		System.out.println("Make:" + this.make);
		System.out.println("Model:" + this.model);
		System.out.println("Price $" + this.price + ". ");
	}

	/**
	 * @param bedSize
	 */
	public Truck(int bedSize, String type) {
		this.bedSize = bedSize;
		this.type = type;
	}

}
