/*
 * URLProfileStoreTest.java
 * JUnit based test
 *
 * Created on October 21, 2003, 10:52 AM
 */

package ca.uhn.hl7v2.conf.store;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;


/**
 * JUnit tests for URLProfileStore 
 * @author Bryan Tripp
 */
public class ClasspathProfileStoreTest  {
    
    @Test
    public void testWithClassLoader() throws Exception {
        ClasspathProfileStore store = new ClasspathProfileStore();
        String profile = store.getProfile("classloader-test");
        assertEquals("<foo/>", profile);        
    }

    @Test
    public void testWithNonExistingResource() throws Exception {
        ClasspathProfileStore store = new ClasspathProfileStore();
        String profile = store.getProfile("non-existing");
        assertNull(profile);
    }
}
