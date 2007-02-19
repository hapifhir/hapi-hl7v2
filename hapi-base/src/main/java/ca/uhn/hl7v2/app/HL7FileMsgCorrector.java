/*
 * Created on Apr 14, 2005
 * HL7FileMsgCorrector.java
 * 
 */
package ca.uhn.hl7v2.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This is an application that will perform specific translations on the
 * hl7 messages stored within a flat file.  It will output the new messages to 
 * "./correctedMessageFile.txt"  
 * 
 * @author <a href="mailto:neal.acharya@uhn.on.ca">Neal Acharya</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:37 $ by $Author: jamesagnew $
 */
public class HL7FileMsgCorrector {
    
    private static final Log ourLog =  LogFactory.getLog(HL7FileMsgCorrector.class);

    /**
     * 
     */
    public HL7FileMsgCorrector() {
        super();
        // TODO Auto-generated constructor stub
    }


    public static void main(String[] args) {
        
        //NOTE, depending on the size of the flat file you may need to increase the stack
        //and heap size of the JVM when running this class.
        //If so then use the following VM args -Xmx512m -Xms512m -Xss2m
        
        String fileName = "./QueuedRoutStatOrders.dat";
        InputStream inputStream = HL7FileMsgCorrector.class.getClassLoader().getResourceAsStream(fileName);
              
        try {
            BufferedReader reader = new BufferedReader( new InputStreamReader( inputStream  ) );  
            BufferedWriter writer = new BufferedWriter(new FileWriter("./correctedMessageFile.txt"));
            
            String lineRead = null;
            StringBuffer buf = new StringBuffer();
            while ((lineRead = reader.readLine()) != null) {                
                buf.append(lineRead);
                buf.append("\r");
            }
            String fileString = buf.toString().trim();
            
            //Perform a translation
            String newFileString = addPreMshCarriageReturns(fileString);
            
            //write the string to a file
            writer.write(newFileString);            
            writer.close();
            ourLog.info("file conversion completed");
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       
        
    }


    /**
     * @param theFileString ..
     * @return ...
     * Adds two carriage returns before each MSH segment
     * we expect the file to be used by the HL7ServerTestHelper         
     */
    private static String addPreMshCarriageReturns(String theFileString) {
        theFileString = theFileString.replaceAll(".MSH\\|", "\rMSH|");
        theFileString = theFileString.replaceAll("MSH\\|", "\rMSH|");
        theFileString = theFileString.replaceAll("//", "");
        return theFileString;
    }
}
