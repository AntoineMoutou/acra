package eu.ensg.tsi.writting;

import eu.ensg.tsi.exception.WriterException;

public class WriterFactory {

	public WriterFactory() {
		// TODO Auto-generated constructor stub
	}
	
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
