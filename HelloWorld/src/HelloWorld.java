import java.util.Scanner;
public class HelloWorld {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string1 = "Dell";
		System.out.println("Hi,My name is"+ string1);
		Scanner sc = new Scanner(System.in);
		System.out.println("Whats your name?");
		String input = sc.nextLine();
		System.out.println("Nice to meet you "+input);	
		sc.close();
	}

}
