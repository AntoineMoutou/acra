package eu.ensg.tsi.writing;

import eu.ensg.tsi.exception.ReaderException;
import eu.ensg.tsi.geometry.Bound;


/**
 * Interface for the writers.
 * @author Antoine
 */
public interface IWriter {

	/**
     * Writer creation method
     * @param data the matrix that contains the elevation values.
     * @param pathname name of the input file.
     * @param resolution resolution of the DEM.
     * @param bound coordinates of the extent of the input file.
     * @throws ReaderException 
     */
	public abstract void export(double data[][], String pathname, double resolution, Bound bound) throws ReaderException;
}
