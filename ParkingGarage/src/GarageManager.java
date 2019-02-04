
public class GarageManager {
	public static void main(String[] args) {
		try {
			ParkingGarage pg01 = new ParkingGarage(10);
			Car c01 = new Car("Red", "FTZ8505", "Honda", "Civic");
			Car c02 = new Car("Green", "MKP1439", "Chevy", "Impala");
			Car c03 = new Car("Blue", "EFG4503", "Acura", "NSX");
			Car c04 = new Car("Burgundy", "MDF6503", "Aston", "V12");
			Car c05 = new Car("Black", "FRT9034", "Audi", "TTRS");
			Car c06 = new Car("Gray", "DER7645", "Audi", "RS5");
			pg01.park(c01, 8);
			pg01.park(c02, 5);
			pg01.park(c03, 4);
			pg01.park(c04, 0); // vacate and park at spot 1
			pg01.park(c05, 4); // spot not available
			pg01.park(c06, 9); // vacate and park at spot 3
			pg01.vacate(9);
			pg01.park(c06, 3);
			pg01.vacate(2); // Can't vacate empty spot
			pg01.vacate(0);
			pg01.park(c04, 1);
			pg01.printInventory();

			ParkingGarage pg02 = new ParkingGarage(2);
			pg02.park(c01, 2); // Array outofbounds

		} catch (Exception ex) {
			System.out.println("Incorrect Spot: " + ex.getMessage());
		}

	}

}
