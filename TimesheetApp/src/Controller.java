/**
 * @author Mounika_Golla
 *
 */
public class Controller {
	/* Member variables */
	Timesheet timesheet;
	ConsoleUtils consoleUtils;

	/* Constructor */
	public Controller() {
		this.timesheet = new Timesheet();
		this.consoleUtils = new ConsoleUtils();
	}

	/* Methods */

	/*
	 * Runs the program
	 */
	public void start() {

		consoleUtils.printHelp(); // Print the action menu

		boolean quit = false;
		while (!quit) {

			// Prompt the user for input, collect input, parse into parts
			String input = consoleUtils.promptString("> ");
			String[] actionParts = input.split(" ");
			String action = actionParts[0].trim(); // Primary action

			// Figure out what to do depending on the user's primary action
			if (action.equals("add")) {

				processAddAction();

			} else if (action.equals("delete")) {

				processDeleteAction(actionParts);

			} else if (action.equals("stop")) {

				processStopAction(actionParts);

			} else if (action.equals("list")) {

				processListAction(actionParts);

			} else if (action.equals("quit")) {

				quit = true;

			} else if (action.equals("help")) {

				processHelpAction();

			} else if (action.length() == 0) {

				// do nothing.

			} else {

				// Your code here

			}
		}

	}

	/*
	 * The user requested that a given TimesheetEntry be stopped (marked as
	 * complete) This method conveys that request to the Timesheet
	 */
	public void processStopAction(String[] actionParts) {

		if (actionParts.length > 2) {
			consoleUtils.error("Too many inputs to stop command");
			return;
		}

		int id = Integer.parseInt(actionParts[1]);

		TimesheetEntry entry = timesheet.get(id);
		if (entry != null) {
			timesheet.stop(entry);
			consoleUtils.info("Entry Updated");
		}
	}

	/*
	 * The user requested that a given TimesheetEntry be deleted This method conveys
	 * that request to the Timesheet
	 */
	public void processDeleteAction(String[] actionParts) {

		if (actionParts.length > 2) {
			consoleUtils.error("Too many inputs to delete command");
			return;
		}

		int id = Integer.parseInt(actionParts[1]);
		TimesheetEntry entry = timesheet.get(id);
		if (entry != null) {
			timesheet.delete(entry);
			consoleUtils.info("Entry deleted");
		}

	}

	/*
	 * The user wants to view a list of timesheet entries This method conveys that
	 * request to the Timesheet, along with any special options (active-only, filter
	 * by project name)
	 */
	public void processListAction(String[] actionParts) {

		if (actionParts.length > 3) {
			consoleUtils.error("Too many inputs to list command");
			return;
		}
		if (actionParts.length == 3 && (!actionParts[1].equals("-a") && actionParts[2].equals("-a")))
			consoleUtils.printList(timesheet.list(true, actionParts[1]));
		else if (actionParts.length == 3 && (actionParts[1].equals("-a") && !actionParts[2].equals("-a")))
			consoleUtils.printList(timesheet.list(true, actionParts[2]));
		else if (actionParts.length == 2 && (actionParts[1].equals("-a")))
			consoleUtils.printList(timesheet.list(true, ""));
		else if (actionParts.length == 2 && (!actionParts[1].equals("-a")))
			consoleUtils.printList(timesheet.list(false, actionParts[1]));
		else
			consoleUtils.printList(timesheet.list(false, ""));
	}

	/*
	 * The user wants to add a new entry to the Timesheet This method conveys that
	 * request to the Timesheet, along with the specified project name and task
	 * description
	 */
	public void processAddAction() {

		String project = consoleUtils.promptString("Project Name (one word only):");
		String description = consoleUtils.promptString("Task:");
		timesheet.add(project, description);
		consoleUtils.info("Entry added");

	}

	public void processHelpAction() {
		consoleUtils.printHelp();
	}
}
