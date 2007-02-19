package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.parser.*;
import ca.uhn.hl7v2.model.v24.datatype.*;
import ca.uhn.hl7v2.HL7Exception;
import junit.framework.*;

/**
 * A JUnit test harness for Varies 
 * @author Bryan Tripp
 */
public class VariesTest extends TestCase {

    private Parser parser = null;
    private EncodingCharacters ec = null;
    
    /** Creates a new instance of VariesTest */
    public VariesTest(String arg) {
        super(arg);
    }
    
    public void setUp() throws Exception {
        this.parser = new DefaultXMLParser();
        ec = new EncodingCharacters('|', "^~\\&");
    }
    
    public void testParse() throws HL7Exception {
        Varies varies = new Varies(null);
        CE data = new CE(null);
        data.getIdentifier().setValue("foo");
        varies.setData(data);
        assertEquals("foo", ((CE)varies.getData()).getIdentifier().getValue()); //existing primitive will NOT copy over "foo" as of Nov 2002
        data.getIdentifier().setValue("foo");
        assertEquals("foo", ((CE)varies.getData()).getIdentifier().getValue()); 
    }
    

}
