package ca.uhn.hl7v2.model.tests;

import static org.junit.Assert.assertEquals;
import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.model.GenericMessage;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.ModelClassFactory;

/**
 * JUnit test cases for AbstractSegment
 * @author bryan
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class AbstractSegmentTest  {
    
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(AbstractSegmentTest.class);
    
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
    
    // Add test methods here, they have to start with 'test' name.
    // for example:
    // public void testHello() {}
    @Test
    public void testEnsureEnoughFields() throws Exception {
        ModelClassFactory factory = new DefaultModelClassFactory();
        MSH msh = new MSH(new GenericMessage.V25(factory), factory);
        int n = msh.numFields();
        msh.getField(n + 3, 0);
        assertEquals("ca.uhn.hl7v2.model.Varies", msh.getField(n+1, 0).getClass().getName());
        assertEquals("ca.uhn.hl7v2.model.Varies", msh.getField(n+2, 0).getClass().getName());
        assertEquals("ca.uhn.hl7v2.model.Varies", msh.getField(n+3, 0).getClass().getName());
    }
    
    @Test
    public void testUnexpectedFieldReps() throws Exception {
        ModelClassFactory factory = new DefaultModelClassFactory();
        MSH msh = new MSH(new GenericMessage.V25(factory), new DefaultModelClassFactory());
        msh.getField(1, 0);
        msh.getField(1, 1);        
        assertEquals(2, msh.getField(1).length);
    }
    
}
