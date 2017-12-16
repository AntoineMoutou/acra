package eu.ensg.tsi.geometry;

public class Coordinate {
	
	private double x;
	private double y;

	public Coordinate() {
		this.x = 0;
		this.y = 0;
	}
	
	public Coordinate(double a, double b) {
		this.x = a;
		this.y = b;
	}
	
	public boolean equals(Coordinate coordinate) {
		boolean b1 = (Math.abs(this.x - coordinate.getX()) < 0.000000000000001);
		boolean b2 = (Math.abs(this.y - coordinate.getY()) < 0.000000000000001);
		return (b1 && b2);
	}
	
	@Override
	public String toString() {
		return "[ " + this.x + " " + this.y + " ]";
	}

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
