package eu.ensg.tsi.exception;

public class ReaderException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReaderException() {
		System.out.println("Extension not supported ... Please try an other file.");
	}

	public ReaderException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ReaderException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public ReaderException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ReaderException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
