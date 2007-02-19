package ca.uhn.hl7v2.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * Loads system properties from a file.  This is intended as a convenient way 
 * of setting multiple system properties. 
 */
public class PropertyLoader {
    
    private static final HapiLog log = HapiLogFactory.getHapiLog(PropertyLoader.class);
    private static HashSet files = new HashSet();
    
    private PropertyLoader() {
    }
    
    /**
     * Calls <code>loadProperties()</code> if it has not been called before for
     * the given file.  If the given property file has already been loaded, this
     * method does nothing.
     */
    public static void loadOnce(String propertyFileName) throws IOException {
        if (!files.contains(propertyFileName)) {
            loadProperties(propertyFileName);
            files.add(propertyFileName);
        }
    }
    
    /**
     * Reads given "property file" and sets system properties accordingly.  In the property file,
     * there should be one property per line.  A line should consist of 1) the fully qualified property name,
     * 2) one or more tabs, and 3) the value (everything after the first group of tabs and before any subsequent
     * groups will be considered "the value").
     * Lines in the file are consdidered comments if they begin with "%".
     */
    public static void loadProperties(String propertyFileName) throws IOException {
        
        //open stream from given property file
        BufferedReader in = null;
        in = new BufferedReader(new FileReader(propertyFileName));
        
        String line, key, value, delim = "\t";
        StringTokenizer tok;
        while ((line = in.readLine()) != null) {
            //ignore comments
            if (!line.startsWith("%")) {
                key = null; value = null;
                
                //get property key and value
                tok = new StringTokenizer(line, delim, false);
                if (tok.hasMoreTokens()) key = tok.nextToken();
                if (tok.hasMoreTokens()) value = tok.nextToken();
                
                //set property
                if (key != null && value != null) {
                    System.setProperty(key, value);
                    log.debug("Setting system property " + key + " to " + value);
                }
            }
        }
        in.close();
    }
    
    /** Test harness */
    public static void main(String args[]) {
        if (args.length != 1) {
            System.out.println("Usage: PropertyLoader file");
            System.exit(1);
        }
        
        try {
            System.setProperty("ca.uhn.hl7v2.util.status.level", "VERBOSE");
            System.out.println("Loading properties in file " + args[0]);
            loadOnce(args[0]);
            System.out.println("Loading properties in file " + args[0] + " again");
            loadOnce(args[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Properties p = System.getProperties();
        Enumeration en = p.propertyNames();
        while (en.hasMoreElements()) {
            String key = (String) en.nextElement();
            System.out.println("Property: " + key + " Value: " + System.getProperty(key));
        }
    }
}