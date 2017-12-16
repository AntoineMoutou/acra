package eu.ensg.tsi.reading;

import eu.ensg.tsi.geometry.Bound;

public interface IReader {

	public abstract Bound getBoundOfData(String pathname);
}
