import java.time.LocalDateTime;

/**
 * 
 */

/**
 * @author Mounika_Golla
 *
 */
public class TimesheetEntry {

	private static int NEXTID = 1;
	private String projectName;
	private String task;
	private int id;
	private LocalDateTime startTime;
	private LocalDateTime endTime;

	/**
	 * @param projectName
	 * @param task
	 */
	public TimesheetEntry(String myProject, String myTask) {
		this.projectName = myProject;
		this.task = myTask;
		this.id = NEXTID;
		startTime = LocalDateTime.now();
		endTime = null;
		NEXTID++;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @return the task
	 */
	public String getTask() {
		return task;
	}

	/**
	 * @return the startTime
	 */
	public LocalDateTime getStartTime() {
		return startTime;
	}

	/**
	 * @return the endTime
	 */
	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void updateEndTime() {
		// TODO: check for empty
		endTime = LocalDateTime.now();
	}

}
