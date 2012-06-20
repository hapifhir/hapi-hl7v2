
package ca.uhn.hl7v2.model;

import java.util.Map;
import java.util.Properties;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Version;
import ca.uhn.hl7v2.model.v251.message.ACK;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.Parser;

/**
 * Tests all generated message structures to ensure that they can be instantiated
 * correctly
 */
public class MessageStructuresTest extends TestCase {

    private static Logger ourLog = LoggerFactory.getLogger(MessageStructuresTest.class);

    public void testAllMessages() throws Exception {

        for (Version nextVersion : Version.values()) {
            
            Properties structures = Parser.getMessageStructures(nextVersion.getVersion());
            for (Map.Entry<Object, Object> nextEntry : structures.entrySet()) {
                String nextStructure = nextEntry.getValue().toString();
                if ("?".equals(nextStructure)) {
                    continue;
                }
                
                String className = DefaultModelClassFactory.getVersionPackageName(nextVersion.getVersion()) + "message." + nextStructure;

                /*
                 * The DB has a few weird entries we ignore
                 * 
                 * TODO: investigate why
                 */
                if ("ca.uhn.hl7v2.model.v23.message.RRE_O02".equals(className)) {
                    continue;
                }
                if ("ca.uhn.hl7v2.model.v23.message.ORU_W01".equals(className)) {
                    continue;
                }
                if ("ca.uhn.hl7v2.model.v231.message.ROR_ROR".equals(className)) {
                    continue;
                }
                if ("ca.uhn.hl7v2.model.v231.message.MFN_M07".equals(className)) {
                    continue;
                }
                if ("ca.uhn.hl7v2.model.v24.message.QRY_P04".equals(className)) {
                    continue;
                }
                if ("ca.uhn.hl7v2.model.v26.message.BRP_O30".equals(className)) {
                    continue;
                }
                
                ourLog.info("Instantiating " + className);
                Class<?> clazz = Class.forName(className);

                try {
                    clazz.getConstructor(new Class<?>[0]).newInstance(new Object[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                    fail("Error instantiating " + className + " - " + e.getMessage());
                }
            }

        }

    }

    /**
     * Make sure the "reps" methods are generated
     */
    public void testRepsMethods() throws HL7Exception {
    	
    	ACK ack = new ACK();
    	ack.getERR().getErr1_ErrorCodeAndLocationReps();
    	ack.getERR().getErrorCodeAndLocationReps();
    	ack.getERRAll();
    	
    }
    
}
