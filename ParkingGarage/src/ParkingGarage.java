public class ParkingGarage {
	private int capacity;
	private Car[] parkingSpots;

	/**
	 * Constructor
	 * 
	 * @param capacity
	 */
	public ParkingGarage(int capacity) {
		this.capacity = capacity;
		this.parkingSpots = new Car[capacity];
	}

	/**
	 * park car
	 * 
	 * @param car
	 * @param spot
	 */
	public void park(Car car, int spot) {
		if (spot > capacity)
			throw new IndexOutOfBoundsException();
		if (parkingSpots[spot] != null) {
			System.out.printf("Spot %s not available!", spot);
			System.out.print("\n");
		} else
			parkingSpots[spot] = car;
	}

	/**
	 * vacate car from garage spot
	 * 
	 * @param spot
	 */
	public void vacate(int spot) {
		if (parkingSpots[spot] == null) {
			System.out.printf("Can't vacate from empty spot %s", spot);
			System.out.print("\n");
		} else
			parkingSpots[spot] = null;
	}

	/**
	 * print garage inventory
	 */
	public void printInventory() {
		for (int c = 0; c < parkingSpots.length; c++) {
			if (parkingSpots[c] == null)
				continue;
			System.out.printf("Car Parked at Spot Number:%s is %s %s %s with LicenseNumber %s", c,
					parkingSpots[c].getColor(), parkingSpots[c].getMake(), parkingSpots[c].getModel(),
					parkingSpots[c].getLicenseNumber());
			System.out.print("\n");
		}
	}

}
