/*
 * Created on 19-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.protocol.AcceptValidator;
import ca.uhn.hl7v2.protocol.ProcessorContext;
import ca.uhn.hl7v2.protocol.SafeStorage;
import ca.uhn.hl7v2.protocol.Transportable;
import junit.framework.TestCase;

/**
 * Unit tests for <code>AcceptAcknowledger</code>. 
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
 */
public class AcceptAcknowledgerTest extends TestCase {

    private static String message = "MSH|^~\\&|||||||ADT^A01|b|P|2.4\rNTE|\r";
 
    /**
     * Constructor for AcceptAcknowledgerTest.
     * @param arg0
     */
    public AcceptAcknowledgerTest(String arg0) {
        super(arg0);
    }
    
    public void testValidateAccept() throws Exception {
        ProcessorContext context = new ProcessorContextImpl(null, null, new NullSafeStorage());
        context.addValidator(new MockValidator(true));
        
        AcceptAcknowledger.AcceptACK ack = 
            AcceptAcknowledger.validate(context, new TransportableImpl(message));
        assertEquals(true, ack.isAcceptable());
    }
    
    public void testValidateReject() throws Exception {
        ProcessorContext context = new ProcessorContextImpl(null, null, new NullSafeStorage());
        context.addValidator(new MockValidator(false));
        
        AcceptAcknowledger.AcceptACK ack = 
            AcceptAcknowledger.validate(context, new TransportableImpl(message));
        assertEquals(false, ack.isAcceptable());        
    }

    public void testValidateCantStore() throws Exception {
        ProcessorContext context = new ProcessorContextImpl(null, null, new BadStore());
        
        AcceptAcknowledger.AcceptACK ack = 
            AcceptAcknowledger.validate(context, new TransportableImpl(message));
        assertEquals(false, ack.isAcceptable());        
    }
    
    /**
     * Skeleton mock implementation of <code>AcceptValidator</code>. 
     * 
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
     */
    public class MockValidator implements AcceptValidator {
        
        private final boolean OK;
        
        public MockValidator(boolean everythingOK) {
            OK = everythingOK;
        }

        public AcceptRuling check(Transportable arg0) {
            return new AcceptRuling() {
                public boolean isAcceptable() {
                    return OK;
                }

                public String getAckCode() {
                    return null;
                }

                public int getErrorCode() {
                    return 0;
                }

                public String[] getReasons() {
                    return new String[0];
                }
            };
        }
    }

    /**
     * Mock store that throws an exception when an attempt is made to 
     * store something (for negative testing).  
     *  
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.1 $ updated on $Date: 2007-02-19 02:24:40 $ by $Author: jamesagnew $
     */    
    public class BadStore implements SafeStorage {

        /** 
         * Throws an exception. 
         */
        public void store(Transportable arg0) throws HL7Exception {
            throw new HL7Exception("This SafeStorage is meant to fail");            
        }

        public void discard(Transportable arg0) throws HL7Exception {
        }

        public Transportable[] restore() throws HL7Exception {
            return null;
        }
        
    }
}
