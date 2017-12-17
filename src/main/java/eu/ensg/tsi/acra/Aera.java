package eu.ensg.tsi.acra;

import eu.ensg.tsi.generation.IGenerator;
import eu.ensg.tsi.geometry.Bound;
import eu.ensg.tsi.reading.IReader;
import eu.ensg.tsi.writting.IWritter;

public class Aera {
	
	private double data[][];
	private int width; // width of the final image in pixel
	private int height; // height of the final image in pixel
	private Bound bound;
	
	private String pathname;
	private double resolution; // pixel size in meter
	private IReader reader;
	private IGenerator generator;
	private IWritter writter;

	public Aera(IReader r, IGenerator g, IWritter w, String pathname, double res) {
		this.reader = r;
		this.generator = g;
		this.writter = w;
		this.resolution = res;
		this.pathname = pathname;
		
		this.setBoundOfData();
		
		this.setWidth();
		this.setHeight();
		
		this.setData();
	}

	// void setters 
	protected void setData() {
		this.data = new double[this.height][this.width];
	}

	protected void setHeight() {
		// TODO Auto-generated method stub
		this.height = (int)(this.bound.getUl().getY() - this.bound.getBl().getY());
	}

	protected void setWidth() {
		// TODO Auto-generated method stub
		this.width = (int)(this.bound.getUr().getX() - this.bound.getUl().getX());
	}

	protected void setBoundOfData() {
		this.bound = this.reader.getBoundOfData(this.pathname);
	}
	
	// other setters
	public void setResolution(double resolution) {
		this.resolution = resolution;
		this.setHeight();
		this.setWidth();
		this.setData();
	}
	
	public void setReaderAndPathname(IReader reader, String pathname) {
		this.reader = reader;
		this.pathname = pathname;
		
		this.setBoundOfData();
		
		this.setWidth();
		this.setHeight();
		
		this.setData();
	}

	public void setGenerator(IGenerator generator) {
		this.generator = generator;
	}
	
	public void setWritter(IWritter writter) {
		this.writter = writter;
	}
	
	// getters
	public IGenerator getGenerator() {
		return generator;
	}
	
	public IWritter getWritter() {
		return writter;
	}

	public IReader getReader() {
		return reader;
	}
	
	public String getPathname() {
		return pathname;
	}

	public double[][] getData() {
		return data;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public Bound getBound() {
		return bound;
	}
	
	public double getResolution() {
		return resolution;
	}

	// other methods
	public void generate() {
		this.generator.generate(this.data);
	}
	
	public void export() {
		this.writter.export(this.data);
	}

}
