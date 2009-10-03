
package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.model.v23.message.PPG_PCG;
import ca.uhn.hl7v2.parser.DefaultModelClassFactory;
import ca.uhn.hl7v2.parser.Parser;
import java.util.Map;
import java.util.Properties;
import junit.framework.TestCase;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Tests all generated message structures to ensure that they can be instantiated
 * correctly
 */
public class MessageStructuresTest extends TestCase {

    private static Log ourLog = LogFactory.getLog(MessageStructuresTest.class);

    public void testAllMessages() throws Exception {

        for (String nextVersion : Parser.getValidVersions()) {
            
            Properties structures = Parser.getMessageStructures(nextVersion);
            for (Map.Entry<Object, Object> nextEntry : structures.entrySet()) {
                String nextStructure = nextEntry.getValue().toString();
                if ("?".equals(nextStructure)) {
                    continue;
                }
                
                String className = DefaultModelClassFactory.getVersionPackageName(nextVersion) + "message." + nextStructure;

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

}
