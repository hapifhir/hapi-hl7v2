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
package ca.uhn.hl7v2.testpanel.model.msg;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.testpanel.util.Range;
import ca.uhn.hl7v2.testpanel.util.SegmentAndComponentPath;
import ca.uhn.hl7v2.testpanel.util.XmlScanner;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;

public class Hl7V2MessageXml extends Hl7V2MessageBase {

	private static final Logger ourLog = LoggerFactory.getLogger(Hl7V2MessageXml.class);

	private String myHilightedPath;

	@Override
	protected void recalculateIndexes() {
		// nothing
	}

	@Override
	public void setHighlitedPathBasedOnRange(Range theAdd) {
		if (theAdd == null) {
			myHilightedPath = null;
			return;
		}

		List<String> pathElements = new ArrayList<String>();

		XmlScanner scanner = new XmlScanner(getSourceMessage());
		scanner.setCalculateRepetitions(true);
		scanner.setPosition(theAdd.getStart());

		for (;;) {
			if (!scanner.findTagEnclosingCurrentPosition()) {
				break;
			}

			String currentTagName = scanner.getCurrentTagName();
			if (scanner.getCurrentTagRepetition() > 1) {
				currentTagName = currentTagName + "(" + scanner.getCurrentTagRepetition() + ")";
			}
			
			pathElements.add(0, currentTagName);
			scanner.decrementPositionByOne();
		}

		ourLog.info("Path elements " + pathElements);

		if (pathElements.size() < 2) {
			return;
		}

		boolean inSegment = false;
		StringBuilder b = new StringBuilder();
		for (int i = 1; i < pathElements.size(); i++) {
			String nextElement = pathElements.get(i);

			if (inSegment) {

				int dotIndex = nextElement.indexOf('.');
				if (dotIndex > 0) {
					b.append('-');
					b.append(nextElement.substring(dotIndex + 1));
				}

			} else {

				b.append('/');

				if (nextElement.matches("^[A-Z][A-Z0-9][A-Z0-9]$")) {
					inSegment = true;
					b.append(nextElement);
				} else {
					int dotIndex = nextElement.indexOf('.');
					b.append(nextElement.substring(dotIndex + 1));
				}

			}

		}

		myHilightedPath = b.toString();

		ourLog.info("Highlited path is now: " + myHilightedPath);
		
	}

	@Override
	public String getHighlitedPath() {
		return myHilightedPath;
	}

	@Override
	public void setHighlitedRangeBasedOnSegment(Segment... theSegment) {
		// not implemented
	}

	@Override
	public Range getHighlitedRange() {
		// not implemented
		return null;
	}

	@Override
	public void setHighlitedField(SegmentAndComponentPath thePath) {
		// TODO Auto-generated method stub

	}

	@Override
	public Hl7V2MessageBase asEncoding(Hl7V2EncodingTypeEnum theEncoding) {
		switch (theEncoding) {
		case XML:
			return this;
		case ER_7:
		default:
			Hl7V2MessageEr7 retVal = new Hl7V2MessageEr7();
			try {
				PipeParser pipeParser = new PipeParser();
				String encode = pipeParser.encode(getParsedMessage());
				retVal.setSourceMessage(encode);
			} catch (PropertyVetoException e) {
				ourLog.error("Failed to create XML message", e);
			} catch (HL7Exception e) {
				ourLog.error("Failed to create XML message", e);
			}
			
			return retVal;
		}
		
	}

}
