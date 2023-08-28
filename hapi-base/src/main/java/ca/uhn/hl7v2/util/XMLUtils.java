/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "XMLUtils.java".  Description: 
"XML utilities" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 
 */
package ca.uhn.hl7v2.util;

import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSOutput;
import org.w3c.dom.ls.LSResourceResolver;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XMLUtils {
    private static final Logger ourLog = LoggerFactory.getLogger(XMLUtils.class);

    private static DOMImplementation IMPL;

    @SuppressWarnings("unchecked")
    public synchronized static <T> T getDOMImpl() {
        if (IMPL == null) {
            try {
                DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
                IMPL = registry.getDOMImplementation("LS 3.0");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return (T) IMPL;
    }

    @SuppressWarnings("unchecked")
    public static Document parse(String s) {
        return parseDocument(new InputSource(new StringReader(s)), false);
    }

    public static Document parse(String s, boolean validateIfSchema) {
        return parseDocument(new InputSource(new StringReader(s)), validateIfSchema);
    }

    public static Document parse(InputStream s, boolean validateIfSchema) {
        return parseDocument(new InputSource(s), validateIfSchema);
    }

    public static Document parseDocument(InputSource theInputSource, boolean theValidating) {
        DocumentBuilder builder;
        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            docBuilderFactory.setNamespaceAware(true);
            docBuilderFactory.setXIncludeAware(false);
            docBuilderFactory.setExpandEntityReferences(false);
            docBuilderFactory.setValidating(theValidating);
            try {
                docBuilderFactory.setFeature(
                        "http://apache.org/xml/features/disallow-doctype-decl", false);
                docBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
                docBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
                docBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
                docBuilderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            } catch (Exception e) {
                ourLog.warn("Failed to set feature on XML parser: " + e.toString());
            }

            builder = docBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }

        try {
            return builder.parse(theInputSource);
        } catch (SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void validate(Document d, String schema, DOMErrorHandler handler) {
        DOMConfiguration config = d.getDomConfig();
        config.setParameter("schema-type", "http://www.w3.org/2001/XMLSchema");
        config.setParameter("validate", true);
        config.setParameter("schema-location", schema);
        config.setParameter("resource-resolver", new ClasspathResourceResolver());
        config.setParameter("error-handler", handler);
        d.normalizeDocument();
    }

    public static String serialize(Document document, boolean prettyPrint) {
        DOMImplementationLS impl = getDOMImpl();
        LSSerializer serializer = impl.createLSSerializer();
        // document.normalizeDocument();
        DOMConfiguration config = serializer.getDomConfig();
        if (prettyPrint && config.canSetParameter("format-pretty-print", Boolean.TRUE)) {
            config.setParameter("format-pretty-print", true);
        }
        config.setParameter("xml-declaration", true);        
        LSOutput output = impl.createLSOutput();
        output.setEncoding("UTF-8");
        Writer writer = new StringWriter();
        output.setCharacterStream(writer);
        serializer.write(document, output);
        return writer.toString();
    }

    public static Document emptyDocument(String title) {
        DOMImplementation impl = getDOMImpl();
        return impl.createDocument("urn:hl7-org:v2xml", title, null);
    }

    /**
     * This is an implementation of LSResourceResolver that can resolve XML schemas from the
     * classpath
     */
    private static class ClasspathResourceResolver implements LSResourceResolver {
        private final DOMImplementationLS impl;

        ClasspathResourceResolver() {
            impl = getDOMImpl();
        }

        public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId,
                String baseURI) {
            LSInput lsInput = impl.createLSInput();
            InputStream is = getClass().getResourceAsStream("/" + systemId);
            if (is == null)
                return null;
            lsInput.setByteStream(is);
            return lsInput;
        }
    }

}
