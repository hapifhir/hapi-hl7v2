/*
 * Created on 28-Apr-2004
 */
package ca.uhn.hl7v2.preparser;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.parser.EncodingDetector;
import ca.uhn.hl7v2.util.Terser;

/**
 * <p>Extracts specified fields from unparsed messages.  This class is a 
 * facade for the ER7 and XML classes.  Use it like this: </p>
 * 
 * <code>
 * String message = null; //... your ER7 or XML message string goes here
 * String[] fieldSpecs = {"MSH-9-1", "MSH-9-2", "MSH-12"};
 * String[] fields = PreParser.getFields(message, fieldSpecs);
 * </code>
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:37 $ by $Author: jamesagnew $
 */
public class PreParser {

    /**
     * Extracts selected fields from a message.  
     *   
     * @param theMessageText an unparsed message from which to get fields 
     * @param thePathSpecs Terser-like paths to fields in the message.  See documentation
     *      for Terser.  These paths are identical except that they start with the segment
     *      name (search flags and group names are to be omitted as they are not relevant 
     *      with unparsed ER7 messages).  
     * @return field values corresponding to the given paths
     * @throws HL7Exception
     */
    public static String[] getFields(String theMessageText, String... thePathSpecs) throws HL7Exception {
        DatumPath[] paths = new DatumPath[thePathSpecs.length];
        for (int i = 0; i < thePathSpecs.length; i++) {
            StringTokenizer tok = new StringTokenizer(thePathSpecs[i], "-", false);
            String segSpec = tok.nextToken();
            tok = new StringTokenizer(segSpec, "()", false);
            String segName = tok.nextToken();
            if (segName.length() != 3) {
                throw new HL7Exception("In field path, " + segName + " is not a valid segment name");
            }
            int segRep = 0;
            if (tok.hasMoreTokens()) {
                String rep = tok.nextToken();
                try {
                    segRep = Integer.parseInt(rep);
                } catch (NumberFormatException e) {
                    throw new HL7Exception("In field path, segment rep" + rep + " is not valid", e);
                }
            }
            
            int[] indices = Terser.getIndices(thePathSpecs[i]);
            paths[i] = new DatumPath();
            paths[i].add(segName).add(segRep);
            paths[i].add(indices[0]).add(indices[1]).add(indices[2]).add(indices[3]);
            
        }
        return getFields(theMessageText, paths);
    }
    
    /** 
     * Gets selected fields from a message, as with String[] arg version but 
     * using DatumPaths. 
     */     
    private static String[] getFields(String theMessageText, DatumPath[] thePaths) throws HL7Exception {
        String[] fields = new String[thePaths.length];
        Properties props = new Properties();
        
        List<DatumPath> mask = Arrays.asList(thePaths);

        boolean OK = false;
        if (EncodingDetector.isEr7Encoded(theMessageText)) {
            OK = ER7.parseMessage(props, mask, theMessageText);
        } else if (EncodingDetector.isXmlEncoded(theMessageText)) {
            OK = XML.parseMessage(props, theMessageText, null);
        } else {
            throw new HL7Exception("Message encoding is not recognized"); 
        }
        
        if (!OK) {
            throw new HL7Exception("Parse failed");
        }
        
        for (int i = 0; i < fields.length; i++) {
            fields[i] = props.getProperty(thePaths[i].toString());
        }
        return fields;
    }    

}
