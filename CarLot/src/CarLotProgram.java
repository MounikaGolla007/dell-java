/**
 * Driver class
 */

/**
 * @author Mounika_Golla
 *
 */
public class CarLotProgram {
	public static void main(String[] args) {
		CarLot carMax = new CarLot("CarMax"); // carlot1
		CarLot autoNation = new CarLot("AutoNation"); // carlot2

		Vehicle chevy = new Truck(6, "Truck"); // Vehicle01
		chevy.licenseNumber = "DFG1836";
		chevy.make = "Chevrolet";
		chevy.model = "Silverado";
		chevy.price = "60,100";
		carMax.addVehicle(chevy); // add vehicle to carlot1
		autoNation.addVehicle(chevy); // add vehicle to carlot2

		Vehicle audi = new Car("Convertible", 2); // vehicle02
		audi.licenseNumber = "SKT3985";
		audi.make = "Audi";
		audi.model = "A5";
		audi.price = "51,200";
		carMax.addVehicle(audi); // add vehicle to carlot1
		autoNation.addVehicle(audi); // add vehicle to carlot2

		Vehicle ford = new Truck(6, "Truck"); // vehicle3
		ford.licenseNumber = "RJF9486";
		ford.make = "Ford";
		ford.model = "F-150";
		ford.price = "70,560";
		carMax.addVehicle(ford); // add vehicle to carlot1
		autoNation.addVehicle(ford); // add vehicle to carlot2

		Vehicle tesla = new Car("Sedan", 4); // vehicle4
		tesla.licenseNumber = "DJT0483";
		tesla.make = "Tesla";
		tesla.model = "model3";
		tesla.price = "64,000";
		carMax.addVehicle(tesla); // add vehicle to carlot1
		autoNation.addVehicle(tesla); // add vehicle to carlot2

		Vehicle aston = new Car("Sport", 4); // vehicle4
		aston.licenseNumber = "DJT0483";
		aston.make = "Aston Martin";
		aston.model = "Rapide";
		aston.price = "206,000";
		autoNation.addVehicle(aston); // add vehicle to carlot2

		carMax.printInventory(); // print carlot1 inventory
		autoNation.printInventory(); // print carlot2 inventory

	}

}
