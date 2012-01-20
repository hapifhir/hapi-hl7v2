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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.uhn.hl7v2.testpanel.model;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import ca.uhn.hl7v2.testpanel.ex.ConfigurationException;
import ca.uhn.hl7v2.testpanel.model.msg.AbstractMessage;
import ca.uhn.hl7v2.testpanel.xsd.XmlMessageDefinition;

/**
 * XML Message implementation
 */
public class XmlMessageImpl extends AbstractMessage<Document> {
    //~ Instance fields ------------------------------------------------------------------------------------------------

    private Document myDocument;
    private String myText;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    public XmlMessageImpl(String theId) {
        super(theId);
    }

    public XmlMessageImpl(XmlMessageDefinition theDefinition)
                   throws ConfigurationException {
        super(theDefinition);

        try {
            final String text = theDefinition.getText();
            setSourceMessage(text);
        } catch (PropertyVetoException ex) {
            throw new ConfigurationException(ex.getMessage(), ex);
        }
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * Subclasses should make use of this method to export AbstractInterface properties into
     * the return value for {@link #exportConfigToXml()}
     */
    protected XmlMessageDefinition exportConfig(XmlMessageDefinition theConfig) {
        super.exportConfig(theConfig);
        theConfig.setText(myText);

        return theConfig;
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public XmlMessageDefinition exportConfigToXml() {
        return exportConfig(new XmlMessageDefinition());
    }

    @Override
    public Class<Document> getMessageClass() {
        return Document.class;
    }

    @Override
    public String getSourceMessage() {
        return myText;
    }

    @Override
    public void setSourceMessage(final String text) throws PropertyVetoException {
        String original = myText;

        try {
            myText = text.trim();

            DocumentBuilderFactory parserFactory = DocumentBuilderFactory.newInstance();
            parserFactory.setValidating(false);

            DocumentBuilder parser = parserFactory.newDocumentBuilder();
            StringReader inputStream = new StringReader(myText);
            myDocument = parser.parse(new InputSource(inputStream));
        } catch (SAXException ex) {
            throw new PropertyVetoException("Failed to parse XML message: " + ex.getMessage(), null);
        } catch (IOException ex) {
            throw new PropertyVetoException("Failed to parse XML message: " + ex.getMessage(), null);
        } catch (ParserConfigurationException ex) {
            throw new PropertyVetoException("Failed to parse XML message: " + ex.getMessage(), null);
        }

        firePropertyChange(PARSED_MESSAGE_PROPERTY, original, myText);
    }

	@Override
	public Document getParsedMessage() {
		return myDocument;
	}
}
