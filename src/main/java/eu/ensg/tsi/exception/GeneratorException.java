package eu.ensg.tsi.exception;

public class GeneratorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public GeneratorException() {
		System.out.println("Sorry but we have not yet implemented this method ... Please try an other DEM generation method.");
	}

	public GeneratorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public GeneratorException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public GeneratorException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public GeneratorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
