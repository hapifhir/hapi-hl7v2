/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "XMLSchemaRule.java".  Description: 
"Validate hl7 v2.xml messages against a given xml-schema." 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2004.  All Rights Reserved. 

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

package ca.uhn.hl7v2.validation.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.util.XMLUtils;
import ca.uhn.hl7v2.validation.ValidationException;

/**
 * Validates HL7 version 2 messages encoded according to the HL7 XML Encoding Syntax against XML
 * schemas provided by hl7.org.
 * <p>
 * The XML schema to validate against is determined as follows:
 * <ul>
 * <li>if the XML document contains a schemaLocation that points to a valid file, this file is
 * assumed to contain the schema definition
 * <li>the location configured using {@link #setSchemaLocations(Map)}
 * </ul>
 * <p>
 * The validation fails, if
 * <ul>
 * <li>no valid schema file could be found
 * <li>the default namespace of the XML document is not <code>urn:hl7-org:v2xml</code>
 * <li>the document does not validate against the XML schema file foudn as described above
 * </ul>
 * 
 * @author Nico Vannieuwenhuyze
 * @author Christian Ohr
 */
@SuppressWarnings("serial")
public class XMLSchemaRule extends AbstractEncodingRule {

	private static final String SECTION_REFERENCE = "http://www.hl7.org/Special/committees/xml/drafts/v2xml.html";
	private static final String DESCRIPTION = "Checks that an encoded XML message validates against a declared or default schema "
			+ "(it is recommended to use the standard HL7 schema, but this is not enforced here).";
	private static final Logger log = LoggerFactory.getLogger(XMLSchemaRule.class);
	private static final String DEFAULT_NS = "urn:hl7-org:v2xml";

	private Map<String, String> locations;

	private class ErrorHandler implements DOMErrorHandler {
		private List<ValidationException> validationErrors;

		public ErrorHandler(List<ValidationException> validationErrors) {
			super();
			this.validationErrors = validationErrors;
		}

		public boolean handleError(DOMError error) {
			validationErrors.add(new ValidationException(getSeverity(error) + error.getMessage()));
			return true;
		}

		private String getSeverity(DOMError error) {
			switch (error.getSeverity()) {
			case DOMError.SEVERITY_WARNING:
				return "WARNING: ";
			case DOMError.SEVERITY_ERROR:
				return "ERROR: ";
			default:
				return "FATAL ERROR: ";
			}
		}

	}

	/**
	 * Test/validate a given xml document against a hl7 v2.xml schema.
	 * <p>
	 * Before the schema is applied, the namespace is verified because otherwise schema validation
	 * fails anyway.
	 * <p>
	 * If a schema file is specified in the xml message and the file can be located on the disk this
	 * one is used. If no schema has been specified, or the file can't be located, the locations
	 * property is used.
	 * 
	 * @param msg the xml message (as string) to be validated.
	 * @return ValidationException[] an array of validation exceptions, which is zero-sized when no
	 *         validation errors occured.
	 */
	public ValidationException[] apply(String msg) {
		List<ValidationException> validationErrors = new ArrayList<ValidationException>();
		try {
			// parse the incoming string into a dom document - no schema validation yet
			Document doc = XMLUtils.parse(msg);
			if (hasCorrectNamespace(doc, validationErrors)) {
				XMLUtils.validate(doc, getSchemaLocation(doc), new ErrorHandler(validationErrors));
			}
		} catch (Exception e) {
			log.error("Unable to validate message: {}", e.getMessage(), e);
			validationErrors.add(new ValidationException("Unable to validate message "
					+ e.getMessage(), e));
		}

		return validationErrors.toArray(new ValidationException[validationErrors.size()]);

	}

	/**
	 * 
	 * Try to obtain the XML schema file (depending on message version), either as provided in
	 * xsi:schemaLocation, or as provided in the locations property or in a subdirectory of the
	 * current dir.
	 * 
	 * @param doc the DOM document
	 * @return the file name of the schema
	 * @throws IOException
	 */
	private String getSchemaLocation(Document doc) throws IOException {
		String schemaFilename = extractSchemaLocation(doc);
		if (schemaFilename == null) {
			if ((schemaFilename = staticSchema(doc)) == null) {
				throw new IOException(
						"Unable to retrieve a valid schema to use for message validation");
			}
		}
		return schemaFilename;

	}

	private String extractSchemaLocation(Document doc) {
		String schemaFileName = null;
		log.debug("Trying to retrieve the schema defined in the xml document");
		Element element = doc.getDocumentElement();
		String schemaLocation = element.getAttributeNS("http://www.w3.org/2001/XMLSchema-instance",
				"schemaLocation");
		if (schemaLocation.length() > 0) {
			log.debug("Schema defined in document: {}", schemaLocation);
			String schemaItems[] = schemaLocation.split(" ");
			if (schemaItems.length == 2) {
				File f = new File(schemaItems[1]);
				if (f.exists()) {
					schemaFileName = schemaItems[1];
					log.debug("Schema defined in document points to a valid file");
				} else {
					log.warn("Schema file defined in xml document not found on disk: {}",
							schemaItems[1]);
				}
			}
		} else {
			log.debug("No schema location defined in the xml document");
		}

		return schemaFileName;
	}

	private String staticSchema(Document doc) {
		String schemaFilename = null;
		log.debug("Lookup HL7 version in MSH-12 to know which default schema to use");
		NodeList nodeList = doc.getElementsByTagNameNS(DEFAULT_NS, "VID.1");
		if (nodeList.getLength() == 1) {
			Node versionNode = nodeList.item(0);
			Version version = Version.versionOf(versionNode.getFirstChild().getNodeValue());
			String schemaLocation = locations.get(version.getVersion());

			// use the message structure as schema file name (root)
			schemaFilename = schemaLocation + "/" + doc.getDocumentElement().getNodeName() + ".xsd";
			File myFile = new File(schemaFilename);
			if (myFile.exists()) {
				log.debug("Valid schema file present: {}", schemaFilename);
			} else {
				log.warn("Schema file not found on disk: {}", schemaFilename);
				schemaFilename = null;
			}
		} else {
			log.error("HL7 version node MSH-12 not present - unable to determine default schema");
		}
		return schemaFilename;
	}

	/**
	 * @return <code>true</code> if default namespace is set properly
	 */
	private boolean hasCorrectNamespace(Document domDocumentToValidate,
			List<ValidationException> validationErrors) {
		String nsUri = domDocumentToValidate.getDocumentElement().getNamespaceURI();
		boolean ok = DEFAULT_NS.equals(nsUri);
		if (!ok) {
			ValidationException e = new ValidationException(
					"The default namespace of the XML document is incorrect - should be "
							+ DEFAULT_NS + " but was " + nsUri);
			validationErrors.add(e);
			log.error(e.getMessage());
		}
		return ok;
	}

	public void setSchemaLocations(Map<String, String> locations) {
		this.locations = locations;
	}

	Map<String, String> getSchemaLocations() {
		return locations;
	}

	/**
	 * @see ca.uhn.hl7v2.validation.Rule#getDescription()
	 */
	public String getDescription() {
		return DESCRIPTION;
	}

	/**
	 * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
	 */
	public String getSectionReference() {
		return SECTION_REFERENCE;
	}

}