package eu.ensg.tsi.generation;

import static org.junit.Assert.*;

import org.junit.Test;

public class PerlinNoiseGeneratorTest {

	@Test
	public void testGenerate() {
		PerlinNoiseGenerator png = new PerlinNoiseGenerator();
		double[][] data = new double[16][16];
		png.generate(data);
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				assertTrue(data[i][j]<1 && data[i][j]>0);
			}
		}
	}

	@Test
	public void testGeneratePerlinMatrix() {
		double[][] data = new double[16][16];
		PerlinNoiseGenerator.generatePerlinMatrix(data);
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				assertTrue(data[i][j]<1 && data[i][j]>0);
			}
		}
	}

	@Test
	public void testDefPerlin() {
		int[] table = PerlinNoiseGenerator.defPerlin();
		int[] res = new int[256];
		
		for (int i = 0; i < table.length; i++) {
			res[table[i]] += 1;
		}
		
		for (int i = 0; i < res.length; i++) {
			assertTrue(res[i] == 2);
		}
	}

	@Test
	public void testOctaveNoise() {
		int[] table = PerlinNoiseGenerator.defPerlin();
		
		double res = PerlinNoiseGenerator.octaveNoise(25, 56, table);
		
		assertTrue(res<1 && res>0);
	}

	@Test
	public void testGetPerlinValue() {
		int[] table = PerlinNoiseGenerator.defPerlin();
		
		double res = PerlinNoiseGenerator.getPerlinValue(25, 56, table);
		
		assertTrue(res<1 && res>0);
	}

}
