/*
 * URLProfileStoreTest.java
 * JUnit based test
 *
 * Created on October 21, 2003, 10:52 AM
 */

package ca.uhn.hl7v2.conf.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Ignore;
import org.junit.Test;


/**
 * JUnit tests for URLProfileStore 
 * @author Bryan Tripp
 */
public class URLProfileStoreTest  {
    
    @Test
    public void testWithClassLoader() throws Exception {
        URLProfileStore store = new URLProfileStore() {
            public URL getURL(String ID) throws MalformedURLException {
                return this.getClass().getClassLoader().getResource("ca/uhn/hl7v2/conf/store/" + ID + ".xml");
            }
        };
        
        String profile = store.getProfile("classloader-test");
        assertEquals("<foo/>", profile);        
    }

    @Ignore
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
