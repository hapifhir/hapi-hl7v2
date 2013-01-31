package ca.uhn.hl7v2.model;


import static ca.uhn.hl7v2.model.MessageVisitors.visit;
import static ca.uhn.hl7v2.model.MessageVisitors.visitPopulatedElements;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

// import ca.uhn.hl7v2.parser.PipeEncoder;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.util.Terser;

public class MessageVisitorTest {

    @Test
    public void testVisitOmdO03() throws HL7Exception, IOException {
        String msg = loadFile("/ca/uhn/hl7v2/parser/omd_o03.txt", '\r');
        PipeParser pipeParser = new PipeParser();
        Message message = pipeParser.parse(msg);
        
        // Visit all non-empty elements using the TestMessageVisitor
        TestMessageVisitor tmv = visit(message, visitPopulatedElements(new TestMessageVisitor())).getDelegate();
        
        assertEquals("Visitor start/end method calls not equal", 0, tmv.level);
        assertEquals("Wrong number of non-empty primitive values", 44, tmv.nonEmptyPrimitives.size());
        
        // Test that all non-empty primitive locations can be used as input to Terser.get(String)
        // and all returned values correspond with the visited values.
        Terser terser = new Terser(message);
        for (Location l : tmv.nonEmptyPrimitives.keySet()) {
            assertEquals("Unexpected value", terser.get(l.toString()), tmv.nonEmptyPrimitives.get(l));
        }
    }
/**
    @Test
    public void testEncodeOmdO03() throws HL7Exception, IOException {
        String msg = loadFile("/ca/uhn/hl7v2/parser/omd_o03.txt", '\r');
        PipeParser pipeParser = new PipeParser();
        Message message = pipeParser.parse(msg);

        // Visit all non-empty elements using the TestMessageVisitor
        PipeEncoder ppe = visit(message, new PipeEncoder(pipeParser.getParserConfiguration()));
        System.out.println(ppe.getEncoded());
    }
*/
    
    /**
     * Visitor that counts start/end method calls and remembers all non-empty
     * primitive values associated with their respective location.
     */
    private class TestMessageVisitor extends MessageVisitorSupport {
        
        Map<Location, String> nonEmptyPrimitives = new LinkedHashMap<Location, String>();
        int level = 0;

        @Override
        public boolean start(Group group, Location location) throws HL7Exception {
            level++;
            return true;
        }

        @Override
        public boolean end(Group group, Location location) throws HL7Exception {
            level--;
            return true;
        }

        @Override
        public boolean start(Segment segment, Location location) throws HL7Exception {
            level++;
            return true;
        }

        @Override
        public boolean end(Segment segment, Location location) throws HL7Exception {
            level--;
            return true;
        }

        @Override
        public boolean start(Composite type, Location location) throws HL7Exception {
            level++;
            return true;
        }

        @Override
        public boolean end(Composite type, Location location) throws HL7Exception {
            level--;
            return true;
        }

        @Override
        public boolean visit(Primitive type, Location location) throws HL7Exception {
            nonEmptyPrimitives.put(location, type.getValue());
            return true;
        }

    }

    private String loadFile(String name, char linebreak) throws IOException {
        InputStream resourceInputStream = getClass().getResourceAsStream(name);
        StringBuilder sb = new StringBuilder();

        if (resourceInputStream != null) {
            BufferedReader in = new BufferedReader(new InputStreamReader(resourceInputStream));

            try {
                String line = in.readLine();
                while (line != null) {
                    sb.append(line).append(linebreak);
                    line = in.readLine();
                }
                return sb.toString();
            } finally {
                in.close();
            }
        } else {
            throw new IOException("File " + name + " not found");
        }
    }

}
