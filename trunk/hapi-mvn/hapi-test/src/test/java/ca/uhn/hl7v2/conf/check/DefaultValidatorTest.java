package ca.uhn.hl7v2.conf.check;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.spec.RuntimeProfile;
import ca.uhn.hl7v2.conf.spec.message.Seg;
import ca.uhn.hl7v2.conf.store.CodeStore;
import ca.uhn.hl7v2.conf.store.ProfileCodeStore;
import ca.uhn.hl7v2.conf.store.ProfileStoreFactory;
import ca.uhn.hl7v2.model.v24.message.ACK;
import ca.uhn.hl7v2.parser.PipeParser;

/**
 * JUnit tests for DefaultValidator
 * @author Bryan Tripp
 */
public class DefaultValidatorTest extends TestCase {
    
    private RuntimeProfile profile;
    private ACK msg;
    
    public DefaultValidatorTest(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(DefaultValidatorTest.class);
        return suite;
    }
    
    public void setUp() throws Exception {
        ClassLoader cl = ProfileParser.class.getClassLoader();
        InputStream instream = cl.getResourceAsStream("ca/uhn/hl7v2/conf/parser/example_ack.xml");
        if (instream == null) throw new Exception("can't find the xml file");
        BufferedReader in = new BufferedReader(new InputStreamReader(instream));
        int tmp = 0;
        StringBuffer buf = new StringBuffer();
        while ((tmp = in.read()) != -1) {
            buf.append((char) tmp);
        }        
        String profileString = buf.toString();
        //System.out.println(profileString);
        ProfileParser parser = new ProfileParser(false);
        profile = parser.parse(profileString);

        URL specURL = this.getClass().getClassLoader().getResource("ca/uhn/hl7v2/conf/store/sampleTables.xml");
        CodeStore store = new ProfileCodeStore(specURL);
        ProfileStoreFactory.addCodeStore(store, ".*ConfSig.*"); //need qualifier to avoid collision with ProfileStoreFactpryTest    
        
        String message = "MSH|^~\\&|||||||ACK^A01|1|D|2.4|||||CAN|wrong|F^^HL70001^x^^HL78888|\r"; //note HL7888 doesn't exist
        msg =  (ACK) (new PipeParser()).parse(message);
    }    
    
    public void testTableValidation() throws Exception {
        DefaultValidator v = new DefaultValidator();
        Seg mshProfile = (Seg) profile.getMessage().getChild(1);
        String profileID = "{ConfSig(1) CCO(1) 2.4(7) static-profile(1) ADT(3) A01(1) null(0) ADT_A01(4) HL7 2.4(1) Sender(1)}";

        HL7Exception[] e = v.testField(msg.getMSH().getCountryCode(), mshProfile.getField(17), false, profileID);
        printExceptions(e);
        assertEquals(0, e.length);
        
        //should return an exception saying that the code "wrong" is not found 
        e = v.testField(msg.getMSH().getCharacterSet(0), mshProfile.getField(18), false, profileID);
        assertEquals(1, e.length);        
        assertTrue(e[0].getMessage().indexOf("wrong") >= 0);
        
        e = v.testField(msg.getMSH().getPrincipalLanguageOfMessage(), mshProfile.getField(19), false, profileID);

        printExceptions(e);

        //HEY!  this will fail if something unrelated goes wrong ... check output of the above to see what it is
        assertEquals(0, e.length);
    }
    
    public void printExceptions(Exception[] e) {
        for (int i = 0; i < e.length; i++) {
            System.out.println(e[i].getClass().getName() + ": " + e[i].getMessage());
        }        
    }
    
}
