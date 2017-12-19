package eu.ensg.tsi.exception;

public class OutOfMemoryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	
	public OutOfMemoryException() {
		System.out.println("Sorry but your resolution is too small for your envelope ... Please try an higher value.");
	}

}
