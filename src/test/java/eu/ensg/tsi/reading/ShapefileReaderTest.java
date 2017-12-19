package eu.ensg.tsi.reading;

import static org.junit.Assert.*;

import org.junit.Test;

import eu.ensg.tsi.geometry.Bound;

public class ShapefileReaderTest {

	@Test
	public void testGetBoundOfData() {
		
		ShapefileReader s = new ShapefileReader();
		
		Bound b = s.getBoundOfData("data/shp/sentiers_bdtopo.shp");
		
		String result = "[ [ 946532.6 6518015.4 ] [ 952637.5 6518015.4 ] [ 946532.6 6504465.6 ] [ 952637.5 6504465.6 ] ]";
		
		assertTrue(result.equals(b.toString()));
		
	}

}
