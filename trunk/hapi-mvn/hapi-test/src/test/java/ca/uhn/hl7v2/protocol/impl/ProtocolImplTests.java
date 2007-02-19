/*
 * Created on 24-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 */
public class ProtocolImplTests {

    public static Test suite() {
        TestSuite suite = new TestSuite("Test for ca.uhn.hl7v2.protocol.impl");
        //$JUnit-BEGIN$
        suite.addTest(new TestSuite(AbstractTransportTest.class));
        suite.addTest(new TestSuite(AcceptAcknowledgerTest.class));
        suite.addTest(new TestSuite(ApplicationLoaderTest.class));        
        suite.addTest(new TestSuite(ApplicationRouterImplTest.class));
        suite.addTest(new TestSuite(ClientSocketStreamSourceTest.class));
        suite.addTest(new TestSuite(DualTransportConnectorTest.class));
        suite.addTest(new TestSuite(HL7ServerTest.class));
        suite.addTest(new TestSuite(InitiatorImplTest.class));
        suite.addTest(new TestSuite(MetadataExtractorTest.class));
        suite.addTest(new TestSuite(MLLPTransportTest.class));
        suite.addTest(new TestSuite(ProcessorImplTest.class));
        suite.addTest(new TestSuite(ServerSocketStreamSourceTest.class));
        //$JUnit-END$
        return suite;
    }
}
