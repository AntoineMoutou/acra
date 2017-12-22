package eu.ensg.tsi.geometry;

/**
 * Class to represent point by their coordinates.
 */
public class Coordinate {
	
	/**
     * The coordinate x.
     */
	private double x;
	
	/**
     * The coordinate y.
     */
	private double y;

	/**
     * Default constructor.
     */
	public Coordinate() {
		this.x = 0;
		this.y = 0;
	}
	
	/**
     * Constructor with parameters
     * @param a x coordinate
     * @param b y coordinate
     */
	public Coordinate(double a, double b) {
		this.x = a;
		this.y = b;
	}
	
	/**
     * Equality between two Coordinate objects.
     * @param coordinate the other coordinate object
     */
	public boolean equals(Coordinate coordinate) {
		boolean b1 = (Math.abs(this.x - coordinate.getX()) < 0.000000000000001);
		boolean b2 = (Math.abs(this.y - coordinate.getY()) < 0.000000000000001);
		return (b1 && b2);
	}
	
	@Override
	public String toString() {
		return "[ " + this.x + " " + this.y + " ]";
	}

	// Getters and Setters --------------------------------------------
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
