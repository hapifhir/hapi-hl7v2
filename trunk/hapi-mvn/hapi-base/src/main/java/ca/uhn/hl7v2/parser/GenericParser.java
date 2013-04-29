/**
The contents of this file are subject to the Mozilla Public License Version 1.1
(the "License"); you may not use this file except in compliance with the License.
You may obtain a copy of the License at http://www.mozilla.org/MPL/
Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
specific language governing rights and limitations under the License.

The Original Code is "GenericParser.java".  Description:
"A Parser that delegates parsing tasks to an underlying PipeParser and DefaultXMLParser"

The Initial Developer of the Original Code is University Health Network. Copyright (C)
2001.  All Rights Reserved.

Contributor(s): ______________________________________.

Alternatively, the contents of this file may be used under the terms of the
GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
applicable instead of those above.  If you wish to allow use of your version of this
file only under the terms of the GPL and not to allow others to use your version
of this file under the MPL, indicate your decision by deleting  the provisions above
and replace  them with the notice and other provisions required by the GPL License.
If you do not delete the provisions above, a recipient may use your version of
this file under either the MPL or the GPL.

 */
package ca.uhn.hl7v2.parser;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.impl.NoValidation;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;

/**
 * A Parser that delegates parsing tasks to an underlying PipeParser and DefaultXMLParser as needed.
 * Messages to be parsed are inspected in order to determine which Parser to use. If a message is to
 * be encoded, the "primary" Parser will be used. The primary parser defaults to PipeParser, and can
 * be configured using the set...AsPrimary() methods.
 * 
 * @author Bryan Tripp
 */
public class GenericParser extends Parser {

	private Parser primaryParser;
	private Parser secondaryParser;
	private final PipeParser pipeParser;
	private final XMLParser xmlParser;

	/** Creates a new instance of GenericParser */
	public GenericParser() {
		this(new DefaultHapiContext());
	}

    /**
     * @param context the HapiContext to be used
     */
	public GenericParser(HapiContext context) {
		super(context);
		pipeParser = new PipeParser(context);
		xmlParser = new DefaultXMLParser(context);
		setPipeParserAsPrimary();
	}

	/**
	 * Creates a new instance of GenericParser
	 * 
	 * @param theFactory custom factory to use for model class lookup
	 */
	public GenericParser(ModelClassFactory theFactory) {
		super(theFactory);

		pipeParser = new PipeParser(theFactory);
		xmlParser = new DefaultXMLParser(theFactory);
		setPipeParserAsPrimary();
	}

	/**
	 * Sets the underlying XMLParser as the primary parser, so that subsequent calls to encode()
	 * will return XML encoded messages, and an attempt will be made to use the XMLParser first for
	 * parsing.
	 */
	public void setXMLParserAsPrimary() {
		primaryParser = xmlParser;
		secondaryParser = pipeParser;
	}

	/**
	 * Sets the underlying PipeParser as the primary parser, so that subsequent calls to encode()
	 * will return traditionally encoded messages, and an attempt will be made to use the PipeParser
	 * first for parsing. This is the default setting.
	 */
	public void setPipeParserAsPrimary() {
		primaryParser = pipeParser;
		secondaryParser = xmlParser;
	}

	/**
	 * Returns true if the pipe parser is primary
     *
     * @return true if the pipe parser is primary
	 */
	public boolean isPipeParserPrimary() {
		return primaryParser == pipeParser;
	}

	/**
	 * @param theContext the set of validation rules to be applied to messages parsed or encoded by
	 *            this parser (defaults to ValidationContextFactory.DefaultValidation)
	 * 
	 * @deprecated use a dedicated {@link HapiContext} and set its ValidationContext property
	 */
	public void setValidationContext(ValidationContext theContext) {
		super.setValidationContext(theContext);

		// These parsers are not yet initialized when this is called during the Parser constructor
		if (xmlParser != null) {
			pipeParser.setValidationContext(theContext);
			xmlParser.setValidationContext(theContext);
		}
	}

	/**
	 * Checks the encoding of the message using getEncoding(), and returns the corresponding parser
	 * (either pipeParser or xmlParser). If the encoding is not recognized an HL7Exception is
	 * thrown.
	 */
	private Parser getAppropriateParser(String message) throws HL7Exception {
	    String encoding = getEncoding(message);
    	if ("VB".equalsIgnoreCase(encoding)) return pipeParser;
    	if ("XML".equalsIgnoreCase(encoding)) return xmlParser;
        throw new HL7Exception("Can't find appropriate parser - encoding not recognized");          
	}

	/**
	 * Formats a Message object into an HL7 message string using the given encoding.
	 * 
	 * @throws HL7Exception if the data fields in the message do not permit encoding (e.g. required
	 *             fields are null)
	 * @throws EncodingNotSupportedException if the requested encoding is not supported by this
	 *             parser.
	 */
	protected String doEncode(Message source, String encoding) throws HL7Exception,
			EncodingNotSupportedException {
		String ret = null;
		if (encoding == null)
			encoding = ""; // prevent null pointer exception
		if (encoding.equalsIgnoreCase("VB")) {
			ret = pipeParser.doEncode(source);
		} else if (encoding.equalsIgnoreCase("XML")) {
			ret = xmlParser.doEncode(source);
		} else {
			throw new EncodingNotSupportedException("The encoding " + encoding
					+ " is not supported by " + this.getClass().getName());
		}
		return ret;
	}

	/**
	 * <p>
	 * Returns a minimal amount of data from a message string, including only the data needed to
	 * send a response to the remote system. This includes the following fields:
	 * <ul>
	 * <li>field separator</li>
	 * <li>encoding characters</li>
	 * <li>processing ID</li>
	 * <li>message control ID</li>
	 * </ul>
	 * This method is intended for use when there is an error parsing a message, (so the Message
	 * object is unavailable) but an error message must be sent back to the remote system including
	 * some of the information in the inbound message. This method parses only that required
	 * information, hopefully avoiding the condition that caused the original error.
	 * </p>
	 */
	public Segment getCriticalResponseData(String message) throws HL7Exception {
		return getAppropriateParser(message).getCriticalResponseData(message);
	}

	/**
	 * Returns the version ID (MSH-12) from the given message, without fully parsing the message.
	 * The version is needed prior to parsing in order to determine the message class into which the
	 * text of the message should be parsed.
	 * 
	 * @throws HL7Exception if the version field can not be found.
	 */
	public String getVersion(String message) throws HL7Exception {
		return getAppropriateParser(message).getVersion(message);
	}

	/**
	 * Returns a String representing the encoding of the given message, if the encoding is
	 * recognized. For example if the given message appears to be encoded using HL7 2.x XML rules
	 * then "XML" would be returned. If the encoding is not recognized then null is returned. That
	 * this method returns a specific encoding does not guarantee that the message is correctly
	 * encoded (e.g. well formed XML) - just that it is not encoded using any other encoding than
	 * the one returned. Returns null if the encoding is not recognized.
	 */
	public String getEncoding(String message) {
		String encoding = primaryParser.getEncoding(message);
		return (encoding == null ? secondaryParser.getEncoding(message) : encoding);
	}

	/**
	 * For response messages, returns the value of MSA-2 (the message ID of the message sent by the
	 * sending system). This value may be needed prior to main message parsing, so that
	 * (particularly in a multi-threaded scenario) the message can be routed to the thread that sent
	 * the request. We need this information first so that any parse exceptions are thrown to the
	 * correct thread. Implementers of Parsers should take care to make the implementation of this
	 * method very fast and robust. Returns null if MSA-2 can not be found (e.g. if the message is
	 * not a response message).
	 */
	public String getAckID(String message) {
		try {
			return getAppropriateParser(message).getAckID(message);
		} catch (HL7Exception e) {
			return null;
		}
	}

	/**
	 * Returns true if and only if the given encoding is supported by this Parser.
	 */
	public boolean supportsEncoding(String encoding) {
		return (primaryParser.supportsEncoding(encoding) || secondaryParser.supportsEncoding(encoding));
	}

	/**
	 * @return the preferred encoding of the current primary Parser
	 */
	public String getDefaultEncoding() {
		return primaryParser.getDefaultEncoding();
	}

	/**
	 * Parses a message string and returns the corresponding Message object.
	 * 
	 * @throws HL7Exception if the message is not correctly formatted.
	 * @throws EncodingNotSupportedException if the message encoded is not supported by this parser.
	 */
	protected Message doParse(String message, String version) throws HL7Exception {
		return getAppropriateParser(message).doParse(message, version);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Message parse(String theMessage) throws HL7Exception {
		Message retVal = super.parse(theMessage);
		Parser parser = getAppropriateParser(theMessage);
		retVal.setParser(parser);
		return retVal;
	}

	/**
	 * Formats a Message object into an HL7 message string using this parser's default encoding.
	 * 
	 * @throws HL7Exception if the data fields in the message do not permit encoding (e.g. required
	 *             fields are null)
	 */
	protected String doEncode(Message source) throws HL7Exception {
		return primaryParser.doEncode(source);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public String doEncode(Segment structure, EncodingCharacters encodingCharacters)
			throws HL7Exception {
		return primaryParser.doEncode(structure, encodingCharacters);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public String doEncode(Type type, EncodingCharacters encodingCharacters) throws HL7Exception {
		return primaryParser.doEncode(type, encodingCharacters);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void parse(Type type, String string, EncodingCharacters encodingCharacters)
			throws HL7Exception {
		primaryParser.parse(type, string, encodingCharacters);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void parse(Segment segment, String string, EncodingCharacters encodingCharacters)
			throws HL7Exception {
		primaryParser.parse(segment, string, encodingCharacters);
	}

	@Override
	public void parse(Message message, String string) throws HL7Exception {
		primaryParser.parse(message, string);
	}

    /**
     * Convenience factory method which returns an instance that has a {@link NoValidation
     * NoValidation validation context}.
     *
     * @return instance of GenericParser without validation
     */
    public static GenericParser getInstanceWithNoValidation() {
        return new GenericParser(
                new DefaultHapiContext(ValidationContextFactory.noValidation()));
    }

	@Override
	protected Message doParseForSpecificPackage(String theMessage, String theVersion,
			String thePackageName) throws HL7Exception, EncodingNotSupportedException {
		return primaryParser.doParseForSpecificPackage(theMessage, theVersion, thePackageName);
	}

	public static void main(String[] args) throws HL7Exception {

		String msgString = "MSH|^~\\&|RAMSOFT|SENDING FACILITY|RAMSOFT|RECEIVING FACILITY|20101223202939-0400||ADT^A08|101|P|2.3.1||||||||\r"
				+ "EVN|A08|20101223202939-0400||||\r"
				+ "PID||P12345^^^ISSUER|P12345^^^ISSUER||PATIENT^TEST^M^^^^||19741018|M|||10808 FOOTHILL BLVD^^RANCHO CUCAMONGA^CA^91730^US||(909)481-5872^^^sales@ramsoft.com|(909)481-5800x1||M||12345|286-50-9510|||\r"
				+ "PV1||O||||||||||||||||||||||||||||||||||||||||||||||||||\r"
				+ "AL1|1||^PORK^|\r"
				+ "AL1|2||^PENICILLIN^|";

		GenericParser parser = new GenericParser();
		parser.setValidationContext(ValidationContextFactory.noValidation());
		Message msg = parser.parse(msgString);
		System.out.println(msg.getClass().getName());

	}



}
