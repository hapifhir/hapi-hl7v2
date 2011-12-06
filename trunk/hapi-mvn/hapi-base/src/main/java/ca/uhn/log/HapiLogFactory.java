/*
 * HapiLogFactory.java
 * 
 * Created on May 7, 2003 at 2:19:17 PM
 */
package ca.uhn.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * <p>Factory for creating {@link HapiLog} instances. It is factory
 * that delegates the discovery process to the <code> LogFactory </code>
 * class and wraps the discovered <code> Log </code> with a new instance of
 * the <code>HapiLog</code> class.
 * 
 * @author <a href="mailto:alexei.guevara@uhn.on.ca">Alexei Guevara</a>
 * @deprecated use slf4j LoggerFactory
 */
public final class HapiLogFactory {
    
    /**
     * Do not allow instantiation.
     */
    private HapiLogFactory() {
    }

    /**
     * Convenience method to return a named HAPI logger, without the application
     * having to care about factories.
     *
     * @param clazz Class for which a log name will be derived
     *
     * @exception LogConfigurationException if a suitable <code>Log</code>
     *  instance cannot be returned
     */
    public static HapiLog getHapiLog( Class<?> clazz ) {
        Logger log = LoggerFactory.getLogger( clazz );
        return new HapiLogImpl( log );
    }
    
    /**
     * Convenience method to return a named HAPI logger, without the application
     * having to care about factories.
     *
     * @param name Logical name of the <code>Log</code> instance to be
     *  returned (the meaning of this name is only known to the underlying
     *  logging implementation that is being wrapped)
     *
     * @exception LogConfigurationException if a suitable <code>Log</code>
     *  instance cannot be returned
     */
    public static HapiLog getHapiLog( String name ) {
        Logger log = LoggerFactory.getLogger( name );
        return new HapiLogImpl( log );
    }

}


