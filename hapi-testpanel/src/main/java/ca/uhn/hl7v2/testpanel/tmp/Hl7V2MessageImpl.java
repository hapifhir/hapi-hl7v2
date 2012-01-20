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
package ca.uhn.hl7v2.testpanel.tmp;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
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
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.testpanel.ex.ConfigurationException;
import ca.uhn.hl7v2.testpanel.model.msg.AbstractMessage;
import ca.uhn.hl7v2.testpanel.util.CharCountingStringIteratorDecorator;
import ca.uhn.hl7v2.testpanel.util.Range;
import ca.uhn.hl7v2.testpanel.util.SegmentAndComponentPath;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2MessageDefinition;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;

public class Hl7V2MessageImpl extends AbstractMessage<Message> {

	private static final Logger ourLog = LoggerFactory.getLogger(Hl7V2MessageImpl.class);
	public static final String PROP_HIGHLITED_PATH = Hl7V2MessageImpl.class.getName() + "HIGHLITED_PATH";
	public static final String PROP_HIGHLITED_RANGE = Hl7V2MessageImpl.class.getName() + "HIGHLITED_RANGE";
	private Hl7V2EncodingTypeEnum myEncoding = Hl7V2EncodingTypeEnum.ER_7;
	private SegmentAndComponentPath myHighlitedField;
	private Range myHighlitedRange;
	private Segment myHighlitedSegmemt;
	private Message myParsedMessage;
	private GenericParser myParser;
	private ArrayList<Segment> mySegmentIndexes = new ArrayList<Segment>();
	private ArrayList<Range> mySegmentRanges = new ArrayList<Range>();
	private ArrayList<String> mySegmentTerserPaths = new ArrayList<String>();
	private String mySourceMessage;
	private String myHighlitedPath;

	/**
	 * Constructor
	 */
	public Hl7V2MessageImpl() {
		super();
		init();
	}

	public Hl7V2MessageImpl(Hl7V2MessageDefinition theConfig) throws ConfigurationException {
		super(theConfig);

		setEncoding(theConfig.getEncoding());

		try {
			setSourceMessage(theConfig.getText());
		} catch (PropertyVetoException ex) {
			throw new ConfigurationException(ex.getMessage(), ex);
		}

		init();
	}

	public Hl7V2MessageImpl(String theId) {
		super(theId);
		init();
	}

	public void clearHighlight() {
		setHighlitedSegment(null);
		setHighlitedRange(null);
	}

	private void doSetHighlitedField(SegmentAndComponentPath theField) {
		// SegmentAndComponentPath oldValue = myHighlitedField;
		myHighlitedField = theField;
		// firePropertyChange(PROP_HIGHLITED_FIELD, oldValue, myHighlitedField);
	}

	private void doSetHighlitedSegment(Segment theSegment) {
		// Segment oldValue = myHighlitedSegmemt;
		myHighlitedSegmemt = theSegment;
		// firePropertyChange(PROP_HIGHLITED_SEGMENT, oldValue, theSegment);
	}

	/**
	 * Subclasses should make use of this method to export AbstractInterface
	 * properties into the return value for {@link #exportConfigToXml()}
	 */
	protected Hl7V2MessageDefinition exportConfig(Hl7V2MessageDefinition theConfig) {
		super.exportConfig(theConfig);
		theConfig.setText(mySourceMessage);

		return theConfig;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public Hl7V2MessageDefinition exportConfigToXml() {
		return exportConfig(new Hl7V2MessageDefinition());
	}

	/**
	 * @return the encoding
	 */
	public Hl7V2EncodingTypeEnum getEncoding() {
		return myEncoding;
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

	@Override
	public Class<Message> getMessageClass() {
		return Message.class;
	}

	public String getMessageDescription() {
		StringBuilder retVal = new StringBuilder();

		Terser t = new Terser(myParsedMessage);

		try {
			retVal.append(t.get("/.MSH-9-1"));
			retVal.append("^");
			retVal.append(t.get("/.MSH-9-2"));

			retVal.append(" ");

			retVal.append(t.get("/.MSH-10"));
		} catch (HL7Exception e) {
			ourLog.error("Failed to retrieve message props: ", e);
		}

		return retVal.toString();
	}

	@Override
	public Message getParsedMessage() {
		return myParsedMessage;
	}

	@Override
	public String getSourceMessage() {
		return mySourceMessage;
	}

	private void init() {
		myParser = new GenericParser();
		myParser.setValidationContext(new ValidationContextImpl());
	}

	private void recalculateIndexes() {
		String[] lines = mySourceMessage.split("\\r");
		CharCountingStringIteratorDecorator iter = new CharCountingStringIteratorDecorator(Arrays.asList(lines).iterator());
		mySegmentIndexes.clear();
		mySegmentRanges.clear();
		mySegmentTerserPaths.clear();

		try {
			recalculateIndexes(iter, myParsedMessage, null, "");
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
				mySegmentRanges.add(new Range(start, end));

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

	/**
	 * @param theEncoding
	 *            the encoding to set
	 */
	public void setEncoding(Hl7V2EncodingTypeEnum theEncoding) {
		Validate.notNull(theEncoding);
		if (ObjectUtils.equals(myEncoding, theEncoding)) {
			return;
		}

		if (myParsedMessage == null) {
			return;
		}

		myEncoding = theEncoding;

		updateParser();

		String prev = mySourceMessage;
		try {
			mySourceMessage = myParser.encode(myParsedMessage);
		} catch (HL7Exception e) {
			ourLog.error("Could not re-encode message: " + e.getMessage(), e);
		}

		firePropertyChange(SOURCE_MESSAGE_PROPERTY, prev, mySourceMessage);
	}

	public void setHighlitedField(SegmentAndComponentPath theField) {
		doSetHighlitedSegment(null);
		doSetHighlitedField(theField);

		if (theField == null) {
			setHighlitedRange(null);
			return;
		}

		int lineIndex = getLineIndex(theField.getSegment());
		if (lineIndex == -1) {
			setHighlitedRange(null);
			return;
		}

		Range segmentRange = mySegmentRanges.get(lineIndex);
		String sourceMessage = mySourceMessage;
		Message parsedMessage = myParsedMessage;

		Range currentRange = findFieldRange(theField.getComponentPath(), segmentRange, sourceMessage, parsedMessage);
		setHighlitedRange(currentRange);
		doSetHighlitedRange(currentRange);

	}

	public void setHighlitedRange(Range theRange) {
		
		if (theRange == null) {
			String oldValue = myHighlitedPath;
			myHighlitedPath = null;
			firePropertyChange(PROP_HIGHLITED_PATH, oldValue, myHighlitedPath);
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
			enc = EncodingCharacters.getInstance(myParsedMessage);
		} catch (HL7Exception e) {
			ourLog.error("Failed to find field", e);
			return;
		}

		int fieldIndex = 0;
		int cmpIndex = 0;
		int subCmpIndex = 0;
		int repIndex = 0;
		for (int i = segmentRange.getStart() + 1; i <= segmentRange.getEnd() && i <= dot; i++) {
			char nextChar = mySourceMessage.charAt(i - 1);
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

		String oldValue = myHighlitedPath;
		myHighlitedPath = fullPath;
		firePropertyChange(PROP_HIGHLITED_PATH, oldValue, myHighlitedPath);

	}

	/**
	 * @return the highlitedPath
	 */
	public String getHighlitedPath() {
		return myHighlitedPath;
	}

	private void doSetHighlitedRange(Range theRange) {
		Range oldValue = myHighlitedRange;
		myHighlitedRange = theRange;

		ourLog.info("Highlited range is now: " + theRange);

		firePropertyChange(PROP_HIGHLITED_RANGE, oldValue, theRange);
	}

	public void setHighlitedSegment(Segment theSegment) {
		doSetHighlitedSegment(theSegment);
		doSetHighlitedField(null);

		int newSelectedIndex = theSegment != null ? getLineIndex(theSegment) : -1;
		if (newSelectedIndex != -1) {
			doSetHighlitedRange(mySegmentRanges.get(newSelectedIndex));
		} else {
			doSetHighlitedRange(null);
		}

	}

	@Override
	public void setSourceMessage(String theMessage) throws PropertyVetoException {
		theMessage = StringUtils.defaultString(theMessage);

		String original = mySourceMessage;

		String sourceMessage = theMessage.trim();
		String text = sourceMessage.replaceAll("(\\r|\\n)+", "\r");

		updateParser();

		Message parsedMessage;
		try {
			parsedMessage = myParser.parse(text);
		} catch (EncodingNotSupportedException e) {
			throw new PropertyVetoException(e.getMessage(), null);
		} catch (HL7Exception e) {
			throw new PropertyVetoException(e.getMessage(), null);
		}

		myParsedMessage = parsedMessage;
		mySourceMessage = sourceMessage;

		recalculateIndexes();

		firePropertyChange(PARSED_MESSAGE_PROPERTY, original, text);
	}

	private void updateParser() {
		switch (myEncoding) {
		case XML:
			myParser.setXMLParserAsPrimary();
			break;
		case ER_7:
		default:
			myParser.setPipeParserAsPrimary();
			break;
		}
	}

	public void updateSourceMessage(String theNewSource, int theChangeStart, int theChangeEnd) throws PropertyVetoException {

		theNewSource = theNewSource.replace('\n', '\r');
		theNewSource = theNewSource.replace("\n", "");

		if (mySourceMessage.equals(theNewSource.trim())) {
			return;
		}

		if (true) {
			setSourceMessage(theNewSource);
		}

		mySourceMessage = theNewSource;

		// System.out.println(theNewSource.replace("\r", "\n"));

		try {
			// System.out.println(myParsedMessage.printStructure());
			myParsedMessage.parse(theNewSource);
			// System.out.println(myParsedMessage.printStructure());
		} catch (HL7Exception e) {
			ourLog.error("Failed to parse message", e);
		}

		firePropertyChange(PARSED_MESSAGE_PROPERTY, null, null);
	}

	public void updateSourceMessageBasedOnParsedMessage() {
		String newMessage;
		try {
			newMessage = myParsedMessage.encode();

			String oldValue = mySourceMessage;
			mySourceMessage = newMessage;
			firePropertyChange(SOURCE_MESSAGE_PROPERTY, oldValue, myParsedMessage);

			recalculateIndexes();

		} catch (HL7Exception e) {
			ourLog.error("Failed to update parsed message", e);
		}
	}

	static Range findFieldRange(List<Integer> theField, Range theSegmentRange, String theSourceMessage, Message theParsedMessage) {
		EncodingCharacters enc;
		try {
			enc = EncodingCharacters.getInstance(theParsedMessage);
		} catch (HL7Exception e) {
			ourLog.error("Failed to find field", e);
			return null;
		}

		int componentPathIndex = 0;
		Range currentRange = theSegmentRange;
		for (Integer next : theField) {

			char sep;
			int offset = next;
			switch (componentPathIndex) {
			case 0:
				sep = enc.getFieldSeparator();
				if (!theSegmentRange.applyTo(theSourceMessage).startsWith("MSH")) {
					offset++;
				}
				break;
			case 1:
				sep = enc.getComponentSeparator();
				break;
			case 2:
			default:
				sep = enc.getSubcomponentSeparator();
				break;
			}

			while (offset > 0) {

				int nextSeparatorIndex = theSourceMessage.indexOf(sep, currentRange.getStart());
				if (nextSeparatorIndex == -1 || nextSeparatorIndex > currentRange.getEnd()) {
					if (offset > 1) {
						nextSeparatorIndex = currentRange.getEnd() - 1;
					} else {
						nextSeparatorIndex = currentRange.getStart();
					}
				}

				if (offset > 1) {
					currentRange = new Range(nextSeparatorIndex + 1, currentRange.getEnd());
				} else {
					currentRange = new Range(currentRange.getStart(), nextSeparatorIndex);
				}

				offset--;

			}
			componentPathIndex++;
		}
		return currentRange;
	}

}
