package eu.ensg.tsi.geometry;

public class Bound {
	
	private Coordinate ul;
	private Coordinate ur;
	private Coordinate bl;
	private Coordinate br;	

	public Bound() {
		this.ul = new Coordinate();
		this.ur = new Coordinate();
		this.bl = new Coordinate();
		this.br = new Coordinate();
	}
	
	public Bound(Coordinate upperLeft, Coordinate upperRight, Coordinate bottomLeft, Coordinate bottomRight) {
		this.ul = upperLeft;
		this.ur = upperRight;
		this.bl = bottomLeft;
		this.br = bottomRight;
	}
	
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
