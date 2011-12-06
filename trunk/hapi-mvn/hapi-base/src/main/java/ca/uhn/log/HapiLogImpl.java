/*
 * HapiLog.java
 * 
 * Created on May 7, 2003 at 2:23:45 PM
 */
package ca.uhn.log;

import org.slf4j.Logger;
import org.slf4j.Marker;

/**
 * Provides a base implementation of the <code>HapiLog</code> interface.
 * 
 * It delegates all method calls declared by <code>Log</code> to the delegate specified in
 * the contructor.
 * 
 * @author <a href="mailto:alexei.guevara@uhn.on.ca">Alexei Guevara</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:52 $ by $Author: jamesagnew $
 * @deprecated use slf4j logger class
 */
public class HapiLogImpl implements HapiLog {
    
    HapiLogImpl( Logger delegate ) {
        this.delegate = delegate;
    }
    
	/** 
	 * @deprecated Not available in slf4j. Use e.g. {@link #error(String, Throwable)} instead
	 */
	public void error(Exception e) {
		delegate.error(e.getMessage(), e);
	}
    
    public String getName() {
		return delegate.getName();
	}

	public boolean isTraceEnabled() {
		return delegate.isTraceEnabled();
	}

	public void trace(String msg) {
		delegate.trace(msg);
	}

	public void trace(String format, Object arg) {
		delegate.trace(format, arg);
	}

	public void trace(String format, Object arg1, Object arg2) {
		delegate.trace(format, arg1, arg2);
	}

	public void trace(String format, Object[] argArray) {
		delegate.trace(format, argArray);
	}

	public void trace(String msg, Throwable t) {
		delegate.trace(msg, t);
	}

	public boolean isTraceEnabled(Marker marker) {
		return delegate.isTraceEnabled(marker);
	}

	public void trace(Marker marker, String msg) {
		delegate.trace(marker, msg);
	}

	public void trace(Marker marker, String format, Object arg) {
		delegate.trace(marker, format, arg);
	}

	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		delegate.trace(marker, format, arg1, arg2);
	}

	public void trace(Marker marker, String format, Object[] argArray) {
		delegate.trace(marker, format, argArray);
	}

	public void trace(Marker marker, String msg, Throwable t) {
		delegate.trace(marker, msg, t);
	}

	public boolean isDebugEnabled() {
		return delegate.isDebugEnabled();
	}

	public void debug(String msg) {
		delegate.debug(msg);
	}

	public void debug(String format, Object arg) {
		delegate.debug(format, arg);
	}

	public void debug(String format, Object arg1, Object arg2) {
		delegate.debug(format, arg1, arg2);
	}

	public void debug(String format, Object[] argArray) {
		delegate.debug(format, argArray);
	}

	public void debug(String msg, Throwable t) {
		delegate.debug(msg, t);
	}

	public boolean isDebugEnabled(Marker marker) {
		return delegate.isDebugEnabled(marker);
	}

	public void debug(Marker marker, String msg) {
		delegate.debug(marker, msg);
	}

	public void debug(Marker marker, String format, Object arg) {
		delegate.debug(marker, format, arg);
	}

	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		delegate.debug(marker, format, arg1, arg2);
	}

	public void debug(Marker marker, String format, Object[] argArray) {
		delegate.debug(marker, format, argArray);
	}

	public void debug(Marker marker, String msg, Throwable t) {
		delegate.debug(marker, msg, t);
	}

	public boolean isInfoEnabled() {
		return delegate.isInfoEnabled();
	}

	public void info(String msg) {
		delegate.info(msg);
	}

	public void info(String format, Object arg) {
		delegate.info(format, arg);
	}

	public void info(String format, Object arg1, Object arg2) {
		delegate.info(format, arg1, arg2);
	}

	public void info(String format, Object[] argArray) {
		delegate.info(format, argArray);
	}

	public void info(String msg, Throwable t) {
		delegate.info(msg, t);
	}

	public boolean isInfoEnabled(Marker marker) {
		return delegate.isInfoEnabled(marker);
	}

	public void info(Marker marker, String msg) {
		delegate.info(marker, msg);
	}

	public void info(Marker marker, String format, Object arg) {
		delegate.info(marker, format, arg);
	}

	public void info(Marker marker, String format, Object arg1, Object arg2) {
		delegate.info(marker, format, arg1, arg2);
	}

	public void info(Marker marker, String format, Object[] argArray) {
		delegate.info(marker, format, argArray);
	}

	public void info(Marker marker, String msg, Throwable t) {
		delegate.info(marker, msg, t);
	}

	public boolean isWarnEnabled() {
		return delegate.isWarnEnabled();
	}

	public void warn(String msg) {
		delegate.warn(msg);
	}

	public void warn(String format, Object arg) {
		delegate.warn(format, arg);
	}

	public void warn(String format, Object[] argArray) {
		delegate.warn(format, argArray);
	}

	public void warn(String format, Object arg1, Object arg2) {
		delegate.warn(format, arg1, arg2);
	}

	public void warn(String msg, Throwable t) {
		delegate.warn(msg, t);
	}

	public boolean isWarnEnabled(Marker marker) {
		return delegate.isWarnEnabled(marker);
	}

	public void warn(Marker marker, String msg) {
		delegate.warn(marker, msg);
	}

	public void warn(Marker marker, String format, Object arg) {
		delegate.warn(marker, format, arg);
	}

	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		delegate.warn(marker, format, arg1, arg2);
	}

	public void warn(Marker marker, String format, Object[] argArray) {
		delegate.warn(marker, format, argArray);
	}

	public void warn(Marker marker, String msg, Throwable t) {
		delegate.warn(marker, msg, t);
	}

	public boolean isErrorEnabled() {
		return delegate.isErrorEnabled();
	}
	
	public void error(String msg) {
		delegate.error(msg);
	}

	public void error(String format, Object arg) {
		delegate.error(format, arg);
	}

	public void error(String format, Object arg1, Object arg2) {
		delegate.error(format, arg1, arg2);
	}

	public void error(String format, Object[] argArray) {
		delegate.error(format, argArray);
	}

	public void error(String msg, Throwable t) {
		delegate.error(msg, t);
	}

	public boolean isErrorEnabled(Marker marker) {
		return delegate.isErrorEnabled(marker);
	}

	public void error(Marker marker, String msg) {
		delegate.error(marker, msg);
	}

	public void error(Marker marker, String format, Object arg) {
		delegate.error(marker, format, arg);
	}

	public void error(Marker marker, String format, Object arg1, Object arg2) {
		delegate.error(marker, format, arg1, arg2);
	}

	public void error(Marker marker, String format, Object[] argArray) {
		delegate.error(marker, format, argArray);
	}

	public void error(Marker marker, String msg, Throwable t) {
		delegate.error(marker, msg, t);
	}

	private final Logger delegate;
    

    
}
