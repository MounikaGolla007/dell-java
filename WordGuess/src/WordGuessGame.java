import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * GuessGame
 */

/**
 * @author Mounika_Golla
 *
 */
public class WordGuessGame {
	static List<String> alphaWords;
	static boolean isValidInput = true;
	static boolean isWordComplete = true;

	public static void main(String[] args) throws IOException {
		readWordDictionary();
		String randomWord = getRandomWord(); // Choose Random word from Dictionary
		// System.out.println(randomWord);
		String hiddenWord = getHiddenwordInDashes(randomWord); // Display "-" to user
		System.out.println(hiddenWord);
		Scanner sc = new Scanner(System.in);
		while (isValidInput || isWordComplete) {
			try {
				System.out.println("Choose a Letter");
				String userInput = sc.nextLine();
				ValidateUserInput(userInput); // throw exception for invalid input and continue to ask for input
				isValidInput = false;
				hiddenWord = getWordWithGuessedLetter(randomWord, userInput, hiddenWord); // Display hidden word with
																							// guessed letter
				System.out.println(hiddenWord);
				isWordComplete = hiddenWord.contains("-");

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
		System.out.println("You Successfully Completed the Word.");
		sc.close();
	}

	/*
	 * Get a random word from dictionary
	 */
	static void readWordDictionary() throws IOException {
		alphaWords = new ArrayList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("words_alpha.txt"))) { // close reader after reading
			String word;
			while ((word = br.readLine()) != null) {
				alphaWords.add(word);
			}
		}
	}

	/*
	 * Get a Random word from Dictionary
	 */
	static String getRandomWord() {
		if (alphaWords != null) {
			Random random = new Random();
			return alphaWords.get(random.nextInt(alphaWords.size()));
		}
		return null;
	}

	/*
	 * Generate random word with Dashes
	 */
	static String getHiddenwordInDashes(String word) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < word.length(); i++) {
			builder.append("-");
		}
		return builder.toString();
	}

	/*
	 * Get word with guessed letter
	 */
	static String getWordWithGuessedLetter(String word, String userInput, String hiddenWord) {
		char[] hiddenWordArray = hiddenWord.toCharArray();
		char[] wordCharArray = word.toCharArray();
		for (int i = 0; i < wordCharArray.length; i++) {
			if (wordCharArray[i] == userInput.charAt(0)) {
				hiddenWordArray[i] = userInput.charAt(0);
			}
		}
		return String.copyValueOf(hiddenWordArray);
	}

	/*
	 * Validate user input
	 */
	static String ValidateUserInput(String userInput) {
		char[] letters = userInput.toCharArray();
		if (letters.length > 1)
			throw new IllegalArgumentException("Input has more than one letter");
		if (Character.isDigit(letters[0]))
			throw new IllegalArgumentException("Input is not a letter");
		return null;
	}

}
