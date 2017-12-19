package eu.ensg.tsi.reading;

import static org.junit.Assert.*;

import org.junit.Test;

import eu.ensg.tsi.geometry.Bound;

public class RasterReaderTest {

	@Test
	public void testGetBoundOfData() {
		
		GeotiffReader s = new GeotiffReader();
		
		Bound b = s.getBoundOfData("data/oraison-IRC-2010-050m-crop2.tif");
				
		String result = "[ [ 932050.0 6317850.0 ] [ 933300.0 6317850.0 ] [ 932050.0 6316600.0 ] [ 933300.0 6316600.0 ] ]";
		
		assertTrue(result.equals(b.toString()));
	}

}
