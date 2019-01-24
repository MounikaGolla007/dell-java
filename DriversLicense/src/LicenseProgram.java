
public class LicenseProgram {

	public static void main(String[] args) {
		/**
		 * First Instance of DL class
		 */
		DriversLicense d1 = new DriversLicense();
		d1.FirstName = "John";
		d1.LastName = "Doe";
		d1.DOB = "01/22/1950";
		
		/**
		 * Second instance of DL class
		 */
		DriversLicense d2 = new DriversLicense();
		d2.FirstName = "Kate";
		d2.LastName = "Hudson";
		d2.DOB = "03/23/1990";
		
		/**
		 * Third instance of DL class
		 */
		DriversLicense d3 = new DriversLicense();
		d3.FirstName = "Mike";
		d3.LastName = "pence";
		d3.DOB = "12/10/1943";
		
		System.out.println(d1.getFullName());
		System.out.println(d1.getAge());
		
		System.out.println(d2.getFullName());
		System.out.println(d2.getAge());
		
		System.out.println(d3.getFullName());
		System.out.println(d3.getAge());
	}
}
