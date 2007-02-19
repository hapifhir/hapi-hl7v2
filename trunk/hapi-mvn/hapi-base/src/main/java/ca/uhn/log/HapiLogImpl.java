/*
 * HapiLog.java
 * 
 * Created on May 7, 2003 at 2:23:45 PM
 */
package ca.uhn.log;

import java.text.MessageFormat;

import org.apache.commons.logging.Log;

/**
 * Provides a base implementation of the <code>HapiLog</code> interface.
 * 
 * It delegates all method calls declared by <code>Log</code> to the delegate specified in
 * the contructor.
 * 
 * @author <a href="mailto:alexei.guevara@uhn.on.ca">Alexei Guevara</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:52 $ by $Author: jamesagnew $
 */
public class HapiLogImpl implements HapiLog {
    
    private final Log delegate;
    
    HapiLogImpl( Log delegate ) {
        this.delegate = delegate;
    }

    /**
     * @param message
     */
    public void debug(Object message) {
        delegate.debug(message);
    }

    /**
     * @param message
     * @param t
     */
    public void debug(Object message, Throwable t) {
        delegate.debug(message, t);
    }

    /**
     * @param message
     */
    public void error(Object message) {
        delegate.error(message);
    }

    /**
     * @param message
     * @param t
     */
    public void error(Object message, Throwable t) {
        delegate.error(message, t);
    }

    /**
     * @param message
     */
    public void fatal(Object message) {
        delegate.fatal(message);
    }

    /**
     * @param message
     * @param t
     */
    public void fatal(Object message, Throwable t) {
        delegate.fatal(message, t);
    }

    /**
     * @param message
     */
    public void info(Object message) {
        delegate.info(message);
    }

    /**
     * @param message
     * @param t
     */
    public void info(Object message, Throwable t) {
        delegate.info(message, t);
    }

    /**
     * @return
     */
    public boolean isDebugEnabled() {
        return delegate.isDebugEnabled();
    }

    /**
     * @return
     */
    public boolean isErrorEnabled() {
        return delegate.isErrorEnabled();
    }

    /**
     * @return
     */
    public boolean isFatalEnabled() {
        return delegate.isFatalEnabled();
    }

    /**
     * @return
     */
    public boolean isInfoEnabled() {
        return delegate.isInfoEnabled();
    }

    /**
     * @return
     */
    public boolean isTraceEnabled() {
        return delegate.isTraceEnabled();
    }

    /**
     * @return
     */
    public boolean isWarnEnabled() {
        return delegate.isWarnEnabled();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return delegate.toString();
    }

    /**
     * @param message
     */
    public void trace(Object message) {
        delegate.trace(message);
    }

    /**
     * @param message
     * @param t
     */
    public void trace(Object message, Throwable t) {
        delegate.trace(message, t);
    }

    /**
     * @param message
     */
    public void warn(Object message) {
        delegate.warn(message);
    }

    /**
     * @param message
     * @param t
     */
    public void warn(Object message, Throwable t) {
        delegate.warn(message, t);
    }

    /* (non-Javadoc)
     * @see ca.uhn.log.HapiLog#debug(java.lang.String, java.lang.Object[], java.lang.Throwable)
     */
    public void debug(String msgPattern, Object[] values, Throwable t) {
        String message = MessageFormat.format( msgPattern, values );
        delegate.debug( message, t);
    }
    
}
