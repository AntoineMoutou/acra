package eu.ensg.tsi.generation;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomGeneratorTest {

	@Test
	public void testGenerate() {
		
		double data[][] = new double[10][10];
		IGenerator generator = new RandomGenerator();
		generator.generate(data);
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[0].length; j++) {
				assertTrue((data[i][j] >= 0) || (data[i][j] <= 2000));
			}
		}
		
	}

}
