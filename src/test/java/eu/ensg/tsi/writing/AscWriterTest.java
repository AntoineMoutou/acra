package eu.ensg.tsi.writing;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.mockito.Mockito;

import eu.ensg.tsi.geometry.Bound;
import eu.ensg.tsi.geometry.Coordinate;
import eu.ensg.tsi.writing.AscWriter;

public class AscWriterTest {

	@Test
	public void testExport() {
		
		double data[][] = {{12,35},{14,56}};
		String pathname = "datatest/writer/asc/test.tif";
		double resolution = 5;
		
		Bound bound = Mockito.mock(Bound.class);
		Coordinate ul = Mockito.mock(Coordinate.class);
		
		Mockito.when(bound.getUl()).thenReturn(ul);
		Mockito.when(ul.getX()).thenReturn(456.32);
		Mockito.when(ul.getY()).thenReturn(56662.85);
		
		AscWriter aw= new AscWriter();
		
		aw.export(data, pathname, resolution, bound);
		
		assertTrue(new File(pathname + ".asc").exists());

		
	}

}
