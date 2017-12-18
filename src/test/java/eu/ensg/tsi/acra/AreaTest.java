package eu.ensg.tsi.acra;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import eu.ensg.tsi.generation.IGenerator;
import eu.ensg.tsi.geometry.Bound;
import eu.ensg.tsi.geometry.Coordinate;
import eu.ensg.tsi.reading.IReader;
import eu.ensg.tsi.writting.IWritter;

public class AreaTest {

	@Test
	public void testArea() {
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
		Area area = new Area(reader, generator, writter, pathname, resolution);
		
		// define return value for method equals()
        Mockito.when(bound.equals(area.getBound())).thenReturn(true);
		        
		// Expected values
        int width = 300; 
        int height = 150;
        
        // use mock in test
        assertTrue(bound.equals(area.getBound()));
        assertTrue(pathname.equals(area.getPathname()));
        assertTrue(Math.abs(resolution-area.getResolution())<0.000000000000001); //double equality
        assertTrue(width == area.getWidth());
        assertTrue(height == area.getHeight());        
	}   

	@Test
	public void testSetData() {
		
		Area area = new Area();
		int height = 20;
		int width = 35;
		
		area.setHeight(height);
		area.setWidth(width);
		
		area.setData();
		
		double data[][] = area.getData(); 
		
		assertTrue(data.length == 20);
		assertTrue(data[0].length ==35);
	}

	@Test
	public void testSetHeight() {
		
		Area area = new Area();
		
		double a = 150;
		double b = 300;
		int res = (int) 300 - 150;
		
		Bound bound = Mockito.mock(Bound.class);
		Coordinate ul = Mockito.mock(Coordinate.class);
		Coordinate bl = Mockito.mock(Coordinate.class);
		
		Mockito.when(bound.getBl()).thenReturn(bl);
		Mockito.when(bound.getUl()).thenReturn(ul);
		Mockito.when(bl.getY()).thenReturn(a);
		Mockito.when(ul.getY()).thenReturn(b);
		
		area.setBound(bound);
		
		area.setHeight();
		
		assertTrue(area.getHeight() == res);
	}

	@Test
	public void testSetWidth() {
		
		Area area = new Area();
		
		double a = 150;
		double b = 300;
		int res = (int) 300 - 150;
		
		Bound bound = Mockito.mock(Bound.class);
		Coordinate ul = Mockito.mock(Coordinate.class);
		Coordinate ur = Mockito.mock(Coordinate.class);
		
		Mockito.when(bound.getUl()).thenReturn(ul);
		Mockito.when(bound.getUr()).thenReturn(ur);
		Mockito.when(ur.getX()).thenReturn(b);
		Mockito.when(ul.getX()).thenReturn(a);
		
		area.setBound(bound);
		
		area.setWidth();
		
		assertTrue(area.getWidth() == res);
	}

	@Test
	public void testSetBoundOfData() {
		
		Area area = new Area();
		String pathname = "data/shp/sentiers_bdtopo.shp";
		
		IReader reader = Mockito.mock(IReader.class);
		Bound bound = Mockito.mock(Bound.class);
		
		Mockito.when(reader.getBoundOfData(pathname)).thenReturn(bound);
		Mockito.when(bound.equals(bound)).thenReturn(true);
		
		area.setPathname(pathname);
		area.setReader(reader);
		area.setBoundOfData();
		
		System.out.println(bound);
		System.out.println(area.getBound());
		
		assertTrue(bound.equals(area.getBound()));
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
