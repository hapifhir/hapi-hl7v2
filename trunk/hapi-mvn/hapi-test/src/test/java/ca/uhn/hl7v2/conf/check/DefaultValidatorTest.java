package ca.uhn.hl7v2.conf.check;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.IOUtils;

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
import ca.uhn.hl7v2.model.v251.message.ORU_R01;
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
    
//    public void testOptionality() throws Exception {
//    	
//        ClassLoader cl = ProfileParser.class.getClassLoader();
//        InputStream instream = cl.getResourceAsStream("ca/uhn/hl7v2/conf/parser/ADT_A01_ConstrainedExample.xml");
//        if (instream == null) throw new Exception("can't find the xml file");
//        BufferedReader in = new BufferedReader(new InputStreamReader(instream));
//        int tmp = 0;
//        StringBuffer buf = new StringBuffer();
//        while ((tmp = in.read()) != -1) {
//            buf.append((char) tmp);
//        }        
//        String profileString = buf.toString();
//        //System.out.println(profileString);
//        ProfileParser parser = new ProfileParser(false);
//        RuntimeProfile prof = parser.parse(profileString);
//
//        DefaultValidator v = new DefaultValidator();
//    	
//        // This message has an unsupported second component in MSH-7 
//		String message = "MSH|^~\\&|^QueryServices||||20021011161756.297-0500^000||ADT^A01|1|D|2.4\r";
//		ADT_A01 msg = new ADT_A01();
//		msg.parse(message);
//        
//		HL7Exception[] problems = v.validate(msg, prof.getMessage());
//		
//		assertTrue(problems.length > 0);
//		assertTrue(problems[0].getSegmentName(), problems[0].getSegmentName().equals("MSH"));
//		assertTrue(problems[0].getSegmentRepetition() + "", problems[0].getSegmentRepetition() == 1);
//		assertTrue(problems[0].getFieldPosition() + "", problems[0].getFieldPosition() == 7);
//		assertTrue(problems[0].getMessage(), problems[0].getMessage().toLowerCase().contains("not supported"));
//		
//    }

    
    public void testRequiredSegment() throws Exception {
    	
        ClassLoader cl = ProfileParser.class.getClassLoader();
        InputStream instream = cl.getResourceAsStream("ca/uhn/hl7v2/conf/parser/ADT_A01_reqsft.xml");
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
        RuntimeProfile prof = parser.parse(profileString);

        DefaultValidator v = new DefaultValidator();
    	
        // This message has an unsupported second component in MSH-7 
		String message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r";
		ca.uhn.hl7v2.model.v25.message.ADT_A01 msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		HL7Exception[] problems = v.validate(msg, prof.getMessage());
		String toString = Arrays.asList(problems).toString();
		
		assertTrue(problems.length > 0);
		assertTrue(toString, toString.contains("SFT must have at least 1"));
		
    }

    /** 
     * Issue reported on mailing list 
     */
    public void testOru() throws Exception {
		ClassLoader cl = ProfileParser.class.getClassLoader();
		InputStream instream = cl.getResourceAsStream("ca/uhn/hl7v2/conf/ORU_R01.xml");
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
		RuntimeProfile prof = parser.parse(profileString);
		
		DefaultValidator v = new DefaultValidator();
		
		String message = IOUtils.toString(cl.getResourceAsStream("ca/uhn/hl7v2/conf/ORU_R01.hl7"));
		ORU_R01 msg = new ca.uhn.hl7v2.model.v251.message.ORU_R01();
		msg.parse(message.replaceAll("(\\n|\\r)+", "\r"));
		
		HL7Exception[] problems = v.validate(msg, prof.getMessage());
		String toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length == 0);
    	
    }
    
    
    public void testNotSupportedSegment() throws Exception {
    	
        ClassLoader cl = ProfileParser.class.getClassLoader();
        InputStream instream = cl.getResourceAsStream("ca/uhn/hl7v2/conf/parser/ADT_A01_segnotsup.xml");
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
        RuntimeProfile prof = parser.parse(profileString);

        DefaultValidator v = new DefaultValidator();
    	
		String message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r";
		ca.uhn.hl7v2.model.v25.message.ADT_A01 msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		HL7Exception[] problems = v.validate(msg, prof.getMessage());
		String toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length == 0);
		
		message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r" +
				"SFT|123";
		msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		problems = v.validate(msg, prof.getMessage());
		toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length == 1);
		assertTrue(toString, toString.contains("SFT"));
		
    }
    
    public void testNotSupportedField() throws Exception {
    	
        ClassLoader cl = ProfileParser.class.getClassLoader();
        InputStream instream = cl.getResourceAsStream("ca/uhn/hl7v2/conf/parser/ADT_A01_fieldnotsup.xml");
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
        RuntimeProfile prof = parser.parse(profileString);

        DefaultValidator v = new DefaultValidator();
    	
		String message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r";
		ca.uhn.hl7v2.model.v25.message.ADT_A01 msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		HL7Exception[] problems = v.validate(msg, prof.getMessage());
		String toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length == 0);
		
		message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r" +
				"SFT|123";
		msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		problems = v.validate(msg, prof.getMessage());
		toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length == 0);
		
		message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r" +
				"SFT|123|sssss";
		msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		problems = v.validate(msg, prof.getMessage());
		toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length == 1);
		assertTrue(toString, toString.contains("Field 2"));

    }
    
    public void testNotSupportedComponent() throws Exception {
    	
        ClassLoader cl = ProfileParser.class.getClassLoader();
        InputStream instream = cl.getResourceAsStream("ca/uhn/hl7v2/conf/parser/ADT_A01_compnotsup.xml");
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
        RuntimeProfile prof = parser.parse(profileString);

        DefaultValidator v = new DefaultValidator();
    	
		String message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r";
		ca.uhn.hl7v2.model.v25.message.ADT_A01 msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		HL7Exception[] problems = v.validate(msg, prof.getMessage());
		String toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length == 0);
		
		message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r" +
				"SFT|123";
		msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		problems = v.validate(msg, prof.getMessage());
		toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length == 0);
		
		message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r" +
				"SFT|123|sssss";
		msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		problems = v.validate(msg, prof.getMessage());
		toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length == 0);
	
		message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r" +
				"SFT|123^1111|sssss";
		msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		problems = v.validate(msg, prof.getMessage());
		toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length == 1);
		assertTrue(toString, toString.contains("organization name type code"));

    }

    public void testNotSupportedSubComponent() throws Exception {
    	
        ClassLoader cl = ProfileParser.class.getClassLoader();
        InputStream instream = cl.getResourceAsStream("ca/uhn/hl7v2/conf/parser/ADT_A01_subcompnotsup.xml");
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
        RuntimeProfile prof = parser.parse(profileString);

        DefaultValidator v = new DefaultValidator();
    	
		String message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r";
		ca.uhn.hl7v2.model.v25.message.ADT_A01 msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		HL7Exception[] problems = v.validate(msg, prof.getMessage());
		String toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length == 0);
		
		message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r" +
				"SFT|123";
		msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		problems = v.validate(msg, prof.getMessage());
		toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length == 0);
		
		message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r" +
				"SFT|123|sssss";
		msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		problems = v.validate(msg, prof.getMessage());
		toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length == 0);
	
		message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r" +
				"SFT|123^1111|sssss";
		msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		problems = v.validate(msg, prof.getMessage());
		toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length == 0);

		message = "MSH|^~\\&|^QueryServices||||20021011161756-0500||ADT^A01^ADT_A01|1|D|2.5\r" +
				"SFT|1^2^3^4^5^6&aaa|sssss";
		msg = new ca.uhn.hl7v2.model.v25.message.ADT_A01();
		msg.parse(message);
        
		problems = v.validate(msg, prof.getMessage());
		toString = Arrays.asList(problems).toString();
		
		assertTrue(toString, problems.length > 0);
		assertTrue(toString, toString.contains("universal ID"));

    }

    public void testTableValidation() throws Exception {
        DefaultValidator v = new DefaultValidator();
        Seg mshProfile = (Seg) profile.getMessage().getChild(1);
        String profileID = "{ConfSig(1) CCO(1) 2.4(7) static-profile(1) ADT(3) A01(1) null(0) ADT_A01(4) HL7 2.4(1) Sender(1)}";

        List<HL7Exception> e = v.testField(msg.getMSH().getCountryCode(), mshProfile.getField(17), false, profileID);
        printExceptions(e);
        assertEquals(0, e.size());
        
        //should return an exception saying that the code "wrong" is not found 
        e = v.testField(msg.getMSH().getCharacterSet(0), mshProfile.getField(18), false, profileID);
        assertEquals(1, e.size());
        assertTrue(e.get(0).getMessage().contains("wrong"));
        
        e = v.testField(msg.getMSH().getPrincipalLanguageOfMessage(), mshProfile.getField(19), false, profileID);

        printExceptions(e);

        //HEY!  this will fail if something unrelated goes wrong ... check output of the above to see what it is
        assertEquals(0, e.size());
    }
    
    public void printExceptions(List<HL7Exception> exceptions) {
        for (Exception e : exceptions) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
        }        
    }
    
}
