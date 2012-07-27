package ca.uhn.hl7v2.hoh;

import java.io.IOException;
import java.io.InputStream;

public class Hl7OverHttpDecoder extends AbstractHl7OverHttp {

	private String myUri;


	public void decode() {
		verifyNotUsed();

	}


	/**
	 * @return the uri
	 */
	public String getUri() {
		return myUri;
	}


	/**
	 * Note that if {@link #setUri(String)} is called, this method will assume that the first line
	 * of the HTTP request has already been read from the input stream. If {@link #setHeaders(java.util.LinkedHashMap)} 
	 * has been called, this method will assume that the HTTP headers have already been read from the input stream
	 * as well as the double-LF (ASCII-10) that proceeds the headers.
	 * 
	 * @param theInputStream
	 * @throws IOException
	 * @throws DecodeException 
	 */
	public void readHeadersAndContentsFromInputStreamAndDecode(InputStream theInputStream) throws IOException, DecodeException {
		verifyNotUsed();

		if (myUri == null) {
			String firstLine = readLine(theInputStream);
			if (!firstLine.startsWith("POST ")) {
				throw new DecodeException("HTTP request line message is not valid. Only POST action is supported. Request line was: " + firstLine);
			}
			
			firstLine = firstLine.substring(5);
			int nextSpace = firstLine.indexOf(' ');
			if (nextSpace == -1) {
				throw new DecodeException("HTTP request line message is not valid. Not HTTP version found. Request line was: " + firstLine);
			}
			
			String protocolVersion = firstLine.substring(0, nextSpace);
			
		}

	}


	private String readLine(InputStream theInputStream) throws IOException {
		StringBuilder retVal = new StringBuilder();

		while (theInputStream.available() > 0) {
			int b = theInputStream.read();
			if (b == 13) {
				continue;
			} else if (b == 10) {
				break;
			} else {
				retVal.append((char) b);
			}
		}

		return retVal.toString();
	}


	/**
	 * @param theUri
	 *            the uri to set
	 */
	public void setUri(String theUri) {
		myUri = theUri;
	}

}
