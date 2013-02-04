/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "XMLParser.java".  Description:
 * "Parses and encodes HL7 messages in XML form, according to HL7's normative XML encoding
 * specification."
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2002.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  �GPL�), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.parser;

import java.util.HashSet;
import java.util.Set;

import ca.uhn.hl7v2.ErrorCode;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Composite;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.GenericComposite;
import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.GenericPrimitive;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.util.XMLUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Parses and encodes HL7 messages in XML form, according to HL7's normative XML encoding
 * specification. This is an abstract class that handles datatype and segment parsing/encoding, but
 * not the parsing/encoding of entire messages. To use the XML parser, you should create a subclass
 * for a certain message structure. This subclass must be able to identify the Segment objects that
 * correspond to various Segment nodes in an XML document, and call the methods <code>
 * parse(Segment segment, ElementNode segmentNode)</code> and
 * <code>encode(Segment segment, ElementNode segmentNode)
 * </code> as appropriate. XMLParser uses the Xerces parser, which must be installed in your
 * classpath.
 * 
 * @see ParserConfiguration for configuration options which may affect parser encoding and decoding behaviour
 * @author Bryan Tripp, Shawn Bellina
 */
public abstract class XMLParser extends Parser {

	private static final String ESCAPE_ATTRNAME = "V";
	private static final String ESCAPE_NODENAME = "escape";
	private static final Logger log = LoggerFactory.getLogger(XMLParser.class);

	private String textEncoding;

	/**
	 * The nodes whose names match these strings will be kept as original, meaning that no white
	 * space trimming will occur on them
	 */
	private String[] keepAsOriginalNodes;

	/**
	 * All keepAsOriginalNodes names, concatenated by a pipe (|)
	 */
	private String concatKeepAsOriginalNodes = "";

	/** Constructor */
	public XMLParser() {
		super();
	}

    /**
     *
     * @param context the HAPI context
     */
	public XMLParser(HapiContext context) {
		super(context);
	}

	/**
	 * Constructor
	 * 
	 * @param theFactory custom factory to use for model class lookup
	 */
	public XMLParser(ModelClassFactory theFactory) {
		super(theFactory);

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
		return EncodingDetector.isXmlEncoded(message) ? getDefaultEncoding() : null;
	}

	/**
	 * @return the preferred encoding of this Parser
	 */
	public String getDefaultEncoding() {
		return "XML";
	}

	/**
	 * Sets the <i>keepAsOriginalNodes<i>
	 * 
	 * The nodes whose names match the <i>keepAsOriginalNodes<i> will be kept as original, meaning
	 * that no white space treaming will occur on them
     *
     * @param keepAsOriginalNodes of the nodes to be kept as original
	 */
	public void setKeepAsOriginalNodes(String[] keepAsOriginalNodes) {
		this.keepAsOriginalNodes = keepAsOriginalNodes;

		if (keepAsOriginalNodes.length != 0) {
			// initializes the
			StringBuilder strBuf = new StringBuilder(keepAsOriginalNodes[0]);
			for (int i = 1; i < keepAsOriginalNodes.length; i++) {
				strBuf.append("|");
				strBuf.append(keepAsOriginalNodes[i]);
			}
			concatKeepAsOriginalNodes = strBuf.toString();
		} else {
			concatKeepAsOriginalNodes = "";
		}
	}

	/**
	 * Sets the <i>keepAsOriginalNodes<i>
	 */
	public String[] getKeepAsOriginalNodes() {
		return keepAsOriginalNodes;
	}

	/**
	 * <p>
	 * Creates and populates a Message object from an XML Document that contains an XML-encoded HL7
	 * message.
	 * </p>
	 * <p>
	 * The easiest way to implement this method for a particular message structure is as follows:
	 * <ol>
	 * <li>Create an instance of the Message type you are going to handle with your subclass of
	 * XMLParser</li>
	 * <li>Go through the given Document and find the Elements that represent the top level of each
	 * message segment.</li>
	 * <li>For each of these segments, call
	 * <code>parse(Segment segmentObject, Element segmentElement)</code>, providing the appropriate
	 * Segment from your Message object, and the corresponding Element.</li>
	 * </ol>
	 * At the end of this process, your Message object should be populated with data from the XML
	 * Document.
	 * </p>
	 *
     * @param xmlMessage DOM message object to be parsed
     * @param version HL7 version
	 * @throws HL7Exception if the message is not correctly formatted.
	 * @throws EncodingNotSupportedException if the message encoded is not supported by this parser.
	 */
	public abstract Message parseDocument(Document xmlMessage, String version) throws HL7Exception;

	/**
	 * <p>
	 * Parses a message string and returns the corresponding Message object. This method checks that
	 * the given message string is XML encoded, creates an XML Document object (using Xerces) from
	 * the given String, and calls the abstract method <code>parse(Document XMLMessage)</code>
	 * </p>
	 */
	protected Message doParse(String message, String version) throws HL7Exception {
		Message m;

		// parse message string into a DOM document
		Document doc;
		doc = parseStringIntoDocument(message);
		m = parseDocument(doc, version);

		return m;
	}

	/**
	 * Parses a string containing an XML document into a Document object.
	 * 
	 * Note that this method is synchronized currently, as the XML parser is not thread safe
	 * 
	 * @throws HL7Exception
	 */
	protected synchronized Document parseStringIntoDocument(String message) throws HL7Exception {
		try {
			return XMLUtils.parse(message);
		} catch (Exception e) {
			throw new HL7Exception("Exception parsing XML", e);
		}
	}

	/**
	 * Formats a Message object into an HL7 message string using the given encoding.
	 * 
	 * @throws HL7Exception if the data fields in the message do not permit encoding (e.g. required
	 *             fields are null)
	 * @throws EncodingNotSupportedException if the requested encoding is not supported by this
	 *             parser.
	 */
	protected String doEncode(Message source, String encoding) throws HL7Exception {
		if (!encoding.equals("XML"))
			throw new EncodingNotSupportedException("XMLParser supports only XML encoding");
		return encode(source);
	}

	/**
	 * Formats a Message object into an HL7 message string using this parser's default encoding (XML
	 * encoding). This method calls the abstract method <code>encodeDocument(...)</code> in order to
	 * obtain XML Document object representation of the Message, then serializes it to a String.
	 * 
	 * @throws HL7Exception if the data fields in the message do not permit encoding (e.g. required
	 *             fields are null)
	 */
	protected String doEncode(Message source) throws HL7Exception {
		if (source instanceof GenericMessage) {
			throw new HL7Exception(
					"Can't XML-encode a GenericMessage.  Message must have a recognized structure.");
		}

		Document doc = encodeDocument(source);
		// Element documentElement = doc.getDocumentElement();
		// if (!documentElement.hasAttribute("xmlns"))
		// documentElement.setAttribute("xmlns", "urn:hl7-org:v2xml");
		try {
			return XMLUtils.serialize(doc, getParserConfiguration().isPrettyPrintWhenEncodingXml());
		} catch (Exception e) {
			throw new HL7Exception("Exception serializing XML document to string", e);
		}
	}

	/**
	 * <p>
	 * Creates an XML Document that corresponds to the given Message object.
	 * </p>
	 * <p>
	 * If you are implementing this method, you should create an XML Document, and insert XML
	 * Elements into it that correspond to the groups and segments that belong to the message type
	 * that your subclass of XMLParser supports. Then, for each segment in the message, call the
	 * method <code>encode(Segment segmentObject, Element segmentElement)</code> using the Element
	 * for that segment and the corresponding Segment object from the given Message.
	 * </p>
     *
     * @param source message
     * @return the DOM document object of the encoded message
	 */
	public abstract Document encodeDocument(Message source) throws HL7Exception;

	/**
	 * Populates the given Segment object with data from the given XML Element.
	 *
     * @param segmentObject the segment to parse into
     * @param segmentElement the DOM element to be parsed
	 * @throws HL7Exception if the XML Element does not have the correct name and structure for the
	 *             given Segment, or if there is an error while setting individual field values.
	 */
	public void parse(Segment segmentObject, Element segmentElement) throws HL7Exception {
		Set<String> done = new HashSet<String>();

		NodeList all = segmentElement.getChildNodes();
		for (int i = 0; i < all.getLength(); i++) {
			String elementName = all.item(i).getNodeName();
			if (all.item(i).getNodeType() == Node.ELEMENT_NODE && !done.contains(elementName)) {
				done.add(elementName);

				int index = elementName.indexOf('.');
				if (index >= 0 && elementName.length() > index) { // properly formatted element
					String fieldNumString = elementName.substring(index + 1);
					int fieldNum = Integer.parseInt(fieldNumString);
					parseReps(segmentObject, segmentElement, elementName, fieldNum);
				} else {
					log.debug("Child of segment {} doesn't look like a field {}",
							segmentObject.getName(), elementName);
				}
			}
		}

		// set data type of OBX-5
		if (segmentObject.getClass().getName().contains("OBX")) {
			Varies.fixOBX5(segmentObject, getFactory(), getHapiContext().getParserConfiguration());
		}
	}

	private void parseReps(Segment segmentObject, Element segmentElement, String fieldName,
			int fieldNum) throws HL7Exception {

		NodeList reps = segmentElement.getElementsByTagName(fieldName);
		for (int i = 0; i < reps.getLength(); i++) {
			parse(segmentObject.getField(fieldNum, i), (Element) reps.item(i));
		}
	}

	/**
	 * Populates the given Element with data from the given Segment, by inserting Elements
	 * corresponding to the Segment's fields, their components, etc. Returns true if there is at
	 * least one data value in the segment.
     *
     * @param segmentObject the segment to be encoded
     * @param segmentElement the DOM element to encode into
     * @return true if there is at least one data value in the segment
     * @throws HL7Exception if an erro occurred while encoding
	 */
	public boolean encode(Segment segmentObject, Element segmentElement) throws HL7Exception {
		boolean hasValue = false;
		int n = segmentObject.numFields();
		for (int i = 1; i <= n; i++) {
			String name = makeElementName(segmentObject, i);
			Type[] reps = segmentObject.getField(i);
			for (Type rep : reps) {
				Element newNode = segmentElement.getOwnerDocument().createElement(name);
				boolean componentHasValue = encode(rep, newNode);
				if (componentHasValue) {
					try {
						segmentElement.appendChild(newNode);
					} catch (DOMException e) {
						throw new HL7Exception("DOMException encoding Segment: ", e);
					}
					hasValue = true;
				}
			}
		}
		return hasValue;
	}

	/**
	 * Populates the given Type object with data from the given XML Element.
     *
     * @param datatypeObject the type to parse into
     * @param datatypeElement the DOM element to be parsed
     * @throws DataTypeException if the data did not match the expected type rules
	 */
	public void parse(Type datatypeObject, Element datatypeElement) throws DataTypeException {
		if (datatypeObject instanceof Varies) {
			parseVaries((Varies) datatypeObject, datatypeElement);
		} else if (datatypeObject instanceof Primitive) {
			parsePrimitive((Primitive) datatypeObject, datatypeElement);
		} else if (datatypeObject instanceof Composite) {
			parseComposite((Composite) datatypeObject, datatypeElement);
		}
	}

	/**
	 * Parses an XML element into a Varies by determining whether the element is primitive or
	 * composite, calling setData() on the Varies with a new generic primitive or composite as
	 * appropriate, and then calling parse again with the new Type object.
	 */
	private void parseVaries(Varies datatypeObject, Element datatypeElement)
			throws DataTypeException {
		// figure out what data type it holds
		// short nodeType = datatypeElement.getFirstChild().getNodeType();
		if (!hasChildElement(datatypeElement)) {
			// it's a primitive
			datatypeObject.setData(new GenericPrimitive(datatypeObject.getMessage()));
		} else {
			// it's a composite ... almost know what type, except that we don't have the version
			// here
			datatypeObject.setData(new GenericComposite(datatypeObject.getMessage()));
		}
		parse(datatypeObject.getData(), datatypeElement);
	}

	/** Returns true if any of the given element's children are (non-escape) elements */
	private boolean hasChildElement(Element e) {
		NodeList children = e.getChildNodes();
		boolean hasElement = false;
		int c = 0;
		while (c < children.getLength() && !hasElement) {
			if (children.item(c).getNodeType() == Node.ELEMENT_NODE
					&& !ESCAPE_NODENAME.equals(children.item(c).getNodeName())) {
				hasElement = true;
			}
			c++;
		}
		return hasElement;
	}

	/**
	 * Parses a primitive type by filling it with text child, if any. If the datatype element
	 * contains escape elements, resolve them properly.
	 */
	private void parsePrimitive(Primitive datatypeObject, Element datatypeElement)
			throws DataTypeException {
		NodeList children = datatypeElement.getChildNodes();
		StringBuilder builder = new StringBuilder();
		for (int c = 0; c < children.getLength(); c++) {
			Node child = children.item(c);
			try {
				if (child.getNodeType() == Node.TEXT_NODE) {
					String value = child.getNodeValue();
					if (value != null && value.length() > 0) {
						if (keepAsOriginal(child.getParentNode())) {
							builder.append(value);
						} else {
							builder.append(removeWhitespace(value));
						}
					}
					// Check for formatting elements
				} else if (child.getNodeType() == Node.ELEMENT_NODE
						&& ESCAPE_NODENAME.equals(child.getNodeName())) {
					EncodingCharacters ec = EncodingCharacters.getInstance(datatypeObject
							.getMessage());
					Element elem = (Element) child;
					String attr = elem.getAttribute(ESCAPE_ATTRNAME).trim();
					if (attr != null && attr.length() > 0) {
						builder.append(ec.getEscapeCharacter()).append(attr)
								.append(ec.getEscapeCharacter());
					}
				}
			} catch (Exception e) {
				log.error("Error parsing primitive value from TEXT_NODE", e);
			}

		}
		datatypeObject.setValue(builder.toString());
	}

	/**
	 * Checks if <code>Node</code> content should be kept as original (ie.: whitespaces won't be
	 * removed)
	 * 
	 * @param node The target <code>Node</code>
	 * @return boolean <code>true</code> if whitespaces should not be removed from node content,
	 *         <code>false</code> otherwise
	 */
	protected boolean keepAsOriginal(Node node) {
		return (node.getNodeName() != null) && concatKeepAsOriginalNodes.contains(node.getNodeName());
	}

	/**
	 * Removes all unnecessary whitespace from the given String (intended to be used with Primitive
	 * values). This includes leading and trailing whitespace, and repeated space characters.
	 * Carriage returns, line feeds, and tabs are replaced with spaces.
	 */
	protected String removeWhitespace(String s) {
		s = s.replace('\r', ' ');
		s = s.replace('\n', ' ');
		s = s.replace('\t', ' ');

		boolean repeatedSpacesExist = true;
		while (repeatedSpacesExist) {
			int loc = s.indexOf("  ");
			if (loc < 0) {
				repeatedSpacesExist = false;
			} else {
				StringBuilder buf = new StringBuilder();
				buf.append(s.substring(0, loc));
				buf.append(" ");
				buf.append(s.substring(loc + 2));
				s = buf.toString();
			}
		}
		return s.trim();
	}

	/**
	 * Populates a Composite type by looping through it's children, finding corresponding Elements
	 * among the children of the given Element, and calling parse(Type, Element) for each.
	 */
	private void parseComposite(Composite datatypeObject, Element datatypeElement)
			throws DataTypeException {
		if (datatypeObject instanceof GenericComposite) { // elements won't be named
															// GenericComposite.x
			NodeList children = datatypeElement.getChildNodes();
			int compNum = 0;
			for (int i = 0; i < children.getLength(); i++) {
				if (children.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element nextElement = (Element) children.item(i);
					String localName = nextElement.getLocalName();
					int dotIndex = localName.indexOf(".");
					if (dotIndex > -1) {
						compNum = Integer.parseInt(localName.substring(dotIndex + 1)) - 1;
					} else {
						log.debug(
								"Datatype element {} doesn't have a valid numbered name, usgin default index of {}",
								datatypeElement.getLocalName(), compNum);
					}
					Type nextComponent = datatypeObject.getComponent(compNum);
					parse(nextComponent, nextElement);
					compNum++;
				}
			}
		} else {
			Type[] children = datatypeObject.getComponents();
			for (int i = 0; i < children.length; i++) {
				NodeList matchingElements = datatypeElement.getElementsByTagName(makeElementName(
						datatypeObject, i + 1));
				if (matchingElements.getLength() > 0) {
					parse(children[i], (Element) matchingElements.item(0)); // components don't
																			// repeat - use 1st
				}
			}
		}
	}

	/** Returns the expected XML element name for the given child of the given Segment */
	private String makeElementName(Segment s, int child) {
		return s.getName() + "." + child;
	}

	/** Returns the expected XML element name for the given child of the given Composite */
	private String makeElementName(Composite composite, int child) {
		return composite.getName() + "." + child;
	}

	/**
	 * Populates the given Element with data from the given Type, by inserting Elements
	 * corresponding to the Type's components and values. Returns true if the given type contains a
	 * value (i.e. for Primitives, if getValue() doesn't return null, and for Composites, if at
	 * least one underlying Primitive doesn't return null).
	 */
	private boolean encode(Type datatypeObject, Element datatypeElement) throws DataTypeException {
		boolean hasData = false;
		if (datatypeObject instanceof Varies) {
			hasData = encodeVaries((Varies) datatypeObject, datatypeElement);
		} else if (datatypeObject instanceof Primitive) {
			hasData = encodePrimitive((Primitive) datatypeObject, datatypeElement);
		} else if (datatypeObject instanceof Composite) {
			hasData = encodeComposite((Composite) datatypeObject, datatypeElement);
		}
		return hasData;
	}

	/**
	 * Encodes a Varies type by extracting it's data field and encoding that. Returns true if the
	 * data field (or one of its components) contains a value.
	 */
	private boolean encodeVaries(Varies datatypeObject, Element datatypeElement)
			throws DataTypeException {
		boolean hasData = false;
		if (datatypeObject.getData() != null) {
			hasData = encode(datatypeObject.getData(), datatypeElement);
		}
		return hasData;
	}

	/**
	 * Encodes a Primitive in XML by adding it's value as a child of the given Element. Detects
	 * escape character and creates proper <escape> elements in the DOM tree. Returns true if the
	 * given Primitive contains a value.
	 */
	private boolean encodePrimitive(Primitive datatypeObject, Element datatypeElement)
			throws DataTypeException {
		String value = datatypeObject.getValue();
		boolean hasValue = (value != null && value.length() > 0);
		if (hasValue) {
			try {
				EncodingCharacters ec = EncodingCharacters.getInstance(datatypeObject.getMessage());
				char esc = ec.getEscapeCharacter();
				int pos;
				int oldpos = 0;
				boolean escaping = false;

				// Find next escape character
				while ((pos = value.indexOf(esc, oldpos)) >= 0) {

					// string until next escape character
					String v = value.substring(oldpos, pos);
					if (!escaping) {
						// currently in "text mode", so create textnode from it
						if (v.length() > 0)
							datatypeElement.appendChild(datatypeElement.getOwnerDocument()
									.createTextNode(v));
						escaping = true;
					} else {
						if (v.startsWith(".") || "H".equals(v) || "N".equals(v)) {
							// currently in "escape mode", so create escape element from it
							Element escape = datatypeElement.getOwnerDocument().createElement(
									ESCAPE_NODENAME);
							escape.setAttribute(ESCAPE_ATTRNAME, v);
							datatypeElement.appendChild(escape);
							escaping = false;
						} else {
							// no proper escape sequence, assume text
							datatypeElement.appendChild(datatypeElement.getOwnerDocument()
									.createTextNode(esc + v));
						}
					}
					oldpos = pos + 1;
				}
				// create text from the remainder
				if (oldpos < value.length()) {

					StringBuilder sb = new StringBuilder();
					// If we are in escaping mode, there appears no closing escape character,
					// so we treat the string as text
					if (escaping)
						sb.append(esc);

					sb.append(value.substring(oldpos));
					datatypeElement.appendChild(datatypeElement.getOwnerDocument().createTextNode(
							sb.toString()));
				}

			} catch (Exception e) {
				throw new DataTypeException("Exception encoding Primitive: ", e);
			}

		}
		return hasValue;
	}

	/**
	 * Encodes a Composite in XML by looping through it's components, creating new children for each
	 * of them (with the appropriate names) and populating them by calling encode(Type, Element)
	 * using these children. Returns true if at least one component contains a value.
	 */
	private boolean encodeComposite(Composite datatypeObject, Element datatypeElement)
			throws DataTypeException {
		Type[] components = datatypeObject.getComponents();
		boolean hasValue = false;
		for (int i = 0; i < components.length; i++) {
			String name = makeElementName(datatypeObject, i + 1);
			Element newNode = datatypeElement.getOwnerDocument().createElement(name);
			boolean componentHasValue = encode(components[i], newNode);
			if (componentHasValue) {
				try {
					datatypeElement.appendChild(newNode);
				} catch (DOMException e) {
					throw new DataTypeException("DOMException encoding Composite: ", e);
				}
				hasValue = true;
			}
		}
		return hasValue;
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
		String version = getVersion(message);
		Segment criticalData = Parser.makeControlMSH(version, getFactory());

		Terser.set(criticalData, 1, 0, 1, 1, parseLeaf(message, "MSH.1", 0));
		Terser.set(criticalData, 2, 0, 1, 1, parseLeaf(message, "MSH.2", 0));
		Terser.set(criticalData, 10, 0, 1, 1, parseLeaf(message, "MSH.10", 0));
		String procID = parseLeaf(message, "MSH.11", 0);
		if (procID == null || procID.length() == 0) {
			procID = parseLeaf(message, "PT.1", message.indexOf("MSH.11"));
			// this field is a composite in later versions
		}
		Terser.set(criticalData, 11, 0, 1, 1, procID);

		return criticalData;
	}

	/**
	 * For response messages, returns the value of MSA-2 (the message ID of the message sent by the
	 * sending system). This value may be needed prior to main message parsing, so that
	 * (particularly in a multi-threaded scenario) the message can be routed to the thread that sent
	 * the request. We need this information first so that any parse exceptions are thrown to the
	 * correct thread. Implementers of Parsers should take care to make the implementation of this
	 * method very fast and robust. Returns null if MSA-2 can not be found (e.g. if the message is
	 * not a response message). Trims whitespace from around the MSA-2 field.
	 */
	public String getAckID(String message) {
		String ackID = null;
		try {
			ackID = parseLeaf(message, "msa.2", 0).trim();
		} catch (HL7Exception e) { /* OK ... assume it isn't a response message */
		}
		return ackID;
	}

	public String getVersion(String message) throws HL7Exception {
        String version = parseLeaf(message, "MSH.12", 0);
        if (version == null || version.trim().length() == 0) {
            version = parseLeaf(message, "VID.1", message.indexOf("MSH.12"));
        }
        return version;	    
	}

	/**
	 * Attempts to retrieve the value of a leaf tag without using DOM or SAX. This method searches
	 * the given message string for the given tag name, and returns everything after the given tag
	 * and before the start of the next tag. Whitespace is stripped. This is intended only for lead
	 * nodes, as the value is considered to end at the start of the next tag, regardless of whether
	 * it is the matching end tag or some other nested tag.
	 * 
	 * @param message a string message in XML form
	 * @param tagName the name of the XML tag, e.g. "MSA.2"
	 * @param startAt the character location at which to start searching
	 * @throws HL7Exception if the tag can not be found
	 */
	protected static String parseLeaf(String message, String tagName, int startAt) throws HL7Exception {
		String value;

		int tagStart = message.indexOf("<" + tagName, startAt);
		if (tagStart < 0)
			tagStart = message.indexOf("<" + tagName.toUpperCase(), startAt);
		int valStart = message.indexOf(">", tagStart) + 1;
		int valEnd = message.indexOf("<", valStart);

		if (tagStart >= 0 && valEnd >= valStart) {
			value = message.substring(valStart, valEnd);
		} else {
			throw new HL7Exception("Couldn't find " + tagName + " in message beginning: "
					+ message.substring(0, Math.min(150, message.length())),
					ErrorCode.REQUIRED_FIELD_MISSING);
		}

		// Escape codes, as defined at http://hdf.ncsa.uiuc.edu/HDF5/XML/xml_escape_chars.htm
		value = value.replaceAll("&quot;", "\"");
		value = value.replaceAll("&apos;", "'");
		value = value.replaceAll("&amp;", "&");
		value = value.replaceAll("&lt;", "<");
		value = value.replaceAll("&gt;", ">");

		return value;
	}

	/**
	 * Throws unsupported operation exception
	 * 
	 * @throws UnsupportedOperationException
	 */
	@Override
	public String doEncode(Segment structure, EncodingCharacters encodingCharacters)
			throws HL7Exception {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Throws unsupported operation exception
	 * 
	 * @throws UnsupportedOperationException
	 */
	@Override
	protected Message doParseForSpecificPackage(String theMessage, String theVersion,
			String thePackageName) throws HL7Exception {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Throws unsupported operation exception
	 * 
	 * @throws UnsupportedOperationException
	 */
	@Override
	public String doEncode(Type type, EncodingCharacters encodingCharacters) throws HL7Exception {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Throws unsupported operation exception
	 * 
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void parse(Type type, String string, EncodingCharacters encodingCharacters)
			throws HL7Exception {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Throws unsupported operation exception
	 * 
	 * @throws UnsupportedOperationException
	 */
	@Override
	public void parse(Segment segment, String string, EncodingCharacters encodingCharacters)
			throws HL7Exception {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/**
	 * Returns the text encoding to be used in generating new messages. Note that this affects
	 * encoding to string only, not parsing.
	 * 
	 * @return text encoding
	 */
	public String getTextEncoding() {
		return textEncoding;
	}

	/**
	 * Sets the text encoding to be used in generating new messages. Note that this affects encoding
	 * to string only, not parsing.
	 * 
	 * @param textEncoding The encoding. Default is the platform default.
	 */
	public void setTextEncoding(String textEncoding) {
		this.textEncoding = textEncoding;
	}

}
