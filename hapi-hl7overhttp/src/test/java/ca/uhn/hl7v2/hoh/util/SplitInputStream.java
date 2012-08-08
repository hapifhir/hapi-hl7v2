package ca.uhn.hl7v2.hoh.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;

public class SplitInputStream extends InputStream {

	private int myBytesUntilSplit;
	private InputStream myWrap;

	public SplitInputStream(InputStream theWrap, int theSplitPoint) {
		myBytesUntilSplit = theSplitPoint;
		myWrap = theWrap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.InputStream#read(byte[])
	 */
	@Override
	public int read(byte[] theB) throws IOException {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.InputStream#read(byte[], int, int)
	 */
	@Override
	public int read(byte[] theB, int theOff, int theLen) throws IOException {
		if (myBytesUntilSplit < 0) {
			// nothing
		} else if (myBytesUntilSplit > 0 && theLen > myBytesUntilSplit) {
			theLen = myBytesUntilSplit;
		} else {
			myBytesUntilSplit = -1;
			theLen = 0;
			throw new SocketTimeoutException();
		}
		int retVal = myWrap.read(theB, theOff, theLen);
		myBytesUntilSplit -= retVal;
		return retVal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.InputStream#skip(long)
	 */
	@Override
	public long skip(long theN) throws IOException {
		myBytesUntilSplit -= theN;
		return myWrap.skip(theN);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.InputStream#available()
	 */
	@Override
	public int available() throws IOException {
		return myBytesUntilSplit >= 0 ? Math.min(myBytesUntilSplit, myWrap.available()) : myWrap.available();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.InputStream#close()
	 */
	@Override
	public void close() throws IOException {
		myWrap.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.InputStream#mark(int)
	 */
	@Override
	public synchronized void mark(int theReadlimit) {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.InputStream#reset()
	 */
	@Override
	public synchronized void reset() throws IOException {
		throw new UnsupportedOperationException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.InputStream#markSupported()
	 */
	@Override
	public boolean markSupported() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int read() throws IOException {
		if (myBytesUntilSplit == 0) {
			myBytesUntilSplit--;
			throw new SocketTimeoutException();
		}
		int retVal = myWrap.read();
		if (retVal != -1) {
			myBytesUntilSplit--;
		}
		return retVal;
	}

}
