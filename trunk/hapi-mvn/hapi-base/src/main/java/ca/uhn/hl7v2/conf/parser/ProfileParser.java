/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "ProfileParser.java".  Description: 
"Parses a Message Profile XML document into a RuntimeProfile object." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2003.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

 */

package ca.uhn.hl7v2.conf.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import org.apache.xerces.parsers.DOMParser;
import org.apache.xerces.parsers.StandardParserConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import ca.uhn.hl7v2.conf.ProfileException;
import ca.uhn.hl7v2.conf.spec.MetaData;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.conf.spec.message.AbstractComponent;
import ca.uhn.hl7v2.conf.spec.message.AbstractSegmentContainer;
import ca.uhn.hl7v2.conf.spec.message.Component;
import ca.uhn.hl7v2.conf.spec.message.DataValue;
import ca.uhn.hl7v2.conf.spec.message.Field;
import ca.uhn.hl7v2.conf.spec.message.ProfileStructure;
import ca.uhn.hl7v2.conf.spec.message.Seg;
import ca.uhn.hl7v2.conf.spec.message.SegGroup;
import ca.uhn.hl7v2.conf.spec.message.StaticDef;
import ca.uhn.hl7v2.conf.spec.message.SubComponent;

/**
 * <p>
 * Parses a Message Profile XML document into a RuntimeProfile object. A Message
 * Profile is a formal description of additional constraints on a message
 * (beyond what is specified in the HL7 specification), usually for a particular
 * system, region, etc. Message profiles are introduced in HL7 version 2.5
 * section 2.12. The RuntimeProfile object is simply an object representation of
 * the profile, which may be used for validating messages or editing the
 * profile.
 * </p>
 * <p>
 * Example usage: <code><pre>
 * 		// Load the profile from the classpath
 *      ProfileParser parser = new ProfileParser(false);
 *      RuntimeProfile profile = parser.parseClasspath("ca/uhn/hl7v2/conf/parser/example_ack.xml");
 * 
 *      // Create a message to validate
 *      String message = "MSH|^~\\&|||||||ACK^A01|1|D|2.4|||||CAN|wrong|F^^HL70001^x^^HL78888|\r"; //note HL7888 doesn't exist
 *      ACK msg = (ACK) (new PipeParser()).parse(message);
 * 		
 *      // Validate
 * 		HL7Exception[] errors = new DefaultValidator().validate(msg, profile.getMessage());
 * 		
 * 		// Each exception is a validation error
 * 		System.out.println("Validation errors: " + Arrays.asList(errors));
 * </pre></code>
 * </p>
 * 
 * @author Bryan Tripp
 */
public class ProfileParser {

	private static final Logger log = LoggerFactory.getLogger(ProfileParser.class);

	private DOMParser parser;
	private boolean alwaysValidate;

	/**
	 * Creates a new instance of ProfileParser
	 * 
	 * @param alwaysValidateAgainstDTD
	 *            if true, validates all profiles against a local copy of the
	 *            profile DTD; if false, validates against declared grammar (if
	 *            any)
	 */
	public ProfileParser(boolean alwaysValidateAgainstDTD) {

		this.alwaysValidate = alwaysValidateAgainstDTD;

		parser = new DOMParser(new StandardParserConfiguration());
		try {
			parser.setFeature("http://apache.org/xml/features/dom/include-ignorable-whitespace", false);
		} catch (Exception e) {
			log.error("Can't exclude whitespace from XML DOM", e);
		}
		try {
			parser.setFeature("http://apache.org/xml/features/validation/dynamic", true);
		} catch (Exception e) {
			log.error("Can't validate profile against XML grammar", e);
		}
		parser.setErrorHandler(new ErrorHandler() {
			public void error(SAXParseException e) throws SAXException {
				throw e;
			}

			public void fatalError(SAXParseException e) throws SAXException {
				throw e;
			}

			public void warning(SAXParseException e) throws SAXException {
				System.err.println("Warning: " + e.getMessage());
			}

		});

		if (alwaysValidateAgainstDTD) {
			try {
				final String grammar = loadGrammar();
				parser.setEntityResolver(new EntityResolver() {
					// returns the grammar we specify no matter what the
					// document declares
					public InputSource resolveEntity(String publicID, String systemID) throws SAXException, IOException {
						return new InputSource(new StringReader(grammar));
					}
				});
			} catch (IOException e) {
				log.error("Can't validate profiles against XML grammar", e);
			}
		}

	}

	/** Loads the XML grammar from disk */
	private String loadGrammar() throws IOException {
		InputStream dtdStream = ProfileParser.class.getClassLoader().getResourceAsStream("ca/uhn/hl7v2/conf/parser/message_profile.dtd");
		BufferedReader dtdReader = new BufferedReader(new InputStreamReader(dtdStream));
		String line = null;
		StringBuffer dtd = new StringBuffer();
		while ((line = dtdReader.readLine()) != null) {
			dtd.append(line);
			dtd.append("\r\n");
		}
		return dtd.toString();
	}

	/**
	 * Parses an XML profile string into a RuntimeProfile object.
	 * 
	 * Input is a path pointing to a textual file on the classpath. Note that
	 * the file will be read using the thread context class loader.
	 * 
	 * For example, if you had a file called PROFILE.TXT in package
	 * com.foo.stuff, you would pass in "com/foo/stuff/PROFILE.TXT"
	 * 
	 * @throws IOException
	 *             If the resource can't be read
	 */
	public RuntimeProfile parseClasspath(String classPath) throws ProfileException, IOException {

		InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(classPath);
		if (stream == null) {
			throw new FileNotFoundException(classPath);
		}

		StringBuffer profileString = new StringBuffer();
		byte[] buffer = new byte[1000];
		int bytesRead;
		while ((bytesRead = stream.read(buffer)) > 0) {
			profileString.append(new String(buffer, 0, bytesRead));
		}

		RuntimeProfile profile = new RuntimeProfile();
		Document doc = parseIntoDOM(profileString.toString());

		Element root = doc.getDocumentElement();
		profile.setHL7Version(root.getAttribute("HL7Version"));

		// get static definition
		NodeList nl = root.getElementsByTagName("HL7v2xStaticDef");
		Element staticDef = (Element) nl.item(0);
		StaticDef sd = parseStaticProfile(staticDef);
		profile.setMessage(sd);
		return profile;
	}

	/**
	 * Parses an XML profile string into a RuntimeProfile object.
	 */
	public RuntimeProfile parse(String profileString) throws ProfileException {
		RuntimeProfile profile = new RuntimeProfile();
		Document doc = parseIntoDOM(profileString);

		Element root = doc.getDocumentElement();
		profile.setHL7Version(root.getAttribute("HL7Version"));

		// get static definition
		NodeList nl = root.getElementsByTagName("HL7v2xStaticDef");
		Element staticDef = (Element) nl.item(0);
		StaticDef sd = parseStaticProfile(staticDef);
		profile.setMessage(sd);
		return profile;
	}

	private StaticDef parseStaticProfile(Element elem) throws ProfileException {
		StaticDef message = new StaticDef();
		message.setMsgType(elem.getAttribute("MsgType"));
		message.setEventType(elem.getAttribute("EventType"));
		message.setMsgStructID(elem.getAttribute("MsgStructID"));
		message.setOrderControl(elem.getAttribute("OrderControl"));
		message.setEventDesc(elem.getAttribute("EventDesc"));
		message.setIdentifier(elem.getAttribute("identifier"));
		message.setRole(elem.getAttribute("role"));

		Element md = getFirstElementByTagName("MetaData", elem);
		if (md != null)
			message.setMetaData(parseMetaData(md));

		message.setImpNote(getValueOfFirstElement("ImpNote", elem));
		message.setDescription(getValueOfFirstElement("Description", elem));
		message.setReference(getValueOfFirstElement("Reference", elem));

		parseChildren(message, elem);
		return message;
	}

	/** Parses metadata element */
	private MetaData parseMetaData(Element elem) {
		log.debug("ProfileParser.parseMetaData() has been called ... note that this method does nothing.");
		return null;
	}

	/**
	 * Parses children (i.e. segment groups, segments) of a segment group or
	 * message profile
	 */
	private void parseChildren(AbstractSegmentContainer parent, Element elem) throws ProfileException {
		int childIndex = 1;
		NodeList children = elem.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node n = children.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element child = (Element) n;
				if (child.getNodeName().equalsIgnoreCase("SegGroup")) {
					SegGroup group = parseSegmentGroupProfile(child);
					parent.setChild(childIndex++, group);
				} else if (child.getNodeName().equalsIgnoreCase("Segment")) {
					Seg segment = parseSegmentProfile(child);
					parent.setChild(childIndex++, segment);
				}
			}
		}
	}

	/** Parses a segment group profile */
	private SegGroup parseSegmentGroupProfile(Element elem) throws ProfileException {
		SegGroup group = new SegGroup();
		log.debug("Parsing segment group profile: " + elem.getAttribute("Name"));

		parseProfileStuctureData(group, elem);

		parseChildren(group, elem);
		return group;
	}

	/** Parses a segment profile */
	private Seg parseSegmentProfile(Element elem) throws ProfileException {
		Seg segment = new Seg();
		log.debug("Parsing segment profile: " + elem.getAttribute("Name"));

		parseProfileStuctureData(segment, elem);

		int childIndex = 1;
		NodeList children = elem.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node n = children.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element child = (Element) n;
				if (child.getNodeName().equalsIgnoreCase("Field")) {
					Field field = parseFieldProfile(child);
					segment.setField(childIndex++, field);
				}
			}
		}

		return segment;
	}

	/** Parse common data in profile structure (eg SegGroup, Segment) */
	private void parseProfileStuctureData(ProfileStructure struct, Element elem) throws ProfileException {
		struct.setName(elem.getAttribute("Name"));
		struct.setLongName(elem.getAttribute("LongName"));
		struct.setUsage(elem.getAttribute("Usage"));
		String min = elem.getAttribute("Min");
		String max = elem.getAttribute("Max");
		try {
			struct.setMin(Short.parseShort(min));
			if (max.indexOf('*') >= 0) {
				struct.setMax((short) -1);
			} else {
				struct.setMax(Short.parseShort(max));
			}
		} catch (NumberFormatException e) {
			throw new ProfileException("Min and max must be short integers: " + min + ", " + max, e);
		}

		struct.setImpNote(getValueOfFirstElement("ImpNote", elem));
		struct.setDescription(getValueOfFirstElement("Description", elem));
		struct.setReference(getValueOfFirstElement("Reference", elem));
		struct.setPredicate(getValueOfFirstElement("Predicate", elem));
	}

	/** Parses a field profile */
	private Field parseFieldProfile(Element elem) throws ProfileException {
		Field field = new Field();
		log.debug("  Parsing field profile: " + elem.getAttribute("Name"));

		field.setUsage(elem.getAttribute("Usage"));
		String itemNo = elem.getAttribute("ItemNo");
		String min = elem.getAttribute("Min");
		String max = elem.getAttribute("Max");

		try {
			if (itemNo.length() > 0) {
				field.setItemNo(Short.parseShort(itemNo));
			}
		} catch (NumberFormatException e) {
			throw new ProfileException("Invalid ItemNo: " + itemNo + "( for name " + elem.getAttribute("Name") + ")", e);
		} // try-catch

		try {
			field.setMin(Short.parseShort(min));
			if (max.indexOf('*') >= 0) {
				field.setMax((short) -1);
			} else {
				field.setMax(Short.parseShort(max));
			}
		} catch (NumberFormatException e) {
			throw new ProfileException("Min and max must be short integers: " + min + ", " + max, e);
		}

		parseAbstractComponentData(field, elem);

		int childIndex = 1;
		NodeList children = elem.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node n = children.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element child = (Element) n;
				if (child.getNodeName().equalsIgnoreCase("Component")) {
					Component comp = (Component) parseComponentProfile(child, false);
					field.setComponent(childIndex++, comp);
				}
			}
		}

		return field;
	}

	/** Parses a component profile */
	private AbstractComponent parseComponentProfile(Element elem, boolean isSubComponent) throws ProfileException {
		AbstractComponent comp = null;
		if (isSubComponent) {
			log.debug("      Parsing subcomp profile: " + elem.getAttribute("Name"));
			comp = new SubComponent();
		} else {
			log.debug("    Parsing comp profile: " + elem.getAttribute("Name"));
			comp = new Component();

			int childIndex = 1;
			NodeList children = elem.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node n = children.item(i);
				if (n.getNodeType() == Node.ELEMENT_NODE) {
					Element child = (Element) n;
					if (child.getNodeName().equalsIgnoreCase("SubComponent")) {
						SubComponent subcomp = (SubComponent) parseComponentProfile(child, true);
						((Component) comp).setSubComponent(childIndex++, subcomp);
					}
				}
			}
		}

		parseAbstractComponentData(comp, elem);

		return comp;
	}

	/**
	 * Parses common features of AbstractComponents (ie field, component,
	 * subcomponent)
	 */
	private void parseAbstractComponentData(AbstractComponent comp, Element elem) throws ProfileException {
		comp.setName(elem.getAttribute("Name"));
		comp.setUsage(elem.getAttribute("Usage"));
		comp.setDatatype(elem.getAttribute("Datatype"));
		String length = elem.getAttribute("Length");
		if (length != null && length.length() > 0) {
			try {
				comp.setLength(Long.parseLong(length));
			} catch (NumberFormatException e) {
				throw new ProfileException("Length must be a long integer: " + length, e);
			}
		}
		comp.setConstantValue(elem.getAttribute("ConstantValue"));
		String table = elem.getAttribute("Table");
		if (table != null && table.length() > 0) {
			try {
				comp.setTable(table);
			} catch (NumberFormatException e) {
				throw new ProfileException("Table must be a short integer: " + table, e);
			}
		}

		comp.setImpNote(getValueOfFirstElement("ImpNote", elem));
		comp.setDescription(getValueOfFirstElement("Description", elem));
		comp.setReference(getValueOfFirstElement("Reference", elem));
		comp.setPredicate(getValueOfFirstElement("Predicate", elem));

		int dataValIndex = 0;
		NodeList children = elem.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node n = children.item(i);
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				Element child = (Element) n;
				if (child.getNodeName().equalsIgnoreCase("DataValues")) {
					DataValue val = new DataValue();
					val.setExValue(child.getAttribute("ExValue"));
					comp.setDataValues(dataValIndex++, val);
				}
			}
		}

	}

	/** Parses profile string into DOM document */
	private Document parseIntoDOM(String profileString) throws ProfileException {
		if (this.alwaysValidate)
			profileString = insertDoctype(profileString);
		Document doc = null;
		try {
			synchronized (this) {
				parser.parse(new InputSource(new StringReader(profileString)));
				log.debug("DOM parse complete");
				doc = parser.getDocument();
			}
		} catch (SAXException se) {
			throw new ProfileException("SAXException parsing message profile: " + se.getMessage());
		} catch (IOException ioe) {
			throw new ProfileException("IOException parsing message profile: " + ioe.getMessage());
		}
		return doc;
	}

	/** Inserts a DOCTYPE declaration in the string if there isn't one */
	private String insertDoctype(String profileString) {
		String result = profileString;
		if (profileString.indexOf("<!DOCTYPE") < 0) {
			StringBuffer buf = new StringBuffer();
			int loc = profileString.indexOf("?>");
			if (loc > 0) {
				buf.append(profileString.substring(0, loc + 2));
				buf.append("<!DOCTYPE HL7v2xConformanceProfile SYSTEM \"\">");
				buf.append(profileString.substring(loc + 2));
				result = buf.toString();
			}
		}
		return result;
	}

	/**
	 * Returns the first child element of the given parent that matches the
	 * given tag name. Returns null if no instance of the expected element is
	 * present.
	 */
	private Element getFirstElementByTagName(String name, Element parent) {
		NodeList nl = parent.getElementsByTagName(name);
		Element ret = null;
		if (nl.getLength() > 0) {
			ret = (Element) nl.item(0);
		}
		return ret;
	}

	/**
	 * Gets the result of getFirstElementByTagName() and returns the value of
	 * that element.
	 */
	private String getValueOfFirstElement(String name, Element parent) throws ProfileException {
		Element el = getFirstElementByTagName(name, parent);
		String val = null;
		if (el != null) {
			try {
				Node n = el.getFirstChild();
				if (n.getNodeType() == Node.TEXT_NODE) {
					val = n.getNodeValue();
				}
			} catch (Exception e) {
				throw new ProfileException("Unable to get value of node " + name, e);
			}
		}
		return val;
	}

	public static void main(String args[]) {

		if (args.length != 1) {
			System.out.println("Usage: ProfileParser profile_file");
			System.exit(1);
		}

		try {
			// File f = new
			// File("C:\\Documents and Settings\\bryan\\hapilocal\\hapi\\ca\\uhn\\hl7v2\\conf\\parser\\example_ack.xml");
			File f = new File(args[0]);
			BufferedReader in = new BufferedReader(new FileReader(f));
			char[] cbuf = new char[(int) f.length()];
			in.read(cbuf, 0, (int) f.length());
			String xml = String.valueOf(cbuf);
			// System.out.println(xml);

			ProfileParser pp = new ProfileParser(true);
			pp.parse(xml);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
