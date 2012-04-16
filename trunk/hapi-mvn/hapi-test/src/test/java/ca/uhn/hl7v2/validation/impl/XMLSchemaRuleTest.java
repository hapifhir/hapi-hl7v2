/*
 * Created on 21-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

import org.junit.Test;

import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.ValidationException;

/**
 * Unit tests for <code>ValidatesAgainstSchema</code>.
 *   
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @author Christian Ohr
 */
public class XMLSchemaRuleTest {

	@Test
    public void testTest() throws IOException {
        
        URL res = XMLSchemaRuleTest.class.getClassLoader().getResource("ca/uhn/hl7v2/validation/impl/ACK.xsd");
        String resPath = res.toString().replace("file:", "").replace("/ACK.xsd", "");
   
        System.setProperty("ca.uhn.hl7v2.validation.xmlschemavalidator.schemalocation.2.5", 
                resPath);
        
        EncodingRule rule = new XMLSchemaRule();
        ValidationException[] errors = rule.test(getMessage1());
        for (int i =0; i < errors.length;i++) {
        	System.out.println(errors[i].toString());
        }
        assertEquals(Arrays.asList(errors).toString(), 0, errors.length);

        errors = rule.test(getMessage2());
        assertEquals(Arrays.asList(errors).toString(), 1, errors.length);
    }
    
    private String getMessage1() {
        return "<?xml version=\"1.0\"?>"
               + " <ACK "
               + "  xmlns=\"urn:hl7-org:v2xml\">"
               + "     <MSH>"
               + "         <MSH.1>|</MSH.1>"
               + "         <MSH.2>^~\\&amp;</MSH.2>"
               + "         <MSH.7>"
               + "             <TS.1>20050621103250.424-0500</TS.1>"
               + "         </MSH.7>"
               + "         <MSH.9>"
               + "             <MSG.1>ACK</MSG.1>"
               + "         </MSH.9>"
               + "         <MSH.10>1</MSH.10>"
               + "         <MSH.11>"
               + "             <PT.1>P</PT.1>"
               + "         </MSH.11>"
               + "         <MSH.12>"
               + "             <VID.1>2.5</VID.1>"
               + "         </MSH.12>"
               + "     </MSH>"
               + "     <MSA>"
               + "         <MSA.1>AA</MSA.1>"
               + "         <MSA.2>100</MSA.2>"
               + "     </MSA>"
               + " </ACK>";
    }

    private String getMessage2() {
        return "<?xml version=\"1.0\"?>"
               + " <ACK "
               + "  xmlns=\"urn:hl7-org:v2xml\">"
               + "     <MSH>"
               + "         <MSH.1>|</MSH.1>"
               + "         <MSH.2>^~\\&amp;</MSH.2>"
               + "         <MSH.7>"
               + "             <TS.1>20050621103250.424-0500</TS.1>"
               + "         </MSH.7>"
               + "         <MSH.9>"
               + "             <MSG.1>ACK</MSG.1>"
               + "         </MSH.9>"
               + "         <MSH.10>1</MSH.10>"
               + "         <MSH.11>"
               + "             <PT.1>P</PT.1>"
               + "         </MSH.11>"
               + "         <MSH.12>"
               + "             <VID.1>2.5</VID.1>"
               + "         </MSH.12>"
               + "     </MSH>"
               + "     <MSA>"
               + "         <MSA.XXXXXXXX>AA</MSA.XXXXXXXX>"
               + "         <MSA.2>100</MSA.2>"
               + "     </MSA>"
               + " </ACK>";
    }
}
