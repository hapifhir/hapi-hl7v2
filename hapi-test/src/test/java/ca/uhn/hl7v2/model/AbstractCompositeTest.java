package ca.uhn.hl7v2.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;

public class AbstractCompositeTest {

    @Test
    public void testParseNull() throws HL7Exception, IOException {

        ORU_R01 msg = new ORU_R01();
        msg.initQuickstart("ORU", "R01", "T");

        assertTrue(msg.getMSH().getMessageType().encode().length() > 0);

        msg.getMSH().getMessageType().parse(null);

        assertNull(msg.getMSH().getMessageType().getMessageCode().getValue());
        assertNull(msg.getMSH().getMessageType().getMessageStructure().getValue());

    }

    /**
     * HL7 doesn't actually have subsubcomponents.
     * However, the hapi-structures libs have some errors in them which can cause the nesting of components to go to the level of
     * subsubcomponents. (case in point: OBR-32-1-9 is actually a ST in v23 but HAPI thinks it is an HD
     * Therefore, we need message visitors to be able to traverse into subsubcomponents in order to reach every primitive in a message
     */
    @Test
    public void testTraversesIntoFirstSubSubComponentOnly() throws HL7Exception {
        String msgString = "MSH|^~\\&|||||||ORU^R01|||2.3\r" // -
                + "OBR||||||||||||||||||||||||||||||||MUE&MUELLER&SARAH&JANE&&&&&ASSIGNINGAUTH\r";
        PipeParser pipeParser = new PipeParser();
        final Message message = pipeParser.parse(msgString);
        final Terser terser = new Terser(message);
        // first check we can access OBR-32-1-9 with the terser in general
        assertEquals("ASSIGNINGAUTH", terser.get("/RESPONSE(0)/ORDER_OBSERVATION(0)/OBR-32-1-9"));
        final Map<String, String> locationsReached = new HashMap<String, String>();
        // Now check that the MessageVisitor copes OK with the subsubcomponent by iterating over its primitives and comparing with itself.
        final MessageVisitorSupport comparisonVisitor = new MessageVisitorSupport() {
            @Override
            public boolean visit(Primitive type, Location location) throws HL7Exception {
                final String valueInThis = type.getValue();
                final String valueInThat = terser.get(location.toString());
                locationsReached.put(location.toString(), valueInThat);
                assertEquals("Fields " + location + " not equal", valueInThat, valueInThis);
                return true;
            }
        };
        MessageVisitors.visit(message, comparisonVisitor);
        // Check that we actually traversed our way into the OBR-32-1-9-1 but did not assay the mythical OBR-32-1-9-2.
        assertEquals("ASSIGNINGAUTH", locationsReached.get("/RESPONSE(0)/ORDER_OBSERVATION(0)/OBR-32-1-9-1"));
        assertFalse(locationsReached.keySet().contains("/RESPONSE(0)/ORDER_OBSERVATION(0)/OBR-32-1-9-2"));

    }

}
