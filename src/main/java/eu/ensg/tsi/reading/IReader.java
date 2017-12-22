package eu.ensg.tsi.reading;

import org.geotools.geometry.jts.ReferencedEnvelope;

import eu.ensg.tsi.geometry.Bound;

/**
 * Interface for the reader.
 * @author Antoine
 *
 */
public interface IReader {

	/**
	 * The default Coordinate Reference System.
	 */
	public static final String DEFAULT_CRS = "EPSG:3857";
	
	/**
	 * Reads a geographic file in order to get the vertices of it extent.
	 * @param pathname pathname of the file to read
	 * @return The Bound object that corresponds at the extent of the read file.
	 */
	public abstract Bound getBoundOfData(String pathname);
	
	/**
	 *  Reads a geographic file in order to get it extent.
	 * @param pathname pathname of the file to read
	 * @return The ReferencedEnvelope object that corresponds at the extent of the read file.
	 */
	public abstract ReferencedEnvelope getReferencedEnvelope(String pathname);
}
