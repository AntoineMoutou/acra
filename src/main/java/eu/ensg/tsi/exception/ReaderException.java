package eu.ensg.tsi.exception;

/**
 *  Exception class for the reader choice.
 *  @author Antoine
 */
public class ReaderException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 *  Exception method that prints a message in the console.
	 */
	public ReaderException() {
		System.out.println("Extension not supported ... Please try an other file.");
	}

}
