/*
 * Hl7InputStreamReader.java
 */

package ca.uhn.hl7v2.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reads HL7 messages from an InputStream
 * 
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:27 $ by $Author: jamesagnew $
 * @deprecated see {@link Hl7InputStreamMessageIterator} or
 *             {@link Hl7InputStreamMessageStringIterator}
 */
public class Hl7InputStreamReader {

	private static final Logger ourLog = LoggerFactory.getLogger(Hl7InputStreamReader.class);

	/**
	 * Reads HL7 messages from an InputStream and outputs an array of HL7 message strings
	 * 
	 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:27 $ by $Author: jamesagnew $
	 */
	public static String[] read(InputStream theMsgInputStream) throws FileNotFoundException,
			IOException {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new CommentFilterReader(
					new InputStreamReader(theMsgInputStream)));

			StringBuffer rawMsgBuffer = new StringBuffer();
			int c = 0;
			while ((c = in.read()) >= 0) {
				rawMsgBuffer.append((char) c);
			}

			String[] messages = getHL7Messages(rawMsgBuffer.toString());
			ourLog.info(messages.length + " messages sent.");
			return messages;
		} finally {
			if (in != null)
				in.close();
		}

	}

	/**
	 * Given a string that contains HL7 messages, and possibly other junk, returns an array of the
	 * HL7 messages. An attempt is made to recognize segments even if there is other content between
	 * segments, for example if a log file logs segments individually with timestamps between them.
	 * 
	 * @param theSource a string containing HL7 messages
	 * @return the HL7 messages contained in theSource
	 */
	private static String[] getHL7Messages(String theSource) {
		List<String> messages = new ArrayList<String>(20);
		Pattern startPattern = Pattern.compile("^MSH", Pattern.MULTILINE);
		Matcher startMatcher = startPattern.matcher(theSource);

		while (startMatcher.find()) {
			String messageExtent = getMessageExtent(theSource.substring(startMatcher.start()),
					startPattern);

			char fieldDelim = messageExtent.charAt(3);
			Pattern segmentPattern = Pattern.compile("^[A-Z]{3}\\" + fieldDelim + ".*$",
					Pattern.MULTILINE);
			Matcher segmentMatcher = segmentPattern.matcher(messageExtent);
			StringBuffer msg = new StringBuffer();
			while (segmentMatcher.find()) {
				msg.append(segmentMatcher.group().trim());
				msg.append('\r');
			}
			messages.add(msg.toString());
		}
		return messages.toArray(new String[0]);
	}

	/**
	 * Given a string that contains at least one HL7 message, returns the smallest string that
	 * contains the first of these messages.
	 */
	private static String getMessageExtent(String theSource, Pattern theStartPattern) {
		Matcher startMatcher = theStartPattern.matcher(theSource);
		if (!startMatcher.find()) {
			throw new IllegalArgumentException(theSource + "does not contain message start pattern"
					+ theStartPattern.toString());
		}

		int start = startMatcher.start();
		int end = theSource.length();
		if (startMatcher.find()) {
			end = startMatcher.start();
		}

		return theSource.substring(start, end).trim();
	}

	/**
	 * TODO: this code is copied from HAPI ... should make it part of HAPI public API instead
	 * Removes C and C++ style comments from a reader stream. C style comments are distinguished
	 * from URL protocol delimiters by the preceding colon in the latter.
	 */
	private static class CommentFilterReader extends PushbackReader {

		private final char[] startCPPComment = { '/', '*' };
		private final char[] endCPPComment = { '*', '/' };
		private final char[] startCComment = { '/', '/' };
		private final char[] endCComment = { '\n' };
		private final char[] protocolDelim = { ':', '/', '/' };

		public CommentFilterReader(Reader in) {
			super(in, 5);
		}

		/**
		 * Returns the next character, not including comments.
		 */
		public int read() throws IOException {
			if (atSequence(protocolDelim)) {
				// proceed normally
			} else if (atSequence(startCPPComment)) {
				// skip() doesn't seem to work for some reason
				while (!atSequence(endCPPComment))
					super.read();
				for (int i = 0; i < endCPPComment.length; i++)
					super.read();
			} else if (atSequence(startCComment)) {
				while (!atSequence(endCComment))
					super.read();
				for (int i = 0; i < endCComment.length; i++)
					super.read();
			}
			int ret = super.read();
			if (ret == 65535)
				ret = -1;
			return ret;
		}

		public int read(char[] cbuf, int off, int len) throws IOException {
			int i = -1;
			boolean done = false;
			while (++i < len) {
				int next = read();
				if (next == 65535 || next == -1) { // Pushback causes -1 to convert to 65535
					done = true;
					break;
				}
				cbuf[off + i] = (char) next;
			}
			if (i == 0 && done)
				i = -1;
			return i;
		}

		/**
		 * Tests incoming data for match with char sequence, resets reader when done.
		 */
		private boolean atSequence(char[] sequence) throws IOException {
			boolean result = true;
			int i = -1;
			int[] data = new int[sequence.length];
			while (++i < sequence.length && result == true) {
				data[i] = super.read();
				if ((char) data[i] != sequence[i])
					result = false; // includes case where end of stream reached
			}
			for (int j = i - 1; j >= 0; j--) {
				this.unread(data[j]);
			}
			return result;
		}
	}

}
