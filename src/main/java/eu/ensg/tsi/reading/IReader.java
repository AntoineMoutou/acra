package eu.ensg.tsi.reading;

import org.geotools.geometry.jts.ReferencedEnvelope;

import eu.ensg.tsi.geometry.Bound;

public interface IReader {

	public static final String DEFAULT_CRS = "EPSG:3857";
	
	public abstract Bound getBoundOfData(String pathname);
	
	public abstract ReferencedEnvelope getReferencedEnvelope(String pathname);
}
