/**
 * @author Mounika_Golla
 *
 */
import java.util.Scanner;
import java.util.EnumSet;
import java.util.Random;
public class TryCatchFinally {
		public static void main(String[] args) {		
			String userHand = "";
			String computerHand = "";	
			boolean isExists = true ;
			// ask for input until user input is correct
			while(isExists) {				
				try
				{			
					Scanner sc = new Scanner(System.in);
					System.out.println("Choose a Hand from below");
					EnumSet.allOf(Options.class).forEach(option ->System.out.println(option));		
					userHand = sc.nextLine();					
					ValidateUserInput(userHand);
					isExists = false;
					computerHand = GenerateRandomHand().toString();
					System.out.println(String.format("ComputerHand:%s",computerHand));				
					CompareHand(userHand,computerHand);	
					sc.close();
				}
				catch(Exception e) {
					System.out.println(e.toString());						
				}					
			}			
		}
		
		/**
		 * Generate random hand
		 * @return
		 */
		public static Options GenerateRandomHand()
		{
			Options option = Options.values()[(int)(Math.random()*Options.values().length)];
			return option;		
		}
		/**
		 * Validate user input
		 * @param userHand
		 */
		static void ValidateUserInput(String userHand) {	
			boolean isExists = false;
				for(Options o:Options.values()) {
					if(o.name().toLowerCase().equals(userHand.toLowerCase())) isExists = true;
				}
				if(!isExists) throw new IllegalArgumentException();				
		}
		/**
		 * compare hands
		 * @param userHand
		 * @param randomHand
		 */
		public static void CompareHand(String userHand , String randomHand)
		{
			if(userHand.equalsIgnoreCase(randomHand))
			{
				System.out.println("User and Computer hand are same.It's a Tie!!");			
			}
			else if(userHand.equalsIgnoreCase(Options.Rock.toString()) &&  randomHand.equalsIgnoreCase(Options.Scissors.toString()))
			{
				System.out.println("Computer Won!!");	
			}
			else if(userHand.equalsIgnoreCase(Options.Rock.toString()) &&  randomHand.equalsIgnoreCase(Options.Paper.toString()))
			{
				System.out.println("Computer Won!!");
			}
			else if(userHand.equalsIgnoreCase(Options.Scissors.toString()) &&  randomHand.equalsIgnoreCase(Options.Paper.toString()))
			{
				System.out.println("User Won!!");
			}	
			else if(userHand.equalsIgnoreCase(Options.Scissors.toString()) &&  randomHand.equalsIgnoreCase(Options.Rock.toString()))
			{
				System.out.println("Computer Won!!");	
			}
			else if(userHand.equalsIgnoreCase(Options.Paper.toString()) &&  randomHand.equalsIgnoreCase(Options.Rock.toString()))
			{
				System.out.println("User Won!!");
			}
			else if(userHand.equalsIgnoreCase(Options.Paper.toString()) &&  randomHand.equalsIgnoreCase(Options.Scissors.toString()))
			{
				System.out.println("Computer Won!!");
			}		
		}
		
		/**
		 * hand options
		 * @author Mounika_Golla
		 *
		 */
		public enum Options{
			Rock,
			Paper,
			Scissors
		}	
}
