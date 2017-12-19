package eu.ensg.tsi.generation;

import eu.ensg.tsi.exception.GeneratorException;

public class GeneratorFactory {

	public GeneratorFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static IGenerator createGenerator(String methodTag) throws GeneratorException {

		switch (methodTag)
		{
			case "diamondSquare":
				return new DiamondSquareGenerator();
			case "random":
				return new RandomGenerator(); 
			case "perlinNoise":
				return new PerlinNoiseGenerator(); 
			default:
				throw new GeneratorException() ;             
		}
	}

}
