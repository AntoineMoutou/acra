package eu.ensg.tsi.reading;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.geotools.geometry.jts.ReferencedEnvelope;
import org.junit.Test;
import org.opengis.geometry.BoundingBox;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.operation.TransformException;

import eu.ensg.tsi.geometry.Bound;

public class GeotiffReaderTest {

	@Test
	public void testGetBoundOfData() {
		
		GeotiffReader s = new GeotiffReader();
		
		Bound b = s.getBoundOfData("datatest/reader/tif/oraison-IRC-2010-050m-crop2.tif");
		
		String result = "[ [ 655589.5739447209 5453291.9624824915 ] [ 657384.2875646825 5453291.9624824915 ] [ 655589.5739447209 5451490.972280654 ] [ 657384.2875646825 5451490.972280654 ] ]";
		
		assertTrue(result.equals(b.toString()));
	}
	
	@Test
	public void testGetReferencedEnvelope() {
		
		GeotiffReader s = new GeotiffReader();
		
		ReferencedEnvelope b = s.getReferencedEnvelope("datatest/reader/tif/oraison-IRC-2010-050m-crop2.tif");
		
		String result = "ReferencedEnvelope[655589.5739447209 : 657384.2875646825, 5451490.972280654 : 5453291.9624824915]";
		
		assertTrue(result.equals(b.toString()));
		
	}
	
	@Test
	public void testGetBoundingBox() {
		
		String pathname = "datatest/reader/tif/oraison-IRC-2010-050m-crop2.tif";
		
		BoundingBox bbox = GeotiffReader.getBoundingBox(pathname);
		
		String result = "Envelope2D[(655589.5739447209, 5451490.972280654), (657384.2875646825, 5453291.9624824915)]";
		
		assertTrue(bbox.toString().equals(result));	
		
	}

}
