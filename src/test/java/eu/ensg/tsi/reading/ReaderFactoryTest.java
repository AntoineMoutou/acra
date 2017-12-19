package eu.ensg.tsi.reading;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.ensg.tsi.exception.ReaderException;

public class ReaderFactoryTest {

	@Test
	public void testCreateReader() {
		
		String pathname = "bonjour.shp";
		String pathname2 = "salut.tif";
		String pathname3 = "ciao.tiqff";
		
		boolean thrown = false;
		
		try {
			
			IReader w1 = ReaderFactory.createReader(pathname);
			IReader w2 = ReaderFactory.createReader(pathname2);
		    
			assertTrue(w1.getClass().equals(ShapefileReader.class));
			assertTrue(w2.getClass().equals(GeotiffReader.class));
			
			IReader w3 = ReaderFactory.createReader(pathname3);
			
		} catch (ReaderException e1) {
			// TODO Auto-generated catch block
			thrown = true;
		}
		
		assertTrue(thrown);
	}

}
