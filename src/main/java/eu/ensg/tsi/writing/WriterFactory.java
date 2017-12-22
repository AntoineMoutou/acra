package eu.ensg.tsi.writing;

import eu.ensg.tsi.exception.WriterException;

/**
 * Factory class for the writing methods.
 */
public class WriterFactory {
	
	/**
     * Writing creation method from its chosen extension.
     * @param dataExtension the extension of the export file.
     * @return an instance of the corresponding writer.
     * @throws WriterException 
     */
	public static IWriter createWriter(String dataExtension) throws WriterException {
		switch (dataExtension)
		{
			case "asc":
				return new AscWriter();
			case "tif":
				  return new GeotiffWriter(); 
			default:
				throw new WriterException() ;             
		}
	}

}
