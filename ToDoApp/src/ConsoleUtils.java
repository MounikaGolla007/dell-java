import java.util.List;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Mounika_Golla
 *
 */
public class ConsoleUtils {

	/* Member variables */

	private Scanner scanner;

	/* Constructor */

	public ConsoleUtils() {
		scanner = new Scanner(System.in);
	}
	/* Methods */

	/*
	 * Prints the menu of actions to the console
	 */
	public void printHelp() {
		System.out.println(" Available Functions: ");
		System.out.println("add: To add an Item");
		System.out.println("delete: To delete an Item");
		System.out.println("mark done: the item to mark as done");
		System.out.println("list pending: to list the pending items");
		System.out.println("list done: to list the done items");
		System.out.println("list all: to list all items");
		System.out.println("help: display available functions");
		System.out.println("quit: to exit");
		System.out.println();

	}

	/*
	 * Prints an informational message to the console
	 */
	public void info(String msg) {
		System.out.println("[" + msg + "]");
		System.out.println();
	}

	/*
	 * Prints an informational message to the console
	 */
	public void todoIteminfo(String text, String value) {
		System.out.print(text + ":" + value);
		System.out.println();
	}

	/*
	 * Prints an error message to the console
	 */
	public void error(String msg) {
		System.out.println("[ERROR: " + msg + "]");
		System.out.println();
	}

	/*
	 * Prompts the user to enter input/ Returns the text entered by the user
	 */
	public String promptString(String label) {
		System.out.print(label + " ");
		return scanner.nextLine();
	}

	/*
	 * Prints a list of ToDoItem Items
	 */
	public void printList(List<ToDoItem> entries) {
		int longestDescription = 7;
		int longestCompletedFlag = 4;

		for (ToDoItem entry : entries) {
			if (entry.getDescription().length() > longestDescription) {
				longestDescription = entry.getDescription().length();
			}
			if (entry.getCompletedFlag().length() > longestCompletedFlag) {
				longestCompletedFlag = entry.getCompletedFlag().length();
			}
		}

		String descriptionHeader = String.format("%" + longestDescription + "s", "Description");
		String descriptionUnderline = "";
		for (int i = 0; i < longestDescription; i++) {
			descriptionUnderline += "-";
		}

		String statusHeader = String.format("%" + longestCompletedFlag + "s", "Status");
		String statusUnderline = "";
		for (int i = 0; i < longestCompletedFlag; i++) {
			statusUnderline += "-";
		}

		System.out.println(" ID | " + descriptionHeader + " | " + statusHeader);
		System.out.println("----+-" + descriptionUnderline + "-+-" + statusUnderline);

		for (ToDoItem entry : entries) {
			String description = String.format("%-" + longestDescription + "s", entry.getDescription());
			String status = String.format("%-" + longestCompletedFlag + "s", entry.getCompletedFlag());
			String line = String.format(" %2s | %s | %s ", entry.getId(), description, status);
			System.out.println(line);
		}

		if (entries.size() == 1) {
			System.out.println("[1 entry]");
		} else {
			System.out.println("[" + entries.size() + " entries]");
		}

		System.out.println();
	}

}
