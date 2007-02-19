package ca.uhn.hl7v2.util;

import java.io.*;
import java.util.GregorianCalendar;
import java.util.Date;

/**
 * <p>Handles output of status messages.  Authors are encouraged to provide status 
 * information using the methods: </p>
 * <p><code>writeStatus(String message);<br>
 * writeVerboseStatus(String message);</code></p>
 * <p>... instead of using <code>System.out.println(...)</code>.  This allows the user
 * to control the output of status messages in one place. </p>
 * <p>By default, messages are written to std out, and only "standard" messages are 
 * written (i.e. from calls to <code>writeStatus()</code>, not <code>writeVerboseStatus()</code>).
 * This can be changed at startup by setting the following system properties: </p>
 * <p>ca.uhn.hl7v2.util.status.out = ["STANDARD_OUT" | "FILE"]<br>
 * ca.uhn.hl7v2.util.status.level = ["NONE" | "STANDARD" | "VERBOSE"]</p>
 * <p>If a programmer wishes to log status messages more reliably and without user control, (s)he
 * should use <code>ca.uhn.hl7v2.Log</code> instead.</p>
 *
 * @deprecated use ca.uhn.log package
 * @author Bryan Tripp
 * 
 */
public class Status {
    
    private int dest = 0;
    private int detail = 0;
    private BufferedWriter fileOut;
    
    private static Status singleton = null;

    /**
     * Used as an argument to setOutput(), causes status information to be printed 
     * to standard out.
     */
    public static final int STANDARD_OUT = 1;
    
    /**
     * Used as an argument to setOutput(), causes status information to be printed 
     * to the file "status.log" in the working directory. 
     */
    public static final int FILE = 2;
    
    /**
     * Used as an argument to setVerbosity(), causes no status information to 
     * be output.  
     */
    public static final int NONE = 3;
    
    /**
     * Used as an argument to setVerbosity(), causes standard status information to 
     * be output.  
     */
    public static final int STANDARD = 4;
    
    /**
     * Used as an argument to setVerbosity(), causes detailed status information to 
     * be output.  
     */
    public static final int VERBOSE = 5;
    
    /** 
     * Creates a new instance of Status 
     */
    private Status() {
        //check system properties for configuration info
        String out = System.getProperty("ca.uhn.hl7v2.util.status.out");
        String level = System.getProperty("ca.uhn.hl7v2.util.status.level");
        
        if (out != null && out.equals("FILE")) {
            setOutput(Status.FILE);
        } else {
            setOutput(Status.STANDARD_OUT);
        }
        
        if (level != null && level.equals("NONE")) {
            setVerbosity(Status.NONE);
        } else if (level != null && level.equals("VERBOSE")) {
            setVerbosity(Status.VERBOSE);
        } else {
            setVerbosity(Status.STANDARD);
        }
    }
    
    /** 
     * Sets the location where status messages are output.  Valid values include 
     * Status.STANDARD_OUT (std out) and Status.FILE (messages output to <hapi.home>/status.log)
     */
    public synchronized void setOutput(int destination) {
        if (destination == Status.STANDARD_OUT || destination == Status.FILE) {
            this.dest = destination;
            if (dest == Status.STANDARD_OUT) {
                System.out.println("Outputting status messages to standard out.");
            } else {
                String file = Home.getHomeDirectory().getAbsolutePath() + "/status.log";
                System.out.println("Outputting status messages to the file " + file);
                try {
                    this.fileOut = new BufferedWriter(new FileWriter(file, true));
                } catch (IOException e) {
                    System.err.println("Couldn't open file status.log for status output - using std out instead.");
                    this.dest = Status.STANDARD_OUT;
                }
            }
        }
    }
    
    /**
     * Sets the level of detail of status messages.  Valid values include 
     * Status.NONE, Status.STANDARD, and Status.VERBOSE (detailed).
     */
    public synchronized void setVerbosity(int level) {
        if (level == Status.NONE || level == Status.STANDARD || level == Status.VERBOSE) {
            this.detail = level;
            if (detail == Status.NONE) {
                System.out.println("ca.uhn.hl7v2.util.Status: No status messages will be output.");
            } else if (detail == Status.STANDARD) {
                System.out.println("ca.uhn.hl7v2.util.Status: Standard status messages will be output.");
            } else { 
                System.out.println("ca.uhn.hl7v2.util.Status: Verbose status messages will be output.");
            }
        }
    }

    /** 
     * Outputs a standard status message as per configuration. 
     */
    public static void writeStatus(String message) {
        if (singleton == null) {
            //initialize instance
            singleton = new Status();
        }
     
        singleton.writeStatus(message, false);
    }
    
    /** 
     * Outputs a detail status message as per configuration. 
     */
    public static void writeVerboseStatus(String message) {
        if (singleton == null) {
            //initialize instance
            singleton = new Status();
        }
     
        singleton.writeStatus(message, true);        
    }
    
    /**
     * Should be called only through static method of same name.
     */
    private synchronized void writeStatus(String message, boolean verbose) {
        boolean output = true;
        if (this.detail == Status.NONE || (verbose && this.detail != Status.VERBOSE)) output = false;
        
        GregorianCalendar now = new GregorianCalendar();
        now.setTime(new Date());
        StringBuffer mess = new StringBuffer();
        mess.append(now.get(GregorianCalendar.DAY_OF_MONTH));
        mess.append("/");
        mess.append(now.get(GregorianCalendar.MONTH + 1));
        mess.append("/");
        mess.append(now.get(GregorianCalendar.YEAR));
        mess.append(" ");
        mess.append(now.get(GregorianCalendar.HOUR_OF_DAY));
        mess.append(":");
        mess.append(now.get(GregorianCalendar.MINUTE));
        mess.append(":");
        mess.append(now.get(GregorianCalendar.SECOND));
        mess.append(".");
        mess.append(now.get(GregorianCalendar.MILLISECOND));
        mess.append("  ");
        mess.append(message);
        
        if (output) {
            if (this.dest == Status.STANDARD_OUT) {
                System.out.println(mess.toString());
            } else {
                try {
                    this.fileOut.write(mess.toString());
                    this.fileOut.write("\r\n");
                    this.fileOut.flush();
                } catch (IOException e) {
                    System.err.println("Error writing status message to file: " + e.getMessage());
                    System.out.println(mess.toString());
                }
            }
        }
    }
}
