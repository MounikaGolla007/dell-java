
public class Car {
	private String color;
	private String licenseNumber;
	private String make;
	private String model;

	/**
	 * Constructor
	 * 
	 * @param color
	 * @param licenseNumber
	 * @param make
	 * @param model
	 */
	public Car(String color, String licenseNumber, String make, String model) {
		this.color = color;
		this.licenseNumber = licenseNumber;
		this.make = make;
		this.model = model;
	}

	/**
	 * get car color
	 * 
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * get car license number
	 * 
	 * @return license number
	 */
	public String getLicenseNumber() {
		return licenseNumber;
	}

	/**
	 * get make of the car
	 * 
	 * @return make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * get model of the car
	 * 
	 * @return model
	 */
	public String getModel() {
		return model;
	}

}
