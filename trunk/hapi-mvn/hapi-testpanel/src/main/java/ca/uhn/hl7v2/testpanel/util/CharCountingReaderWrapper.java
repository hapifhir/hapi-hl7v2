package ca.uhn.hl7v2.testpanel.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

public class CharCountingReaderWrapper extends Reader {

	private long myCount = 0;
	private Reader myWrap;

	public CharCountingReaderWrapper(Reader theWrap) {
		myWrap = theWrap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Reader#close()
	 */
	@Override
	public void close() throws IOException {
		myWrap.close();
	}

	/**
	 * @return the count
	 */
	public long getCount() {
		return myCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Reader#mark(int)
	 */
	@Override
	public void mark(int theReadAheadLimit) throws IOException {
		myWrap.mark(theReadAheadLimit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Reader#markSupported()
	 */
	@Override
	public boolean markSupported() {
		return myWrap.markSupported();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Reader#read()
	 */
	@Override
	public int read() throws IOException {
		int read = myWrap.read();
		myCount++;
		return read;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Reader#read(char[])
	 */
	@Override
	public int read(char[] theCbuf) throws IOException {
		int read = myWrap.read(theCbuf);
		myCount += read;
		return read;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Reader#read(char[], int, int)
	 */
	@Override
	public int read(char[] theCbuf, int theOff, int theLen) throws IOException {
		int read = myWrap.read(theCbuf, theOff, theLen);
		myCount += read;
		return read;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Reader#read(java.nio.CharBuffer)
	 */
	@Override
	public int read(CharBuffer theTarget) throws IOException {
		int read = myWrap.read(theTarget);
		myCount += read;
		return read;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Reader#ready()
	 */
	@Override
	public boolean ready() throws IOException {
		return myWrap.ready();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Reader#reset()
	 */
	@Override
	public void reset() throws IOException {
		myCount = 0;
		myWrap.reset();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.Reader#skip(long)
	 */
	@Override
	public long skip(long theN) throws IOException {
		long skip = myWrap.skip(theN);
		myCount += skip;
		return skip;
	}

}
