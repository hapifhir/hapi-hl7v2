/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.provision;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.scanDir;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.MessageValidator;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.MessageRuleBinding;
import ca.uhn.hl7v2.validation.impl.RuleBinding;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;


/**
 * Unit tests for MessageValidator. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:18 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class MessageValidatorTest{
    
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(MessageValidatorTest.class);
    
    @Inject
    BundleContext bundleContext;
    
    @Configuration
    public static Option[] configure() {
	return options(frameworks(equinox(), felix(), knopflerfish())
		, logProfile()
		, systemProperty("org.ops4j.pax.logging.DefaultServiceLog.level").value("INFO")
		, mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-mvn").version("0.4.0")
		, wrappedBundle(mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-util").version("0.5.3"))
		, mavenBundle().groupId("ca.uhn.hapi").artifactId("hapi-osgi-base").version("1.0-beta1")
//		, vmOption("-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5006" )


	);
    }

    private MessageValidator myFailingValidator; 
    private MessageValidator myNonFailingValidator; 
    
    
    @Before
    public void BeforeTheTest() {
	System.out.println("*****************************BeforeTheTest******************************************");
        ValidationContextImpl context = new ValidationContextImpl();
        context.getMessageRuleBindings().add(new MessageRuleBinding("*", "*", "*", new MockMessageRule()));
        context.getMessageRuleBindings().add(new MessageRuleBinding("*", "*", "*", new MockMessageRule()));
        context.getEncodingRuleBindings().add(new RuleBinding("*", "*", new MockEncodingRule()));
        context.getEncodingRuleBindings().add(new RuleBinding("*", "*", new MockEncodingRule()));
        
        myFailingValidator = new MessageValidator(context, true);
        myNonFailingValidator = new MessageValidator(context, false);
    }
     
    
    
    
     /*
     * Class under test for void validate(Message)
     */
    @Test
    public void testValidateMessage() throws HL7Exception {
        ACK m = new ACK();
        Terser t = new Terser(m);
        t.set("MSH-9-1", "ACK");
        t.set("MSH-9-2", "A01");
        assertEquals(false, myNonFailingValidator.validate(m));
        try {
            myFailingValidator.validate(m);
            fail("Should throw exception on fail");
        } catch (HL7Exception e) {}
    }

    /*
     * Class under test for void validate(String, boolean, String)
     */
    @Test
    public void testValidateString() throws HL7Exception {
        String m = "a message";
        assertEquals(false, myNonFailingValidator.validate(m, false, "2.5"));
        try {
            myFailingValidator.validate(m, false, "2.5");
            fail("Should throw exception on fail");            
        } catch (HL7Exception e) {}
    }
    
    private class MockMessageRule implements MessageRule {
        
        public ValidationException[] test(Message msg) {
            return new ValidationException[] {new ValidationException("testing validator")};
        }
        
        public String getDescription() {
            return null;
        }

        public String getSectionReference() {
            return null;
        }
    }
    
    private class MockEncodingRule implements EncodingRule {
        
        public boolean appliesToER7() {
            return true;
        }
        
        public boolean appliesToXML() {
            return true;
        }
        
        public ValidationException[] test(String msg) {
            return new ValidationException[] {new ValidationException("test validator")};
        }
        
        public String getDescription() {
            return null;
        }
        
        public String getSectionReference() {
            return null;
        }
    }

}
