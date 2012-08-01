package ca.uhn.hl7v2.hoh.encoder;

import static org.apache.commons.lang.StringUtils.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.util.GZipUtils;

public abstract class AbstractHl7OverHttpDecoder extends AbstractHl7OverHttp {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(AbstractHl7OverHttpDecoder.class);
	private byte[] myBytes;
	private List<String> myConformanceProblems;
	private int myContentLength = -1;
	private String myContentType;
	private boolean myGzipCoding;
	private String myResponseName;
	private Integer myResponseStatus;
	private TransferEncoding myTransferEncoding;

	private void addConformanceProblem(String theString) {
		ourLog.debug("Conformance problem detected: {}", theString);
		if (myConformanceProblems == null) {
			myConformanceProblems = new ArrayList<String>();
		}
		myConformanceProblems.add(theString);
	}

	public void decode() throws DecodeException {
		verifyNotUsed();

		decodeHeaders();
		authorize();
		decodeBody();
	}

	protected abstract void authorize() throws AuthorizationFailureException;

	private void decodeBody() throws DecodeException {
		byte[] bytes = myBytes;

		if (myTransferEncoding == TransferEncoding.CHUNKED) {
			ourLog.debug("Decoding message bytes using CHUNKED encoding style");
			byte[] newBytes = new byte[bytes.length];
			int nextOffset = 0;

			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			while (bis.available() > 0) {
				String nextSize;
				try {
					nextSize = readLine(bis);
				} catch (IOException e) {
					throw new DecodeException("Failed to decode CHUNKED encoding", e);
				}

				int nextSizeInt;
				try {
					nextSizeInt = Integer.parseInt(nextSize, 16);
				} catch (NumberFormatException e) {
					throw new DecodeException("Failed to decode CHUNKED encoding", e);
				}

				int bytesRead = bis.read(newBytes, nextOffset, nextSizeInt);
				nextOffset += bytesRead;

				int nextChar;
				do {
					nextChar = bis.read();
				} while (nextChar != -1 && (nextChar == 13 || nextChar == 13));

			}

			bytes = Arrays.copyOfRange(newBytes, 0, nextOffset);
		}

		if (myGzipCoding) {
			ourLog.debug("Decoding message contents using GZIP encoding style");
			try {
				bytes = GZipUtils.uncompress(bytes);
			} catch (IOException e) {
				throw new DecodeException("Failed to uncompress GZip content", e);
			}
		}

		ourLog.debug("Message is {} bytes with charset {}", bytes.length, getCharset().name());
		setMessage(new String(bytes, getCharset()));
	}

	private void decodeHeaders() throws DecodeException {

		for (Map.Entry<String, String> nextEntry : getHeaders().entrySet()) {
			String nextHeader = nextEntry.getKey().toLowerCase();
			String nextValue = nextEntry.getValue();

			if ("transfer-encoding".equals(nextHeader)) {
				if ("chunked".equalsIgnoreCase(nextValue)) {
					myTransferEncoding = TransferEncoding.CHUNKED;
				} else {
					throw new DecodeException("Unknown transfer encoding: " + nextValue);
				}
			} else if ("content-length".equals(nextHeader)) {
				try {
					myContentLength = Integer.parseInt(nextValue);
				} catch (NumberFormatException e) {
					addConformanceProblem("Could not parse Content-Length header value: " + nextHeader);
				}
			} else if ("content-type".equals(nextHeader)) {
				int colonIndex = nextValue.indexOf(';');
				if (colonIndex == -1) {
					myContentType = nextValue;
				} else {
					myContentType = nextValue.substring(0, colonIndex);
					String charsetDef = nextValue.substring(colonIndex + 1).trim();
					if (charsetDef.startsWith("charset=")) {
						String charsetName = charsetDef.substring(8);
						Charset charset;
						try {
							charset = Charset.forName(charsetName);
						} catch (UnsupportedCharsetException e) {
							addConformanceProblem("Unsupported or invalid charset: " + charsetName);
							continue;
						}
						setCharset(charset);
					}
				}
			} else if ("authorization".equals(nextHeader)) {
				int spaceIndex = nextValue.indexOf(' ');
				if (spaceIndex == -1) {
					throw new DecodeException("Invalid authorization header. No authorization style detected");
				}
				String type = nextValue.substring(0, spaceIndex);
				if ("basic".equalsIgnoreCase(type)) {
					String encodedCredentials = nextValue.substring(spaceIndex + 1);
					byte[] decodedCredentials = Base64.decodeBase64(encodedCredentials);
					String credentialsString = new String(decodedCredentials, getDefaultCharset());
					int colonIndex = credentialsString.indexOf(':');
					if (colonIndex == -1) {
						setUsername(credentialsString);
					} else {
						setUsername(credentialsString.substring(0, colonIndex));
						setPassword(credentialsString.substring(colonIndex + 1));
					}
				} else {
					addConformanceProblem("Invalid authorization type. Only basic authorization is supported.");
				}
			} else if ("content-coding".equals(nextHeader)) {
				if (isNotBlank(nextValue)) {
					if ("gzip".equals(nextValue)) {
						myGzipCoding = true;
					} else {
						throw new DecodeException("Unknown content-coding: " + nextValue);
					}
				}
			}

		}

	}

	public List<String> getConformanceProblems() {
		if (myConformanceProblems == null) {
			myConformanceProblems = new ArrayList<String>();
		}
		return myConformanceProblems;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return myContentType;
	}

	/**
	 * @return the responseName
	 */
	public String getResponseName() {
		return myResponseName;
	}

	private byte[] readBytes(InputStream theInputStream) {
		int length = myContentLength > 0 ? myContentLength : 1000;
		ByteArrayOutputStream bos = new ByteArrayOutputStream(length);

		byte[] buffer = new byte[1000];
		while ((myContentLength < 0 || bos.size() < myContentLength)) {
			if (myContentLength < 0) {
				try {
					if (theInputStream.available() <= 0) {
						break;
					}
				} catch (IOException e) {
					ourLog.debug("Received IOException while calling inputStream#available()", e);
					break;
				}
			}

			int max = buffer.length;
			if (myContentLength > 0) {
				max = myContentLength - bos.size();
			}
			try {
				int bytesRead = theInputStream.read(buffer, 0, max);
				bos.write(buffer, 0, bytesRead);
			} catch (IOException e) {
				ourLog.debug("Received IOException while calling inputStream#available()", e);
				break;
			}
		}

		return bos.toByteArray();
	}

	protected String readFirstLine(InputStream theInputStream) throws IOException, NoMessageReceivedException {
		String firstLine;
		try {
			firstLine = readLine(theInputStream, true);
		} catch (SocketTimeoutException e) {
			throw new NoMessageReceivedException();
		}
		return firstLine;
	}

	/**
	 * Note that if {@link #setUri(String)} is called, this method will assume
	 * that the first line of the HTTP request has already been read from the
	 * input stream. If {@link #setHeaders(java.util.LinkedHashMap)} has been
	 * called, this method will assume that the HTTP headers have already been
	 * read from the input stream as well as the double-LF (ASCII-10) that
	 * proceeds the headers.
	 * 
	 * @param theInputStream
	 * @throws IOException
	 * @throws DecodeException
	 * @throws NoMessageReceivedException
	 */
	public void readHeadersAndContentsFromInputStreamAndDecode(InputStream theInputStream) throws IOException, DecodeException, NoMessageReceivedException {
		verifyNotUsed();

		readActionLine(theInputStream);

		if (getHeaders() == null) {
			setHeaders(new LinkedHashMap<String, String>());

			while (theInputStream.available() > 0) {
				String nextLine = readLine(theInputStream);
				if (nextLine.length() == 0) {
					break;
				}

				int colonIndex = nextLine.indexOf(':');
				if (colonIndex == -1) {
					throw new DecodeException("Invalid HTTP header line detected. Value is: " + nextLine);
				}

				String key = nextLine.substring(0, colonIndex);
				String value = nextLine.substring(colonIndex + 1).trim();
				getHeaders().put(key, value);
			}
		}

		doReadContentsFromInputStreamAndDecode(theInputStream);

	}

	/**
	 * @return the responseStatus
	 */
	public Integer getResponseStatus() {
		return myResponseStatus;
	}

	/**
	 * @param theResponseStatus
	 *            the responseStatus to set
	 */
	public void setResponseStatus(Integer theResponseStatus) {
		myResponseStatus = theResponseStatus;
	}

	/**
	 * @param theResponseName
	 *            the responseName to set
	 */
	public void setResponseName(String theResponseName) {
		myResponseName = theResponseName;
	}

	protected abstract void readActionLine(InputStream theInputStream) throws IOException, NoMessageReceivedException, DecodeException;

	/**
	 * Read in the contents of the raw message from the input stream and decode
	 * entire the message. This method assumes that the headers have been
	 * provided using {@link #setHeaders(LinkedHashMap)}
	 * 
	 * @param theInputStream
	 *            The inputstream to read the raw message from
	 * @throws AuthorizationFailureException
	 * @throws DecodeException
	 */
	public void readContentsFromInputStreamAndDecode(InputStream theInputStream) throws AuthorizationFailureException, DecodeException {
		verifyNotUsed();

		doReadContentsFromInputStreamAndDecode(theInputStream);
	}

	private void doReadContentsFromInputStreamAndDecode(InputStream theInputStream) throws DecodeException, AuthorizationFailureException {
		decodeHeaders();
		authorize();
		myBytes = readBytes(theInputStream);
		decodeBody();
	}

	private String readLine(InputStream theInputStream) throws IOException {
		return readLine(theInputStream, false);
	}

	private String readLine(InputStream theInputStream, boolean forceBlock) throws IOException {

		// TODO: make sure we handle any line ending possibilities, probably
		// using a pushback iterator

		StringBuilder retVal = new StringBuilder();
		while (theInputStream.available() > 0 || forceBlock) {
			forceBlock = false;

			int b = theInputStream.read();
			if (b == 13) {
				continue;
			} else if (b == 10) {
				break;
			} else if (b == -1) {
				ourLog.info("Read -1 from input stream, closing it");
				theInputStream.close();
			} else if (b < ' ') {
				continue;
			} else {
				retVal.append((char) b);
			}
		}

		return retVal.toString();
	}

}
