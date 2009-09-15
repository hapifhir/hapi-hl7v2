/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl.tests;

import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;
import static org.junit.Assert.*;

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

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.PrimitiveTypeRule;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.MessageRuleBinding;
import ca.uhn.hl7v2.validation.impl.RuleBinding;
import ca.uhn.hl7v2.validation.impl.SizeRule;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;


/**
 * Unit tests for ValidationContextImpl. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:18 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class ValidationContextImplTest {
    
    private ValidationContextImpl myContext;
    
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(ValidationContextImplTest.class);
    
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
    
    
    @Before
    public void BeforeTheTest() {
	 myContext = new ValidationContextImpl(); 
    }
    


    @Test
    public void testGetPrimitiveRules() {
        PrimitiveTypeRule rule1 = new SizeRule(10);
        PrimitiveTypeRule rule2 = new SizeRule(20);
        
        myContext.getPrimitiveRuleBindings().add(new RuleBinding("2.5", "ST", rule1));
        myContext.getPrimitiveRuleBindings().add(new RuleBinding("2.5", "FT", rule2));
        
        PrimitiveTypeRule[] rules = myContext.getPrimitiveRules("2.5", "ST", null);
        assertEquals(1, rules.length);
        assertEquals(rule1, rules[0]);
    }

    @Test
    public void testGetMessageRules() {
        MessageRule rule1 = new MockMessageRule();
        MessageRule rule2 = new MockMessageRule();
        
        myContext.getMessageRuleBindings().add( new MessageRuleBinding("2.5", "ADT", "A01", rule1));
        myContext.getMessageRuleBindings().add( new MessageRuleBinding("2.5", "ADT", "A04", rule2));
        
        MessageRule[] rules = myContext.getMessageRules("2.5", "ADT", "A01");
        assertEquals(1, rules.length);
        assertEquals(rule1, rules[0]);
    }

    @Test
    public void testGetEncodingRules() {
        EncodingRule rule1 = new MockEncodingRule();
        EncodingRule rule2 = new MockEncodingRule();
        
        myContext.getEncodingRuleBindings().add( new RuleBinding("2.5", "XML", rule1));
        myContext.getEncodingRuleBindings().add( new RuleBinding("2.5", "ER7", rule1));
        
        EncodingRule[] rules = myContext.getEncodingRules("2.5", "XML");
        assertEquals(1, rules.length);
        assertEquals(rule1, rules[0]);
    }

//    public void testGetCheckPrimitivesOnSet() {
//        assertEquals(true, myContext.getCheckPrimitivesOnSet());
//        myContext.setCheckPrimitivesOnSet(false);
//        assertEquals(false, myContext.getCheckPrimitivesOnSet());
//    }
    
    private class MockMessageRule implements MessageRule {

        /**
         * @see ca.uhn.hl7v2.validation.MessageRule#test(ca.uhn.hl7v2.model.tests.Message)
         */
        public ValidationException[] test(Message arg0) {
            return null;
        }

        /** 
         * @see ca.uhn.hl7v2.validation.Rule#getDescription()
         */
        public String getDescription() {
            return null;
        }

        /** 
         * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
         */
        public String getSectionReference() {
            return null;
        }
        
    }
    
    private class MockEncodingRule implements EncodingRule {

        /** 
         * @see ca.uhn.hl7v2.validation.EncodingRule#test(java.lang.String)
         */
        public ValidationException[] test(String arg0) {
            return null;
        }

        /** 
         * @see ca.uhn.hl7v2.validation.Rule#getDescription()
         */
        public String getDescription() {
            return null;
        }

        /** 
         * @see ca.uhn.hl7v2.validation.Rule#getSectionReference()
         */
        public String getSectionReference() {
            return null;
        }
        
    }

}
