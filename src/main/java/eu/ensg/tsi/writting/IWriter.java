package eu.ensg.tsi.writting;

import eu.ensg.tsi.exception.ReaderException;

public interface IWriter {

	public abstract void export(double data[][], String pathname) throws ReaderException;
}
