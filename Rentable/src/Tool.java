/*
 * Tool class
 */
public class Tool implements IRentable {

	double hourlyRate;
	String toolName;

	public Tool(double hourlyRate, String toolName) {
		this.hourlyRate = hourlyRate;
		this.toolName = toolName;
	}

	/*
	 * (non-Javadoc) Tool Description
	 * 
	 * @see IRentable#getDescription()
	 */
	@Override
	public String getDescription() {
		return toolName + " in good condition";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRentable#getDailyRate()
	 */
	@Override
	public double getDailyRate() {
		return 24 * hourlyRate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRentable#getPrice(double)
	 */
	@Override
	public double getPrice(double days) {
		return days * 24 * hourlyRate;
	}

}
