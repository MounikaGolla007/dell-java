
public class Condo implements IRentable {

	double weeklyRate;
	String condoType;

	/**
	 * @param weeklyRate
	 * @param condoType
	 */
	public Condo(double weeklyRate, String condoType) {
		this.weeklyRate = weeklyRate;
		this.condoType = condoType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRentable#getDescription()
	 */
	@Override
	public String getDescription() {
		return condoType + " at good neighbourhood";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRentable#getDailyRate()
	 */
	@Override
	public double getDailyRate() {
		return weeklyRate / 7;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see IRentable#getPrice(double)
	 */
	@Override
	public double getPrice(double days) {
		return days * (weeklyRate / 7);
	}

}
