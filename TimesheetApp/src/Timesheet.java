
/**
 * 
 */
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mounika_Golla
 *
 */
public class Timesheet {
	private List<TimesheetEntry> database;

	public Timesheet() {
		this.database = new ArrayList<TimesheetEntry>();
	}

	public void add(String project, String task) {
		database.add(new TimesheetEntry(project, task));
	}

	public List<TimesheetEntry> list(boolean activeOnly, String name) {
		List<TimesheetEntry> requiredEntries = new ArrayList<>();
		if (activeOnly && name != "") {
			for (int i = 0; i < database.size(); i++) {
				if (database.get(i).getEndTime() == null
						&& database.get(i).getProjectName().toLowerCase().equals(name.toLowerCase())) {
					requiredEntries.add(database.get(i));
				}
			}
			return requiredEntries;
		} else if (!activeOnly && name != "") {
			for (int i = 0; i < database.size(); i++) {
				if (database.get(i).getProjectName().toLowerCase().equals(name.toLowerCase())) {
					requiredEntries.add(database.get(i));
				}
			}
			return requiredEntries;
		} else if (activeOnly && name == "") {
			for (int i = 0; i < database.size(); i++) {
				if (database.get(i).getEndTime() == null) {
					requiredEntries.add(database.get(i));
				}
			}
			return requiredEntries;
		}

		return database;
	}

	public TimesheetEntry get(int id) {
		for (TimesheetEntry entry : database) {
			if (entry.getId() != id)
				continue;
			else
				return entry;
		}
		return null;
	}

	public void delete(TimesheetEntry entry) {
		for (int i = 0; i < database.size(); i++) {
			if (database.get(i).getId() == entry.getId()) {
				database.remove(i);
			}
		}
	}

	public void stop(TimesheetEntry entry) {
		if (entry != null) {
			for (int i = 0; i < database.size(); i++) {
				if (database.get(i).getId() == entry.getId()) {
					database.get(i).updateEndTime();
				}
			}

		}
	}
}
