package eu.ensg.tsi.acra;

import eu.ensg.tsi.exception.GeneratorException;
import eu.ensg.tsi.exception.ReaderException;
import eu.ensg.tsi.exception.WriterException;
import eu.ensg.tsi.generation.GeneratorFactory;
import eu.ensg.tsi.generation.IGenerator;
import eu.ensg.tsi.geometry.Bound;
import eu.ensg.tsi.reading.IReader;
import eu.ensg.tsi.reading.ReaderFactory;
import eu.ensg.tsi.writting.IWriter;
import eu.ensg.tsi.writting.WriterFactory;

public class Area {
	
	private double data[][];
	private int width; // width of the final image in pixel
	private int height; // height of the final image in pixel
	private Bound bound;
	
	private String pathname;
	private double resolution; // pixel size in meter
	private String methodTag;
	private String exportDataExtension;
	
	// default constructor, only used for unit tests
	protected Area() {
		this.resolution = 0;
		this.pathname = null;
		this.methodTag = null;
		this.exportDataExtension = null;
		this.data = null;
		this.width = 0;
		this.height = 0;
		this.bound = null;
	}

	public Area(String pathname, String methodTag, String exportDataExtension, double res) throws Exception {
		
		this.resolution = res;
		this.pathname = pathname;
		this.methodTag = methodTag;
		this.exportDataExtension = exportDataExtension;
		
		this.setBoundOfData();		
		this.setWidth();
		this.setHeight();

		this.setData();
		
	}
	
	public static void main(String args[]) throws Exception {
		
		Area area = new Area("data/shp/sentiers_bdtopo.shp","perlinNoise","tif",100.0);
		//Area area = new Area("data/oraison-IRC-2010-050m-crop2.tif","perlinNoise","tif",10.0);
		area.generate();
		area.export();
		
	}
	
	// other methods
	public void generate() throws GeneratorException {
		IGenerator g = GeneratorFactory.createGenerator(this.methodTag);
		g.generate(this.data);
	}
	
	public void export() throws WriterException, ReaderException {
		IWriter w = WriterFactory.createWriter(exportDataExtension);
		w.export(this.data,this.pathname);
	}
	
	// void setters 
	protected void setData() {
		this.data = new double[this.height][this.width];
	}

	protected void setHeight() {
		// TODO Auto-generated method stub
		this.height = (int)((this.bound.getUl().getY() - this.bound.getBl().getY()) / this.resolution);
	}

	protected void setWidth() {
		// TODO Auto-generated method stub
		this.width = (int)((this.bound.getUr().getX() - this.bound.getUl().getX()) / this.resolution);
	}

	protected void setBoundOfData() throws ReaderException {
		IReader reader = ReaderFactory.createReader(this.pathname);
		this.bound = reader.getBoundOfData(this.pathname);
	}
	
	protected double[][] getData() {
		return data;
	}

	protected void setData(double[][] data) {
		this.data = data;
	}

	protected int getWidth() {
		return width;
	}

	protected void setWidth(int width) {
		this.width = width;
	}

	protected int getHeight() {
		return height;
	}

	protected void setHeight(int height) {
		this.height = height;
	}

	protected Bound getBound() {
		return bound;
	}

	protected void setBound(Bound bound) {
		this.bound = bound;
	}

	protected String getPathname() {
		return pathname;
	}

	protected void setPathname(String pathname) {
		this.pathname = pathname;
	}

	protected double getResolution() {
		return resolution;
	}

	protected void setResolution(double resolution) {
		this.resolution = resolution;
	}

	protected String getMethodTag() {
		return methodTag;
	}

	protected void setMethodTag(String methodTag) {
		this.methodTag = methodTag;
	}

	protected String getExportDataExtension() {
		return exportDataExtension;
	}

	protected void setExportDataExtension(String exportDataExtension) {
		this.exportDataExtension = exportDataExtension;
	}
	
	
}
