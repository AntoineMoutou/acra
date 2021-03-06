package eu.ensg.tsi.acra;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

import eu.ensg.tsi.exception.GeneratorException;
import eu.ensg.tsi.exception.ReaderException;
import eu.ensg.tsi.exception.WriterException;
import eu.ensg.tsi.geometry.Bound;
import eu.ensg.tsi.geometry.Coordinate;

public class AreaTest {

	@Test
	public void testArea() throws Exception {
		
		// initial variables
		String pathname = "data/shp/sentiers_bdtopo.shp";
		String methodTag = "diamondSquare";
		String exportDataExtension = "asc";
		double resolution = 25;
		
		// create Area object with constructor
		Area area = new Area(pathname, methodTag, exportDataExtension, resolution);
		       
		// Expected values
        int width = 380; 
        int height = 790;
        
        
        // use mock in test
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
		double resolution = 5;
		
		area.setHeight(height);
		area.setWidth(width);
		area.setResolution(resolution);
		
		
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
		double resolution = 5;
		
		int res = (int) ((b - a) / resolution);
		
		Bound bound = Mockito.mock(Bound.class);
		Coordinate ul = Mockito.mock(Coordinate.class);
		Coordinate bl = Mockito.mock(Coordinate.class);
		
		Mockito.when(bound.getBl()).thenReturn(bl);
		Mockito.when(bound.getUl()).thenReturn(ul);
		Mockito.when(bl.getY()).thenReturn(a);
		Mockito.when(ul.getY()).thenReturn(b);
		
		area.setBound(bound);
		area.setResolution(resolution);
		
		area.setHeight();
		
		assertTrue(area.getHeight() == res);
	}

	@Test
	public void testSetWidth() {
		
		Area area = new Area();
		
		double a = 150;
		double b = 300;
		double resolution = 5;
		
		int res = (int) ((b - a) / resolution);
		
		Bound bound = Mockito.mock(Bound.class);
		Coordinate ul = Mockito.mock(Coordinate.class);
		Coordinate ur = Mockito.mock(Coordinate.class);
		
		Mockito.when(bound.getUl()).thenReturn(ul);
		Mockito.when(bound.getUr()).thenReturn(ur);
		Mockito.when(ur.getX()).thenReturn(b);
		Mockito.when(ul.getX()).thenReturn(a);
		
		area.setBound(bound);
		area.setResolution(resolution);

		area.setWidth();
		
		assertTrue(area.getWidth() == res);
	}

	@Test
	public void testSetBoundOfData() throws Exception {
		
		Area area = new Area();
		String pathname = "data/shp/sentiers_bdtopo.shp";
		
		area.setPathname(pathname);
		area.setBoundOfData();
		
		String res = "[ [ 686068.0443291274 5735141.707100947 ] [ 695573.352335453 5735141.707100947 ] [ 686068.0443291274 5715370.395842486 ] [ 695573.352335453 5715370.395842486 ] ]";
		
		assertTrue(area.getBound().toString().equals(res));
	}

	@Test
	public void testGenerate() throws GeneratorException {
		Area area = new Area();
		String methodTag = "random";
		area.setMethodTag(methodTag);
		double data[][] = new double[10][10];
		area.setData(data);
		
		area.generate();
		
		assertTrue(area.getMethodTag().equals(methodTag));
		assertTrue(area.getData()[0][0] > 0.0);
	}

	@Test
	public void testExport() throws WriterException, ReaderException {
		Area area = new Area();
		String exportDataExtension = "asc";
		area.setExportDataExtension(exportDataExtension);	
		double data[][] = {{10,15},{20,30}};
		area.setData(data);
		
		//area.export();

		assertTrue(area.getExportDataExtension().equals(exportDataExtension));
		
	}

}
