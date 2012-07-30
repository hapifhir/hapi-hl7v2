package ca.uhn.hl7v2.hoh;

import static org.apache.commons.lang.StringUtils.*;

import java.io.IOException;
import java.io.InputStream;

public class Hl7OverHttpResponseDecoder extends AbstractHl7OverHttpDecoder {

	@Override
	protected void readActionLine(InputStream theInputStream) throws IOException, NoMessageReceivedException, DecodeException {
		if (getResponseStatus() == null) {
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
		}
	}

}
