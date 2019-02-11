/*
 * Room class
 */
public class Room implements IRentable {

	double dailyRate;
	String roomName;

	/*
	 * constructor
	 */
	public Room(double dailyRate, String roomName) {
		this.dailyRate = dailyRate;
		this.roomName = roomName;
	}

	/*
	 * (non-Javadoc) get room description
	 * 
	 * @see IRentable#getDescription()
	 */
	@Override
	public String getDescription() {
		return roomName + " at great Location";
	}

	/*
	 * (non-Javadoc) get dailyrate
	 * 
	 * @see IRentable#getDailyRate()
	 */
	@Override
	public double getDailyRate() {
		return dailyRate;
	}

	/*
	 * (non-Javadoc) get price
	 * 
	 * @see IRentable#getPrice(double)
	 */
	@Override
	public double getPrice(double days) {
		return days * dailyRate;
	}

}
