package ca.uhn.hl7v2.conf.store;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

import ca.uhn.hl7v2.conf.ProfileException;

/**
 * @author Neal Acharya
 * Created on 27-Aug-2003
 *
 * This particular implementation of CodeStore retrieves valid codes and validates codeSystems
 * using tables found in 'spec xml tables only' docs generated from the HL7 Messaging
 * Workbench tool.
 *
 * Note:  The codeSystem parameter value used in the following methods must be a concatenation
 * of a coding authority and coding table number that is 4 digits long.
 *
 * Note: The current implementation only accepts a coding authority of HL7
 *
 */
public class ProfileCodeStore extends AbstractCodeStore {
    
    private Document tableDoc;
    
    /**
     * @param uri the location of the specification XML file
     * @throws ProfileException
     * @throws IOException
     *
     * Creates a ProfileCodeStore object that uses tables found in an 'spec xml tables only'
     * xml doc specified by the input URI. The private field member tableDoc is created with
     * content from the xml doc specified by the URI.
     */
    public ProfileCodeStore(String uri) throws ProfileException, IOException {
        try {
            if (uri == null) {
                throw new ProfileException("The input url parameter cannot be null");
            } //end if
            //create tableDoc object
            tableDoc = new SAXBuilder().build(uri);
        } //end try
        catch (ProfileException e) {
            throw e;
        } //end catch
        catch (IOException e){
            throw e;
        }//end catch
        catch (Exception e) {
            throw new ProfileException(e.toString(), e);
        } //end catch
    } //end constructor

    /** As string constructor but accepts a URL object */
    public ProfileCodeStore(URL url) throws ProfileException, IOException {
        if (url == null) 
            throw new ProfileException("The input url parameter cannot be null");
        
        try {            
            tableDoc = new SAXBuilder().build(url);
        } catch (org.jdom.JDOMException e) {
            throw new ProfileException(e.toString(), e); 
        } 
    } 
    
    /**
     * @param codeSystem
     * @return String[]
     * @throws ProfileException
     * @see ca.uhn.hl7v2.conf.store.CodeStore#getValidCodes(java.lang.String, java.lang.String)
     *
     * Retreives all codes for a given conformance profile and codeSystem.
     * Note:  The codeSystem parameter value must be a concatenation of a coding authority
     * and coding table number that is 4 digits long.
     *
     * Note: The current implementation only accepts a coding authority of HL7
     */
    public String[] getValidCodes(String codeSystem) throws ProfileException {
        String[] codeValues = null;
        //obtain the table for the codesystem
        try {
            Element table = getCodeTable(codeSystem);
            List tableElementList = table.getChildren("tableElement");
            Iterator itr = tableElementList.iterator();
            codeValues = new String[tableElementList.size()];
            int i = 0;
            while (itr.hasNext()) {
                Element tableElement = (Element) itr.next();
                codeValues[i] = tableElement.getAttributeValue("code");
                i++;
            } //end while
        } //end try
        catch (NullPointerException e) {
            throw new ProfileException("The spec xml table doc is missing one or more of the following: tableElement element, code attribute", e);
        } //end catch
        return codeValues;
    } //end method
    
    /**
     * @param codeSystem
     * @return boolean
     * @see ca.uhn.hl7v2.conf.store.CodeStore#knowsCodes(java.lang.String, java.lang.String)
     *
     * Validates the codeSytem against the input conformance profile. If valid then
     * output is 'true' else 'false'.
     * Note:  The codeSystem parameter value must be a concatenation of a coding authority
     * and coding table number that is 4 digits long.
     *
     * Note: The current implementation only accepts a coding authority of HL7
     */
    public boolean knowsCodes(String codeSystem){
        try{
            Element table = getCodeTable(codeSystem);
            if (table != null) {
                return true;
            } //end if
            else {
                return false;
            } //end else
        }//end try
        catch (Exception e){
            return false;
        }//end catch
    } //end method
    
    /**
     * @param profileId
     * @throws ProfileException
     * void
     *
     * Validates the input conformance profile. Returns an exception if invalid.
     */    
    /*private void validateProfile(String profileId) throws ProfileException {
        try {
            if (profileId == null) {
                throw new ProfileException("The input profileId parameter cannot be null");
            } //end if
            XPath path = XPath.newInstance("/Specification/Conformance[@StaticID]");
            Element conformance = (Element) path.selectSingleNode(tableDoc);
            String staticId = conformance.getAttributeValue("StaticID");
            if (!staticId.equals(profileId)) {
                throw new ProfileException("The input profileId is not valid or is not specified for the spec xml table doc");
            } //end if
        } //end try
        catch (ProfileException e) {
            throw e;
        } //end catch
        catch (Exception e) {
            throw new ProfileException(e.toString(), e);
        } //end catch
    }*/ //end method
    
    /**
     * @param profileId
     * @param codeSystem
     * @return Element
     * @throws ProfileException
     * Element
     *
     * Retreives the hl7Table Element from the tableDoc object defined by the table number
     * in the input codeSystem.
     */
    private Element getCodeTable(String codeSystem) throws ProfileException {
        //initialize return param
        Element table = null;
        //Validate the input Profile
        //validateProfile(profileId);
        //Validate the codeSystem
        if (codeSystem == null) {
            throw new ProfileException("The input codeSystem parameter cannot be null");
        } //end if
        if (codeSystem.length() < 4) {
            throw new ProfileException("The input codeSystem parameter cannot be less than 4 characters long");
        } //end if
        try {
            //Extract the last 4 characters from the codeSystem param
            String tableId = codeSystem.substring(codeSystem.length() - 4);
            //System.out.println(tableId);
            XPath path = XPath.newInstance("/Specification/hl7tables/hl7table[@id='" + tableId + "']");
            table = (Element) path.selectSingleNode(tableDoc);
        } //end try
        catch (Exception e) {
            throw new ProfileException(e.toString(), e);
        } //end catch
        return table;
    } //end method
} //end class
