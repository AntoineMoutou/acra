package eu.ensg.tsi.reading;

import java.io.File;
import java.io.IOException;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.io.AbstractGridFormat;
import org.geotools.coverage.grid.io.GridCoverage2DReader;
import org.geotools.coverage.grid.io.GridFormatFinder;
import org.geotools.geometry.jts.ReferencedEnvelope;
import org.geotools.referencing.CRS;
import org.opengis.geometry.BoundingBox;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.TransformException;

import eu.ensg.tsi.geometry.Bound;
import eu.ensg.tsi.geometry.Coordinate;

public class GeotiffReader implements IReader {

	public GeotiffReader() {
		// TODO Auto-generated constructor stub
	}

	public Bound getBoundOfData(String pathname) {
			
		BoundingBox bounds = getBoundingBox(pathname);
	    
	    double maxX = bounds.getMaxX();
        double maxY = bounds.getMaxY();
        double minX = bounds.getMinX();
        double minY = bounds.getMinY();
        
        Coordinate c1 = new Coordinate(minX,maxY);
        Coordinate c2 = new Coordinate(maxX,maxY);
        Coordinate c3 = new Coordinate(minX,minY);
        Coordinate c4 = new Coordinate(maxX,minY);
        	        
        return new Bound(c1,c2,c3,c4);
		
	}
	
	public ReferencedEnvelope getReferencedEnvelope(String pathname) {
		        
		BoundingBox bounds = getBoundingBox(pathname);
		ReferencedEnvelope env = new ReferencedEnvelope(bounds);
		return env;
			
		
	}
	
	protected static BoundingBox getBoundingBox(String pathname) {
		File file = new File(pathname);
	    
		AbstractGridFormat format = GridFormatFinder.findFormat(file);
		GridCoverage2DReader reader = format.getReader(file);
		
		GridCoverage2D coverage;
		try {
			coverage = (GridCoverage2D) reader.read(null);
			CoordinateReferenceSystem crs = CRS.decode(DEFAULT_CRS);
			BoundingBox bounds = coverage.getEnvelope2D().toBounds(crs);
	        	        
			return bounds;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAuthorityCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
