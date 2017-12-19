package eu.ensg.tsi.generation;

public class PerlinNoiseGenerator implements IGenerator {
	
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
	
	private static double RES = 0.5;
	private static double AMP = 0.5;

	@Override
	public void generate(double[][] data) {
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[0].length; j++) {
				double tmp = 0;
				for(int k = 1; k < 5; k++ ) {
					tmp += Math.pow(AMP, k) *((getPerlin(i, j, Math.pow(RES, k),data.length, data[0].length ) + 1) * 0.5);
				}
				data[i][j] = tmp;
			}
		}
	}
	
	protected static int[] defPerlin() {
		int[] perm = PERMLIST;
		mixPermList(perm);
		
		int[] permTable = new int[512];
		for(int i = 0; i < permTable.length; i++) {
			permTable[i] = perm[i&255];
		}
		
		return permTable;
	}
	
	protected static void switchElements(int[] permList , int i, int j){

		int tmp = permList[j];
		permList[j] = permList[i];
		permList[i] = tmp;
	}
	
	protected static void mixPermList(int[] permList) {
		for(int i = 0; i < permList.length/2; i++) {
			switchElements(permList, i, (int)(Math.random() * (permList.length -1)));
		}
	}
	
	protected static double getPerlin(int x, int y, double res, int width, int height) {
		
		double unit = 1.0/Math.sqrt(2);
		double[][] gradient2 = {{unit, unit}, {-unit, unit}, {unit, -unit}, {-unit, -unit},{1,0},{-1,0},{0,1},{0,-1}};
		
//		int[] perm = PERMLIST;
		int[] permTable = defPerlin();

		
		// adapt the resolution
		double xd = (double) x / (width * res);
		double yd = (double) y / (height * res);
		
		// get positions of the linked grid
		int xi = (int) xd;
		int yi = (int) yd;
		
		// add a mask
		int ii = xi & 255;
		int jj = yi & 255;
		
		// use of modulo 8 to limit grad values
		int grad0 = permTable[ii + permTable[jj]] % 8;
		int grad1 = permTable[ii + 1 + permTable[jj]] % 8;
		int grad2 = permTable[ii + permTable[jj + 1]] % 8;
		int grad3 = permTable[ii + 1 + permTable[jj + 1]] % 8;
		
		//set vectors
		double tempX = xd - xi;
		double tempY = yd - yi;
		double s = gradient2[grad0][0]*tempX + gradient2[grad0][1]*tempY;
		
		tempX = xd - (xi + 1);
	    tempY = yd - yi;
	    double t = gradient2[grad1][0]*tempX + gradient2[grad1][1]*tempY;

	    tempX = xd - xi;
	    tempY = yd - (yi + 1);
	    double u = gradient2[grad2][0]*tempX + gradient2[grad2][1]*tempY;

	    tempX = xd - (xi + 1);
	    tempY = yd - (yi + 1);
	    double v = gradient2[grad3][0]*tempX + gradient2[grad3][1]*tempY;
		
	    //Smoothing
	    double tmp = xd-xi;
	    double Cx = 3 * tmp * tmp - 2 * tmp * tmp * tmp;

	    double Li1 = s + Cx*(t-s);
	    double Li2 = u + Cx*(v-u);

	    tmp = yd - yi;
	    double Cy = 3 * tmp * tmp - 2 * tmp * tmp * tmp;

	    return Li1 + Cy*(Li2-Li1);
		
	}
	
//	protected static double rand_noise(int t)
//	{
//	    t = (t<<13) ^ t;
//	    t = (t * (t * t * 15731 + 789221) + 1376312589);
//	    return 1.0 - (t & 0x7fffffff) / 1073741824.0;
//	}
//	
//	protected static double noise_2d(int x, int y)
//	{
//	    int tmp = (int) rand_noise(x) * 850000;
//	    return rand_noise(tmp + y);
//	}
//	
//	protected static double noise_nd(int[] data_set, int dim)
//	{
//	    int i;
//	    double r = 0.;
//
//	    for(i = 0; i < dim; i++)
//	        r = rand_noise(data_set[i] + (int)(r * 850000) );
//	    return r;
//	}
//	
//	protected static double linear_interpolate(double a, double b, double t)
//	{
//	    return (1. - t) * a + t * b;
//	}
//	
//	protected static double cosine_interpolate(double a, double b, double t)
//	{
//	    double c = (1 - Math.cos(t * 3.1415927)) * .5;
//
//	    return (1. - c) * a + c * b;
//	}
//	
//	protected static double cubic_interpolate(double before_p0, double p0, double p1, double after_p1, double t)
//	{
//	   //Calcul des coefficients de notre polynôme
//	   double a3 = -0.5*before_p0 + 1.5*p0 - 1.5*p1 + 0.5*after_p1;
//	   double a2 = before_p0 - 2.5*p0 + 2*p1 - 0.5*after_p1;
//	   double a1 = -0.5*before_p0 + 0.5*p1;
//	   double a0 = p0;
//	
//	   //Calcul de la valeur de ce polynôme en t
//	   return (a3 * t*t*t) + (a2 * t*t) + (a1 * t) + a0;
//	   
//	}
//	
//	protected static double smooth_noise_firstdim(int integer_x,int integer_y, double fractional_x)
//	{
//		double v0 = noise_2d(integer_x - 1, integer_y);
//		double v1 = noise_2d(integer_x,     integer_y);
//		double v2 = noise_2d(integer_x + 1, integer_y);
//		double v3 = noise_2d(integer_x + 2, integer_y);
//		
//		return cubic_interpolate(v0, v1, v2, v3, fractional_x);
//	}
//	
//	//Nous interpolons sur les y, en utilisant la fonction précédente
//	protected staticdouble smooth_noise(double x, double y)
//	{
//		int integer_x = (int)x;
//		double fractional_x = x - integer_x;
//		int integer_y = (int)y;
//		double fractional_y = y - integer_y;
//		
//		double t0 = smooth_noise_firstdim(integer_x,
//		                integer_y - 1, fractional_x);
//		double t1 = smooth_noise_firstdim(integer_x,
//		                integer_y,     fractional_x);
//		double t2 = smooth_noise_firstdim(integer_x,
//		                integer_y + 1, fractional_x);
//		double t3 = smooth_noise_firstdim(integer_x,
//		                integer_y + 2, fractional_x);
//		
//		return cubic_interpolate(t0, t1, t2, t3, fractional_y);
//	}
		
}
