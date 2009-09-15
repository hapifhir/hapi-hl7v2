/*
 * URLProfileStoreTest.java
 * JUnit based test
 *
 * Created on October 21, 2003, 10:52 AM
 */

package ca.uhn.hl7v2.conf.store.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;

import java.io.File;
import java.net.MalformedURLException;
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

import ca.uhn.hl7v2.conf.store.URLProfileStore;
import ca.uhn.hl7v2.util.tests.MessageLibrary;

/**
 * JUnit tests for URLProfileStore 
 * @author Bryan Tripp
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class URLProfileStoreTest {
 // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(URLProfileStoreTest.class);
    
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
    public void testWithClassLoader() throws Exception {
        
	URLProfileStore store = new URLProfileStore() {
            public URL getURL(String ID) throws MalformedURLException {
                return URLProfileStoreTest.class.getClassLoader().getResource("ca/uhn/hl7v2/conf/store/tests/" + ID + ".xml");
            }
        };
        
        String profile = store.getProfile("classloader-test");
        assertEquals("<foo/>", profile);        
    }

//    @Test
//    public void testWithHTTP() throws Exception {
//        URLProfileStore store = new URLProfileStore() {
//            public URL getURL(String ID) throws MalformedURLException {
//                return new URL("http://www.google.com");
//            }
//        };
//        
//        String in = store.getProfile("test");
//        assertTrue(in.indexOf("Google") >= 0);
//    }
    
    public void testWithFile() throws Exception {
        URLProfileStore store = new URLProfileStore() {
            public URL getURL(String ID) throws MalformedURLException {
                File f = new File(".");
                return new URL("file:///" + f.getAbsolutePath() + "/" + ID + ".xml");
            }
        };
        
        String out = "<test_profile/>";
        store.persistProfile("test", out);
        String in = store.getProfile("test");
        assertEquals(out, in);
    }
    
}
