package eu.ensg.tsi.generation;

/**
 * Class to fill a matrix with the Perlin Noise method.
 * @author Antoine
 */
public class PerlinNoiseGenerator implements IGenerator {
	
	/**
	 * The initial matrix of permutation.
	 */
	private static int[] PERMLIST = {151,160,137,91,90,15,131,13,201,95,96,53,194,233,7,225,140,36,103,30,69,
									     142,8,99,37,240,21,10,23,190, 6,148,247,120,234,75,0,26,197,62,94,252,219,
									     203,117,35,11,32,57,177,33,88,237,149,56,87,174,20,125,136,171,168, 68,175,
									     74,165,71,134,139,48,27,166,77,146,158,231,83,111,229,122,60,211,133,230,220,
									     105,92,41,55,46,245,40,244,102,143,54, 65,25,63,161,1,216,80,73,209,76,132,
									     187,208, 89,18,169,200,196,135,130,116,188,159,86,164,100,109,198,173,186,3,
									     64,52,217,226,250,124,123,5,202,38,147,118,126,255,82,85,212,207,206,59,227,
									     47,16,58,17,182,189,28,42,223,183,170,213,119,248,152, 2,44,154,163, 70,221,
									     153,101,155,167, 43,172,9,129,22,39,253, 19,98,108,110,79,113,224,232,178,185,
									     112,104,218,246,97,228,251,34,242,193,238,210,144,12,191,179,162,241,81,51,145,
									     235,249,14,239,107,49,192,214, 31,181,199,106,157,184, 84,204,176,115,121,50,45,
									     127, 4,150,254,138,236,205,93,222,114,67,29,24,72,243,141,128,195,78,66,215,61,
									     156,180};
	
	/**
	 * The persistence value.
	 */
	private static double PER = 0.5;
	
	/**
	 * The amplitude value.
	 */
	private static double AMP = 1.0;
	
	/**
	 * The number of octave.
	 */
	private static int OCT = 5;
	
	/**
	 * The frequency value.
	 */
	private static double FRE = 0.0625; // 1/16
	
	@Override
	public void generate(double[][] data) {
		generatePerlinMatrix(data);
		
	}
	
	/**
	 * Fill a matrix with Perlin Noise values.
	 * @param data the matrix that will contain elevation values.
	 */
	protected static void generatePerlinMatrix(double[][] data) {
		int[] permTable = defPerlin();
		
		mix(permTable);
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				data[i][j] = octaveNoise(j,i,permTable);
			}
		}
	}
	
	/**
	 * Set the initial permutation matrix.
	 * @return the permutation matrix.
	 */
	protected static int[] defPerlin() {
		int[] perm = PERMLIST;
		
		int[] permTable = new int[512];
		
		for(int i = 0; i < permTable.length; i++) {
			permTable[i] = perm[i&255];
		}
		return permTable;
	}
	
	/**
	 * Switch random elements of a matrix.
	 * @param permTable the permutation matrix.
	 */
	private static void mix(int[] permTable) {
		
		for(int i = 0; i < permTable.length; i++) {
			int j = (int) Math.random() * 512;
			int tmp = permTable[i];
			permTable[i] = permTable[j];
			permTable[j] = tmp;
		}
	}
	
	/**
	 * Calculate the values with different octaves.
	 * @param x the x position in the matrix of elevation.
	 * @param y the y position in the matrix of elevation.
	 * @param permTable the matrix of permutation.
	 */
	protected static double octaveNoise(double x, double y, int[] permTable) {
		double persistence = PER;
		double octaves     = OCT;
		double frequency   = FRE;
		double amplitude   = AMP;
		
		double totalValue = 0;
		double maxi = 0;
		
		for(int i = 0; i < octaves; i++) {
			
			totalValue += getPerlinValue(x*frequency, y*frequency, permTable) * amplitude;
			 
			 frequency *= 2;
			 maxi += amplitude;
			 amplitude *= persistence;
			 
		}
		
		return totalValue/maxi;
		
	}
	
	/**
	 * Calculate the value for one octave.
	 * @param x the x position in the matrix of elevation.
	 * @param y the y position in the matrix of elevation.
	 * @param permTable the matrix of permutation.
	 */
	protected static double getPerlinValue(double x, double y, int[] permTable) {

		double unit = 1.0/Math.sqrt(2);
		double[][] gradient2 = {{unit, unit}, {-unit, unit}, {unit, -unit}, {-unit, -unit},{1,0},{-1,0},{0,1},{0,-1}};
		
		// get positions of the linked grid
		int xi = (int) x;
		int yi = (int) y;
		
		// add a mask
		int ii = xi & 255;
		int jj = yi & 255;
		
		// use of modulo 8 to limit grad values
		int grad0 = permTable[ii     + permTable[jj]    ] % 8;
		int grad1 = permTable[ii + 1 + permTable[jj]    ] % 8;
		int grad2 = permTable[ii     + permTable[jj + 1]] % 8;
		int grad3 = permTable[ii + 1 + permTable[jj + 1]] % 8;
		
		//set vectors
		double tempX = x - xi;
		double tempY = y - yi;
		double s = gradient2[grad0][0]*tempX + gradient2[grad0][1]*tempY;
		
		tempX = x - (xi + 1);
	    tempY = y - yi;
	    double t = gradient2[grad1][0]*tempX + gradient2[grad1][1]*tempY;

	    tempX = x - xi;
	    tempY = y - (yi + 1);
	    double u = gradient2[grad2][0]*tempX + gradient2[grad2][1]*tempY;

	    tempX = x - (xi + 1);
	    tempY = y - (yi + 1);
	    double v = gradient2[grad3][0]*tempX + gradient2[grad3][1]*tempY;
		
	    //Smoothing
	    double tmp = x-xi;
	    double Cx = 3 * tmp * tmp - 2 * tmp * tmp * tmp;

	    double Li1 = s + Cx*(t-s);
	    double Li2 = u + Cx*(v-u);

	    tmp = y - yi;
	    double Cy = 3 * tmp * tmp - 2 * tmp * tmp * tmp;

	    return (Li1 + Cy*(Li2-Li1) + 1) / 2;
		
	}		
}
