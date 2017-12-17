package eu.ensg.tsi.acra;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import eu.ensg.tsi.generation.IGenerator;
import eu.ensg.tsi.geometry.Bound;
import eu.ensg.tsi.geometry.Coordinate;
import eu.ensg.tsi.reading.IReader;
import eu.ensg.tsi.writting.IWritter;

public class AeraTest {

	@Test
	public void testAera() {
		//  create mocks
		IReader reader = Mockito.mock(IReader.class);
		IGenerator generator = Mockito.mock(IGenerator.class);
		IWritter writter = Mockito.mock(IWritter.class);
		Bound bound = Mockito.mock(Bound.class);
		Coordinate ul = Mockito.mock(Coordinate.class);
		Coordinate bl = Mockito.mock(Coordinate.class);
		Coordinate ur = Mockito.mock(Coordinate.class);
		
		// other variables
		String pathname = "/test/img.tif";
		double resolution = 25;
		
        // define return value for bound and reader methods
		Mockito.when(reader.getBoundOfData(pathname)).thenReturn(bound);
		Mockito.when(bound.getBl()).thenReturn(bl);
		Mockito.when(bound.getUl()).thenReturn(ul);
		Mockito.when(bound.getUr()).thenReturn(ur);
		Mockito.when(bl.getY()).thenReturn(150.0);
		Mockito.when(ul.getX()).thenReturn(150.0);
		Mockito.when(ul.getY()).thenReturn(300.0);
		Mockito.when(ur.getX()).thenReturn(450.0);
		
		// create Area object with constructor
		Aera aera = new Aera(reader, generator, writter, pathname, resolution);
		
		// define return value for method equals()
        Mockito.when(bound.equals(aera.getBound())).thenReturn(true);
		        
		// Expected values
        int width = 300; 
        int height = 150;
        
        // use mock in test
        assertTrue(bound.equals(aera.getBound()));
        assertTrue(pathname.equals(aera.getPathname()));
        assertTrue(Math.abs(resolution-aera.getResolution())<0.000000000000001); //double equality
        assertTrue(width == aera.getWidth());
        assertTrue(height == aera.getHeight());        
	}   

	@Test
	public void testSetData() {
		
	}

	@Test
	public void testSetHeight() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetWidth() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBoundOfData() {
		fail("Not yet implemented");
	}

	@Test
	public void testGenerate() {
		fail("Not yet implemented");
	}

	@Test
	public void testExport() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetResolution() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetReaderAndPathname() {
		fail("Not yet implemented");
	}

}
