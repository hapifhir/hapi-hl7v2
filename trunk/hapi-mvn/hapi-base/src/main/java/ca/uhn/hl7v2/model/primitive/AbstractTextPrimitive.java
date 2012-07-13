/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "".  Description:
 * ""
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2005.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.model.primitive;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ca.uhn.hl7v2.model.AbstractPrimitive;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.util.StringUtil;

/**
 * Base class for a textual datatype such as FT, TX, ST.
 */
public abstract class AbstractTextPrimitive extends AbstractPrimitive {

	/**
	 * Constructor
	 */
	public AbstractTextPrimitive(Message theMessage) {
		super(theMessage);
	}

	/**
	 * <p>
	 * Returns the value of this type with HL7 defined formatting codes replaced by their HTML
	 * equivalent.
	 * </p>
	 * <p>
	 * For example, if this type contained the string:<br> 
	 * <pre>ABC \.ce\MIDDLE\.br\</pre>
	 * <br>This would be returned as:<br>
	 * <pre>ABC &lt;center&gt;MIDDLE&lt;center&gt;&lt;br&gt;</pre>
	 * </p>
	 * <p>
	 * The following codes are handled:
	 * <ul>
	 * <li>\.br\ (converted to &lt;br&gt;)
	 * <li>\.ce\ (converted to &lt;center&gt;)
	 * <li>\.sk\ (converted to &amp;nbsp;)
	 * <li>\.sp\
	 * <li>\.sp ###\
	 * <li>\.fi\
	 * <li>\.nf\
	 * <li>\.in\
	 * <li>\.ti\
	 * <li>\H\
	 * <li>\N\
	 * <li>Ampersands (&amp;) are converted to their HTML equivalent (&amp;amp;)
	 * <li>Chars over ASCII 160 are HTML encoded (e.g. &amp;#199;) 
	 * </ul>
	 * </p>
	 * <p>
	 * Note that the returned value from this method is an HTML snippet, not a complete HTML document.
	 * </p>
	 */
	public String getValueAsHtml() {
		// See section 2.3.6 from the OLIS spec

		String string = getValue();
		if (string == null) {
			return null;
		}
		
		StringBuilder retVal = new StringBuilder(string.length() + 20);
		
		boolean atStartOfLine = true;
		boolean inCenter = false;
		boolean wordWrap = true;
		int currentIndent = 0;
		for (int i = 0; i < string.length(); i++) {
			
			char nextChar = string.charAt(i);
			boolean handled = true;
			
			if (nextChar == '\\') {
				
				int theStart = i + 1;
				int numericArgument = -1;
				int offsetIncludingNumericArgument = 0;
				String nextFourChars = string.substring(theStart, Math.min(string.length(), theStart + 4)).toLowerCase();
				if (string.length() >= theStart + 5) {
					if (string.charAt(i + 1) == '.' && string.charAt(i + 4) == ' ') {
						String nextThirtyChars = string.substring(theStart + 4, Math.min(string.length(), theStart + 30));
						Matcher m = Pattern.compile("^([0-9]+)\\\\").matcher(nextThirtyChars);
						if (m.find()) {
							String group = m.group(1);
							numericArgument = Integer.parseInt(group);
							offsetIncludingNumericArgument = group.length() + 5;
						}
					}
				}
				
				if (nextFourChars.equals(".br\\")) {

					closeCenterIfNeeded(retVal, inCenter);
					addBreak(retVal);
					i += 4;
					atStartOfLine = true;
					inCenter = false;
					currentIndent = 0;
					
				} else if (nextFourChars.equals(".ce\\")) {

					closeCenterIfNeeded(retVal, inCenter);
					if (!atStartOfLine) {
						addBreak(retVal);
					}
					retVal.append("<center>");
					i += 4;
					atStartOfLine = false;
					inCenter = true;
					
				} else if (nextFourChars.equals(".fi\\")) {
					
					if (!wordWrap) {
						retVal.append("</nobr>");
						wordWrap = true;
					}
					i += 4;
					
				} else if (nextFourChars.equals(".nf\\")) {
					
					if (wordWrap) {
						retVal.append("<nobr>");
						wordWrap = false;
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
							retVal.append("<br>");
						}
						for (int j = 0; j < currentIndent; j++) {
							retVal.append("&nbsp;");
						}
						
					} else if (numericArgument == -1) {
						
						handled = false;
						
					}

				} else {
					
					handled = false;
					
				}
				
			} else {
				
				handled = false;
				
			}
			
			if (!handled) {
				retVal.append(nextChar);
				atStartOfLine = false;
				currentIndent++;
			}
			
		}

		
		
		if (!wordWrap) {
			retVal.append("</nobr>");
		}
		closeCenterIfNeeded(retVal, inCenter);

		if (true) {
			return retVal.toString();
		}
		

		// \.ce\ conversion
		Pattern pattern = Pattern.compile("\\\\\\.ce\\\\(.*?)($|\\\\\\.br\\\\)");
		Matcher matcher = pattern.matcher(string);
		while (matcher.find()) {
			String match = matcher.group();
			String replacement = "\\.br\\<center>" + matcher.group(1) + "</center>" + matcher.group(2);
			string = StringUtil.replace(string, match, replacement);
		}

		// \.sk <number>\ conversion
		pattern = Pattern.compile("\\\\\\.sk (\\d)*\\\\");
		matcher = pattern.matcher(string);
		while (matcher.find()) {
			String match = matcher.group();
			String number = match.substring(5, match.length() - 1);
			int k;
			String replacement = "";
			try {
				k = Integer.parseInt(number);
				for (int n = 0; n < k; n++) {
					replacement = replacement + "&nbsp;";
				}
			} catch (NumberFormatException e) {
				replacement = " ";
			}
			string = StringUtil.replace(string, match, replacement);
		}

		// \.sp <number>\ conversion
		pattern = Pattern.compile("\\\\\\.sp (\\d)*\\\\");
		matcher = pattern.matcher(string);
		while (matcher.find()) {
			String match = matcher.group();
			String number = match.substring(5, match.length() - 1);
			int k;
			String replacement = "";
			try {
				k = Integer.parseInt(number);
				for (int n = 0; n < k; n++) {
					replacement = replacement + "<br>";
				}
			} catch (NumberFormatException e) {
				replacement = " ";
			}
			string = StringUtil.replace(string, match, replacement);
		}

		// \.sp\ conversion
		string = string.replaceAll("\\\\\\.sp\\\\", "<br>");

		// \.br\ conversion
		pattern = Pattern.compile("\\\\\\.br\\\\", Pattern.CASE_INSENSITIVE);
		string = pattern.matcher(string).replaceAll("<br>");
		
		// \H\ conversion
		string = string.replaceAll("\\\\H\\\\", "<b>");
		// \N\ conversion
		string = string.replaceAll("\\\\N\\\\", "</b>");
		// \.fi\ conversion
		string = string.replaceAll("\\\\\\.fi\\\\", " ");
		// \.nf\ conversion
		string = string.replaceAll("\\\\\\.nf\\\\", " ");
		// \.in <number>\ conversion
		string = string.replaceAll("\\\\\\.in (\\d)*\\\\", " ");
		// \.ti <number>\ conversion
		string = string.replaceAll("\\\\\\.ti (\\d)*\\\\", " ");

		retVal = new StringBuilder();
		for (int i = 0; i < string.length(); i++) {
			char next = string.charAt(i);
			if (next == '&') {
				retVal.append("&amp;");
			} else if (((int) next) > 160) {
				retVal.append("&#").append(((int) next)).append(';');
			} else {
				retVal.append(next);
			}
		}

		return retVal.toString();
	}

	private void addBreak(StringBuilder retVal) {
		retVal.append("<br>");
	}

	private void closeCenterIfNeeded(StringBuilder retVal, boolean inCenter) {
		if (inCenter) {
			retVal.append("</center>");
		}
	}

	private String getUpToThreeCharsInLowerCase(String theString, int theStart) {
		return theString.substring(theStart, Math.min(theString.length(), theStart + 3));
	}

	
}
