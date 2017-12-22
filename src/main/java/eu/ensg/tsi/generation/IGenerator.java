package eu.ensg.tsi.generation;

/**
 * Interface for the generators.
 * @author Antoine
 */
public interface IGenerator {

	/**
     * Generator creation method
     * @param data the matrix that will contain the elevation values.
     */
	public abstract void generate(double data[][]);
}
