/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.DataTypeException;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.impl.DefaultValidation;
import ca.uhn.hl7v2.validation.impl.MessageRuleBinding;
import ca.uhn.hl7v2.validation.impl.RuleBinding;
import ca.uhn.hl7v2.validation.impl.ValidationContextImpl;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Unit tests for MessageValidator.
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2011-02-19 17:40:18 $ by $Author:
 *          jamesagnew $
 */
public class MessageValidatorTest extends TestCase {

    private MessageValidator myFailingValidator;
    private MessageValidator myNonFailingValidator;

    /*
     * @see TestCase#setUp()
     */
    protected void setUp() throws Exception {
        super.setUp();
        ValidationContextImpl context = new ValidationContextImpl();
        context.getMessageRuleBindings().add(new MessageRuleBinding("*", "*", "*", new MockMessageRule()));
        context.getMessageRuleBindings().add(new MessageRuleBinding("*", "*", "*", new MockMessageRule()));
        context.getEncodingRuleBindings().add(new RuleBinding<EncodingRule>("*", "*", new MockEncodingRule()));
        context.getEncodingRuleBindings().add(new RuleBinding<EncodingRule>("*", "*", new MockEncodingRule()));

        myFailingValidator = new MessageValidator(context, true);
        myNonFailingValidator = new MessageValidator(context, false);
    }

    /**
     * Constructor for MessageValidatorTest.
     * 
     * @param arg0
     */
    public MessageValidatorTest(String arg0) {
        super(arg0);
    }

    /*
     * Class under test for void validate(Message)
     */
    public void testValidateMessage() throws HL7Exception {
        ACK m = new ACK();
        Terser t = new Terser(m);
        t.set("MSH-9-1", "ACK");
        t.set("MSH-9-2", "A01");
        assertEquals(false, myNonFailingValidator.validate(m));
        try {
            myFailingValidator.validate(m);
            fail("Should throw exception on fail");
        } catch (HL7Exception e) {
        }
    }

    /*
     * Class under test for void validate(String, boolean, String)
     */
    public void testValidateString() throws HL7Exception {
        String m = "a message";
        assertEquals(false, myNonFailingValidator.validate(m, false, "2.5"));
        try {
            myFailingValidator.validate(m, false, "2.5");
            fail("Should throw exception on fail");
        } catch (HL7Exception e) {
        }
    }

    public void testWithdrawnDatatype() throws EncodingNotSupportedException, HL7Exception {

        String deviceObservationMessage = "MSH|^~\\&|AcmeInc^ACDE48234567ABCD^EUI-64||||20090713090030+0000||ORU^R01^ORU_R01|MSGID1234|P|2.6|||NE|AL|||||IHE PCD ORU-R01 2006^HL7^2.16.840.1.113883.9.n.m^HL7\r"
                + "PID|||1^^^Imaginary Hospital^PI ||Doe^John^Joseph^^^^L^A|||M|||||0123456789\r"
                + "OBR|1|AB12345^AcmeAHDInc^ACDE48234567ABCD^EUI-64|CD12345^AcmeAHDInc^ACDE48234567ABCD^EUI-64|182777000^monitoring of patient^SNOMED-CT|||20090813095715+0000\r"
                + "OBX|1|CWE|68220^MDC_TIME_SYNC_PROTOCOL^MDC|0.0.0.1|532224^MDC_TIME_SYNC_NONE^MDC|||||R\r"
                + "OBX|2||528391^MDC_DEV_SPEC_PROFILE_BP^MDC|1|||||||X|||||||0123456789ABCDEF^EUI-64\r"
                + "OBX|3||150020^MDC_PRESS_BLD_NONINV^MDC|1.0.1|||||||X|||20090813095715+0000\r"
                + "OBX|4|NM|150021^MDC_PRESS_BLD_NONINV_SYS^MDC|1.0.1.1|120|266016^MDC_DIM_MMHG^MDC|||||R\r"
                + "OBX|5|NM|150022^MDC_PRESS_BLD_NONINV_DIA^MDC|1.0.1.2|80|266016^MDC_DIM_MMHG^MDC|||||R\r"
                + "OBX|6|NM|150023^MDC_PRESS_BLD_NONINV_MEAN^MDC|1.0.1.3|100|266016^MDC_DIM_MMHG^MDC|||||R\r"
                + "OBX|7|DTM|67975^MDC_ATTR_TIME_ABS^MDC|1.0.0.1|20091028123702||||||R|||20091028173702+0000\r";

        Parser parser = new GenericParser();
        parser.setValidationContext(new DefaultValidation());
        try {
            parser.parse(deviceObservationMessage);
            fail();
        } catch (DataTypeException e) {
            Assert.assertTrue(e.getMessage().contains("Withdrawn"));
        }
    }

    @SuppressWarnings("serial")
	private class MockMessageRule implements MessageRule {

        public ValidationException[] test(Message msg) {
            return new ValidationException[] { new ValidationException("testing validator") };
        }

        public String getDescription() {
            return null;
        }

        public String getSectionReference() {
            return null;
        }
    }

    @SuppressWarnings("serial")
	private class MockEncodingRule implements EncodingRule {

        public ValidationException[] test(String msg) {
            return new ValidationException[] { new ValidationException("test validator") };
        }

        public String getDescription() {
            return null;
        }

        public String getSectionReference() {
            return null;
        }
    }

}
