/*
 * Rentable Interface
 */
public interface IRentable {
	String getDescription();

	double getDailyRate();

	double getPrice(double days);
}
