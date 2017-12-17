package eu.ensg.tsi.geometry;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class BoundTest {

	@Test
	public void testBound() {
		//  create mocks
		Coordinate c1 = Mockito.mock(Coordinate.class);
		
		// create Bound object with default constructor
		Bound bound = new Bound();
		
        // define return value for method equals()
		Mockito.when(c1.equals(bound.getUl())).thenReturn(true);
        Mockito.when(c1.equals(bound.getUr())).thenReturn(true);
        Mockito.when(c1.equals(bound.getBl())).thenReturn(true);
        Mockito.when(c1.equals(bound.getBr())).thenReturn(true);

        // use mock in test
        assertTrue(c1.equals(bound.getUl()));
        assertTrue(c1.equals(bound.getUr()));
        assertTrue(c1.equals(bound.getBl()));
        assertTrue(c1.equals(bound.getBr()));
	}

	@Test
	public void testBoundCoordinateCoordinateCoordinateCoordinate() {
		//  create mocks
		Coordinate c1 = Mockito.mock(Coordinate.class);
		Coordinate c2 = Mockito.mock(Coordinate.class);
		Coordinate c3 = Mockito.mock(Coordinate.class);
		Coordinate c4 = Mockito.mock(Coordinate.class);
		
		// create Bound object
		Bound bound = new Bound(c1, c2, c3, c4);
		
        // define return value for method equals()
        Mockito.when(c1.equals(bound.getUl())).thenReturn(true);
        Mockito.when(c2.equals(bound.getUr())).thenReturn(true);
        Mockito.when(c3.equals(bound.getBl())).thenReturn(true);
        Mockito.when(c4.equals(bound.getBr())).thenReturn(true);

        // use mock in test
        assertTrue(c1.equals(bound.getUl()));
        assertTrue(c2.equals(bound.getUr()));
        assertTrue(c3.equals(bound.getBl()));
        assertTrue(c4.equals(bound.getBr()));
	}

	@Test
	public void testEqualsBound() {
		//  create mocks
		Coordinate c1 = Mockito.mock(Coordinate.class);
		Coordinate c2 = Mockito.mock(Coordinate.class);
		Coordinate c3 = Mockito.mock(Coordinate.class);
		Coordinate c4 = Mockito.mock(Coordinate.class);
		Coordinate c5 = Mockito.mock(Coordinate.class);

		// create Bound objects 
		Bound b1 = new Bound(c1, c2, c3, c4);
		Bound b2 = new Bound(c1, c2, c3, c4);
		Bound b3 = new Bound(c1, c2, c3, c5);
		
        // define return value for method equals()
        Mockito.when(c1.equals(c1)).thenReturn(true);
        Mockito.when(c2.equals(c2)).thenReturn(true);
        Mockito.when(c3.equals(c3)).thenReturn(true);
        Mockito.when(c4.equals(c4)).thenReturn(true);
        Mockito.when(c4.equals(c5)).thenReturn(false);

        // use mock in test
        assertTrue(b1.equals(b2));
        assertTrue(!(b1.equals(b3)));
	}

	@Test
	public void testToString() {
		//  create mocks
		Coordinate c1 = Mockito.mock(Coordinate.class);
		Coordinate c2 = Mockito.mock(Coordinate.class);
		Coordinate c3 = Mockito.mock(Coordinate.class);
		Coordinate c4 = Mockito.mock(Coordinate.class);
	
		// create Bound objects 
		Bound b1 = new Bound(c1, c2, c3, c4);
		
		//create the expected result
		String result = "[ " + "[ " + 1 + " " + 1 + " ]" + " " + "[ " + 1 + " " + 1 + " ]" + " " + "[ " + 1 + " " + 1 + " ]" + " " + "[ " + 1 + " " + 1 + " ]" + " ]" ;
		
	    // define return value for method equals()
	    Mockito.when(c1.toString()).thenReturn("[ " + 1 + " " + 1 + " ]");
	    Mockito.when(c2.toString()).thenReturn("[ " + 1 + " " + 1 + " ]");
	    Mockito.when(c3.toString()).thenReturn("[ " + 1 + " " + 1 + " ]");
	    Mockito.when(c4.toString()).thenReturn("[ " + 1 + " " + 1 + " ]");
	
	    // use mock in test
	    assertEquals(b1.toString(), result);
	}

}
