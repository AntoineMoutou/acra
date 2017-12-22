package eu.ensg.tsi.acra;

import eu.ensg.tsi.exception.GeneratorException;
import eu.ensg.tsi.exception.ReaderException;
import eu.ensg.tsi.exception.WriterException;
import eu.ensg.tsi.generation.GeneratorFactory;
import eu.ensg.tsi.generation.IGenerator;
import eu.ensg.tsi.geometry.Bound;
import eu.ensg.tsi.reading.IReader;
import eu.ensg.tsi.reading.ReaderFactory;
import eu.ensg.tsi.writing.IWriter;
import eu.ensg.tsi.writing.WriterFactory;


/**
 * Main class, used to generate and export DEM from files.
 * @author Antoine
 */

public class Area {
	
	/**
     * The matrix m x n that contains elevation values.
     */
	private double data[][];
	
	/**
     * The width of the export.
     */
	private int width; 
	
	/**
     * The height of the export.
     */
	private int height;
	
	/**
     * The Bound object that define the extent of the input file.
     */
	private Bound bound;
	
	/**
     * The pathname of the input data.
     */
	private String pathname;
	
	/**
     * The resolution of the exported DEM (pixel size in meters).
     */
	private double resolution; 
	
	/**
     * The method tag that defines the chosen method to generate a DEM.
     */
	private String methodTag;
	
	/**
     * The extension of the export file.
     */
	private String exportDataExtension;
	
	/**
     * Default constructor only used for unit tests.
     */

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
	
	/**
     * Constructor 
     * @param pathname the pathname of the input file
     * @param methodTag the generation method chosen by the user
     * @param exportDataExtension the extension of the export file
     * @param res maximum the resolution of the exported DEM
     */
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
	
	// Methods --------------------------------------------
	
	/**
     * Generates the DEM.
     */
	public void generate() throws GeneratorException {
		IGenerator g = GeneratorFactory.createGenerator(this.methodTag);
		g.generate(this.data);
	}
	
	/**
     * Export the DEM.
     */
	public void export() throws WriterException, ReaderException {
		IWriter w = WriterFactory.createWriter(exportDataExtension);
		w.export(this.data,this.pathname,this.resolution,this.bound);
	}
	
	// Getters and Setters --------------------------------------------
	protected void setData() {
		try {
			this.data = new double[this.height][this.width];
		} catch(OutOfMemoryError e1) {
			e1.printStackTrace();
		}
	}

	protected void setHeight() {
		this.height = (int)((this.bound.getUl().getY() - this.bound.getBl().getY()) / this.resolution);
	}

	protected void setWidth() {
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
