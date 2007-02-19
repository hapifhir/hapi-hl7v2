/*
 * Created on 21-Apr-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.log.HapiLog;
import ca.uhn.log.HapiLogFactory;

/**
 * A debugging utility that logs raw messages and parsed/encoded versions, and warnings about 
 * apparent discrepancies between them.  This information is all logged to HapiLog under 
 * the name of this class, at the "info" level.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class ParseChecker {

    private static final HapiLog log = HapiLogFactory.getHapiLog(ParseChecker.class);

    /**
     * Encodes the given message and compares it to the given string.  Any differences
     * are noted in the file [hapi.home]/parse_check.txt.  Ignores extra field delimiters.
     */
    public static void checkParse(String originalMessageText, Message parsedMessage, Parser parser)
            throws HL7Exception, IOException {
        log.info("ParseChecker is checking parse integrity (turn this off if you are not testing)");
        String newMessageText = parser.encode(parsedMessage);
        
        log.info("******************* Comparing Messages ****************\r\n");
        log.info("Original:           " + originalMessageText + "\r\n");
        log.info("Parsed and Encoded: " + newMessageText + "\r\n");
        
        if (!originalMessageText.equals(newMessageText)) {
            //check each segment
            StringTokenizer tok = new StringTokenizer(originalMessageText, "\r");
            ArrayList one = new ArrayList();
            while (tok.hasMoreTokens()) {
                String seg = tok.nextToken();
                if (seg.length() > 4)
                    one.add(seg);
            }
            tok = new StringTokenizer(newMessageText, "\r");
            ArrayList two = new ArrayList();
            while (tok.hasMoreTokens()) {
                String seg = tok.nextToken();
                if (seg.length() > 4)
                    two.add(stripExtraDelimiters(seg, seg.charAt(3)));
            }
            
            if (one.size() != two.size()) {
                log.info("Warning: inbound and parsed messages have different numbers of segments: \r\n");
                log.info("Original: " + originalMessageText + "\r\n");
                log.info("Parsed:   " + newMessageText + "\r\n");
            }
            else {
                //check each segment
                for (int i = 0; i < one.size(); i++) {
                    String origSeg = (String) one.get(i);
                    String newSeg = (String) two.get(i);
                    if (!origSeg.equals(newSeg)) {
                        log.info("Warning: inbound and parsed message segment differs: \r\n");
                        log.info("Original: " + origSeg + "\r\n");
                        log.info("Parsed: " + newSeg + "\r\n");
                    }
                }
            }
        }
        else {
            log.info("No differences found\r\n");
        }
        
        log.info("********************  End Comparison  ******************\r\n");
        
    }
    
    /**
     * Removes unecessary delimiters from the end of a field or segment.
     * This is cut-and-pasted from PipeParser (just making it public in
     * PipeParser would kind of cloud the purpose of PipeParser).
     */
    private static String stripExtraDelimiters(String in, char delim) {
        char[] chars = in.toCharArray();
        
        //search from back end for first occurance of non-delimiter ...
        int c = chars.length - 1;
        boolean found = false;
        while (c >= 0 && !found) {
            if (chars[c--] != delim)
                found = true;
        }
        
        String ret = "";
        if (found)
            ret = String.valueOf(chars, 0, c + 2);
        return ret;
    }
    
    
}
