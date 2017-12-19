package eu.ensg.tsi.generation;

public class RandomGenerator implements IGenerator {

	@Override
	public void generate(double[][] data) {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[0].length; j++) {
				data[i][j] = Math.random() * 2000;
			}
		}

	}

}
