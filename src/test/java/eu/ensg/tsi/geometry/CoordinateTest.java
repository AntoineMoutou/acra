package eu.ensg.tsi.geometry;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTest {

	@Test
	public void testCoordinate() {
		
		// the default constructor creates a new Coordinate object with x = 0.0 and y = 0.0
		Coordinate coordinate = new Coordinate(); 
		coordinate.setX(15);
		coordinate.setY(14);
		
		assertTrue(Math.abs(coordinate.getX() - 15) < 0.0000000000000001);
		assertTrue(Math.abs(coordinate.getY() - 14) < 0.0000000000000001);
	}

	@Test
	public void testCoordinateDoubleDouble() {
		
		// this constructor creates a new Coordinate object with coordinates (a, b) set in the parameters
		double a = 46.5;
		double b = 3;
		Coordinate coordinate = new Coordinate(a, b); 
		
		assertTrue(Math.abs(coordinate.getX() - a) < 0.0000000000000001);
		assertTrue(Math.abs(coordinate.getY() - b) < 0.0000000000000001);
	}

	@Test
	public void testEqualsCoordinate() {
		
		double a = 46.5;
		double b = 3;
		double c = 2;
		Coordinate c1 = new Coordinate(a, b);
		Coordinate c2 = new Coordinate(a, b);
		Coordinate c3 = new Coordinate(b, c);
		Coordinate c4 = new Coordinate(a, c);
		
		assertTrue(c1.equals(c2));
		assertTrue(!(c1.equals(c3)));
		assertTrue(!(c3.equals(c4)));
		assertTrue(!(c2.equals(c4)));
	}

	@Test
	public void testToString() {
		
		double a = 46.5;
		double b = 3;
		Coordinate coordinate = new Coordinate(a, b); 
		String result = "[ " + a + " " + b + " ]";
		
		assertEquals(coordinate.toString(), result);
	}

}
