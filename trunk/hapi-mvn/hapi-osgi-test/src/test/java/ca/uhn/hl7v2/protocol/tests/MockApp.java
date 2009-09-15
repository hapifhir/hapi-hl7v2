/*
 * Created on 25-May-2004
 */
package ca.uhn.hl7v2.protocol.tests;

import java.io.IOException;
import java.util.Map;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.app.DefaultApplication;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import ca.uhn.hl7v2.util.Terser;

/**
 * Mock <code>Application</code> that returns default messages.  
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:19 $ by $Author: jamesagnew $
 */
public class MockApp implements ReceivingApplication {

    /** 
     * Returns a default message.  
     * @see ca.uhn.hl7v2.app.Application#processMessage(ca.uhn.hl7v2.model.tests.Message)
     */
    public Message processMessage(Message in, Map theMetadata) throws ReceivingApplicationException, HL7Exception {
        Message response = null;
        try {
            response = DefaultApplication.makeACK((Segment) in.get("MSH"));
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
     * @see ca.uhn.hl7v2.app.Application#canProcess(ca.uhn.hl7v2.model.tests.Message)
     */
    public boolean canProcess(Message in) {
        return true;
    }

}
