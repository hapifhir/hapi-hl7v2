/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "Log.java".  Description: 
"Manages the logging of exceptions and status information" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the "GPL"), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL. 

*/

package ca.uhn.hl7v2;

/**
 * <p>Manages the logging of exceptions and status information.<p>  
 * <p>To select a particular implementation with which to log, set the system property
 * <code>ca.on.uhn.hl7.log</code> to the fully qualified class name of a subclass 
 * of Log before getInstance() is first called.  If this property is not set, the 
 * default FileLog is used with the log files "hl7_exceptions_<name>_<date>.log" and "hl7_status_<name>_<date>.log" in  
 * the working directory.</p>  
 * <p>The logs entries arising from a particular VM can be named, to distinguish them from 
 * log entries from other VMs.  To do this, set the system property "ca.uhn.hl7v2.log.name" to something 
 * descriptive.<p>
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 * 
 * @deprecated MUST USE jakarta-commons-logging
 */
public abstract class Log {

    private static Log log;
    
    /**
     * <p>Returns the singleton instance of Log.  The Log returned will be an instance of a 
     * subclass that uses a specific means of logging (e.g. logging to a particular text 
     * file or database).  </p>
     * @exception LogException there is a problem opening the Log or the subclass 
     *      specified can not be found or is not in fact a subclass of Log.  
     */
    public static synchronized Log getInstance() throws LogException {
        if (log == null) {
            String logClass = System.getProperty("ca.on.uhn.hl7.log");
            if (logClass == null) {
                log = new FileLog();
            } else {
                try {
                    log = (Log)Class.forName(logClass).newInstance();
                } catch (ClassNotFoundException ce) {
                    throw new LogException("Can't initialize HL7 Log - can't find the Log subclass " + 
                        logClass + ".");
                } catch (ClassCastException cce) {
                    throw new LogException("Can't initialize HL7 Log - the specified log class - " + 
                        logClass + " - does not extend ca.on.uhn.hl7.Log");
                } catch (Exception e) {
                    throw new LogException("Can't initialize HL7 log of class " + 
                        logClass + ": " + e.getClass().getName() + ": " + e.getMessage());
                }
            }
        }
        return log;
        
    }

  
    /**
     * Convenience method for logging exceptions - if a LogException 
     * is thrown while logging, the original exception is written to std out 
     * and no exception is thrown by this method.  
     */
    public static void tryToLog(Exception e, String message) {
        try {
            Log.getInstance().log(e, message);
        } catch (Exception loge) {
            loge.printStackTrace();
            System.err.println("\r\n\r\n------------------\r\nCan't write to exception log - writing to standard out ..." + message); 
            e.printStackTrace();
            System.err.println("-----------------\r\n\r\n");
            
        }
    }
    
    /**
     * Logs an Exception. 
     * @exception LogException if there is an error writing to the log.  
     */
    public abstract void log(Exception e, String message) throws LogException;
    
    /**
     * Logs a status message. 
     * @exception LogException if there is an error writing to the log.  
     */
    public abstract void log(String status) throws LogException;
    
    /**
     * Returns a description of where logged data are being stored.  Implementing 
     * classes should return sufficient text to allow a human who reads this message 
     * to independently view information in the log (e.g. the file name, password for the 
     * database, etc.).  
     */
    public abstract String getDescription();
    
    //test
    public static void main(String args[]) {
        try { 
            throw new LogException("this is a test message");
        } catch (Exception e) {
            try {
                Log.getInstance().log(e, "thing message");
            } catch (LogException le) {
                e.printStackTrace();
            }
        }
        try { 
            throw new LogException("this is a test message");
        } catch (Exception e) {
            try {
                Log.getInstance().log(e, "");
            } catch (LogException le) {
                e.printStackTrace();
            }
        }
        try { 
            throw new LogException("this is a test message");
        } catch (Exception e) {
            try {
                Log.getInstance().log(e, "");
            } catch (LogException le) {
                e.printStackTrace();
            }
        }
        try { 
            Log.getInstance().log("status 1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try { 
            Log.getInstance().log("status 2");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
