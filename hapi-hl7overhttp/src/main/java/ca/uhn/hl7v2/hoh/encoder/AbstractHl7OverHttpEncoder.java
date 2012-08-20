package ca.uhn.hl7v2.hoh.encoder;

import static ca.uhn.hl7v2.hoh.util.StringUtils.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import ca.uhn.hl7v2.hoh.api.EncodeException;
import ca.uhn.hl7v2.hoh.api.ISendable;
import ca.uhn.hl7v2.hoh.sign.SignatureFailureException;
import ca.uhn.hl7v2.hoh.util.HTTPUtils;


/**
 * Base class that creates HL7 over HTTP requests. This class is intended to be
 * single use, so please create a new instance for each message.
 */
public abstract class AbstractHl7OverHttpEncoder extends AbstractHl7OverHttp {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(AbstractHl7OverHttpEncoder.class);

	private String myActionLine;

	private ISendable mySendable;
	private static DateFormat ourRfc1123DateFormat;
	
	static {
		ourRfc1123DateFormat = new SimpleDateFormat("EEE, dd MMM yy HH:mm:ss z");
	}
	
	/**
	 * Constructor
	 */
	public AbstractHl7OverHttpEncoder() {
		super();
	}


	/**
	 * @throws EncodeException 
	 * 
	 */
	public void encode() throws EncodeException {
		verifyNotUsed();
		
		if (isBlank(getMessage()) && mySendable == null) {
			throw new IllegalStateException("Either Message or Sendable must be set");
		}
		if (getMessage() != null) {
			setData(getMessage().getBytes(getCharset()));
		} else {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			OutputStreamWriter w = new OutputStreamWriter(bos, getCharset());
			try {
				mySendable.writeMessage(w);
			} catch (IOException e) {
				throw new EncodeException("Failed to convert message to sendable bytes");
			}
			setData(bos.toByteArray());
		}

		setActionLineAppropriately();

		setHeaders(new LinkedHashMap<String, String>());
		
		StringBuilder ctBuilder = new StringBuilder();
		if (mySendable != null) {
			ctBuilder.append(mySendable.getEncodingStyle().getContentType());
		} else {
			ctBuilder.append(EncodingStyle.detect(getMessage()).getContentType());
		}
		ctBuilder.append("; charset=");
		ctBuilder.append(getCharset().name());
		getHeaders().put("Content-Type", ctBuilder.toString());

		getHeaders().put("Content-Length", Integer.toString(getData().length));

		addSpecificHeaders();

		synchronized (ourRfc1123DateFormat) {
			getHeaders().put("Date", ourRfc1123DateFormat.format(new Date()));
		}
		
		if (getSigner() != null) {
			try {
				getHeaders().put(HTTP_HEADER_HL7_SIGNATURE, getSigner().sign(getData()));
			} catch (SignatureFailureException e) {
				throw new EncodeException(e);
			}
		}
	}


	protected abstract void addSpecificHeaders();


	protected abstract void setActionLineAppropriately();

	/**
	 * Provide the message to send with a {@link ISendable} instance. Either this method
	 * OR {@link #setMessage(String)} must be called, but not both.
	 */
	public void setDataProvider(ISendable theSendable) {
		if (getMessage() != null) {
			throw new IllegalStateException("Message already provided");
		}
		mySendable = theSendable;
	}


	/**
	 * Provide the message to send with a String. Either this method
	 * OR {@link #setDataProvider(ISendable)} must be called, but not both.
	 */
	@Override
	public void setMessage(String theData) {
		if (mySendable != null) {
			throw new IllegalStateException("Data provider already provided");
		}
		super.setMessage(theData);
	}


	public void encodeToOutputStream(OutputStream theOutputStream) throws IOException, EncodeException {
		encode();

		ourLog.debug("Writing HTTP action: {}", getActionLine());
		
		OutputStreamWriter w = new OutputStreamWriter(theOutputStream, HTTPUtils.DEFAULT_CHARSET);
		w.write(getActionLine());
		w.write("\r\n");
		
		for (Map.Entry<String, String> next : getHeaders().entrySet()) {
			w.write(next.getKey());
			w.write(": ");
			w.write(next.getValue());
			w.write("\r\n");
		}
		
		w.write("\r\n");
		w.flush();
		
		theOutputStream.write(getData());
		
	}

	
	/**
	 * @return the actionLine
	 */
	public String getActionLine() {
		return myActionLine;
	}


	/**
	 * @param theActionLine the actionLine to set
	 */
	public void setActionLine(String theActionLine) {
		myActionLine = theActionLine;
	}

}
