package eu.ensg.tsi.exception;

/**
 *  Exception class for the DEM generation method choice.
 *  @author Antoine
 */
public class GeneratorException extends RuntimeException {
	
	private static final long serialVersionUID = 2L;

	/**
	 *  Exception method that prints a message in the console.
	 */
	public GeneratorException() {
		System.out.println("Sorry but we have not yet implemented this method ... Please try an other DEM generation method.");
	}

}
