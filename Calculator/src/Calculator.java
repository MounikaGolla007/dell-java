import java.util.Scanner;
public class Calculator {
	public static void main(String[] args) {
		int number1;
		int number2;			
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Operator from Below");
		System.out.println("+,-,*,/");
		String operator = sc.nextLine();
		System.out.println("Enter First Number");		
		number1 = sc.nextInt();
		System.out.println("Enter Second Number");
		number2 = sc.nextInt();
		sc.close();
				
		switch(operator)
		{		
		case "+":
			System.out.println(Sum(number1,number2));
			break;
		case "-":
			System.out.println(Difference(number1,number2));
			break;
		case "*":
			System.out.println(Product(number1,number2));
			break;
		case "/":
			if(number2 == 0)
				System.out.println("Invalid Second Number");
			else			
			System.out.println(quotient(number1,number2));
			break;
		default:
			System.out.println("Entered Operator is Invalid");
			break;		
				
		}
		
	}
	
	static int Sum(int number1,int number2)
	{
		return number1 + number2;
	}
	
	static int Difference(int number1,int number2)
	{
		return number1 - number2; 
	}
	
	static int Product(int number1,int number2)
	{
		return number1 * number2;
	}
	
	static int quotient(int number1, int number2)
	{
		return number1 / number2;
	}

}
