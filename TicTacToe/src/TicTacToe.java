import java.util.Scanner;
import java.util.*;
public class TicTacToe {
	static String[][] board =  {
			{"EMPTY","EMPTY","EMPTY"},
			{"EMPTY","EMPTY","EMPTY"},
			{"EMPTY","EMPTY","EMPTY"}				
	};
	static String[][] winningMoves = {
			{"00","01","02"},
			{"10","11","12"},
			{"20","21","22"},
			{"00","10","20"},
			{"01","11","21"},
			{"02","12","22"},
			{"00","11","22"},
			{"02","11","20"}			
	};
	static String player = "X";
	public static void main(String[] args) {		
		PlayGame();		
	}

	/* Print Board to console*/
	static void PrintBoard()
	{
		for(int i = 0;i < board.length;i++) {
			for(int j = 0;j < board[i].length;j++) {
				System.out.print(board[i][j]);	
				System.out.print("\t");
			}		
			System.out.println();
		}
	}
	
	/* Determine Players turn */
	static void UpdatePlayer() {
		player = player.equalsIgnoreCase("X") ? "O" : "X";
	}
	
	/* Check for Win */
	static boolean CheckForWin()
	{	
		boolean isWin = false;		
		String first,second,third;
		for(int i = 0;i < winningMoves.length; i++) {			
			first = winningMoves[i][0];
			second = winningMoves[i][1];
			third = winningMoves[i][2];
			if(board[Character.getNumericValue(first.charAt(0))][Character.getNumericValue(first.charAt(1))].equals(player) && board[Character.getNumericValue(second.charAt(0))][Character.getNumericValue(second.charAt(1))].equals(player) && board[Character.getNumericValue(third.charAt(0))][Character.getNumericValue(third.charAt(1))].equals(player))
				isWin = true;
		}		
		return isWin;
	}
	
	static boolean IsBoardHasEmptySpots()
	{
		for(int i = 0;i < board.length;i++) {
			for(int j = 0;j < board[i].length;j++) {
				if(board[i][j].equals("EMPTY")) return true;
			}
		}
		return false;
	}
	
	/* Read input from user and update board  */
	static void UpdateBoard() {		
		System.out.println("Enter row number");
		Scanner sc = new Scanner(System.in);
		int row = Integer.parseInt(sc.nextLine());
		System.out.println("Enter Column number");
		int column = Integer.parseInt(sc.nextLine());		
		if(board[row][column].equals("EMPTY")) 
			board[row][column] = player;
		else {
			if(IsBoardHasEmptySpots()) {
				System.out.println("Try again!");
				UpdateBoard();
			}			
		}
	}	
	 
	/* Play Game*/
	 static void PlayGame() {
		PrintBoard();
		System.out.println(String.format("Its Player %s Turn", player));
		UpdateBoard();	
		boolean isWin = CheckForWin();
		if(IsBoardHasEmptySpots() && !isWin) {
			UpdatePlayer();
			PlayGame();		
		}
		else if(!IsBoardHasEmptySpots() && !isWin) {
			System.out.println("It's a Tie!");
		}
		else System.out.println(String.format("Player %s Won!!", player));
	}
	
}
