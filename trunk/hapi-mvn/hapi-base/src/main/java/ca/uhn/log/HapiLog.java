/*
 * HapiLog.java
 * 
 * Created on May 7, 2003 at 3:53:44 PM
 */
package ca.uhn.log;

import org.slf4j.Logger;

/**
 * 
 * Instantiate using {@link HapiLogFactory#getLog( Class clazz)}
 * or {@link HapiLogFactory#getLog( String name)}
 * 
 * <pre>
 *  USASE PATTERN:
 *  (look at the jakarta-commons-logging and log4j documentation first)
 * 
 *      ...
 *      import ca.uhn.log.*;
 *      ...
 *      class A {
 *          private static final HapiLog log = HapiLogFactory.getHapiLog( A.class );
 * 
 *          public boolean methodA( Object param1 ) {
 *              boolean retVal = true;
 * 
 *              //log debug messages (to be printed only when the debug mode is specified
 *              //in the configuration file)
 *              log.debug( "param1 = " + param1 );
 *              
 *              Object copy = null;
 *              try {
 *                  copy = param1.clone();
 *              }
 *              catch( CloneNotSupportedException e ) {
 *                  //log the error
 *                  log.error( "param1 must be cloneable", e );
 *                  retVal = false;
 *              }
 * 
 *              log.debug( "retVal = " + retVal );
 *              return retVal;
 *          }
 * 
 *          ...
 * 
 *      }
 * </pre>
 * 
 * @author <a href="mailto:alexei.guevara@uhn.on.ca">Alexei Guevara</a>
 * @deprecated use slf4j Logger directly
 */
public interface HapiLog extends Logger {

	/**
	 * @deprecated not available in sl4j. Use {@link #error(String, Throwable)}
	 */
	void error(Exception e);

}
