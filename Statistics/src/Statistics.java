import java.util.Scanner;
public class Statistics {
	public static void main(String[] args) {		
		Double average = 0.0;
		Double sum = 0.0;
		System.out.println("Enter List of Numbers");
		Scanner sc = new Scanner(System.in);
		String commaSeperateList = sc.nextLine();	
		/* split comma seperated user input*/
		String numbers[] =commaSeperateList.split(",");
		/* Initialize min and max to first element in list*/
			Double min = Double.parseDouble(numbers[0]);
			Double max =Double.parseDouble(numbers[0]);
			sum = Double.parseDouble(numbers[0]);
			/* Loop through list and find min and max*/
			for(int i = 1;i<=numbers.length-1;i++)
			{			
				Double number = Double.parseDouble(numbers[i]);				
				if(number <= min)
					min = number;
				if(number > max)
					max = number;
				sum  += number;
			}
		/* Calculate average*/
		average = sum/numbers.length;
		System.out.println(String.format("Minimum :%s",min));
		System.out.println(String.format("Maximum :%s",max));
		System.out.println(String.format("Sum :%s",sum));
		System.out.println(String.format("Total :%s",numbers.length));
		System.out.println(String.format("Average :%s",average));		
	}
}
