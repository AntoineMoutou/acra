package eu.ensg.tsi.exception;

public class WriterException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;

	public WriterException() {
		System.out.println("Extension not supported ... Please try another format to export this data.");
	}

	public WriterException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public WriterException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public WriterException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public WriterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
