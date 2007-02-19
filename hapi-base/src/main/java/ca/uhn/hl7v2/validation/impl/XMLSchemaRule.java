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
GNU General Public License (the  “GPL”), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
*/

package ca.uhn.hl7v2.validation.impl;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.apache.xpath.XPathAPI;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.apache.xerces.xni.grammars.*;
import org.apache.xerces.util.*;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.StringReader;
import java.io.File;

import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.log.*;

/**
 * <p>Validate hl7 version 2 messages encoded according to the HL7 XML Encoding Syntax against xml schemas provided by hl7.org</p>
 * @author  Nico Vannieuwenhuyze
 */
public class XMLSchemaRule implements EncodingRule {

    private static final HapiLog log = HapiLogFactory.getHapiLog(XMLSchemaRule.class);
    private static final String parserName = "org.apache.xerces.parsers.SAXParser";
    
    private XMLGrammarPool myGrammarPool = new XMLGrammarPoolImpl();
    private Element myNamespaceNode;
    private DocumentBuilder myBuilder;

    private class SchemaEventHandler extends DefaultHandler
    {
        private List validationErrors;
        
        public SchemaEventHandler(List theValidationErrorList)
        {
            validationErrors = theValidationErrorList;
        }

        /** Warning. */
        public void warning(SAXParseException ex) {

            validationErrors.add(new ValidationException("[Warning] "+
                           getLocationString(ex)+": "+
                           ex.getMessage() + " "));
        }

        /** Error. */
        public void error(SAXParseException ex) {

            validationErrors.add(new ValidationException("[Error] "+
                           getLocationString(ex)+": "+
                           ex.getMessage() + " "));
        }

        /** Fatal error. */
        public void fatalError(SAXParseException ex) throws SAXException {

            validationErrors.add(new ValidationException("[Fatal Error] "+
                           getLocationString(ex)+": "+
                           ex.getMessage() + " "));
        }
        
        /** Returns a string of the location. */
        private String getLocationString(SAXParseException ex) {
            StringBuffer str = new StringBuffer();

            String systemId = ex.getSystemId();
            if (systemId != null) {
                int index = systemId.lastIndexOf('/');
                if (index != -1)
                    systemId = systemId.substring(index + 1);
                str.append(systemId);
            }
            str.append(':');
            str.append(ex.getLineNumber());
            str.append(':');
            str.append(ex.getColumnNumber());

            return str.toString();

        } // getLocationString(SAXParseException):String
        
    }
    
    /** Creates a new instance of XMLSchemaValidator */
    public XMLSchemaRule() {
        myBuilder = createDocumentBuilder();
        myNamespaceNode = createNamespaceNode(myBuilder);    
    }
    
    /** 
     * <P>Test/validate a given xml document against a hl7 v2.xml schema.</P>
     * <P>Before the schema is applied, the namespace is verified because otherwise schema validation fails anyway.</P>
     * <P>If a schema file is specified in the xml message and the file can be located on the disk this one is used.
     * If no schema has been specified, or the file can't be located, a system property ca.uhn.hl7v2.validation.xmlschemavalidator.schemalocation. + version 
     * can be used to assign a default schema location.</P>
     *
     * @param msg the xml message (as string) to be validated.   
     * @return ValidationException[]
     */
    
    public ValidationException[] test(String msg) {
        List validationErrors = new ArrayList(20);
        Document domDocumentToValidate = null;
        
        StringReader stringReaderForDom = new StringReader(msg);
        try
        {
            // parse the icoming string into a dom document - no schema validation yet
            domDocumentToValidate = myBuilder.parse(new InputSource(stringReaderForDom));
            
            // check if the xml document has the right default namespace
            if (validateNamespace(domDocumentToValidate, validationErrors))
            {
                String schemaLocation = getSchemaLocation(domDocumentToValidate, validationErrors);
                if (schemaLocation.length() > 0)
                {
                        // now parse the icoming string using a sax parser with schema validation
                        XMLReader parser = XMLReaderFactory.createXMLReader(parserName);
                        SchemaEventHandler eventHandler = new SchemaEventHandler(validationErrors);
                        parser.setContentHandler(eventHandler);
                        parser.setErrorHandler(eventHandler);
                        parser.setProperty("http://apache.org/xml/properties/schema/external-schemaLocation", "urn:hl7-org:v2xml" + " " + schemaLocation);
                        parser.setFeature("http://xml.org/sax/features/validation", true);
                        parser.setFeature("http://apache.org/xml/features/validation/schema", true);
                        parser.setFeature("http://apache.org/xml/features/validation/schema-full-checking", true);
                        parser.setProperty("http://apache.org/xml/properties/internal/grammar-pool",  myGrammarPool);
                        StringReader stringReaderForSax =new StringReader(msg);
                        parser.parse(new InputSource(stringReaderForSax));
                }
            }
        }            
        catch (SAXException se)
        {
            log.error("Unable to parse message - please verify that it's a valid xml document");
            log.error("SAXException: ", se);
            validationErrors.add(new ValidationException("Unable to parse message - please verify that it's a valid xml document" + " [SAXException] " + se.getMessage()));
            
        }
        catch (IOException e)
        {
            log.error("Unable to parse message - please verify that it's a valid xml document");
            log.error("IOException: ", e);
            validationErrors.add(new ValidationException("Unable to parse message - please verify that it's a valid xml document" + " [IOException] " + e.getMessage()));
        }
 
        return (ValidationException[]) validationErrors.toArray(new ValidationException[0]);

    }
    
    private Element createNamespaceNode(DocumentBuilder theBuilder)
    {
        Element namespaceNode = null;
        // set up a document purely to hold the namespace mappings prefix-uri
        // prefix used is hl7v2xml
        if (theBuilder != null)
        {
            DOMImplementation impl = theBuilder.getDOMImplementation();
            Document namespaceHolder = impl.createDocument(
                "http://namespaceuri.org", 
                "f:namespaceMapping", null);
            namespaceNode = namespaceHolder.getDocumentElement();
            namespaceNode.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:hl7v2xml",
                 "urn:hl7-org:v2xml");
            namespaceNode.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
        }
        return namespaceNode;
    }
    
    private DocumentBuilder createDocumentBuilder()
    {
        DocumentBuilder builder = null;
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);

            try
            {
                builder = factory.newDocumentBuilder();
            }
            catch (ParserConfigurationException e)
            {
                log.error(e.getMessage());
            }
        }
        catch (FactoryConfigurationError e)
        {
            log.error(e.getMessage());
        }
        
        return builder;
    }
    
     private String getSchemaLocation(Document domDocumentToValidate, List validationErrors) {
        boolean validSchemaInDocument = false;
        String schemaLocation = new String();
        String schemaFilename = new String();

        // retrieve the schema specified in the document
        try
        {
            log.debug("Trying to retrieve the schema defined in the xml document");
            Node schemaNode = XPathAPI.selectSingleNode(domDocumentToValidate, "//@xsi:schemaLocation" , myNamespaceNode); 
            if (schemaNode != null)
            {
                log.debug("Schema defined in document: " + schemaNode.getNodeValue());
                String schemaItems[] = schemaNode.getNodeValue().split(" ");
                if (schemaItems.length == 2)
                {
                    File myFile = new File(schemaItems[1].toString());
                    if (myFile.exists())
                    {
                        validSchemaInDocument = true;
                        schemaFilename = schemaItems[1].toString();
                        log.debug("Schema defined in document points to a valid file - use this one");
                    }
                    else
                    {
                        log.warn("Schema file defined in xml document not found on disk: " + schemaItems[1].toString());
                    }
                }
             }
            else
            {
                log.debug("No schema defined in the xml document");
            }
            
            // if no valid schema was found - use the default (version dependent) from property
            if (!validSchemaInDocument)
            {
                log.debug("Lookup hl7 version in msh-12 to know which default schema to use");
                Node versionNode = XPathAPI.selectSingleNode(domDocumentToValidate, "//hl7v2xml:MSH.12/hl7v2xml:VID.1/text()" , myNamespaceNode); 
                if (versionNode != null)
                {
                    String schemaLocationProperty = new String("ca.uhn.hl7v2.validation.xmlschemavalidator.schemalocation.") + versionNode.getNodeValue();
                    log.debug("Lookup schema location system property: " + schemaLocationProperty);
                    schemaLocation = System.getProperty(schemaLocationProperty);
                    if (schemaLocation == null)
                    {
                        log.warn("System property for schema location path " + schemaLocationProperty + " not defined");
                        schemaLocation = System.getProperty("user.dir") + "\\v"+ versionNode.getNodeValue().replaceAll("\\.", "") + "\\xsd";
                        log.info("Using default schema location path (current directory\\v2x\\xsd) " + schemaLocation);
                    }

                    // use the messagestructure as schema file name (root)
                    schemaFilename = schemaLocation + "/" + domDocumentToValidate.getDocumentElement().getNodeName() + ".xsd";
                    File myFile = new File(schemaFilename);
                    if (myFile.exists())
                    {
                        validSchemaInDocument = true;
                        log.debug("Valid schema file present: " + schemaFilename);
                    }
                    else
                    {
                        log.warn("Schema file not found on disk: " + schemaFilename);
                    }
                }
                else
                {
                    log.error("HL7 version node MSH-12 not present - unable to determine default schema");
                }
            }
        }
        catch (Exception e)
        {
            log.error(e.getMessage());
        }
        
        if (validSchemaInDocument)
        {
            return schemaFilename;
        }
        else
        {
            ValidationException e = new ValidationException("Unable to retrieve a valid schema to use for message validation - please check logs");
            validationErrors.add(e);
            return "";
        }
    }

    private boolean validateNamespace(Document domDocumentToValidate, List validationErrors) {
        // start by verifying the default namespace if this isn't correct the rest will fail anyway
        if (domDocumentToValidate.getDocumentElement().getNamespaceURI() == null)
        {
            ValidationException e = new ValidationException("The default namespace of the xml document is not specified - should be urn:hl7-org:v2xml");
            validationErrors.add(e);
            log.error("The default namespace of the xml document is not specified - should be urn:hl7-org:v2xml");
        }
        else
        {
            if (! domDocumentToValidate.getDocumentElement().getNamespaceURI().equals("urn:hl7-org:v2xml"))
            {
                ValidationException e = new ValidationException("The default namespace of the xml document (" + domDocumentToValidate.getDocumentElement().getNamespaceURI() + ") is incorrect - should be urn:hl7-org:v2xml");
                validationErrors.add(e);
                log.error("The default namespace of the xml document (" + domDocumentToValidate.getDocumentElement().getNamespaceURI() + ") is incorrect - should be urn:hl7-org:v2xml");
             }
             else
             {
                 return true;
             }
         }
        return false;
    }

    /** 
     * @see ca.uhn.hl7v2.validation.Rule#getDescription()
     */
    public String getDescription() {
        return "Checks that an encoded XML message validates against a declared or default schema " +
                "(it is recommended to use the standard HL7 schema, but this is not enforced here).";
    }

    /** 
     * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
     */
    public String getSectionReference() {
        return "http://www.hl7.org/Special/committees/xml/drafts/v2xml.html";
    }
    
     
}