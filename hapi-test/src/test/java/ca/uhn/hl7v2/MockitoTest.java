package ca.uhn.hl7v2;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Mockito used its own CGLIB-enhancing classloader as the current thread's classloader and does not
 * clean it up. As a result, in subsequent tests, JAXP/DOM bootstrapping is not able to instantiate
 * its implementation classes.
 * <p>
 * Tests using Mockito *must* extend this class, which cleans up the classloader after all tests
 * have finished.
 * 
 * @author Christian Ohr
 */
public abstract class MockitoTest {

    private static ClassLoader loader;

    @BeforeClass
    public static void beforeStart() {
        loader = Thread.currentThread().getContextClassLoader();
    }

    @AfterClass
    public static void afterEnd() {
        if (loader != null)
            Thread.currentThread().setContextClassLoader(loader);
    }

}
