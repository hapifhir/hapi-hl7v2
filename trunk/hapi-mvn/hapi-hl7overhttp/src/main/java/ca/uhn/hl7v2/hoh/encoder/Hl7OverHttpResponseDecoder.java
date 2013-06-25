package ca.uhn.hl7v2.hoh.encoder;

import static ca.uhn.hl7v2.hoh.util.StringUtils.*;

import java.io.IOException;
import java.io.InputStream;

import ca.uhn.hl7v2.hoh.api.DecodeException;

public class Hl7OverHttpResponseDecoder extends AbstractHl7OverHttpDecoder {

	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(Hl7OverHttpResponseDecoder.class);
	private String myActionLine;

	@Override
	protected String readActionLineAndDecode(InputStream theInputStream) throws IOException, NoMessageReceivedException, DecodeException {
		ourLog.trace("Entering readActionLineAndDecode(InputStream)");

		if (myActionLine == null) {
			String firstLine = readFirstLine(theInputStream);
			if (firstLine == null || isBlank(firstLine)) {
				throw new NoMessageReceivedException();
			}

			if (!firstLine.startsWith("HTTP/1.1 ")) {
				throw new DecodeException("HTTP response begins with unknown HTTP version. Line is: " + firstLine);
			}

			String statusPart = firstLine.substring(9);
			int spaceIdx = statusPart.indexOf(' ');
			if (spaceIdx == -1) {
				throw new DecodeException("Invalid response line, no space after status code. Line is: " + firstLine);
			}

			String statusCode = statusPart.substring(0, spaceIdx);
			try {
				setResponseStatus(Integer.parseInt(statusCode));
			} catch (NumberFormatException e) {
				throw new DecodeException("Invalid response line. Bad status code: " + statusCode);
			}

			setResponseName(statusPart.substring(spaceIdx).trim());
			myActionLine = firstLine;
			ourLog.trace("Action line is {}", myActionLine);

		} else {
			ourLog.trace("Already have an action line");
		}
		
		return myActionLine;
	}

	@Override
	protected void authorize() throws AuthorizationFailureException {
		// responses do not need authorization
	}

	/**
	 * Returns true if the connection=close header was present in the response
	 */
	@Override
	public boolean isConnectionCloseHeaderPresent() {
		return super.isConnectionCloseHeaderPresent();
	}

}
