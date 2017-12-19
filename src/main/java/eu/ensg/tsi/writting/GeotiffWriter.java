package eu.ensg.tsi.writting;

import java.io.File;

import org.geotools.coverage.grid.GridCoverage2D;
import org.geotools.coverage.grid.GridCoverageFactory;
import org.geotools.coverage.grid.io.AbstractGridFormat;
import org.geotools.gce.geotiff.GeoTiffFormat;
import org.geotools.gce.geotiff.GeoTiffWriteParams;
import org.geotools.gce.geotiff.GeoTiffWriter;
import org.geotools.geometry.jts.ReferencedEnvelope;
import org.opengis.parameter.GeneralParameterValue;
import org.opengis.parameter.ParameterValueGroup;

import eu.ensg.tsi.exception.ReaderException;
import eu.ensg.tsi.reading.IReader;
import eu.ensg.tsi.reading.ReaderFactory;

public class GeotiffWriter implements IWriter {

	public GeotiffWriter() {
		// TODO Auto-generated constructor stub
	}

	public void export(double data[][], String pathname) throws ReaderException {
		
		float[][] exportData = new float[data.length][data[0].length];
		
		for(int i = 0; i < exportData.length; i++) {
			for(int j = 0; j < exportData[0].length; j++) {
				exportData[i][j] = (float) data[i][j];
			}
		}
		
		IReader reader = ReaderFactory.createReader(pathname);
		ReferencedEnvelope refEnvelope = reader.getReferencedEnvelope(pathname);
		
	    GridCoverage2D coverage = new GridCoverageFactory().create("OTPAnalyst", exportData, refEnvelope);
	    try {
	        GeoTiffWriteParams wp = new GeoTiffWriteParams();
	        wp.setCompressionMode(GeoTiffWriteParams.MODE_EXPLICIT);
	        wp.setCompressionType("LZW");
	        ParameterValueGroup params = new GeoTiffFormat().getWriteParameters();
	        params.parameter(AbstractGridFormat.GEOTOOLS_WRITE_PARAMS.getName().toString()).setValue(wp);
	        GeoTiffWriter writer = new GeoTiffWriter(new File(pathname + ".tif"));
	        writer.write(coverage, (GeneralParameterValue[]) params.values().toArray(new GeneralParameterValue[1]));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
