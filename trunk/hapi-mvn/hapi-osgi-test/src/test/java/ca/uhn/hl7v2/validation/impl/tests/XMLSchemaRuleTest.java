/*
 * Created on 21-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl.tests;

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
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.vmOption;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;


import ca.uhn.hl7v2.validation.EncodingRule;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.impl.XMLSchemaRule;

/**
 * Unit tests for <code>ValidatesAgainstSchema</code>.
 *   
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:18 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class XMLSchemaRuleTest{


    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(XMLSchemaRuleTest.class);
    
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
    
    @Test
    public void testTest() throws IOException {
        
        URL res = XMLSchemaRuleTest.class.getClassLoader().getResource("ca/uhn/hl7v2/validation/impl/tests/ACK.xsd");
        String resPath = res.toString().replace("file:/", "").replace("/ACK.xsd", "");
         
        System.out.println("*****************************ResPath="+resPath+"*******************" );
        System.setProperty("ca.uhn.hl7v2.validation.xmlschemavalidator.schemalocation.2.5", resPath);
        
        EncodingRule rule = new XMLSchemaRule();
        ValidationException[] errors = rule.test(getMessage1());
        System.out.println(errors[0].getMessage());
        assertEquals(0, errors.length);

        errors = rule.test(getMessage2());
        assertEquals(1, errors.length);
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
