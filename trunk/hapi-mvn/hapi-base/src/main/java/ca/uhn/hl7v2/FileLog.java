/**
The contents of this file are subject to the Mozilla Public License Version 1.1 
(the "License"); you may not use this file except in compliance with the License. 
You may obtain a copy of the License at http://www.mozilla.org/MPL/ 
Software distributed under the License is distributed on an "AS IS" basis, 
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the 
specific language governing rights and limitations under the License. 

The Original Code is "FileLog.java".  Description: 
"An implementation of Log that writes log data to files" 

The Initial Developer of the Original Code is University Health Network. Copyright (C) 
2001.  All Rights Reserved. 

Contributor(s): ______________________________________. 

Alternatively, the contents of this file may be used under the terms of the 
GNU General Public License (the  “GPL”), in which case the provisions of the GPL are 
applicable instead of those above.  If you wish to allow use of your version of this 
file only under the terms of the GPL and not to allow others to use your version 
of this file under the MPL, indicate your decision by deleting  the provisions above 
and replace  them with the notice and other provisions required by the GPL License.  
If you do not delete the provisions above, a recipient may use your version of 
this file under either the MPL or the GPL.

*/

package ca.uhn.hl7v2;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.StringWriter;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.util.GregorianCalendar;
import java.util.Calendar;
import ca.uhn.hl7v2.util.Status;

/**
 * An implementation of Log that writes log data to files.  
 * @author Bryan Tripp (bryan_tripp@sourceforge.net)
 * 
 * @deprecated MUST USE jakarta-commons-logging 
 */
public class FileLog extends Log {

    BufferedWriter exceptionWriter;  
    BufferedWriter statusWriter;
    int currentDay = -1;
    private String prefix;
    
    /** 
     * Creates new FileLog. 
     * @exception LogException if one of the log files can not be opened.  
     */
    protected FileLog() throws LogException {
        openLogs();
    }
    
    /**
     * Sets the exceptionWriter and statusWriter to point to the appropriate log files, based on 
     * the VM-specific log name found in the property ca.uhn.hl7v2.log.name, and the current date. 
     */
    private void openLogs() throws LogException {
        prefix = System.getProperty("ca.uhn.hl7v2.log.name");
        if (prefix == null || prefix.equals("")) {  //use default
            prefix = "hl7";
        }
        
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date(System.currentTimeMillis()));
        this.currentDay = cal.get(Calendar.DAY_OF_MONTH);
        String date = DateFormat.getDateInstance(DateFormat.MEDIUM).format(cal.getTime());
        Status.writeStatus("Setting current log date to " + date);

        String exceptionLogFileName = prefix + "_exception_" + date + ".log";
        String statusLogFileName = prefix + "_status_" + date + ".log";
        
        //try to open writers to the log files
        try { 
            exceptionWriter = new BufferedWriter(new FileWriter(exceptionLogFileName, true));
        } catch (IOException ioe) {
            throw new LogException("Can't open writer to exception log file " + exceptionLogFileName);
        } 
        try { 
            statusWriter = new BufferedWriter(new FileWriter(statusLogFileName, true));
        } catch (IOException ioe) {
            throw new LogException("Can't open writer to status log file " + statusLogFileName);
        }                     
    }
    
    /**
     * If the current day of the month doesn't match the day of the month of the log files, 
     * openLogs() is called so that new log files can be opened for today. 
     */
    private void maybeNewFile() throws LogException {
       GregorianCalendar cal = new GregorianCalendar();
       cal.setTime(new Date(System.currentTimeMillis()));
       
       if (cal.get(Calendar.DAY_OF_MONTH) != this.currentDay) {
           openLogs();
       }
    }

    public synchronized void log(Exception e, String message) throws LogException {
        System.out.println("FileLog: logging exception");
        if (e == null) { 
            throw new LogException("Can't log null exception");
        }

        maybeNewFile();

        try {            
            exceptionWriter.write(getCurrentTime());
            exceptionWriter.write("\t");
            exceptionWriter.write(e.getClass().getName());
            exceptionWriter.write("\t");
            exceptionWriter.write((e.getMessage() == null) ? "" : e.getMessage());
            exceptionWriter.write("\t");
            if (message != null) exceptionWriter.write(message);
            exceptionWriter.write("\r\n");

            StringWriter stackTraceWriter = new StringWriter();
            e.printStackTrace(new PrintWriter(stackTraceWriter));
            exceptionWriter.write(stackTraceWriter.toString());
            
            exceptionWriter.write("\r\n");            
            exceptionWriter.flush();
        } catch (IOException ioe) {
            throw new LogException("Can't write to exception log: " + ioe.toString());
        }            
    }

    public synchronized void log(String status) throws LogException {
        maybeNewFile();
        
        try {
            statusWriter.write(getCurrentTime());
            statusWriter.write("\t");
            statusWriter.write(status);
            statusWriter.write("\r\n");
            statusWriter.flush();
        } catch (IOException ioe) {
            throw new LogException("Can't write to status log: " + ioe.getMessage());
        }
    }
    
    public String getDescription() {
        StringBuffer desc = new StringBuffer();
        desc.append("HL7 exceptions and status messages are being logged by a FileLog object.  ");
        desc.append("Exceptions are being logged to files beginning ./");
        desc.append(prefix);
        desc.append("_exceptions and status messages are being logged to files beginning ./");
        desc.append(prefix);
        desc.append("_status. ");
        return desc.toString();
    }
    
    private String getCurrentTime() {
        return DateFormat.getDateTimeInstance().format(new Date());
    }

}
