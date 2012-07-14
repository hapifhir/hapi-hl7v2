package ca.uhn.hl7v2.model.primitive;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>
 * Provides methods to convert between HL7 Formatted Text encoding (See Chapter
 * 2.7) and other encoding schemes.
 * </p>
 * <p>
 * <b>Note that this class is not threadsafe!</b> Always use a new instance
 * (from a factory method) for each invocation.
 * </p>
 * 
 * @author James Agnew
 * @see AbstractTextPrimitive
 */
public class FormattedTextEncoder {

	private boolean myAtStartOfLine;

	private StringBuilder myBuffer;
	private int myCurrentLineOffset;
	private int myInBold;
	private boolean myInCenter;
	private int myIndent;
	private boolean myInDiv;
	private boolean myNeedBreakBeforeNextText;
	private int myTemporaryIndent;
	private boolean myWordWrap;

	/**
	 * Use factory methods to instantiate this class
	 */
	private FormattedTextEncoder() {
		super();
	}

	private void addAmpersand() {
		myBuffer.append("&amp;");
	}

	private void addBreak() {
		myBuffer.append("<br>");
	}

	private void addEndNoBreak() {
		myBuffer.append("</nobr>");
	}

	private void addHighAscii(char nextChar) {
		myBuffer.append("&#");
		myBuffer.append((int) nextChar);
		myBuffer.append(";");
	}

	private void addSpace() {
		myBuffer.append("&nbsp;");
	}

	private void addStartCenter() {
		myBuffer.append("<center>");
	}

	private void addStartNoBreak() {
		myBuffer.append("<nobr>");
	}

	private void closeCenterIfNeeded() {
		if (myInCenter) {
			myBuffer.append("</center>");
		}
	}

	/**
	 * Convert the input string containing FT encoding strings (\.br\, \.sp XX\,
	 * etc.) into the appropriate output type for this encoder (currently HTML)
	 * 
	 * @param theInput
	 *            The input string
	 * @return An encoded version of the input string
	 */
	public String encode(String theInput) {
		if (theInput == null) {
			return null;
		}

		myBuffer = new StringBuilder(theInput.length() + 20);
		myAtStartOfLine = true;
		myInCenter = false;
		myWordWrap = true;
		myCurrentLineOffset = 0;
		myTemporaryIndent = 0;
		myIndent = 0;
		myNeedBreakBeforeNextText = false;
		myInDiv = false;
		myInBold = 0;

		for (int i = 0; i < theInput.length(); i++) {

			char nextChar = theInput.charAt(i);
			boolean handled = true;

			if (nextChar == '\\') {

				int theStart = i + 1;
				int numericArgument = Integer.MIN_VALUE;
				int offsetIncludingNumericArgument = 0;
				String nextFourChars = theInput.substring(theStart, Math.min(theInput.length(), theStart + 4)).toLowerCase();
				if (theInput.length() >= theStart + 5) {
					char sep = theInput.charAt(i + 4);
					if (theInput.charAt(i + 1) == '.' && (sep == ' ' || sep == '-' || sep == '+')) {
						String nextThirtyChars = theInput.substring(theStart + 3, Math.min(theInput.length(), theStart + 30));
						Matcher m = Pattern.compile("^([ +-]?[0-9]+)\\\\").matcher(nextThirtyChars);
						if (m.find()) {
							String group = m.group(1);
							offsetIncludingNumericArgument = group.length() + 4;
							group = group.replace('+', ' ').trim();
							numericArgument = Integer.parseInt(group);
						}
					}
				}

				if (nextFourChars.equals(".br\\")) {

					closeCenterIfNeeded();
					if (myNeedBreakBeforeNextText == true) {
						addBreak();
					}
					myNeedBreakBeforeNextText = true;
					i += 4;
					myAtStartOfLine = true;
					myInCenter = false;
					myCurrentLineOffset = 0;

				} else if (nextFourChars.startsWith("h\\")) {

					startBold();
					i += 2;

				} else if (nextFourChars.startsWith("n\\")) {

					endBold();
					i += 2;

				} else if (nextFourChars.startsWith(".in") && myAtStartOfLine && numericArgument != Integer.MIN_VALUE) {

					myIndent = numericArgument;
					myTemporaryIndent = 0;
					i += offsetIncludingNumericArgument;

				} else if (nextFourChars.startsWith(".ti") && myAtStartOfLine && numericArgument != Integer.MIN_VALUE) {

					myTemporaryIndent = numericArgument;
					i += offsetIncludingNumericArgument;

				} else if (nextFourChars.equals(".ce\\")) {

					closeCenterIfNeeded();
					if (!myAtStartOfLine) {
						addBreak();
					}
					addStartCenter();
					i += 4;
					myAtStartOfLine = false;
					myInCenter = true;

				} else if (nextFourChars.equals(".fi\\")) {

					if (!myWordWrap) {
						addEndNoBreak();
						myWordWrap = true;
					}
					i += 4;

				} else if (nextFourChars.equals(".nf\\")) {

					if (myWordWrap) {
						addStartNoBreak();
						myWordWrap = false;
					}
					i += 4;

				} else if (nextFourChars.startsWith(".sp")) {

					if (nextFourChars.equals(".sp\\")) {
						numericArgument = 1;
						i += 4;
					} else if (numericArgument != -1) {
						i += offsetIncludingNumericArgument;
					}

					if (numericArgument > 0) {

						for (int j = 0; j < numericArgument; j++) {
							addBreak();
						}
						for (int j = 0; j < myCurrentLineOffset; j++) {
							addSpace();
						}

					} else if (numericArgument == Integer.MIN_VALUE) {

						handled = false;

					}

				} else if (nextFourChars.equals(".sk ") && numericArgument >= 0) {

					for (int j = 0; j < numericArgument; j++) {
						addSpace();
					}
					i += offsetIncludingNumericArgument;

				} else {

					handled = false;

				}

			} else {

				handled = false;

			}

			if (!handled) {

				if (myAtStartOfLine) {

					int thisLineIndent = Math.max(0, myIndent + myTemporaryIndent);
					if (myNeedBreakBeforeNextText) {

						if (myInDiv) {
							myBuffer.append("</div>");
						} else if (thisLineIndent == 0) {
							addBreak();
						}
					}

					if (thisLineIndent > 0) {
						myBuffer.append("<div style=\"margin-left: ");
						myBuffer.append(thisLineIndent);
						myBuffer.append("em;\">");
						myInDiv = true;
					}
				}

				if (nextChar == '&') {
					addAmpersand();
				} else if (nextChar >= 160) {
					addHighAscii(nextChar);
				} else {
					myBuffer.append(nextChar);
				}

				myAtStartOfLine = false;
				myNeedBreakBeforeNextText = false;
				myCurrentLineOffset++;

			}

		}

		endBold();

		if (!myWordWrap) {
			addEndNoBreak();
		}
		closeCenterIfNeeded();

		if (myInDiv) {
			myBuffer.append("</div>");
		}

		return myBuffer.toString();
	}

	private void endBold() {
		for (int i = 0; i < myInBold; i++) {
			myBuffer.append("</b>");
		}
		myInBold = 0;
	}

	private void startBold() {
		myBuffer.append("<b>");
		myInBold++;
	}

	/**
	 * Returns a newly created instance which uses standard HTML encoding. The
	 * returned instance is not threadsafe, so this method should be called to
	 * obtain a new instance in any thread that requires a FormattedTextEncoder.
	 * 
	 * @see AbstractTextPrimitive#getValueAsHtml() for a description of the
	 *      encoding performed by this type of encoder
	 */
	public static FormattedTextEncoder getInstanceHtml() {
		return new FormattedTextEncoder();
	}

}
