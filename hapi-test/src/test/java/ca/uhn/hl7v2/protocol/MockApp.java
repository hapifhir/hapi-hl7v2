/*
 * Created on 25-May-2004
 */
package ca.uhn.hl7v2.protocol;

import java.io.IOException;
import java.util.Map;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.util.Terser;

/**
 * Mock <code>Application</code> that returns default messages.  
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:38 $ by $Author: jamesagnew $
 */
public class MockApp implements ReceivingApplication<Message> {

    /** 
     * Returns a default message.  
     * @see ca.uhn.hl7v2.app.Application#processMessage(ca.uhn.hl7v2.model.Message)
     */
    public Message processMessage(Message in, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {
        Message response = null;
        try {
            response = in.generateACK();
        } catch (HL7Exception e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Terser t = new Terser(response);
        t.set("MSA-3", "this is a mock application response");
        return response;
    }

    /** 
     * Returns true. 
     * @see ca.uhn.hl7v2.app.Application#canProcess(ca.uhn.hl7v2.model.Message)
     */
    public boolean canProcess(Message in) {
        return true;
    }

}
