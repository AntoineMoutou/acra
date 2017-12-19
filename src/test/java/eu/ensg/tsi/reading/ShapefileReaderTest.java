package eu.ensg.tsi.reading;

import static org.junit.Assert.*;

import org.geotools.geometry.jts.ReferencedEnvelope;
import org.junit.Test;

import eu.ensg.tsi.geometry.Bound;

public class ShapefileReaderTest {

	@Test
	public void testGetBoundOfData() {
		
		ShapefileReader s = new ShapefileReader();
		
		Bound b = s.getBoundOfData("data/shp/sentiers_bdtopo.shp");
		
		System.out.println(b);
		
		String result = "[ [ 686068.0443291274 5735141.707100947 ] [ 695573.352335453 5735141.707100947 ] [ 686068.0443291274 5715370.395842486 ] [ 695573.352335453 5715370.395842486 ] ]";
		
		assertTrue(result.equals(b.toString()));
		
	}
	
	@Test
	public void testGetReferencedEnvelope() {
		
		ShapefileReader s = new ShapefileReader();
		
		ReferencedEnvelope b = s.getReferencedEnvelope("data/shp/sentiers_bdtopo.shp");
		
		String result = "ReferencedEnvelope[686068.0443291274 : 695573.352335453, 5715370.395842486 : 5735141.707100947]";
		
		assertTrue(result.equals(b.toString()));
		
	}

}
