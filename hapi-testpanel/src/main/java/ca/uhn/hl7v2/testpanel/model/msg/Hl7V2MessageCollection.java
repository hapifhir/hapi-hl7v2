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

import static org.apache.commons.lang.StringUtils.*;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.testpanel.model.AbstractModelClass;
import ca.uhn.hl7v2.testpanel.model.UnknownMessage;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileFileList;
import ca.uhn.hl7v2.testpanel.model.conf.ProfileGroup;
import ca.uhn.hl7v2.testpanel.ui.ShowEnum;
import ca.uhn.hl7v2.testpanel.util.ClassUtils;
import ca.uhn.hl7v2.testpanel.util.LineEndingsEnum;
import ca.uhn.hl7v2.testpanel.util.Range;
import ca.uhn.hl7v2.testpanel.util.SegmentAndComponentPath;
import ca.uhn.hl7v2.testpanel.xsd.Hl7V2EncodingTypeEnum;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;

public class Hl7V2MessageCollection extends AbstractModelClass {
	private static final Pattern FIRSTLINE_COMMENT_PATTERN = Pattern.compile("^\\#\\s*(\\S.*)");
	private static final Logger ourLog = LoggerFactory.getLogger(Hl7V2MessageCollection.class);
	public static final String PARSED_MESSAGES_PROPERTY = Hl7V2MessageCollection.class.getName() + "PARSED_MESSAGES_PROPERTY";
	public static final String PROP_DESCRIPTION = Hl7V2MessageCollection.class.getName() + "DESCRIPTION";
	public static final String PROP_ENCODING = Hl7V2MessageCollection.class.getName() + "ENCODING";
	public static final String PROP_HIGHLITED_PATH = Hl7V2MessageCollection.class.getName() + "HIGHLITED_PATH";
	public static final String PROP_HIGHLITED_RANGE = Hl7V2MessageCollection.class.getName() + "HIGHLITED_RANGE";
	public static final String PROP_SAVE_FILENAME = Hl7V2MessageCollection.class.getName() + "SAVE_FILENAME";
	public static final String PROP_VALIDATIONCONTEXT_OR_PROFILE = Hl7V2MessageCollection.class.getName() + "VALIDATIONCONTEXT";
	public static final String SAVED_PROPERTY = AbstractMessage.class.getName() + "SAVED_PROPERTY";
	public static final String SOURCE_MESSAGE_PROPERTY = Hl7V2MessageCollection.class.getName() + "SOURCE_MESSAGE_PROPERTY";

	private Hl7V2EncodingTypeEnum myEncoding = Hl7V2EncodingTypeEnum.ER_7;
	private String myHighlitedPath;
	private Range myHighlitedRange;
	private String myId;
	private String myLastSendToInterfaceId;
	private String myMessageDescription;
	private List<Range> myMessageRanges = new ArrayList<Range>();
	private List<AbstractMessage<?>> myMessages = new ArrayList<AbstractMessage<?>>();
	private GenericParser myParser;
	private String myProfileId;
	private ProfileGroup myRuntimeProfile;
	private Charset mySaveCharset;
	private boolean mySaved;
	private String mySaveFileName;
	private long mySaveFileTimestamp;
	private LineEndingsEnum mySaveLineEndings;
	private int mySendNumberOfTimes = 1;
	private ShowEnum myShow;
	private String mySourceMessage;
	private boolean myStripSaveComments;
	private ValidationContext myValidationContext = new DefaultValidation();

	/**
	 * Constructor
	 */
	public Hl7V2MessageCollection() {
		myParser = new GenericParser();
		myParser.setValidationContext(new ValidationContextImpl());

		myId = UUID.randomUUID().toString();
	}

	public synchronized void addComment(String theComment) {
		String oldValue = mySourceMessage;

		ensureSourceMessage();

		StringBuilder b = new StringBuilder();
		if (myEncoding == Hl7V2EncodingTypeEnum.ER_7) {
			for (String next : theComment.split("\\n")) {
				if (StringUtils.isNotBlank(next)) {
					b.append("#");
					b.append(next);
					b.append("\n");
				} else {
					b.append("\n");
				}
			}

		} else {
			b.append("<!--");
			b.append(theComment);
			b.append("-->\n");
		}

		int originalLength = mySourceMessage.length();
		mySourceMessage += b.toString();

		Comment comment = new Comment();
		comment.setSourceMessage(theComment);
		myMessages.add(comment);

		ensureSourceMessage();

		myMessageRanges.add(new Range(originalLength, originalLength + b.length()));

		firePropertyChange(SOURCE_MESSAGE_PROPERTY, oldValue, mySourceMessage);
		firePropertyChange(PARSED_MESSAGES_PROPERTY, oldValue, mySourceMessage);
	}

	public synchronized void addMessage(AbstractMessage<?> theMessage) {
		Validate.notNull(theMessage);

		int newIndex = myMessages.size();
		myMessages.add(theMessage);

		ensureSourceMessage();

		myMessageRanges.add(new Range(mySourceMessage.length()));

		if (theMessage instanceof Hl7V2MessageBase) {
			updateSourceMessageBasedOnParsedMessage(newIndex, (Message) theMessage.getParsedMessage());
		}
	}

	public void clearHighlight() {
		Range oldValue = myHighlitedRange;
		myHighlitedRange = null;
		firePropertyChange(PROP_HIGHLITED_RANGE, oldValue, myHighlitedRange);

	}

	public int countMessagesOfType(Class<Hl7V2MessageBase> theClass) {
		int retVal = 0;
		for (AbstractMessage<?> next : getMessages()) {
			if (theClass.isAssignableFrom(next.getClass())) {
				retVal++;
			}
		}
		return retVal;
	}

	private synchronized void doSetSourceMessageEr7(String message) {
		String[] lines = message.split("\\r");

		StringBuilder buf = new StringBuilder();
		ParserState curState = ParserState.NONE;
		int curStart = 0;
		for (String nextLine : lines) {
			ParserState newState;
			if (nextLine.startsWith("#")) {
				newState = ParserState.COMMENT;
			} else if (nextLine.startsWith("MSH")) {
				newState = ParserState.AT_MSG_START;
			} else {
				if (nextLine.trim().length() > 0) {
					if (curState == ParserState.IN_MSG && nextLine.matches("^[A-Z][A-Z0-9][A-Z0-9].*")) {
						newState = ParserState.IN_MSG;
					} else {
						newState = ParserState.UNKNOWN;
					}
				} else {
					newState = ParserState.NONE;
				}
			}

			if (curState != newState) {
				AbstractMessage<?> msg = null;
				String bufToString = buf.toString();
				if (bufToString.length() > 0) {
					switch (curState) {
					case AT_MSG_START:
					case IN_MSG:
						try {

							// Note: this code is duplicated below.. that should
							// be cleaned
							// up probably, but until then if this is modified,
							// modify it below
							// also
							ourLog.info("Found ER7 message");
							Hl7V2MessageBase hl7msg = new Hl7V2MessageEr7();
							hl7msg.setIndexWithinCollection(myMessages.size());
							hl7msg.setRuntimeProfile(myRuntimeProfile);
							hl7msg.setSourceMessage(bufToString);
							msg = hl7msg;

						} catch (PropertyVetoException e) {
							msg = new UnknownMessage(bufToString);
						}
						break;
					case COMMENT:
						msg = new Comment(bufToString);
						break;
					case UNKNOWN:
						msg = new UnknownMessage(bufToString);
						break;
					}

					if (msg != null) {
						myMessages.add(msg);
						myMessageRanges.add(new Range(curStart, curStart + bufToString.length()));
					}
				}

				curStart = curStart + bufToString.length();
				buf.setLength(0);

				if (newState == ParserState.AT_MSG_START) {
					curState = ParserState.IN_MSG;
				} else {
					curState = newState;
				}
			}

			buf.append(nextLine).append('\r');

		}

		String bufToString = buf.toString();
		if (bufToString.trim().length() > 0) {
			AbstractMessage<?> msg = null;
			switch (curState) {
			case IN_MSG:
			case AT_MSG_START:
				try {

					ourLog.info("Found ER7 message");
					Hl7V2MessageBase hl7msg = new Hl7V2MessageEr7();
					hl7msg.setIndexWithinCollection(myMessages.size());
					hl7msg.setRuntimeProfile(myRuntimeProfile);
					hl7msg.setSourceMessage(bufToString);
					msg = hl7msg;

				} catch (PropertyVetoException e) {
					msg = new UnknownMessage(bufToString);
				}
				break;
			case COMMENT:
				msg = new Comment(bufToString);
				break;
			case UNKNOWN:
				msg = new UnknownMessage(bufToString);
				break;
			}

			if (msg != null) {
				myMessages.add(msg);
				myMessageRanges.add(new Range(curStart, curStart + bufToString.length()));
			}

		}

		// List<String> b = new ArrayList<String>();
		// StringBuilder fullMsgBuilder = new StringBuilder();
		// int start = 0;
		// int end = 0;
		// int charIndex = 0;
		// boolean inMsg = false;
		// for (String line : lines) {
		//
		// if (line.startsWith("MSH")) {
		// addMessageIfAny(b, start, end);
		// b.clear();
		// start = charIndex;
		// inMsg = true;
		// }
		//
		// if (line.trim().length() == 0) {
		// if (inMsg) {
		// addMessageIfAny(b, start, end);
		// b.clear();
		// inMsg = false;
		// }
		// } else if (!line.matches("^[A-Z][A-Z0-9]{2}.*") && inMsg) {
		// addMessageIfAny(b, start, end);
		// b.clear();
		// inMsg = false;
		// }
		//
		// b.add(line);
		//
		// fullMsgBuilder.append(line);
		// fullMsgBuilder.append('\r');
		//
		// charIndex += line.length();
		// charIndex++;
		// end = charIndex;
		// }
		//
		// addMessageIfAny(b, start, end);
	}

	private synchronized void doSetSourceMessageXml(String theMessage) {
		int rangeStart = 0;
		int rangeEnd = 0;

		Pattern p = Pattern.compile("<([A-Za-z0-9_]+).*?>");
		Matcher m = p.matcher(theMessage);

		while (rangeStart < theMessage.length() && m.find(rangeStart)) {

			int startIndex = m.start();
			String tagName = m.group(1);

			Pattern endP = Pattern.compile("</" + tagName + "(\\s.*?)?>");
			Matcher endM = endP.matcher(theMessage);
			boolean foundEnd = endM.find(startIndex);

			if (foundEnd) {

				String fullMsg = theMessage.substring(startIndex, endM.end());
				Hl7V2MessageXml nextMsg = new Hl7V2MessageXml();
				nextMsg.setIndexWithinCollection(myMessages.size());
				nextMsg.setRuntimeProfile(myRuntimeProfile);
				nextMsg.setEncoding(Hl7V2EncodingTypeEnum.XML);
				try {
					nextMsg.setSourceMessage(fullMsg);
					myMessages.add(nextMsg);
				} catch (PropertyVetoException e) {
					UnknownMessage nextUnk = new UnknownMessage(fullMsg);
					myMessages.add(nextUnk);
				}

				rangeEnd = endM.end();

			} else {

				String fullMsg = theMessage.substring(startIndex);
				UnknownMessage nextUnk = new UnknownMessage(fullMsg);
				myMessages.add(nextUnk);
				rangeEnd = theMessage.length();

			}

			myMessageRanges.add(new Range(rangeStart, rangeEnd));
			rangeStart = rangeEnd;

		}

		// for (String nextString : msgs) {
		//
		// if (StringUtils.isNotBlank(nextString)) {
		//
		// nextString = "<?xml" + nextString;
		// Hl7V2MessageXml nextMsg = new Hl7V2MessageXml();
		// nextMsg.setIndexWithinCollection(myMessages.size());
		// nextMsg.setRuntimeProfile(myRuntimeProfile);
		// nextMsg.setEncoding(Hl7V2EncodingTypeEnum.XML);
		// try {
		// nextMsg.setSourceMessage(nextString);
		// myMessages.add(nextMsg);
		// } catch (PropertyVetoException e) {
		// UnknownMessage nextUnk = new UnknownMessage(nextString);
		// myMessages.add(nextUnk);
		// }
		//
		// }
		// }
	}

	private void ensureSourceMessage() {
		if (mySourceMessage == null) {
			mySourceMessage = "";
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object theObj) {
		if (!(theObj instanceof Hl7V2MessageCollection)) {
			return false;
		}
		Hl7V2MessageCollection o = (Hl7V2MessageCollection) theObj;
		return StringUtils.equals(myId, o.myId);
	}

	@Override
	public String exportConfigToXml() {
		XmlFormat xml = exportCreate();
		return exportWrite(xml);
	}

	public String exportConfigToXmlWithoutContents() {
		XmlFormat xml = exportCreate();
		xml.mySourceMessage = null;
		return exportWrite(xml);
	}

	private XmlFormat exportCreate() {
		XmlFormat xml = new XmlFormat();

		xml.myId = this.myId;

		if (getSaveFileName() == null) {
			xml.mySourceMessage = this.mySourceMessage.replaceAll("((\r\n)|\r)|(\n)", "\n");
		}

		xml.mySaveCharsetName = mySaveCharset != null ? mySaveCharset.name() : "";
		xml.mySaved = this.mySaved;
		xml.mySaveFileName = StringUtils.isNotBlank(mySaveFileName) ? mySaveFileName : "";
		xml.myEncodingType = myEncoding.name();
		xml.myValidationContextClass = myValidationContext != null ? myValidationContext.getClass().getName() : "";
		xml.myProfileId = myProfileId != null ? myProfileId : "";
		xml.mySaveStripComments = Boolean.toString(myStripSaveComments);
		xml.mySaveLineEndings = mySaveLineEndings != null ? mySaveLineEndings.name() : "";
		xml.mySaveTimestamp = mySaveFileTimestamp;
		xml.myLastSendToInterfaceId = myLastSendToInterfaceId;
		xml.myEditorShowMode = getEditorShowMode();
		xml.mySendNumberOfTimes = mySendNumberOfTimes;
		return xml;
	}

	private String exportWrite(XmlFormat xml) {
		StringWriter stringWriter = new StringWriter();
		JAXB.marshal(xml, stringWriter);
		String string = stringWriter.toString();
		return string;
	}

	private synchronized int findSegmentMsgIndex(Message message) {
		int msgIndex = -1;
		for (int i = 0; i < myMessages.size(); i++) {
			Object nextParsed = myMessages.get(i).getParsedMessage();
			if (nextParsed == message) {
				msgIndex = i;
				break;
			}
		}
		return msgIndex;
	}

	private String fixLineEndings(String theSourceMessage, LineEndingsEnum theEndings) {
		StringBuilder b = new StringBuilder(theSourceMessage.length());

		for (int i = 0; i < theSourceMessage.length(); i++) {

			char next = theSourceMessage.charAt(i);
			boolean isEnd = false;
			if (next == '\r') {
				isEnd = true;
			} else if (next == '\n') {
				if (i > 0 && theSourceMessage.charAt(i - 1) == '\r') {
					continue;
				} else {
					isEnd = true;
				}
			}

			if (isEnd) {
				if (theEndings == LineEndingsEnum.UNIX) {
					b.append('\n');
				} else if (theEndings == LineEndingsEnum.HL7) {
					b.append('\r');
				} else if (theEndings == LineEndingsEnum.WINDOWS) {
					b.append('\r');
					b.append('\n');
				}
			} else {
				b.append(next);
			}

		}

		return b.toString();
	}

	/**
	 * Returns whatever description of this message is most appropriate for
	 * dialogs relating to it (such as a prompt to save before closing)
	 */
	public String getBestDescription() {
		if (mySaveFileName != null) {
			return mySaveFileName;
		}
		return getMessageDescription();
	}

	/**
	 * @return the show
	 */
	public ShowEnum getEditorShowMode() {
		if (myShow == null) {
			myShow = ShowEnum.POPULATED;
		}
		return myShow;
	}

	public Hl7V2EncodingTypeEnum getEncoding() {
		return myEncoding;
	}

	public String getHighlitedPath() {
		return myHighlitedPath;
	}

	public String getId() {
		return myId;
	}

	/**
	 * @return the lastSendToInterfaceId
	 */
	public String getLastSendToInterfaceId() {
		return myLastSendToInterfaceId;
	}

	public String getMessageDescription() {
		if (myMessageDescription == null) {
			updateMessageDescription();
		}
		return myMessageDescription;
	}

	/**
	 * @return the messageRanges
	 */
	public List<Range> getMessageRanges() {
		return Collections.unmodifiableList(myMessageRanges);
	}

	/**
	 * @return the messages
	 */
	public List<AbstractMessage<?>> getMessages() {
		return myMessages;
	}

	/**
	 * @return the runtimeProfile
	 */
	public ProfileGroup getRuntimeProfile() {
		return myRuntimeProfile;
	}

	/**
	 * @return the saveCharset
	 */
	public Charset getSaveCharset() {
		return mySaveCharset;
	}

	/**
	 * @return the fileName
	 */
	public String getSaveFileName() {
		return mySaveFileName;
	}

	/**
	 * @return the saveFileTimestamp
	 */
	public long getSaveFileTimestamp() {
		return mySaveFileTimestamp;
	}

	/**
	 * @return the saveLineEndings
	 */
	public LineEndingsEnum getSaveLineEndings() {
		return mySaveLineEndings;
	}

	/**
	 * @return the sendNumberOfTimes
	 */
	public int getSendNumberOfTimes() {
		if (mySendNumberOfTimes <= 0) {
			return 1;
		}
		return mySendNumberOfTimes;
	}

	public String getSourceMessage() {
		return mySourceMessage;
	}

	/**
	 * @return the validationContext
	 */
	public ValidationContext getValidationContext() {
		return myValidationContext;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(myId).toHashCode();
	}

	/**
	 * @return the saved
	 */
	public boolean isSaved() {
		return mySaved;
	}

	/**
	 * @return the saveComments
	 */
	public boolean isSaveStripComments() {
		return myStripSaveComments;
	}

	public boolean isValidating() {
		return myValidationContext != null || myRuntimeProfile != null;
	}

	/**
	 * @param theShow
	 *            the show to set
	 */
	public void setEditorShowMode(ShowEnum theShow) {
		myShow = theShow;
	}

	public void setEncoding(Hl7V2EncodingTypeEnum theEncoding) {
		Validate.notNull(theEncoding);
		
		Hl7V2EncodingTypeEnum oldEncodingValue = myEncoding;
		if (myEncoding != theEncoding) {
			myEncoding = theEncoding;

			switch (myEncoding) {
			case ER_7:
				myParser.setPipeParserAsPrimary();
				break;
			case XML:
				myParser.setXMLParserAsPrimary();
				break;
			}

			StringBuilder b = new StringBuilder();
			myMessageRanges.clear();

			for (int i = 0; i < myMessages.size(); i++) {
				int start = b.length();

				AbstractMessage<?> nextObj = myMessages.get(i);
				if (nextObj instanceof Hl7V2MessageBase) {

					Hl7V2MessageBase messageImpl = (Hl7V2MessageBase) nextObj;
					messageImpl = messageImpl.asEncoding(myEncoding);

					b.append(messageImpl.getSourceMessage());
					myMessages.set(i, messageImpl);

				} else if (nextObj instanceof UnknownMessage) {

					UnknownMessage messageImpl = (UnknownMessage) nextObj;
					b.append(messageImpl.getSourceMessage());

				}

				b.append("\r\r");
				int end = b.length();
				myMessageRanges.add(new Range(start, end));
			}

			String oldValue = mySourceMessage;
			mySourceMessage = b.toString();
			firePropertyChange(SOURCE_MESSAGE_PROPERTY, oldValue, mySourceMessage);

			if (StringUtils.equals(oldValue, mySourceMessage) == false) {
				setSaved(false);
			}

			firePropertyChange(PROP_ENCODING, oldEncodingValue, myEncoding);
		}
	}

	public void setHighlitedPathBasedOnRange(Range theRange) {

		final String oldValue = myHighlitedPath;

		if (theRange == null) {
			myHighlitedPath = null;
		} else {
			for (int i = 0; i < myMessageRanges.size(); i++) {
				Range range = myMessageRanges.get(i);
				if (range.contains(theRange.getStart())) {
					AbstractMessage<?> am = myMessages.get(i);
					if (am instanceof Hl7V2MessageBase) {
						Hl7V2MessageBase messageImpl = (Hl7V2MessageBase) am;
						messageImpl.setHighlitedPathBasedOnRange(theRange.add(-range.getStart()));
						myHighlitedPath = i + messageImpl.getHighlitedPath();
					}
					break;
				}
			}
		} // if-else

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				firePropertyChange(PROP_HIGHLITED_PATH, oldValue, myHighlitedPath);
				updateMessageDescription();
			}
		});

	}

	public void setHighlitedRangeBasedOnField(SegmentAndComponentPath thePath) {
		Segment segment = thePath.getSegment();
		Message message = segment.getMessage();
		int msgIndex = findSegmentMsgIndex(message);

		Range oldValue = myHighlitedRange;
		if (msgIndex != -1) {
			Hl7V2MessageBase msg = (Hl7V2MessageBase) myMessages.get(msgIndex);
			msg.setHighlitedField(thePath);
			myHighlitedRange = msg.getHighlitedRange();
			if (myHighlitedRange != null) {
				myHighlitedRange = myHighlitedRange.add(myMessageRanges.get(msgIndex).getStart());
			} else {
				ourLog.info("No highlited range");
			}
		} else {
			ourLog.info("Couldn't find message");
		}

		firePropertyChange(PROP_HIGHLITED_RANGE, oldValue, myHighlitedRange);
	}

	public void setHighlitedRangeBasedOnSegment(Segment... theSegment) {
		Range oldValue = myHighlitedRange;

		if (theSegment == null || theSegment.length == 0) {
			myHighlitedRange = null;
			firePropertyChange(PROP_HIGHLITED_RANGE, oldValue, myHighlitedRange);
			return;
		}

		Message message = theSegment[0].getMessage();
		int msgIndex = findSegmentMsgIndex(message);

		if (msgIndex != -1) {
			Hl7V2MessageBase msg = (Hl7V2MessageBase) myMessages.get(msgIndex);
			msg.setHighlitedRangeBasedOnSegment(theSegment);
			myHighlitedRange = msg.getHighlitedRange();
			if (myHighlitedRange != null) {
				myHighlitedRange = myHighlitedRange.add(myMessageRanges.get(msgIndex).getStart());
			} else {
				ourLog.info("No highlited range");
			}
		} else {
			ourLog.info("Couldn't find message");
		}

		firePropertyChange(PROP_HIGHLITED_RANGE, oldValue, myHighlitedRange);

	}

	private void setId(String theId) {
		myId = theId;
	}

	/**
	 * @param theLastSendToInterfaceId
	 *            the lastSendToInterfaceId to set
	 */
	public void setLastSendToInterfaceId(String theLastSendToInterfaceId) {
		myLastSendToInterfaceId = theLastSendToInterfaceId;
	}

	public void setRuntimeProfile(ProfileGroup theProfileGroup) throws ProfileException {
		if (theProfileGroup == null && myRuntimeProfile == null && myValidationContext == null) {
			return;
		}

		if (theProfileGroup == null && myRuntimeProfile == null && myValidationContext != null) {
			myValidationContext = null;
			myRuntimeProfile = null;
			myProfileId = null;
			firePropertyChange(PROP_VALIDATIONCONTEXT_OR_PROFILE, null, null);
			return;
		}

		myRuntimeProfile = theProfileGroup;
		myValidationContext = null;
		myProfileId = theProfileGroup.getId();

		for (AbstractMessage<?> next : myMessages) {
			if (next instanceof Hl7V2MessageBase) {
				((Hl7V2MessageBase) next).setRuntimeProfile(myRuntimeProfile);
			}
		}

		firePropertyChange(PROP_VALIDATIONCONTEXT_OR_PROFILE, null, null);
	}

	/**
	 * @param theSaveCharset
	 *            the saveCharset to set
	 */
	public void setSaveCharset(Charset theSaveCharset) {
		mySaveCharset = theSaveCharset;
	}

	/**
	 * @param theSaved
	 *            the saved to set
	 */
	public void setSaved(boolean theSaved) {
		boolean oldValue = mySaved;
		mySaved = theSaved;
		firePropertyChange(SAVED_PROPERTY, oldValue, mySaved);
	}

	/**
	 * @param theFileName
	 *            the fileName to set
	 */
	public void setSaveFileName(String theFileName) {
		String oldValue = null;
		mySaveFileName = theFileName;
		firePropertyChange(PROP_SAVE_FILENAME, oldValue, theFileName);

		updateMessageDescription();
	}

	/**
	 * @param theSaveFileTimestamp
	 *            the saveFileTimestamp to set
	 */
	public void setSaveFileTimestamp(long theSaveFileTimestamp) {
		mySaveFileTimestamp = theSaveFileTimestamp;
	}

	public void setSaveLineEndings(LineEndingsEnum theLineEndings) {
		mySaveLineEndings = theLineEndings;
	}

	public void setSaveStripComments(boolean theSaveComments) {
		myStripSaveComments = theSaveComments;
	}

	/**
	 * @param theSendNumberOfTimes
	 *            the sendNumberOfTimes to set
	 */
	public void setSendNumberOfTimes(int theSendNumberOfTimes) {
		mySendNumberOfTimes = theSendNumberOfTimes;
	}

	public void setSourceMessage(String theSourceMessage) {
		ourLog.info("About to set source message for collection");

		ArrayList<AbstractMessage<?>> oldMessages = new ArrayList<AbstractMessage<?>>(myMessages);
		myMessages.clear();
		myMessageRanges.clear();

		String message = fixLineEndings(theSourceMessage, LineEndingsEnum.HL7);

		if (myEncoding == Hl7V2EncodingTypeEnum.ER_7) {
			doSetSourceMessageEr7(message);
		} else {
			doSetSourceMessageXml(message);
		}

		String oldValue = mySourceMessage;
		mySourceMessage = theSourceMessage;

		ourLog.info("Firing message change event");

		firePropertyChange(PARSED_MESSAGES_PROPERTY, oldMessages, myMessages);
		firePropertyChange(SOURCE_MESSAGE_PROPERTY, oldValue, mySourceMessage);

		if (StringUtils.equals(oldValue, mySourceMessage) == false) {
			setSaved(false);
		}

		updateMessageDescription();

		ourLog.info("Done setting source message for collection");
	}

	/**
	 * @param theValidationContext
	 *            the validationContext to set
	 */
	public void setValidationContext(ValidationContext theValidationContext) {
		if (myValidationContext instanceof DefaultValidation && theValidationContext instanceof DefaultValidation) {
			return;
		}

		if (theValidationContext != null) {
			myRuntimeProfile = null;
			myRuntimeProfile = null;
		}

		ourLog.info("Setting validation context to: " + theValidationContext);

		for (AbstractMessage<?> next : myMessages) {
			if (next instanceof Hl7V2MessageBase) {
				((Hl7V2MessageBase) next).setRuntimeProfile(null);
			}
		}

		ValidationContext oldValue = myValidationContext;
		myValidationContext = theValidationContext;
		firePropertyChange(PROP_VALIDATIONCONTEXT_OR_PROFILE, oldValue, theValidationContext);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return Hl7V2MessageCollection.class.getSimpleName() + "[" + getSaveFileName() + "]";
	}

	private void updateMessageDescription() {
		String oldValue = myMessageDescription;

		Matcher matcher = FIRSTLINE_COMMENT_PATTERN.matcher(StringUtils.defaultString(mySourceMessage));
		if (matcher.find()) {

			myMessageDescription = matcher.group(1).trim();

		} else if (mySaveFileName == null) {

			int msgs = 0;
			AbstractMessage<?> firstNonComment = null;
			for (AbstractMessage<?> next : myMessages) {
				if (!(next instanceof Comment)) {
					if (msgs == 0) {
						firstNonComment = next;
					}
					msgs++;
				}
			}

			if (msgs == 0) {
				myMessageDescription = "None";
			} else if (msgs == 1) {
				if (firstNonComment instanceof UnknownMessage) {
					myMessageDescription = "Unknown";
				} else if (firstNonComment instanceof Hl7V2MessageBase) {
					myMessageDescription = ((Hl7V2MessageBase) firstNonComment).getMessageDescription();
				} else {
					myMessageDescription = "None";
				}
			} else {
				myMessageDescription = msgs + " messages";
			}

		} else {

			myMessageDescription = mySaveFileName.replaceAll(".*(\\\\|\\/)", "");

		}

		firePropertyChange(PROP_DESCRIPTION, oldValue, myMessageDescription);
	}

	public void updateSourceMessage(String theNewSource, int theChangeStart, int theChangeEnd) {
		// TODO: optimize this to only update changed bits
		setSourceMessage(theNewSource);
	}

	private synchronized void updateSourceMessageBasedOnEncodedMessage(int theMessageIndex, String theEncodedMessage) {
		setHighlitedPathBasedOnRange(null);

		Range range = myMessageRanges.get(theMessageIndex);

		String oldValue = mySourceMessage;

		String preMessage = mySourceMessage.substring(0, range.getStart());
		String postMessage = mySourceMessage.length() > range.getEnd() ? mySourceMessage.substring(range.getEnd()) : "";
		mySourceMessage = preMessage + theEncodedMessage + postMessage;

		int sizeDifference = theEncodedMessage.length() - range.getDelta();
		for (int i = theMessageIndex; i < myMessageRanges.size(); i++) {
			if (i == theMessageIndex) {
				myMessageRanges.set(i, myMessageRanges.get(i).addToEnd(sizeDifference));
			} else {
				myMessageRanges.set(i, myMessageRanges.get(i).addToBoth(sizeDifference));
			}
		}

		Hl7V2MessageBase msgBase = (Hl7V2MessageBase) myMessages.get(theMessageIndex);
		try {
			msgBase.setSourceMessage(theEncodedMessage);
		} catch (PropertyVetoException e) {
			ourLog.error("Failed to update message", e);
		}

		firePropertyChange(SOURCE_MESSAGE_PROPERTY, oldValue, mySourceMessage);

		if (StringUtils.equals(oldValue, mySourceMessage) == false) {
			setSaved(false);
		}

	}

	public void updateSourceMessageBasedOnParsedMessage(int theMessageIndex, Message theMsg) {
		String encodedMessage;
		try {
			encodedMessage = myParser.encode(theMsg);
		} catch (HL7Exception e) {
			ourLog.error("Failed to encode message", e);
			return;
		}

		updateSourceMessageBasedOnEncodedMessage(theMessageIndex, encodedMessage);
	}

	/**
	 * Write the messages to an output stream
	 */
	public void writeToFile(Writer theWriter, boolean theSelectedSaveStripComments, LineEndingsEnum theSelectedLineEndings) throws IOException {
		String toWrite = mySourceMessage;

		if (theSelectedSaveStripComments) {
			switch (myEncoding) {
			case ER_7:

				Pattern p = Pattern.compile("(^|\\r)\\s*#[^\\r]*");
				Matcher m = p.matcher(toWrite);
				toWrite = m.replaceAll("").trim() + "\r";

				p = Pattern.compile("\\r\\s*\\r");
				m = p.matcher(toWrite);
				toWrite = m.replaceAll("\r");

				break;
			}
		}

		toWrite = fixLineEndings(toWrite, theSelectedLineEndings);

		theWriter.append(toWrite);
	}

	public static Hl7V2MessageCollection fromXml(ProfileFileList theProfileFileList, String theContents) {
		XmlFormat xmlFormat = JAXB.unmarshal(new StringReader(theContents), XmlFormat.class);

		Hl7V2MessageCollection retVal = new Hl7V2MessageCollection();

		retVal.setSaveFileName(isNotBlank(xmlFormat.mySaveFileName) ? xmlFormat.mySaveFileName : null);
		retVal.setId(xmlFormat.myId);
		retVal.setLastSendToInterfaceId(xmlFormat.myLastSendToInterfaceId);
		retVal.setEditorShowMode(xmlFormat.myEditorShowMode);
		retVal.setSendNumberOfTimes(xmlFormat.mySendNumberOfTimes);

		try {
			retVal.setSaveCharset(isNotEmpty(xmlFormat.mySaveCharsetName) ? Charset.forName(xmlFormat.mySaveCharsetName) : null);
		} catch (IllegalCharsetNameException e) {
			// ignore
		}

		if (isNotBlank(xmlFormat.myValidationContextClass)) {
			retVal.setValidationContext(ClassUtils.instantiateOrReturnNull(xmlFormat.myValidationContextClass, ValidationContext.class));
		}

		if (isNotBlank(xmlFormat.myProfileId)) {
			try {
				retVal.setRuntimeProfile(theProfileFileList.getProfile(xmlFormat.myProfileId));
			} catch (ProfileException e) {
				ourLog.error("Failed to retrieve profile with id: " + xmlFormat.myProfileId, e);
			}
		}

		try {
			retVal.setSaveLineEndings(LineEndingsEnum.valueOf(xmlFormat.mySaveLineEndings));
		} catch (Exception e) {
			retVal.setSaveLineEndings(LineEndingsEnum.HL7);
		}

		retVal.setSaveStripComments(Boolean.parseBoolean(xmlFormat.mySaveStripComments));

		retVal.setEncoding("XML".equals(xmlFormat.myEncodingType) ? Hl7V2EncodingTypeEnum.XML : Hl7V2EncodingTypeEnum.ER_7);

		if (StringUtils.isNotBlank(xmlFormat.mySourceMessage)) {
			retVal.setSourceMessage(xmlFormat.mySourceMessage);
		} else {
			retVal.setSourceMessage("");
		}

		retVal.setSaveFileTimestamp(xmlFormat.mySaveTimestamp);

		// set this last!
		retVal.setSaved(xmlFormat.mySaved);

		return retVal;
	}

	public static void main(String[] args) {

		System.out.println(Pattern.compile("<([A-Z0-9_]+)").matcher("<ORU_R01 xmlns=\"ffdf\">aaaaa").find());

	}

	private enum ParserState {
		AT_MSG_START, COMMENT, IN_MSG, NONE, UNKNOWN
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "Hl7V2MessageCollection", namespace = "urn:ca.uhn.hapi:testpanel")
	private static class XmlFormat {

		@XmlAttribute(required = false, name = "editorShowMode")
		public ShowEnum myEditorShowMode;

		@XmlAttribute(required = true, name = "encodingType")
		public String myEncodingType;

		@XmlAttribute(required = true, name = "id")
		public String myId;

		@XmlAttribute(required = false, name = "lastSendToInterfaceId")
		private String myLastSendToInterfaceId;

		@XmlElement(required = true, name = "profileId")
		public String myProfileId;

		@XmlAttribute(required = true, name = "charsetName")
		private String mySaveCharsetName;

		@XmlAttribute(required = true, name = "saved")
		private boolean mySaved;

		@XmlAttribute(required = true, name = "saveFileName")
		private String mySaveFileName;

		@XmlAttribute(required = true, name = "saveLineEndings")
		private String mySaveLineEndings;

		@XmlAttribute(required = true, name = "saveStripComments")
		private String mySaveStripComments;

		@XmlAttribute(required = true, name = "saveFileTimestamp")
		private long mySaveTimestamp;

		@XmlAttribute(required = false, name = "sendNumberOfTimes")
		public int mySendNumberOfTimes;

		@XmlElement(required = true, name = "sourceMessage")
		public String mySourceMessage;

		@XmlElement(required = true, name = "validationContextClass")
		public String myValidationContextClass;

	}

}
