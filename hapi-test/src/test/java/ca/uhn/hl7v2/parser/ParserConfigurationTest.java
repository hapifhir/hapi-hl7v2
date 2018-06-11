package ca.uhn.hl7v2.parser;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;

public class ParserConfigurationTest  {
	private static final org.slf4j.Logger ourLog = org.slf4j.LoggerFactory.getLogger(ParserConfigurationTest.class);
	
	/**
	 * Test for
	 * http://sourceforge.net/tracker/?func=detail&aid=3472728&group_id=38899&atid=423835
	 */
	@Test
	public void testCheckFirstCharacterForcedEncode() throws HL7Exception, IOException {
		
		ORU_R01 msg = new ORU_R01();
		msg.initQuickstart("ORU", "R01", "T");
		msg.getPATIENT_RESULT().getPATIENT().getPID();
		
		PipeParser p = new PipeParser();
		p.getParserConfiguration().addForcedEncode("PATIENT_RESULT/PATIENT/PID-11-7");
		
		String encoded = p.encode(msg);
		ourLog.debug("Encoded:\n" + encoded.replace("\r", "\n"));
		assertTrue(encoded.contains("PID|||||||||||^^^^^^"));
		
	}

	@Test
	public void testAddForcedEncodeValidatesInput() {
		
		ParserConfiguration pc = new ParserConfiguration();
		pc.addForcedEncode("ORDER/RXR-22");
		
		assertIllegalArgument(pc, "A");
        assertIllegalArgument(pc, "AA");
        assertIllegalArgument(pc, "AAA/");
        assertIllegalArgument(pc, "AAA-A");
        assertIllegalArgument(pc, "AAA-123-");

	}


    /**
     * <p>
     *     Test for {@link ParserConfiguration#setDefaultMfe5Type(String)}.  Attempt to parse a message with a missing MFE-5 value.
     * </p>
     * <p>
     *     Setup: Set default MFE-5 type to 'ST' with {@link ParserConfiguration#setDefaultMfe5Type(String)}.  Attempt to parse sample message.
     * </p>
     * <p>
     *     Expected Result:  Message will parse successfully
     * </p>
     */
	@Test
    public void test_setDefaultMfe5Type() throws Exception {

        String message = "MSH|^~\\&|Send App|Send Fac|Rec App|Rec Fac|20070504141816||MFN^M02||P|2.6\r" +
                         "MFE||||VALUE\r";

        Parser p = new PipeParser();
        p.getParserConfiguration().setDefaultMfe5Type("ST");

        Message m = p.parse(message);

        Assert.assertNotNull(m);
    }

    /**
     * <p>
     *     Test for {@link ParserConfiguration#setDefaultMfe5Type(String)}.  Attempt to parse a message with a missing MFE-5 value.
     * </p>
     * <p>
     *     Setup: Attempt to parse sample message, not adjusting {@link ParserConfiguration}
     * </p>
     * <p>
     *     Expected Result:  Message will fail to parse
     * </p>
     */
    @Test(expected = HL7Exception.class)
    public void test_setDefaultMfe5Type_systemDefault() throws Exception {

        String message = "MSH|^~\\&|Send App|Send Fac|Rec App|Rec Fac|20070504141816||MFN^M02||P|2.6\r" +
                         "MFE||||VALUE\r";

        Parser p = new PipeParser();

        p.parse(message);
    }

    /**
     * <p>
     *     Test for {@link ParserConfiguration#setInvalidMfe5Type(String)}.  Attempt to parse a message with an invalid MFE-5 value.
     * </p>
     * <p>
     *     Setup: Set default MFE-5 type to 'ST' with {@link ParserConfiguration#setDefaultMfe5Type(String)}.  Attempt to parse sample message.
     * </p>
     * <p>
     *     Expected Result:  Message will parse successfully
     * </p>
     */
    @Test
    public void test_setInvalidMfe5Type() throws Exception {

        String message = "MSH|^~\\&|Send App|Send Fac|Rec App|Rec Fac|20070504141816||MFN^M02||P|2.6\r" +
                         "MFE||||VALUE|INVALID\r";

        Parser p = new PipeParser();
        p.getParserConfiguration().setInvalidMfe5Type("ST");

        Message m = p.parse(message);

        Assert.assertNotNull(m);
    }

    /**
     * <p>
     *     Test for {@link ParserConfiguration#setInvalidMfe5Type(String)}.  Attempt to parse a message with an invalid MFE-5 value.
     * </p>
     * <p>
     *     Setup: Attempt to parse sample message, not adjusting {@link ParserConfiguration}
     * </p>
     * <p>
     *     Expected Result:  Message will fail to parse
     * </p>
     */
    @Test(expected = HL7Exception.class)
    public void test_setInvalidMfe5Type_systemDefault() throws Exception {

        String message = "MSH|^~\\&|Send App|Send Fac|Rec App|Rec Fac|20070504141816||MFN^M02||P|2.6\r" +
                         "MFE||||VALUE|INVALID\r";

        Parser p = new PipeParser();

        p.parse(message);
    }
	
	private void assertIllegalArgument(ParserConfiguration pc, String forcedEncode) {
        try {
            pc.addForcedEncode(forcedEncode);
            fail();
        } catch (IllegalArgumentException e) {
            ourLog.debug(e.getMessage());
        }	    
	}
	
}
