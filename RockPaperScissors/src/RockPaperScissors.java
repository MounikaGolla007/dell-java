import java.util.Scanner;
import java.util.EnumSet;
import java.util.Random;
public class RockPaperScissors {
	public static void main(String[] args) {		
		String userHand;
		String computerHand;		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose a Hand from below");
		EnumSet.allOf(Options.class).forEach(option ->System.out.println(option));		
		userHand = sc.nextLine();
		computerHand = GenerateRandomHand().toString();
		System.out.println(String.format("ComputerHand:%s",computerHand));
		CompareHand(userHand,computerHand);
		sc.close();
	}
	
	public static Options GenerateRandomHand()
	{
		Options option = Options.values()[(int)(Math.random()*Options.values().length)]; 
		return option;		
	}
	
	public static void CompareHand(String userHand , String randomHand)
	{
		if(userHand.equals(randomHand))
		{
			System.out.println("User and Computer hand are same.It's a Tie!!");			
		}
		else if(userHand.equals(Options.Rock.toString()) &&  randomHand.equals(Options.Scissors.toString()))
		{
			System.out.println("Computer Won!!");	
		}
		else if(userHand.equals(Options.Rock.toString()) &&  randomHand.equals(Options.Paper.toString()))
		{
			System.out.println("Computer Won!!");
		}
		else if(userHand.equals(Options.Scissors.toString()) &&  randomHand.equals(Options.Paper.toString()))
		{
			System.out.println("User Won!!");
		}	
		else if(userHand.equals(Options.Scissors.toString()) &&  randomHand.equals(Options.Rock.toString()))
		{
			System.out.println("Computer Won!!");	
		}
		else if(userHand.equals(Options.Paper.toString()) &&  randomHand.equals(Options.Rock.toString()))
		{
			System.out.println("User Won!!");
		}
		else if(userHand.equals(Options.Paper.toString()) &&  randomHand.equals(Options.Scissors.toString()))
		{
			System.out.println("Computer Won!!");
		}		
	}
	
	public enum Options{
		Rock,
		Paper,
		Scissors
	}

}
