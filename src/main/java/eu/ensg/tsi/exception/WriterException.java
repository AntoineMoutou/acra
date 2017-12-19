package eu.ensg.tsi.exception;

public class WriterException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	public WriterException() {
		System.out.println("Extension not supported ... Please try another format to export this data.");
	}

}
