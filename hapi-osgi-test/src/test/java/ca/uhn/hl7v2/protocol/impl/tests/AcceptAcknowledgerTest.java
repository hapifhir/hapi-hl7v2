/*
 * Created on 19-May-2004
 */
package ca.uhn.hl7v2.protocol.impl.tests;

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

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.protocol.AcceptValidator;
import ca.uhn.hl7v2.protocol.ProcessorContext;
import ca.uhn.hl7v2.protocol.SafeStorage;
import ca.uhn.hl7v2.protocol.Transportable;
import ca.uhn.hl7v2.protocol.impl.AcceptAcknowledger;
import ca.uhn.hl7v2.protocol.impl.NullSafeStorage;
import ca.uhn.hl7v2.protocol.impl.ProcessorContextImpl;
import ca.uhn.hl7v2.protocol.impl.TransportableImpl;

/**
 * Unit tests for <code>AcceptAcknowledger</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class AcceptAcknowledgerTest {

    private static String message = "MSH|^~\\&|||||||ADT^A01|b|P|2.4\rNTE|\r";
 
    // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(AcceptAcknowledgerTest.class);
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
    public void testValidateAccept() throws Exception {
        ProcessorContext context = new ProcessorContextImpl(null, null, new NullSafeStorage());
        context.addValidator(new MockValidator(true));
        
        AcceptAcknowledger.AcceptACK ack = 
            AcceptAcknowledger.validate(context, new TransportableImpl(message));
        assertEquals(true, ack.isAcceptable());
    }
    
    @Test
    public void testValidateReject() throws Exception {
        ProcessorContext context = new ProcessorContextImpl(null, null, new NullSafeStorage());
        context.addValidator(new MockValidator(false));
        
        AcceptAcknowledger.AcceptACK ack = 
            AcceptAcknowledger.validate(context, new TransportableImpl(message));
        assertEquals(false, ack.isAcceptable());        
    }

    @Test
    public void testValidateCantStore() throws Exception {
        ProcessorContext context = new ProcessorContextImpl(null, null, new BadStore());
        
        AcceptAcknowledger.AcceptACK ack = 
            AcceptAcknowledger.validate(context, new TransportableImpl(message));
        assertEquals(false, ack.isAcceptable());        
    }
    
    /**
     * Skeleton mock implementation of <code>AcceptValidator</code>. 
     * 
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author: jamesagnew $
     */
    public class MockValidator implements AcceptValidator {
        
        private final boolean OK;
        
        public MockValidator(boolean everythingOK) {
            OK = everythingOK;
        }

        public AcceptRuling check(Transportable arg0) {
            return new AcceptRuling() {
                public boolean isAcceptable() {
                    return OK;
                }

                public String getAckCode() {
                    return null;
                }

                public int getErrorCode() {
                    return 0;
                }

                public String[] getReasons() {
                    return new String[0];
                }
            };
        }
    }

    /**
     * Mock store that throws an exception when an attempt is made to 
     * store something (for negative testing).  
     *  
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author: jamesagnew $
     */    
    public class BadStore implements SafeStorage {

        /** 
         * Throws an exception. 
         */
        public void store(Transportable arg0) throws HL7Exception {
            throw new HL7Exception("This SafeStorage is meant to fail");            
        }

        public void discard(Transportable arg0) throws HL7Exception {
        }

        public Transportable[] restore() throws HL7Exception {
            return null;
        }
        
    }
}