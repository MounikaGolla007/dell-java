
/*
 * Rentable program
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentableProgram {
	public static void main(String[] args) {
		double numberOfDays; // number of days to rent
		List<IRentable> rentable = new ArrayList<IRentable>();

		Room room1 = new Room(33.33, "1-Bed with poolview"); // Instantiation1 room class
		Condo condo1 = new Condo(375, "2-Bed,2-Bath"); // Instantiation1 condo class
		Tool tool1 = new Tool(1.5, "Electric Pressure Washer"); // // Instantiation1 tool class
		rentable.add(room1); // add to rentable list
		rentable.add(condo1);// add to rentable list
		rentable.add(tool1);// add to rentable list

		Room room2 = new Room(30, "1-Bed with elevator service"); // Instantiation2 room class
		Condo condo2 = new Condo(300.30, "2-Bed,2.5Bath"); // Instantiation2 condo class
		Tool tool2 = new Tool(1, "LawnMower"); // Instantiation3 tool class
		rentable.add(room2);
		rentable.add(condo2);
		rentable.add(tool2);

		Room room3 = new Room(20, "1Bed with huge patio"); // Instantiation3 room class
		Condo condo3 = new Condo(250.30, "3Bed,3Bath"); // Instantiation3 condo class
		Tool tool3 = new Tool(0.75, "Air Compressors"); // Instantiation3 tool class
		rentable.add(room3);
		rentable.add(condo3);
		rentable.add(tool3);

		System.out.println("Enter Number of days");
		Scanner sc = new Scanner(System.in); // ask user for number of days to rent
		numberOfDays = Double.parseDouble(sc.nextLine()); // read user input
		for (IRentable r : rentable) {
			System.out.println("Description:" + r.getDescription());
			System.out.println(String.format("DailyRate:%.2f", r.getDailyRate()));
			System.out.println(String.format("FinalPrice:$%.2f", r.getPrice(numberOfDays)));
			System.out.println("\n");
		}
		sc.close();
	}
}
