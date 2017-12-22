package eu.ensg.tsi.generation;

/**
 * Class to fill a matrix with random values.
 * @author Antoine
 */

public class RandomGenerator implements IGenerator {

	/**
	 * Fill a matrix with random values.
	 * @param data the matrix that will contain elevation values.
	 */
	@Override
	public void generate(double[][] data) {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[0].length; j++) {
				data[i][j] = Math.random() * 2000;
			}
		}

	}

}
