package eu.ensg.tsi.geometry;
/**
 * Class that contains the vertices of the extent of the input file
 * @author Antoine
 *
 */
public class Bound {
	/**
	 * The upper-left value
	 */
	private Coordinate ul;
	
	/**
	 * The upper-right value
	 */
	private Coordinate ur;
	
	/**
	 * The bottom-left value
	 */
	private Coordinate bl;
	
	/**
	 * The bottom-right value
	 */
	private Coordinate br;	

	/**
	 * Default constructor
	 */
	public Bound() {
		this.ul = new Coordinate();
		this.ur = new Coordinate();
		this.bl = new Coordinate();
		this.br = new Coordinate();
	}
	
	/**
	 * Constructor with parameters
	 * @param upperLeft the upper-left value
	 * @param upperRight the upper-right value
	 * * @param bottomLeft the bottom-left value
	 * @param bottomRight the bottom-right value
	 */
	public Bound(Coordinate upperLeft, Coordinate upperRight, Coordinate bottomLeft, Coordinate bottomRight) {
		this.ul = upperLeft;
		this.ur = upperRight;
		this.bl = bottomLeft;
		this.br = bottomRight;
	}
	
	/**
	 * Equality between bound objects
	 * @param bound the other bound object to compare
	 */
	public boolean equals(Bound bound) {
		boolean b1 = this.ul.equals(bound.getUl());
		boolean b2 = this.ur.equals(bound.getUr());
		boolean b3 = this.bl.equals(bound.getBl());
		boolean b4 = this.br.equals(bound.getBr());
		return b1 && b2 && b3 && b4;
	}
	
	@Override
	public String toString() {
		return "[ " + this.ul.toString() + " " + this.ur.toString() + " " + this.bl.toString() + " " + this.br.toString() + " ]" ;
	}

	// Getters and Setters --------------------------------------------
	public Coordinate getUl() {
		return ul;
	}

	public void setUl(Coordinate ul) {
		this.ul = ul;
	}

	public Coordinate getUr() {
		return ur;
	}

	public void setUr(Coordinate ur) {
		this.ur = ur;
	}

	public Coordinate getBl() {
		return bl;
	}

	public void setBl(Coordinate bl) {
		this.bl = bl;
	}

	public Coordinate getBr() {
		return br;
	}

	public void setBr(Coordinate br) {
		this.br = br;
	}

}
