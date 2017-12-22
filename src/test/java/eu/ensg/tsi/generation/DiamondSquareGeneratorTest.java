package eu.ensg.tsi.generation;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiamondSquareGeneratorTest {

	@Test
	public void testGenerate() {
		DiamondSquareGenerator png = new DiamondSquareGenerator();
		double[][] data = new double[16][16];
		png.generate(data);
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				assertTrue(data[i][j]>0);
			}
		}
		
	}

	@Test
	public void testSetSize() {
		double[][] data = new double[16][16];
		int res = DiamondSquareGenerator.setSize(data);
		
		assertTrue(res == 17);
	}

	@Test
	public void testFillWith() {
		double[][] data = {{1,2,3,4,5},{5,6,7,8,9},{9,0,1,2,3},{3,4,5,6,7},{7,8,9,0,1}};
		double[][] dataToFill = new double[4][4];
		double[][] res = {{1,2,3,4},{5,6,7,8},{9,0,1,2},{3,4,5,6}};
		DiamondSquareGenerator.fillWith(dataToFill, data);
		
		for (int i = 0; i < dataToFill.length; i++) {
			for (int j = 0; j < dataToFill[0].length; j++) {
				assertTrue(Math.abs(dataToFill[i][j] - res[i][j]) < 0.000000000000001);
			}
		}
	}

	@Test
	public void testCreate() {
		double[][] data = DiamondSquareGenerator.create(17);
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				assertTrue(data[i][j]>0);
			}
		}
	}

}
