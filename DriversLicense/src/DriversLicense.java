import java.time.*;
import java.time.Period;

public class DriversLicense {
 public String FirstName;
 public String LastName;
 public String DOB;
 public double Height;
 public String Gender;
 
 /**
  * Get Fullname
  * @return
  */
 public String getFullName() {
	 return FirstName+" "+LastName;
 }
 
 /**
  * Get Age
  * @return
  */
 public int getAge() {
	 int age = 0;
	 String[] date = DOB.split("/");
	 LocalDate birthdate = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[0]), Integer.parseInt(date[1]));	
	 LocalDate today = LocalDate.now();
	 Period period  = Period.between(birthdate, today);
	 age = period.getYears();
	 return age;
 }
}
