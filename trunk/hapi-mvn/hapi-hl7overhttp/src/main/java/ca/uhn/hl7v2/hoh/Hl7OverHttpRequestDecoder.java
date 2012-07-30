package ca.uhn.hl7v2.hoh;

import static org.apache.commons.lang.StringUtils.*;

import java.io.IOException;
import java.io.InputStream;

public class Hl7OverHttpRequestDecoder extends AbstractHl7OverHttpDecoder {

	@Override
	protected void readActionLine(InputStream theInputStream) throws DecodeException, IOException, NoMessageReceivedException {
		if (getUri() == null) {
			String firstLine = readFirstLine(theInputStream);
			if (firstLine == null || isBlank(firstLine)) {
				throw new NoMessageReceivedException();
			}
			
			if (!firstLine.startsWith("POST ")) {
				throw new DecodeException("HTTP request line message is not valid. Only POST action is supported. Request line was: " + firstLine);
			}

			firstLine = firstLine.substring(5);
			int nextSpace = firstLine.indexOf(' ');
			if (nextSpace == -1) {
				throw new DecodeException("HTTP request line message is not valid. Not HTTP version found. Request line was: " + firstLine);
			}

			setUri(firstLine.substring(0, nextSpace));
			if (isBlank(getUri())) {
				throw new DecodeException("HTTP request line message is not valid. No request URI found. Request line was: " + firstLine);
			}

			String protocolVersion = firstLine.substring(nextSpace + 1);
			if (!"HTTP/1.1".equals(protocolVersion)) {
				throw new DecodeException("HTTP request line message is not valid. HTTP version not supported. Request line was: " + firstLine);
			}

		}
	}


}
