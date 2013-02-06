package ca.uhn.hl7v2.hoh.encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import ca.uhn.hl7v2.hoh.api.DecodeException;
import ca.uhn.hl7v2.hoh.api.NonHl7ResponseException;
import ca.uhn.hl7v2.hoh.sign.SignatureFailureException;
import ca.uhn.hl7v2.hoh.sign.SignatureVerificationException;
import ca.uhn.hl7v2.hoh.util.GZipUtils;
import ca.uhn.hl7v2.hoh.util.IOUtils;
import ca.uhn.hl7v2.hoh.util.StringUtils;
import ca.uhn.hl7v2.hoh.util.repackage.Base64;

public abstract class AbstractHl7OverHttpDecoder extends AbstractHl7OverHttp {

	private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");

	/**
	 * Default amount of time that the decoder will attempt to read before
	 * timing out and throwing an IOException (30000ms)
	 * 
	 * @see #setReadTimeout(long)
	 */
	public static final int DEFAULT_READ_TIMEOUT = 30 * 1000;

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(AbstractHl7OverHttpDecoder.class);

	private byte[] myBytes;
	private List<String> myConformanceProblems;
	private int myContentLength = -1;
	private String myContentType;
	private boolean myGzipCoding;
	private long myLastStartedReading;
	private long myReadTimeout = DEFAULT_READ_TIMEOUT;
	private String myResponseName;
	private Integer myResponseStatus;
	private TransferEncoding myTransferEncoding;
	private String mySignature;
	private EncodingStyle myEncodingStyle;

	private void addConformanceProblem(String theString) {
		ourLog.debug("Conformance problem detected: {}", theString);
		if (myConformanceProblems == null) {
			myConformanceProblems = new ArrayList<String>();
		}
		myConformanceProblems.add(theString);
	}

	protected abstract void authorize() throws AuthorizationFailureException;

	public void decode() throws DecodeException, SignatureVerificationException {
		ourLog.trace("Entering decode()");
		
		verifyNotUsed();

		decodeHeaders();
		authorize();
		decodeBody();
		verifySignature();

		ourLog.trace("Exiting decode()");
	}

	private void decodeBody() throws DecodeException {
		byte[] bytes = myBytes;

		if (myGzipCoding) {
			ourLog.debug("Decoding message contents using GZIP encoding style");
			try {
				bytes = GZipUtils.uncompress(bytes);
			} catch (IOException e) {
				throw new DecodeException("Failed to uncompress GZip content", e);
			}
		}

		Charset charset = getCharset();
		ourLog.debug("Message is {} bytes with charset {}", bytes.length, charset.name());
		String messageString = new String(bytes, charset);
		setMessage(messageString);
	}

	private void decodeHeaders() throws DecodeException {

		ourLog.trace("Headers are: {}", getHeaders());

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
					myEncodingStyle = EncodingStyle.withNameCaseInsensitive(myContentType);
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

				myContentType = myContentType.trim();

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
				if (StringUtils.isNotBlank(nextValue)) {
					if ("gzip".equals(nextValue)) {
						myGzipCoding = true;
					} else {
						throw new DecodeException("Unknown content-coding: " + nextValue);
					}
				}
			} else if (HTTP_HEADER_HL7_SIGNATURE_LC.equals(nextHeader)) {
				mySignature = nextValue;
			}

		}

	}

	/**
	 * Returns the {@link EncodingStyle} associated with the incoming message,
	 * or <code>null</code>. This will be set automatically based on the value
	 * of the <code>Content-Type</code> header, and will be set to
	 * <code>null</code> if the content type is not provided, or if the content
	 * type does not correspond to an HL7 type.
	 * 
	 * @see {@link EncodingStyle} for a list of appropriate content types
	 */
	public EncodingStyle getEncodingStyle() {
		return myEncodingStyle;
	}

	private void doReadContentsFromInputStreamAndDecode(InputStream theInputStream) throws DecodeException, AuthorizationFailureException, IOException, SignatureVerificationException {
		decodeHeaders();
		authorize();
		if (myTransferEncoding == TransferEncoding.CHUNKED) {
			myBytes = readBytesChunked(theInputStream);
		} else {
			myBytes = readBytesNonChunked(theInputStream);
		}

		decodeBody();
		
		if (getContentType() == null) {
			throw new DecodeException("Content-Type not specified");
		}
		if (getEncodingStyle() == null) {
			throw new NonHl7ResponseException("Invalid Content-Type: " + getContentType(), getContentType(), getMessage());
		}
		
		verifySignature();
	}

	private byte[] readBytesChunked(InputStream theInputStream) throws DecodeException, IOException {
		ourLog.debug("Decoding message bytes using CHUNKED encoding style");
		byte[] byteBuffer = new byte[IOUtils.DEFAULT_BUFFER_SIZE];
		ByteArrayOutputStream bos = new ByteArrayOutputStream(IOUtils.DEFAULT_BUFFER_SIZE);

		while (true) {
			String nextSize;
			try {
				nextSize = readLine(theInputStream);
			} catch (IOException e) {
				throw new DecodeException("Failed to decode CHUNKED encoding", e);
			}

			ourLog.trace("Going to interpret CHUNKED size value: {}", nextSize);
			
			if (nextSize.length() == 0) {
				break;
			}

			int nextSizeInt;
			try {
				nextSizeInt = Integer.parseInt(nextSize, 16);
			} catch (NumberFormatException e) {
				throw new DecodeException("Failed to decode CHUNKED encoding", e);
			}

			ourLog.debug("Next CHUNKED size: {}", nextSizeInt);

			if (nextSizeInt < 0) {
				throw new DecodeException("Received invalid octet count in chunked transfer encoding: " + nextSize);
			}

			if (nextSizeInt > 0) {
				int totalRead = 0;
				myLastStartedReading = System.currentTimeMillis();
				do {
					int nextRead = Math.min(nextSizeInt, byteBuffer.length);
					int bytesRead = theInputStream.read(byteBuffer, 0, nextRead);
					if (bytesRead == -1) {
						ourLog.debug("Exception in readBytesChunked(InputStream): Reached EOF. Buffer has {} bytes", bos.size());
						throw new DecodeException("Reached EOF while reading in message chunk");
					}
					if (bytesRead == 0 && totalRead < nextSizeInt) {
						pauseDuringTimedOutRead();
					}
					totalRead += bytesRead;

					ourLog.debug("Read {} byte chunk", bytesRead);
					bos.write(byteBuffer, 0, bytesRead);

				} while (totalRead < nextSizeInt);
			}

			// Try to read a trailing CRLF
			int nextChar;
			boolean had13 = false;
			boolean had10 = false;
			boolean trailing = false;
			while (true) {
				try {
					nextChar = theInputStream.read();
				} catch (SocketTimeoutException e) {
					break;
				}

				if (nextChar == -1) {
					break;
				} else if (nextChar == 13) {
					if (had13) {
						/* 
						 * This is an attempt to be tolerant of people using the wrong
						 * end of line sequence (it should be CRLF), as is the 
						 * had10 below 
						 */
						trailing = true;
					}
					had13 = true;
					continue;
				} else if (nextChar == 10) {
					if (had10) {
						trailing = true;
					}
					continue;
				} else {
					break;
				}
			}
			
			if (trailing) {
				break;
			}

		} // while

		return bos.toByteArray();
	}

	private void verifySignature() throws SignatureVerificationException, DecodeException {
		if (getSigner() != null && StringUtils.isBlank(mySignature)) {
			String mode = (this instanceof Hl7OverHttpRequestDecoder) ? "request" : "response";
			throw new SignatureVerificationException("No HL7 Signature found in " + mode);
		}
		if (getSigner() != null) {
			try {
				getSigner().verify(myBytes, mySignature);
			} catch (SignatureFailureException e) {
				throw new DecodeException("Failed to verify signature due to an error (signature may possibly be valid, but verification failed)", e);
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
	 * @return Returns the content type associated with the message (e.g. application/hl7-v2)
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

	/**
	 * @return the responseStatus
	 */
	public Integer getResponseStatus() {
		return myResponseStatus;
	}

	protected abstract String readActionLineAndDecode(InputStream theInputStream) throws IOException, NoMessageReceivedException, DecodeException;

	private byte[] readBytesNonChunked(InputStream theInputStream) throws IOException {
		int length = myContentLength > 0 ? myContentLength : IOUtils.DEFAULT_BUFFER_SIZE;
		ByteArrayOutputStream bos = new ByteArrayOutputStream(length);

		byte[] buffer = new byte[IOUtils.DEFAULT_BUFFER_SIZE];
		myLastStartedReading = System.currentTimeMillis();
		while ((myContentLength < 0 || bos.size() < myContentLength)) {
			if (myContentLength < 0) {
				try {
					if (theInputStream.available() <= 0) {
						break;
					}
				} catch (IOException e) {
					ourLog.debug("Received IOException while calling inputStream#available()", e);
					throw e;
				}
			}

			int max = buffer.length;
			if (myContentLength > 0) {
				max = myContentLength - bos.size();
			}
			try {
				int bytesRead = theInputStream.read(buffer, 0, max);
				myLastStartedReading = System.currentTimeMillis();
				if (bytesRead == -1) {
					break;
				}
				bos.write(buffer, 0, bytesRead);
			} catch (SocketTimeoutException e) {
				long elapsed = System.currentTimeMillis() - myLastStartedReading;
				if (elapsed > myReadTimeout) {
					throw e;
				} else {
					ourLog.debug("Trying to read for {} / {}ms, going to keep trying", elapsed, myReadTimeout);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// ignore
					}
				}
			} catch (IOException e) {
				ourLog.debug("Received IOException while calling inputStream#available()", e);
				throw e;
			}
		}

		return bos.toByteArray();
	}

	/**
	 * Read in the contents of the raw message from the input stream and decode
	 * entire the message. This method assumes that the headers have been
	 * provided using {@link #setHeaders(LinkedHashMap)}
	 * 
	 * @param theInputStream
	 *            The inputstream to read the raw message from
	 * @throws AuthorizationFailureException
	 *             If the authorization check fails. This will only be thrown if
	 *             this decoder is decoding a request message, and an
	 *             authorization callback has been provided, and the
	 *             authorization fails.
	 * @throws DecodeException
	 *             If the message can not be decoded for any reason
	 * @throws IOException
	 *             If there is a failure while reading from the inputstream
	 * @throws SignatureVerificationException
	 *             If the signature verification fails. This will only occur if
	 *             {@link #setSigner(ca.uhn.hl7v2.hoh.sign.ISigner) a signer}
	 *             has been provided.
	 */
	public void readContentsFromInputStreamAndDecode(InputStream theInputStream) throws AuthorizationFailureException, DecodeException, IOException, SignatureVerificationException {
		verifyNotUsed();

		doReadContentsFromInputStreamAndDecode(theInputStream);
	}

	protected String readFirstLine(InputStream theInputStream) throws IOException, NoMessageReceivedException {
		ourLog.trace("Entering readFirstLine(InputStream) with IS: {}", theInputStream);
		String retVal = readLine(theInputStream, true);
		ourLog.trace("Exiting readFirstLine(InputStream) with result: {}", retVal);
		return retVal;
	}

	/**
	 * Note that if {@link #setPath(String)} is called, this method will assume
	 * that the first line of the HTTP request has already been read from the
	 * input stream. If {@link #setHeaders(java.util.LinkedHashMap)} has been
	 * called, this method will assume that the HTTP headers have already been
	 * read from the input stream as well as the double-LF (ASCII-10) that
	 * proceeds the headers.
	 * 
	 * 
	 * @param theInputStream
	 *            The inputstream to read the raw message from
	 * @throws AuthorizationFailureException
	 *             If the authorization check fails. This will only be thrown if
	 *             this decoder is decoding a request message, and an
	 *             authorization callback has been provided, and the
	 *             authorization fails.
	 * @throws DecodeException
	 *             If the message can not be decoded for any reason
	 * @throws IOException
	 *             If there is a failure while reading from the inputstream
	 * @throws SignatureVerificationException
	 *             If the signature verification fails. This will only occur if
	 *             {@link #setSigner(ca.uhn.hl7v2.hoh.sign.ISigner) a signer}
	 *             has been provided.
	 */
	public void readHeadersAndContentsFromInputStreamAndDecode(InputStream theInputStream) throws IOException, DecodeException, NoMessageReceivedException, SignatureVerificationException {
		verifyNotUsed();

		String actionLine = readActionLineAndDecode(theInputStream);

		ourLog.debug("Read action line: {}", actionLine);

		if (getHeaders() == null) {
			setHeaders(new LinkedHashMap<String, String>());

			while (true) {
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

	private String readLine(InputStream theInputStream) throws IOException {
		try {
			return readLine(theInputStream, false);
		} catch (NoMessageReceivedException e) {
			throw new Error("Threw a NoMessageReceivedException. This should not happen.", e);
		}
	}

	private String readLine(InputStream theInputStream, boolean theFirstLine) throws IOException, NoMessageReceivedException {

		myLastStartedReading = System.currentTimeMillis();

		StringBuilder retVal = new StringBuilder();
		while (true) {

			int b;
			try {
				b = theInputStream.read();
			} catch (SocketTimeoutException e) {
				if (retVal.length() == 0 && theFirstLine) {
					ourLog.trace("No message received, aborting readLine(InputStream, boolean)");
					throw new NoMessageReceivedException();
				}
				ourLog.trace("No message received in readLine(InputStream, boolean), going to wait and continue");
				pauseDuringTimedOutRead();
				continue;
			}

			if (b == 13) {
				continue;
			} else if (b == 10) {
				break;
			} else if (b == -1) {
				ourLog.debug("Current read line is: {}", retVal);
				ourLog.info("Read -1 from input stream, closing it");
				theInputStream.close();
				if (retVal.length() == 0) {
					throw new SocketException("Received EOF from input stream");
				}
				break;
			} else if (b < ' ') {
				continue;
			} else {
				retVal.append((char) b);
			}
		}

		ourLog.debug("Current read line is: {}", retVal);

		return WHITESPACE_PATTERN.matcher(retVal.toString()).replaceAll(" ").trim();
	}

	private void pauseDuringTimedOutRead() throws SocketTimeoutException {
		long elapsed = System.currentTimeMillis() - myLastStartedReading;
		if (elapsed > myReadTimeout) {
			ourLog.trace("Elapsed time of {} exceeds max {}, throwing SocketTimeoutException", elapsed, myReadTimeout);
			throw new SocketTimeoutException();
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// ignore
		}
	}

	/**
	 * Sets the number of milliseconds that the decoder will attempt to read
	 * from an InputStream before timing out and throwing an exception
	 */
	public void setReadTimeout(long theReadTimeout) {
		myReadTimeout = theReadTimeout;
	}

	/**
	 * @param theResponseName
	 *            the responseName to set
	 */
	public void setResponseName(String theResponseName) {
		myResponseName = theResponseName;
	}

	/**
	 * @param theResponseStatus
	 *            the responseStatus to set
	 */
	public void setResponseStatus(Integer theResponseStatus) {
		myResponseStatus = theResponseStatus;
	}

}
