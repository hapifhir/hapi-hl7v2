/*
 * Created on 19-Apr-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.util.Terser;

/**
 * A utility for getting a list of fields from a <code>Message</code>, 
 * e.g. for inclusion in a <code>Transportable</code>. 
 *  
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:26 $ by $Author: jamesagnew $
 */
public class MetadataExtractor {

    /**
     * @param theMessage a message from which to extract fields
     * @param theTerserPaths a list of paths to desired fields, in the 
     *      form required by <code>Terser</code>.  
     * @return a Map from Terser paths to field values 
     */
    public static Map<String, String> getFields(Message theMessage, List<String> theTerserPaths) throws HL7Exception {
        Map<String, String> fields = new HashMap<String, String>();
        Terser terser = new Terser(theMessage);
        for (int i = 0; i < theTerserPaths.size(); i++) {
            String path = theTerserPaths.get(i);
            String fieldValue = terser.get(path);
            fields.put(path, fieldValue);
        }
        return fields;
    }

}
