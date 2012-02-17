/*
 * Created on 18-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.util.ArrayList;
import java.util.Map;

import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import junit.framework.TestCase;

/**
 * Unit tests for <code>MetadataExtractor</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 */
public class MetadataExtractorTest extends TestCase {

    /**
     * Constructor for MetadataExtractorTest.
     * @param arg0
     */
    public MetadataExtractorTest(String arg0) {
        super(arg0);
    }
    
    public void testGetFields() throws Exception {
        ADT_A01 message = new ADT_A01();
        
        //set some random fields
        message.getMSH().getFieldSeparator().setValue("|");
        message.getMSH().getEncodingCharacters().setValue("^~\\&");
        message.getMSH().getMessageControlID().setValue("a");
        message.getMSH().getVersionID().getVersionID().setValue("b");
        message.getROL().getOrganizationUnitTypeROL().getIdentifier().setValue("c");
        
        String a = "/MSH-10";
        String b = "/MSH-12";
        String c = "/.ROL-10-1";
        ArrayList<String> paths = new ArrayList<String>();
        paths.add(a);
        paths.add(b);
        paths.add(c);
        Map<String, String> fields = MetadataExtractor.getFields(message, paths);
        
        assertEquals("a", fields.get(a));
        assertEquals("b", fields.get(b));
        assertEquals("c", fields.get(c));        
    }

}
