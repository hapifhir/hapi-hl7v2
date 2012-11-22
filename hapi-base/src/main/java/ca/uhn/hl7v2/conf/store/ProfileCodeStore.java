package ca.uhn.hl7v2.conf.store;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * 
 * This particular implementation of CodeStore retrieves valid codes and validates codeSystems using
 * tables found in 'spec xml tables only' docs generated from the HL7 Messaging Workbench tool.
 * 
 * Note: The codeSystem parameter value used in the following methods must be a concatenation of a
 * coding authority and coding table number that is 4 digits long.
 * 
 * Note: The current implementation only accepts a coding authority of HL7
 * 
 * @author Neal Acharya
 * @author Christian Ohr
 */
public class ProfileCodeStore extends AbstractCodeStore {

    private Map<String, List<String>> codes = new HashMap<String, List<String>>();

    /**
     * Creates a ProfileCodeStore object that uses tables found in an 'spec xml tables only' xml doc
     * specified by the input URI. The private field member tableDoc is created with content from
     * the xml doc specified by the URI.
     * 
     * @param uri the location of the specification XML file
     * 
     * @throws ProfileException
     * @throws IOException
     * 
     */
    public ProfileCodeStore(String uri) throws ProfileException, IOException {
        try {
            if (uri == null) {
                throw new ProfileException("The input url parameter cannot be null");
            }
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ProfileCodeStoreHandler());
            reader.parse(uri);
        } catch (IOException e) {
            throw e;
        } catch (Exception e) {
            throw new ProfileException(e.toString(), e);
        }
    }

    /** As string constructor but accepts a URL object */
    public ProfileCodeStore(URL url) throws ProfileException, IOException {
        this(url.toExternalForm());
    }

    /**
     * Retrieves all codes for a given conformance profile and codeSystem. Note: The codeSystem
     * parameter value must be a concatenation of a coding authority and coding table number that is
     * 4 digits long.
     * 
     * Note: The current implementation only accepts a coding authority of HL7
     * 
     * @param codeSystem
     * @return String[]
     * @throws ProfileException
     * @see ca.uhn.hl7v2.conf.store.CodeStore#getValidCodes(java.lang.String, java.lang.String)
     * 
     */
    public String[] getValidCodes(String codeSystem) throws ProfileException {
        List<String> result = getCodeTable(codeSystem);
        if (result == null)
            throw new ProfileException("Unknown code system: " + codeSystem);
        return result.toArray(new String[result.size()]);
    }

    /**
     * Validates the codeSystem against the input conformance profile. If valid then output is
     * 'true' else 'false'. Note: The codeSystem parameter value must be a concatenation of a coding
     * authority and coding table number that is 4 digits long.
     * 
     * Note: The current implementation only accepts a coding authority of HL7
     * 
     * @param codeSystem
     * 
     * @return boolean
     * @see ca.uhn.hl7v2.conf.store.CodeStore#knowsCodes(java.lang.String, java.lang.String)
     * 
     */
    public boolean knowsCodes(String codeSystem) {
        try {
            return getCodeTable(codeSystem) != null;
        } catch (ProfileException e) {
            return false;
        }
    }

    /**
     * Retrieves the hl7Table Element from the tableDoc object defined by the table number in the
     * input codeSystem.
     * 
     * @param profileId
     * 
     * @param codeSystem
     * @return Element
     * @throws ProfileException Element
     */
    private List<String> getCodeTable(String codeSystem) throws ProfileException {
        if (codeSystem == null) {
            throw new ProfileException("The input codeSystem parameter cannot be null");
        }
        if (codeSystem.length() < 4) {
            throw new ProfileException("The input codeSystem parameter cannot be less than 4 characters long");
        }
        // Extract the last 4 characters from the codeSystem param
        String tableId = codeSystem.substring(codeSystem.length() - 4);
        return codes.get(tableId);
    }

    private class ProfileCodeStoreHandler extends DefaultHandler {

        private String currentTable;
        private static final String HL7_TABLE_QNAME = "hl7table";
        private static final String TABLE_ELEMENT_QNAME = "tableElement";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (HL7_TABLE_QNAME.equals(qName)) {
                currentTable = attributes.getValue("id");
                codes.put(currentTable, new ArrayList<String>());
            } else if (TABLE_ELEMENT_QNAME.equals(qName)) {
                codes.get(currentTable).add(attributes.getValue("code"));
            }
        }

    }
}
