package eu.ensg.tsi.exception;

public class ReaderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReaderException() {
		System.out.println("Extension not supported ... Please try an other file.");
	}

}
