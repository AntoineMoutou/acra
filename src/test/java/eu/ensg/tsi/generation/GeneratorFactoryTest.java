package eu.ensg.tsi.generation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eu.ensg.tsi.exception.GeneratorException;

public class GeneratorFactoryTest {

	@Test
	public void testCreateGenerator() {
		
		String methodTag = "diamondSquare";
		String methodTag2 = "random";
		String methodTag3 = "perlinNoise";
		String methodTag4 = "ciao.tiqff";
		
		boolean thrown = false;
		
		try {
			
			IGenerator w1 = GeneratorFactory.createGenerator(methodTag);
			IGenerator w2 = GeneratorFactory.createGenerator(methodTag2);
			IGenerator w3 = GeneratorFactory.createGenerator(methodTag3);
		    
			assertTrue(w1.getClass().equals(DiamondSquareGenerator.class));
			assertTrue(w2.getClass().equals(RandomGenerator.class));
			assertTrue(w3.getClass().equals(PerlinNoiseGenerator.class));
			
			IGenerator w4 = GeneratorFactory.createGenerator(methodTag4);
			
		} catch (GeneratorException e1) {
			// TODO Auto-generated catch block
			thrown = true;
		}
		
		assertTrue(thrown);
	}

}
