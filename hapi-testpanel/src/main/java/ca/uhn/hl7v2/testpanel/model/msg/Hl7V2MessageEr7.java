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
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.parser.DefaultXMLParser;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.testpanel.util.CharCountingStringIteratorDecorator;
import ca.uhn.hl7v2.testpanel.util.Range;
import ca.uhn.hl7v2.testpanel.util.SegmentAndComponentPath;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;

public class Hl7V2MessageEr7 extends Hl7V2MessageBase {
	private static final Logger ourLog = LoggerFactory.getLogger(Hl7V2MessageEr7.class);
	private String myHighlitedPath;
	private Range myHighlitedRange;
	private ArrayList<Segment> mySegmentIndexes = new ArrayList<Segment>();
	private ArrayList<Range> mySegmentRanges = new ArrayList<Range>();
	private ArrayList<String> mySegmentTerserPaths = new ArrayList<String>();

	public Hl7V2MessageEr7() {
		super();
	}

	public Hl7V2MessageEr7(int theIndexWithinCollection) throws PropertyVetoException {
		this();

		setIndexWithinCollection(theIndexWithinCollection);
	}

	@Override
	public Hl7V2MessageBase asEncoding(Hl7V2EncodingTypeEnum theEncoding) {
		switch (theEncoding) {
		case ER_7:
			return this;
		case XML:
		default:
			Hl7V2MessageXml retVal = new Hl7V2MessageXml();
			try {
				retVal.setSourceMessage(new DefaultXMLParser().encode(getParsedMessage()));
			} catch (PropertyVetoException e) {
				ourLog.error("Failed to create XML message", e);
			} catch (HL7Exception e) {
				ourLog.error("Failed to create XML message", e);
			}

			return retVal;
		}

	}

	public void clearHighlight() {
		setHighlitedRangeBasedOnSegment((Segment[])null);
		setHighlitedPathBasedOnRange(null);
	}

	/**
	 * @return the highlitedPath
	 */
	public String getHighlitedPath() {
		return myHighlitedPath;
	}

	public Range getHighlitedRange() {
		return myHighlitedRange;
	}

	public int getLineIndex(Segment theSegment) {
		int index = 0;
		for (Segment next : mySegmentIndexes) {
			if (next == theSegment) {
				return index;
			} else {
				index++;
			}
		}

		return -1;
	}

	List<Range> getSegmentRanges() {
		return Collections.unmodifiableList(mySegmentRanges);
	}

	protected void recalculateIndexes() {
		String[] lines = getSourceMessage().split("\\r");
		CharCountingStringIteratorDecorator iter = new CharCountingStringIteratorDecorator(Arrays.asList(lines).iterator());
		mySegmentIndexes.clear();
		mySegmentRanges.clear();
		mySegmentTerserPaths.clear();

		try {
			// Integer.toString(getIndexWithinCollection())
			recalculateIndexes(iter, getParsedMessage(), null, "");
		} catch (HL7Exception e) {
			ourLog.error("Failed to calculate message segment indexes", e);
		}
	}

	private String recalculateIndexes(CharCountingStringIteratorDecorator theIter, Group theGroup, String theNameToSearchFor, String thePath) throws HL7Exception {
		for (String nextName : theGroup.getNames()) {

			if (theNameToSearchFor == null && theIter.hasNext()) {
				do {
					theNameToSearchFor = theIter.next();

					// Account for \r
					theIter.setNumCharsReturned(theIter.getNumCharsReturned() + 1);

					if (theNameToSearchFor.length() < 3) {
						mySegmentIndexes.add(null);
						mySegmentRanges.add(null);
					} else {
						theNameToSearchFor = theNameToSearchFor.substring(0, 3);
					}
				} while (theNameToSearchFor == null);
			}

			if (theNameToSearchFor == null && theIter.hasNext() == false) {
				return null;
			}

			Structure[] reps = theGroup.getAll(nextName);
			if (theGroup.isGroup(nextName)) {
				int repIndex = 1;
				for (Structure structure : reps) {
					String nextPath = thePath + "/" + nextName + (repIndex > 1 ? "(" + repIndex + ")" : "");
					repIndex++;
					theNameToSearchFor = recalculateIndexes(theIter, (Group) structure, theNameToSearchFor, nextPath);
				}
				continue;
			}

			if (!theNameToSearchFor.equals(nextName)) {
				continue;
			}

			int repIndex = 1;
			ER7_STRUCTURE_REPS: for (Structure structure : reps) {

				String nextPath = thePath + "/" + nextName + (repIndex > 1 ? "(" + repIndex + ")" : "");
				mySegmentTerserPaths.add(nextPath);
				repIndex++;

				mySegmentIndexes.add((Segment) structure);

				int start = 0;
				if (mySegmentRanges.size() > 0) {
					start = mySegmentRanges.get(mySegmentRanges.size() - 1).getEnd() + 1;
				}

				int end = theIter.getNumCharsReturned();
				mySegmentRanges.add(new Range(start, end - 1));

				if (theIter.hasNext() == false) {
					return null;
				}

				do {
					theNameToSearchFor = theIter.next();

					// Account for \r
					theIter.setNumCharsReturned(theIter.getNumCharsReturned() + 1);

					if (theNameToSearchFor.length() < 3) {
						mySegmentIndexes.add(null);
						mySegmentRanges.add(null);
					} else {
						theNameToSearchFor = theNameToSearchFor.substring(0, 3);
					}
				} while (theNameToSearchFor == null);

				if (!theNameToSearchFor.equals(nextName)) {
					break ER7_STRUCTURE_REPS;
				}

			}

		} // for

		return theNameToSearchFor;

	}

	public void setHighlitedField(SegmentAndComponentPath theField) {

		if (theField == null) {
			setHighlitedPathBasedOnRange(null);
			return;
		}

		int lineIndex = getLineIndex(theField.getSegment());
		if (lineIndex == -1) {
			setHighlitedPathBasedOnRange(null);
			return;
		}

		Range segmentRange = mySegmentRanges.get(lineIndex);
		String sourceMessage = getSourceMessage();
		Message parsedMessage = getParsedMessage();

		Range currentRange = findFieldRange(theField.getComponentPath(), segmentRange, sourceMessage, parsedMessage);
		setHighlitedPathBasedOnRange(currentRange);
		myHighlitedRange = currentRange;

	}

	public void setHighlitedPathBasedOnRange(Range theRange) {

		if (theRange == null) {
			myHighlitedPath = null;
			return;
		}

		int dot = theRange.getStart();

		int dotIndex = -1;
		Range segmentRange = null;
		for (int i = 0; i < mySegmentRanges.size(); i++) {
			segmentRange = mySegmentRanges.get(i);
			if (segmentRange != null && segmentRange.contains(dot)) {
				dotIndex = i;
				break;
			}
		}

		if (dotIndex == -1) {
			return;
		}

		EncodingCharacters enc;
		try {
			enc = EncodingCharacters.getInstance(getParsedMessage());
		} catch (HL7Exception e) {
			ourLog.error("Failed to find field", e);
			return;
		}

		int fieldIndex = 0;
		int cmpIndex = 0;
		int subCmpIndex = 0;
		int repIndex = 0;
		for (int i = segmentRange.getStart() + 1; i <= segmentRange.getEnd() && i <= dot && i <= getSourceMessage().length(); i++) {
			char nextChar = getSourceMessage().charAt(i - 1);
			if (nextChar == enc.getRepetitionSeparator()) {
				repIndex++;
				cmpIndex = 1;
				subCmpIndex = 1;
			} else if (nextChar == enc.getFieldSeparator()) {
				fieldIndex++;
				repIndex = 0;
				cmpIndex = 1;
				subCmpIndex = 1;
			} else if (nextChar == enc.getComponentSeparator()) {
				cmpIndex++;
				subCmpIndex = 1;
			} else if (nextChar == enc.getSubcomponentSeparator()) {
				subCmpIndex++;
			}
		}

		Segment segment = mySegmentIndexes.get(dotIndex);
		if (segment.getName().equals("MSH")) {
			fieldIndex++;
			if (fieldIndex == 2) {
				cmpIndex = 1;
				subCmpIndex = 1;
			}
		}

		try {
			if (fieldIndex > 0) {
				Type type = segment.getField(fieldIndex, 0);
				if (type instanceof Varies) {
					type = ((Varies) type).getData();
				}
				if (type instanceof Composite) {
					Composite composite = (Composite) type;
					if (subCmpIndex == 1) {
						Type subComponent = composite.getComponent(1);
						if (subComponent instanceof Varies) {
							subComponent = ((Varies) subComponent).getData();
						}
						if (subComponent instanceof Primitive) {
							subCmpIndex = 0;
						}
					}
				} else if (cmpIndex == 1) {
					cmpIndex = 0;
				}
			}

		} catch (HL7Exception e) {
			ourLog.error("Failed to retrieve field", e);
		}

		String basePath = mySegmentTerserPaths.get(dotIndex);
		StringBuilder fullPathB = new StringBuilder(basePath);
		if (fieldIndex >= 1) {
			fullPathB.append('-').append(fieldIndex);
			if (repIndex > 0) {
				fullPathB.append('(');
				fullPathB.append(repIndex + 1);
				fullPathB.append(')');
			}
			if (cmpIndex >= 1) {
				fullPathB.append('-').append(cmpIndex);
				if (subCmpIndex >= 1) {
					fullPathB.append('-').append(subCmpIndex);
				}
			}
		}
		String fullPath = fullPathB.toString();

		ourLog.info("Highlited path is now: " + fullPath);

		myHighlitedPath = fullPath;
	}

	public void setHighlitedRangeBasedOnSegment(Segment... theSegment) {
		if (theSegment == null || theSegment.length == 0) {
			myHighlitedRange = null;
		} else {

			myHighlitedRange = null;
			for (Segment segment : theSegment) {
				int newSelectedIndex = theSegment != null ? getLineIndex(segment) : -1;
				if (newSelectedIndex != -1) {
					Range nextRange = mySegmentRanges.get(newSelectedIndex);
					if (nextRange == null) {
						// nothing
					} else if (myHighlitedRange == null) {
						myHighlitedRange = nextRange;
					} else {
						myHighlitedRange = myHighlitedRange.overlay(nextRange);
					}
				}
			}

		}

	}

}
