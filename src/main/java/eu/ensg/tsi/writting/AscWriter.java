package eu.ensg.tsi.writting;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import eu.ensg.tsi.geometry.Bound;

public class AscWriter implements IWriter {

	public AscWriter() {
		// TODO Auto-generated constructor stub
	}

	public void export(double data[][], String pathname, double resolution, Bound bound) {
		
		BufferedWriter bw = null;
		FileWriter fw = null;

		String content = "";
		content += "ncols "         + data[0].length       + "\n" ;
		content += "nrows "         + data.length          + "\n" ;
		content += "xllcorner "     + bound.getUl().getX() + "\n" ;
		content += "yllcorner "     + bound.getUl().getY() + "\n" ;
		content += "cellsize "      + resolution           + "\n" ;
		content += "NODATA_value " + "-9999"              + "\n" ;
		
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[0].length; j++) {
				if(j==0) {
					content += data[i][j];
				}
				else {
					content +=  " " + data[i][j];
				}
			}
			content += "\n";
		}

		try {
			fw = new FileWriter(pathname + ".asc");
			bw = new BufferedWriter(fw);
			bw.write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
