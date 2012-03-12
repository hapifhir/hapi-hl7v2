package ca.uhn.hl7v2.validation.app;

import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.store.*;
import ca.uhn.hl7v2.model.*;
import java.io.*;

/**
 * Test case for ProfileTestApplication -- note this requires checking logs so it 
 * isn't self-verifying and isn't a JUnit test.  
 * @author bryan
 */
public class ProfileTestApplicationCheck {
    
    /*public ProfileTestApplicationCheck(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(ProfileTestApplicationTest.class);
        return suite;
    }*/
    
    @SuppressWarnings("deprecation")
	public void testProcessMessage() throws Exception {
        ProfileTestApplication app = new ProfileTestApplication();
        addProfileToStore();
        app.processMessage(getTestMessage());            
        System.out.println("Note: profile exception messages should have been logged as per log4j setup");
    }
    
    private void addProfileToStore() throws Exception {
        InputStream instream = ProfileParser.class.getClassLoader().getResourceAsStream("ca/uhn/hl7v2/conf/parser/example_ack.xml");
        BufferedReader in = new BufferedReader(new InputStreamReader(instream));
        StringBuffer profile = new StringBuffer();
        int i;
        while ((i = in.read()) != -1) {
            profile.append( (char) i );
        }
        in.close();
        
        ProfileStoreFactory.getProfileStore().persistProfile("TestProfile", profile.toString());
    }
    
    private Message getTestMessage() throws Exception {
        String message = "MSH|^~\\&|Fake Sending App|Fake Sending Facility||Fake Receiving Facility|200108151718||ACK^A01^ACK|20|P|2.4|||||||||TestProfile|\rMSA|AA\r";
        PipeParser p = new PipeParser();
        return p.parse(message);
    }
    
    public static void main(String args[]) {
        try {
            //System.setProperty("log4j.configuration", "c:/hapi/log4j.xml");
            //System.out.println("log4j.configuration: " + System.getProperty("log4j.configuration"));            
            ProfileTestApplicationCheck check = new ProfileTestApplicationCheck();
            check.testProcessMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
