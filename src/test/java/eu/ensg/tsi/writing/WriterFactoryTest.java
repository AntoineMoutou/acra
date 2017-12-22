package eu.ensg.tsi.writing;

import static org.junit.Assert.*;

import org.junit.Test;

import eu.ensg.tsi.exception.WriterException;
import eu.ensg.tsi.writing.AscWriter;
import eu.ensg.tsi.writing.GeotiffWriter;
import eu.ensg.tsi.writing.IWriter;
import eu.ensg.tsi.writing.WriterFactory;

public class WriterFactoryTest {

	@Test
	public void testCreateWriter() {
		String dataExtension = "asc";
		String dataExtension2 = "tif";
		String dataExtension3 = "tiqff";
		
		boolean thrown = false;
		
		try {
			
			IWriter w1 = WriterFactory.createWriter(dataExtension);
			IWriter w2 = WriterFactory.createWriter(dataExtension2);
		    
			assertTrue(w1.getClass().equals(AscWriter.class));
			assertTrue(w2.getClass().equals(GeotiffWriter.class));
			
			IWriter w3 = WriterFactory.createWriter(dataExtension3);
			
		} catch (WriterException e1) {
			// TODO Auto-generated catch block
			thrown = true;
		}
		
		assertTrue(thrown);
		
	}

}
