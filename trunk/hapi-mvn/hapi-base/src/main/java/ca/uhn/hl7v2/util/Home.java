package ca.uhn.hl7v2.util;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Used to access the hapi.home system property.  Note that the property 
 * is only checked (at most) once per session.  
 * @author Bryan Tripp
 */
public class Home {
    
    private static File home;
    private static Logger log = LoggerFactory.getLogger(Home.class);
    
    /** Creates a new instance of Home */
    public Home() {
    }
    
    /**
     * Returns a File object corresponding to the directory specified in 
     * the system property hapi.home.  The property is only checked the 
     * first time this method is called, so changes will not take place 
     * until a new VM is started.  
     * This method is guaranteed to return a directory.  If hapi.home is 
     * not set, or is set to a non-directory path, the current working directory will 
     * be used.  
     */
    public static File getHomeDirectory() {
        if (home == null) 
            setHomeDirectory();
        
        return home;
    }
    
    private synchronized static void setHomeDirectory() {
        String dir = System.getProperty("hapi.home", ".");
        home = new File(dir);
        
        if (!home.isDirectory()) {
            home = new File("."); 
            log.warn("The system property hapi.home is not a valid directory: {}.  Using . instead", dir);
        }
         
        log.info("hapi.home is set to " + home.getAbsolutePath());
    }
    
    public static void main(String args[]) {
        System.out.println("HOME: " + getHomeDirectory().getAbsolutePath());
    }
        
}
