package eu.ensg.tsi.reading;

import eu.ensg.tsi.exception.ReaderException;

/**
 * Factory class for the reading methods.
 */
public class ReaderFactory {
	
	/**
     * Reading creation method from its pathname
     * @param pathname name of the input file.
     * @return an instance of the corresponding reader.
     * @throws ReaderException 
     */
	public static IReader createReader(String pathname) throws ReaderException {
		String dataExtension = pathname.substring(pathname.length()-3);
		switch (dataExtension)
		{
			case "shp":
				return new ShapefileReader();
			case "tif":
				  return new GeotiffReader(); 

			default:
				throw new ReaderException() ;             
		}
	}

}
