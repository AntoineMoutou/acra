package eu.ensg.tsi.writting;

import eu.ensg.tsi.exception.ReaderException;
import eu.ensg.tsi.geometry.Bound;

public interface IWriter {

	public abstract void export(double data[][], String pathname, double resolution, Bound bound) throws ReaderException;
}
