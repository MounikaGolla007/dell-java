import java.sql.SQLException;

/**
 *  controller class
 */

/**
 * @author Mounika_Golla
 *
 */
public class Controller {
	/* Member variables */
	Dao dao;
	ConsoleUtils consoleUtils;

	/* Constructor */
	public Controller() {
		this.dao = new Dao();
		this.consoleUtils = new ConsoleUtils();
	}

	/* Methods */
	public void start() {
		consoleUtils.printHelp(); // Print available functions
		boolean quit = false;
		while (!quit) {
			// Prompt the user for input, collect input, parse into parts
			String input = consoleUtils.promptString("> ");
			// Figure out what to do depending on the user's primary action

			switch (input) {
			case "add":
				processAddNewAction();
				break;
			case "delete":
				processDeleteAction();
				break;
			case "mark done":
				processMarkDoneAction();
				break;
			case "list pending":
				processListPendingAction();
				break;
			case "list done":
				processListDoneAction();
				break;
			case "list all":
				processListAllAction();
				break;
			case "help":
				processHelpAction();
				break;
			case "quit":
				quit = true;
				break;
			default:
				processInvalidAction();
				break;

			}
		}
	}

	/**
	 * The user requested invalid command which is not in available functions
	 */
	private void processInvalidAction() {
		consoleUtils.info("Invalid Action");
	}

	/**
	 * Display Available user commands
	 */
	private void processHelpAction() {
		consoleUtils.printHelp();
	}

	/*
	 * For User Command "List pending" . Displays all pending todoitems
	 * 
	 */
	private void processListPendingAction() {
		try {
			consoleUtils.printList(dao.list("Pending"));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * For User Command "List done" . Displays all completed todoitems
	 */
	private void processListDoneAction() {
		try {
			consoleUtils.printList(dao.list("Done"));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * For User Command "List all" . Displays all todoitems
	 */
	private void processListAllAction() {
		try {
			consoleUtils.printList(dao.listAll());
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * For User Command "mark done" . To mark a todoitem done
	 */
	private void processMarkDoneAction() {
		int id = Integer.parseInt(consoleUtils.promptString("Enter an Item Id:"));
		ToDoItem entry;
		try {
			entry = dao.get(id);
			if (entry != null) {
				if (!entry.getCompletedFlag().equalsIgnoreCase("done")) {
					entry.setCompletedFlag("Done");
					dao.update(entry);
					consoleUtils.info("Item Updated");
				} else {
					consoleUtils.error("Item is marked Done already!");
				}
			} else {
				consoleUtils.error("could not find an item");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * For User Command "Delete" . Ask user for ID of todoitem to delete. If ID
	 * found in database then deletes that item . Display todoitem details before
	 * deletion.
	 */
	private void processDeleteAction() {
		int id = Integer.parseInt(consoleUtils.promptString("Enter an Item Id:"));
		ToDoItem entry;
		try {
			entry = dao.get(id);
			if (entry != null) {
				consoleUtils.todoIteminfo("Id", Integer.toString(entry.getId()));
				consoleUtils.todoIteminfo("Description", entry.getDescription());
				consoleUtils.todoIteminfo("Status", entry.getCompletedFlag());
				dao.delete(entry);
				consoleUtils.info("Item deleted");
			} else {
				consoleUtils.error("could not find an item");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}

	/**
	 * For User command "add" . Adds todoitem to database with default pending
	 * status.
	 */
	public void processAddNewAction() {
		String description = consoleUtils.promptString("Enter a Description:");
		try {
			dao.add(description, "Pending");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		consoleUtils.info("Item added");
	}
}
