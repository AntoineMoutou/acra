package eu.ensg.tsi.reading;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.geotools.data.DataStore;
import org.geotools.data.DataStoreFinder;
import org.geotools.data.Query;
import org.geotools.data.simple.SimpleFeatureSource;
import org.geotools.feature.FeatureCollection;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;
import org.opengis.filter.Filter;
import org.opengis.geometry.BoundingBox;

import eu.ensg.tsi.geometry.Bound;
import eu.ensg.tsi.geometry.Coordinate;

public class ShapefileReader implements IReader {

	public ShapefileReader() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Bound getBoundOfData(String pathname) {
		
		File file = new File(pathname);
		        
		Map<String, URL> map = new HashMap<String, URL>();      
		try {
			map.put("url", file.toURI().toURL());
			DataStore dataStore = DataStoreFinder.getDataStore(map);
			SimpleFeatureSource featureSource = dataStore.getFeatureSource(dataStore.getTypeNames()[0]);
			SimpleFeatureType schema = featureSource.getSchema();
			Query query = new Query( schema.getTypeName(), Filter.INCLUDE );
			BoundingBox bounds = featureSource.getBounds( query );
			if( bounds == null ){
			   // information was not available in the header
			   FeatureCollection<SimpleFeatureType, SimpleFeature> collection = featureSource.getFeatures( query );
			   bounds = collection.getBounds();
			}
			System.out.println("The features are contained within "+bounds );
	        
            double maxX = bounds.getMaxX();
            double maxY = bounds.getMaxY();
            double minX = bounds.getMinX();
            double minY = bounds.getMinX();
            
            Coordinate c1 = new Coordinate(minX,maxY);
            Coordinate c2 = new Coordinate(maxX,maxY);
            Coordinate c3 = new Coordinate(minX,minY);
            Coordinate c4 = new Coordinate(maxX,minY);
	        
            return new Bound(c1,c2,c3,c4);
            
        } catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
