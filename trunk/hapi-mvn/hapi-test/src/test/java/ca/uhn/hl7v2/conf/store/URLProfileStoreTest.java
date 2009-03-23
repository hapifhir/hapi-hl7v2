/*
 * URLProfileStoreTest.java
 * JUnit based test
 *
 * Created on October 21, 2003, 10:52 AM
 */

package ca.uhn.hl7v2.conf.store;

import junit.framework.*;
import java.net.*;
import java.io.File;

/**
 * JUnit tests for URLProfileStore 
 * @author Bryan Tripp
 */
public class URLProfileStoreTest extends TestCase {
    
    public URLProfileStoreTest(java.lang.String testName) {
        super(testName);
    }
    
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    
    public static Test suite() {
        TestSuite suite = new TestSuite(URLProfileStoreTest.class);
        return suite;
    }
    
    public void testWithClassLoader() throws Exception {
        URLProfileStore store = new URLProfileStore() {
            public URL getURL(String ID) throws MalformedURLException {
                return this.getClass().getClassLoader().getResource("ca/uhn/hl7v2/conf/store/" + ID + ".xml");
            }
        };
        
        String profile = store.getProfile("classloader-test");
        assertEquals("<foo/>", profile);        
    }

    public void testWithHTTP() throws Exception {
        URLProfileStore store = new URLProfileStore() {
            public URL getURL(String ID) throws MalformedURLException {
                return new URL("http://google.com");
            }
        };
        
        String in = store.getProfile("test");
        assertTrue(in.indexOf("Google") >= 0);
    }
    
    /*public void testWithFile() throws Exception {
        URLProfileStore store = new URLProfileStore() {
            public URL getReadURL(String ID) throws MalformedURLException {
                File f = new File(".");
                return new URL("file:///" + f.getAbsolutePath() + "/" + ID + ".xml");
            }
        };
        
        String out = "<test_profile/>";
        store.persistProfile("test", out);
        String in = store.getProfile("test");
        assertEquals(out, in);
    }*/
    
}
