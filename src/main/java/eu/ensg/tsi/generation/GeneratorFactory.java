package eu.ensg.tsi.generation;

import eu.ensg.tsi.exception.GeneratorException;

/**
 * Factory class for the generation methods.
 */
public class GeneratorFactory {
	
	/**
     * Generation creation method from its chosen extension.
     * @param methodTag the chosen method of DEM generation.
     * @return an instance of the corresponding generator.
     * @throws GeneratorException 
     */
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
