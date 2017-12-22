package eu.ensg.tsi.exception;

/**
 *  Exception class for the export choice.
 *  @author Antoine
 */
public class WriterException extends RuntimeException {

	private static final long serialVersionUID = 3L;

	/**
	 *  Exception method that prints a message in the console.
	 */
	public WriterException() {
		System.out.println("Extension not supported ... Please try another format to export this data.");
	}

}
