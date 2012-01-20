/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is ""  Description:
 * ""
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */
package ca.uhn.hl7v2.testpanel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XmlScanner {
	
	private static final Logger ourLog = LoggerFactory.getLogger(XmlScanner.class);
	
	private boolean myCalculateRepetitions;
	private String myCurrentTagName;
	private int myCurrentTagRepetition;
	private String myDocument;
	private int myPosition;

	public XmlScanner(String theDocument) {
		myDocument = theDocument;
	}

	public void decrementPositionByOne() {
		myPosition--;
	}

	public boolean findTagEnclosingCurrentPosition() {
		if (myPosition >= myDocument.length()) {
			return false;
		}
		
		int currentPosition = myPosition;
		int originalPosition = myPosition;

		String currentTagName;
		int tagStart;
		do {
			tagStart = indexOfOpenTagBackwards(currentPosition);

			if (tagStart == -1) {
				return false;
			}

			int tagEnd = indexOfTagNameEnd(tagStart + 1);
			if (tagEnd == -1) {
				return false;
			}

			currentTagName = myDocument.substring(tagStart + 1, tagEnd);

			// Find corresponding close tag
			int closePosition = myDocument.indexOf("</" + currentTagName + ">", tagStart);
			if (closePosition == -1) {
				return false;
			}

			if (closePosition > myPosition) {
				break;
			} else {
				currentPosition = tagStart - 1;
			}

		} while (currentPosition >= 0);

		if (currentTagName == null) {
			return false;
		}

		myCurrentTagName = currentTagName;
		myPosition = tagStart;

		if (myCalculateRepetitions) {
			XmlScanner parentScanner = new XmlScanner(myDocument);
			parentScanner.setPosition(myPosition - 1);
			if (parentScanner.findTagEnclosingCurrentPosition()) {
				int parentTagStart = parentScanner.getPosition();
				myCurrentTagRepetition = countCloseTags(myCurrentTagName, parentTagStart, originalPosition) + 1;
			}
		}

		return true;

	}

	private int countCloseTags(String theCurrentTagName, int theStart, int theEnd) {
		int retVal = 0;

		if (ourLog.isTraceEnabled()) {
			ourLog.trace("Searching for </" + theCurrentTagName + "> within " + theStart + "-" + theEnd + " : "+ myDocument.substring(theStart, theEnd));
		}
		
		for (int i = theStart; i + 3 + theCurrentTagName.length() < theEnd; i++) {
			if (myDocument.charAt(i) == '<') {
				if (myDocument.charAt(i + 1) == '/') {
					int beginIndex = i + 2;
					int endIndex = beginIndex + theCurrentTagName.length();
					
					String substring = myDocument.substring(beginIndex, endIndex);
					if (substring.equals(theCurrentTagName)) {
						if (myDocument.charAt(beginIndex + theCurrentTagName.length()) == '>') {
			
							if (ourLog.isTraceEnabled()) {
								ourLog.info("At " + beginIndex + "-" + endIndex + " found: " + substring);
							}
							
							retVal++;
						}
					}
				}
			}
		}

		if (ourLog.isTraceEnabled()) {
			ourLog.info("Found " + retVal);
		}
		
		return retVal;
	}

	/**
	 * @return the currentTagName
	 */
	public String getCurrentTagName() {
		return myCurrentTagName;
	}

	/**
	 * @return the currentTagRepetition
	 */
	public int getCurrentTagRepetition() {
		return myCurrentTagRepetition;
	}

	/**
	 * @return the position
	 */
	public int getPosition() {
		return myPosition;
	}

	private int indexOfOpenTagBackwards(int theIndex) {
		for (int i = theIndex; i >= 0; i--) {
			if (myDocument.charAt(i) == '<') {
				if ((i + 1) < myDocument.length() && myDocument.charAt(i + 1) != '/') {
					return i;
				}
			}
		}
		return -1;
	}

	private int indexOfTagNameEnd(int theTagStart) {
		for (int i = theTagStart; i < myDocument.length(); i++) {
			char nextChar = myDocument.charAt(i);
			if (Character.isLetterOrDigit(nextChar)) {
				continue;
			}

			switch (nextChar) {
			case '_':
			case '.':
				continue;
			}

			return i;
		}

		return -1;
	}

	/**
	 * @param theCalculateRepetitions
	 *            the calculateRepetitions to set
	 */
	public void setCalculateRepetitions(boolean theCalculateRepetitions) {
		myCalculateRepetitions = theCalculateRepetitions;
	}

	public void setPosition(int thePosition) {
		myPosition = thePosition;
	}

}
