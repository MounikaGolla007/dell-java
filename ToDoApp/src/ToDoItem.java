/**
 * 
 */

/**
 * @author Mounika_Golla
 *
 */
public class ToDoItem {
	/* Member variables */
	private int id;
	private String description;
	private String completedFlag;

	/* Constructor */
	public ToDoItem(int id, String description, String completedFlag) {
		this.description = description;
		this.completedFlag = completedFlag;
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the todoitem description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param set todoitem description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return get status of todoitem
	 */
	public String getCompletedFlag() {
		return completedFlag;
	}

	/**
	 * @param set status of todoitem
	 */
	public void setCompletedFlag(String completedFlag) {
		this.completedFlag = completedFlag;
	}

}
