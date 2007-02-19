/*
 * Created on 27-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import ca.uhn.hl7v2.conf.parser.ProfileParser;
import ca.uhn.hl7v2.conf.store.ProfileStoreFactory;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.validation.ValidationException;
import junit.framework.TestCase;

/**
 * Unit tests for ConformanceProfileRule. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:33 $ by $Author: jamesagnew $
 */
public class ConformanceProfileRuleTest extends TestCase {

    private static String PROFILE_ID = "TestProfile";
    
    private ConformanceProfileRule myRule1;
    private ConformanceProfileRule myRule2;
    
    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        myRule1 = new ConformanceProfileRule(PROFILE_ID);
        myRule2 = new ConformanceProfileRule();
    }

    /**
     * Constructor for ConformanceProfileRuleTest.
     * @param arg0
     */
    public ConformanceProfileRuleTest(String arg0) throws Exception {
        super(arg0);
        addProfileToStore();
    }

    public void testTest() throws Exception {
        Parser p = new PipeParser();        
        Message m1 = p.parse(getMessage1());
        Message m2 = p.parse(getMessage2());
        Message m3 = p.parse(getMessage3());
        
        ValidationException[] errors = myRule1.test(m1);
        assertEquals(10, errors.length);
        
        errors = myRule1.test(m2);
        assertEquals(9, errors.length);
        
        errors = myRule1.test(m3);
        assertEquals(6, errors.length);
        
        errors = myRule2.test(m1);
        assertEquals(10, errors.length);
        
        errors = myRule2.test(m2);
        assertEquals(0, errors.length);
        
        errors = myRule2.test(m3);
        assertEquals(12, errors.length); //gets tested twice
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
        
        ProfileStoreFactory.getProfileStore().persistProfile(PROFILE_ID, profile.toString());
    }

    private String getMessage1() {
        return "MSH|^~\\&|Fake Sending App|Fake Sending Facility||Fake Receiving Facility|200108151718||ACK^A01^ACK|20|P|2.4|||||||||TestProfile|\rMSA|AA\r";
    }

    private String getMessage2() {
        return "MSH|^~\\&|Fake Sending App|Fake Sending Facility||Fake Receiving Facility|200108151718||ACK^A01^ACK|20|P|2.4||||||||||\rMSA|AA\r";
    }

    private String getMessage3() {
        return "MSH|^~\\&|A|B||C|||ACK^A01^ACK|20|P|2.4|||||||||TestProfile~TestProfile|\rMSA|AA|1\r";
    }
}
