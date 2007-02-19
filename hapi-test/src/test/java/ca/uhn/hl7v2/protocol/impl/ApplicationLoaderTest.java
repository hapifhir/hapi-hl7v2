/*
 * Created on 25-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.net.URL;

import ca.uhn.hl7v2.protocol.ApplicationRouter;
import junit.framework.TestCase;

/**
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 */
public class ApplicationLoaderTest extends TestCase {

    /**
     * Constructor for ApplicationLoaderTest.
     * @param arg0
     */
    public ApplicationLoaderTest(String arg0) {
        super(arg0);
    }
    
    public void testLoad() throws Exception {
        ApplicationRouter router = new ApplicationRouterImpl();
        URL appResource = this.getClass().getClassLoader().getResource("ca/uhn/hl7v2/protocol/impl/mock_apps");
        ApplicationLoader.loadApplications(router, appResource);
        
        AppRoutingDataImpl a = new AppRoutingDataImpl("ORU", "R01", "D", "2.4");
        AppRoutingDataImpl b = new AppRoutingDataImpl("ORU", "R01", "P", "2.2");
        AppRoutingDataImpl c = new AppRoutingDataImpl("ADT", "A01", "P", "2.1");
        AppRoutingDataImpl d = new AppRoutingDataImpl("ADT", "A04", "P", "2.1"); //not there
        assertTrue(router.hasActiveBinding(a));
        assertTrue(router.hasActiveBinding(b));
        assertTrue(router.hasActiveBinding(c));
        assertEquals(false, router.hasActiveBinding(d));
    }

}
