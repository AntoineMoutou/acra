package eu.ensg.tsi.writing;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.mockito.Mockito;

import eu.ensg.tsi.exception.ReaderException;
import eu.ensg.tsi.geometry.Bound;
import eu.ensg.tsi.geometry.Coordinate;
import eu.ensg.tsi.writing.GeotiffWriter;

public class GeotiffWriterTest {

	@Test
	public void testExport() throws ReaderException {

		double data[][] = {{12,35},{14,56}};
		String pathname = "datatest/writer/tif/oraison-IRC-2010-050m-crop2.tif";
		double resolution = 5;
		
		Bound bound = Mockito.mock(Bound.class);
		Coordinate ul = Mockito.mock(Coordinate.class);
		
		Mockito.when(bound.getUl()).thenReturn(ul);
		Mockito.when(ul.getX()).thenReturn(456.32);
		Mockito.when(ul.getY()).thenReturn(56662.85);
		
		GeotiffWriter aw= new GeotiffWriter();
		
		aw.export(data, pathname, resolution, bound);
		
		assertTrue(new File(pathname + ".tif").exists());
	}

}
