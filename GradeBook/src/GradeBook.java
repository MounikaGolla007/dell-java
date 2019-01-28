import java.util.Scanner;
import java.util.*;
public class GradeBook {	 
	static HashMap<String, String> studentData;
	static HashMap<String,Double> studentAvgGrades;
	public static void main(String[] args) {		
		 studentData = new HashMap<String, String>();
		 studentAvgGrades = new HashMap<String,Double>();
		AddStudent();
		CalculateAverage();
		PrintStudentData();
	}
	
	/**
	 * store the students and the associated grades (as a comma-seperated string) in a Map<String,String> 
	 */
	public static void AddStudent() {
		String name;
		String grades;
		System.out.println("Enter Total Number of Students");
		Scanner sc = new Scanner(System.in);
		int studentCount = Integer.parseInt(sc.nextLine());
		for(int i =0; i<studentCount;i++)
		{
			System.out.println("Enter Student Name");
			name = sc.nextLine();
			System.out.println("Enter Grades in comma seperatedList");
			grades = sc.nextLine();
			if(!studentData.containsKey(name))
				studentData.put(name, grades);
			else {
				System.out.println("Student already added.TryAgain!");
				studentCount++;
		}
			
	}
		sc.close();
	}
	
	/**
	 * Compute the average grade for each student, and create a new Map<String,Double> that stores the students and their corresponding grade average.
	 */
	public static void CalculateAverage() {
		Double Average = 0.0;		
		for(Map.Entry<String, String> entry:studentData.entrySet()) {
			String[] gradeList = entry.getValue().split(",");
			for(int i = 0;i<gradeList.length;i++) {
				Average +=  Double.parseDouble(gradeList[i]);
			}
			Average = Average/gradeList.length;
			studentAvgGrades.put(entry.getKey(),Average);	
			Average = 0.0;
		}		
	}
	
	/**
	 * Use the Map<String,Double> that contains the students and their average grade to retrieve and print out the results
	 */
	public static void PrintStudentData() {
		for(Map.Entry<String, Double>entry:studentAvgGrades.entrySet())
			System.out.println(String.format("Student: %s Grade: %s", entry.getKey(),entry.getValue()));
	}	

}
