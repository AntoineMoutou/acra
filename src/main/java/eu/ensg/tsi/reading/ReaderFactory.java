package eu.ensg.tsi.reading;

import eu.ensg.tsi.exception.ReaderException;

public class ReaderFactory {

	public ReaderFactory() {
		// TODO Auto-generated constructor stub
	}
	
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
