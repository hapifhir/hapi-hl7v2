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
import java.util.List;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.parser.EncodingCharacters;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.testpanel.ex.ConfigurationException;
import ca.uhn.hl7v2.testpanel.model.conf.ConformanceMessage;
import ca.uhn.hl7v2.testpanel.util.Range;
import ca.uhn.hl7v2.testpanel.util.SegmentAndComponentPath;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2MessageDefinition;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;

public abstract class Hl7V2MessageBase extends AbstractMessage<Message> {

	private static final Logger ourLog = LoggerFactory.getLogger(Hl7V2MessageBase.class);
	private Hl7V2EncodingTypeEnum myEncoding = Hl7V2EncodingTypeEnum.ER_7;
	private int myIndexWithinCollection;
	private Message myParsedMessage;
	private GenericParser myParser;
	private RuntimeProfile myRuntimeProfile;
	private String mySourceMessage;

	/**
	 * Constructor
	 */
	public Hl7V2MessageBase() {
		super();
		initParser();
	}

	public Hl7V2MessageBase(Hl7V2MessageDefinition theConfig) throws ConfigurationException {
		super(theConfig);

		RuntimeProfile profile;
		try {
			profile = new ProfileParser(false).parse(theConfig.getRuntimeProfile());
			setRuntimeProfile(profile);
		} catch (ProfileException e) {
			ourLog.error("Failed to parse profile", e);
		}

		setEncoding(theConfig.getEncoding());

		try {
			setSourceMessage(theConfig.getText());
		} catch (PropertyVetoException ex) {
			throw new ConfigurationException(ex.getMessage(), ex);
		}

		initParser();
	}

	public Hl7V2MessageBase(String theId) {
		super(theId);
		initParser();
	}

	public abstract Hl7V2MessageBase asEncoding(Hl7V2EncodingTypeEnum theEncoding);

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

	public abstract String getHighlitedPath();

	public abstract Range getHighlitedRange();

	/**
	 * @return the indexWithinCollection
	 */
	public int getIndexWithinCollection() {
		return myIndexWithinCollection;
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

	/**
	 * @return the runtimeProfile
	 */
	public RuntimeProfile getRuntimeProfile() {
		return myRuntimeProfile;
	}

	@Override
	public String getSourceMessage() {
		return mySourceMessage;
	}

	private void initParser() {
		myParser = new GenericParser();
		myParser.setValidationContext(new ValidationContextImpl());
	}

	/**
	 * @param theParsedMessage
	 *            the parsedMessage to set
	 */
	public void initWithParsedMessage(Message theParsedMessage) {
		myParsedMessage = theParsedMessage;
	}

	/**
	 * Invoked when the source message is updated prior to notifying listeners
	 */
	protected abstract void recalculateIndexes();

	/**
	 * @param theEncoding
	 *            the encoding to set
	 */
	public void setEncoding(Hl7V2EncodingTypeEnum theEncoding) {
		Validate.notNull(theEncoding);
		if (ObjectUtils.equals(myEncoding, theEncoding)) {
			return;
		}

		myEncoding = theEncoding;
		updateParser();

		if (myParsedMessage == null) {
			return;
		}

		String prev = mySourceMessage;
		try {
			mySourceMessage = myParser.encode(myParsedMessage);
		} catch (HL7Exception e) {
			ourLog.error("Could not re-encode message: " + e.getMessage(), e);
		}

		firePropertyChange(SOURCE_MESSAGE_PROPERTY, prev, mySourceMessage);
	}

	public abstract void setHighlitedField(SegmentAndComponentPath thePath);

	public abstract void setHighlitedPathBasedOnRange(Range theAdd);

	public abstract void setHighlitedRangeBasedOnSegment(Segment... theSegment);

	/**
	 * @param theIndexWithinCollection
	 *            the indexWithinCollection to set
	 */
	public void setIndexWithinCollection(int theIndexWithinCollection) {
		myIndexWithinCollection = theIndexWithinCollection;
	}

	public void setRuntimeProfile(RuntimeProfile theRuntimeProfile) {
		if (myRuntimeProfile == theRuntimeProfile) {
			return;
		}
		myRuntimeProfile = theRuntimeProfile;
		
		if (mySourceMessage == null) {
			return;
		}
		
		// Force a refresh
		String sourceMessage = mySourceMessage;
		mySourceMessage = null;
		try {
			setSourceMessage(sourceMessage);
		} catch (PropertyVetoException e) {
			ourLog.error("Failed to parse message", e);
		}
	}

	@Override
	public void setSourceMessage(String theMessage) throws PropertyVetoException {
		theMessage = StringUtils.defaultString(theMessage);

		String original = mySourceMessage;
		if (mySourceMessage != null && mySourceMessage.equals(theMessage)) {
			return;
		}

		String sourceMessage = theMessage.trim();
		String text = sourceMessage.replaceAll("(\\r|\\n)+", "\r");

		updateParser();

		Message parsedMessage;
		try {
			
			ourLog.info("About to parse message");
			
			if (myRuntimeProfile != null) {
				parsedMessage = ConformanceMessage.newInstanceFromStaticDef(myRuntimeProfile.getMessage());
				parsedMessage.setParser(myParser);
				parsedMessage.parse(text);
			} else {
				parsedMessage = myParser.parse(text);
			}

			ourLog.info("Done parsing message");

		} catch (EncodingNotSupportedException e) {
			ourLog.error("Failed to parse message", e);
			throw new PropertyVetoException(e.getMessage(), null);
		} catch (HL7Exception e) {
			ourLog.error("Failed to parse message", e);
			throw new PropertyVetoException(e.getMessage(), null);
		}

		myParsedMessage = parsedMessage;
		mySourceMessage = sourceMessage;

		recalculateIndexes();

		firePropertyChange(PARSED_MESSAGE_PROPERTY, original, text);
	}

	private void updateParser() {

		// Parser caches structure information, so can't reuse them for
		// structures generated from conformance profiles
		if (myRuntimeProfile != null) {
			initParser();
		}

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
			if (myRuntimeProfile != null) {
				myParsedMessage = ConformanceMessage.newInstanceFromStaticDef(myRuntimeProfile.getMessage());
				myParsedMessage.setParser(myParser);
				myParsedMessage.parse(theNewSource);
			} else {
				myParsedMessage.parse(theNewSource);
			}
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
						nextSeparatorIndex = currentRange.getEnd();
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
