package ca.uhn.hl7v2.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.MockitoTest;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.GenericParser;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;

/**
 * Unit tests for MessageValidator.
 * 
 * @author Bryan Tripp
 * @author Christian Ohr
 * @version $Revision: 1.2 $ updated on $Date: 2011-02-19 17:40:18 $ by $Author:
 *          jamesagnew $
 */
public class MessageValidatorTest extends MockitoTest {

    private MessageValidator myFailingValidator;
    private MessageValidator myNonFailingValidator;

    @SuppressWarnings("serial")
	@Before
    public void setUp() throws Exception {
//        ValidationContextImpl context = new ValidationContextImpl();
//        context.getMessageRuleBindings().add(new MessageRuleBinding("*", "*", "*", new MockMessageRule()));
//        context.getMessageRuleBindings().add(new MessageRuleBinding("*", "*", "*", new MockMessageRule()));
//        context.getEncodingRuleBindings().add(new RuleBinding<EncodingRule>("*", "*", new MockEncodingRule()));
//        context.getEncodingRuleBindings().add(new RuleBinding<EncodingRule>("*", "*", new MockEncodingRule()));

        ValidationContext context = ValidationContextFactory.fromBuilder(new ValidationRuleBuilder() {

			@Override
			protected void configure() {
				forAllVersions()
					.message().all()
						.test(mockRule(Message.class, MessageRule.class, true))
					.encoding("ER7")
						.test(mockRule(String.class, EncodingRule.class, true));
			}
        	
        });
        myFailingValidator = new MessageValidator(context, true);
        myNonFailingValidator = new MessageValidator(context, false);
    }

    /*
     * Class under test for void validate(Message)
     */
    @Test(expected=HL7Exception.class)
    public void testValidateMessage() throws HL7Exception {
        ACK m = new ACK();
        Terser t = new Terser(m);
        t.set("MSH-9-1", "ACK");
        t.set("MSH-9-2", "A01");
        assertFalse(myNonFailingValidator.validate(m));
        myFailingValidator.validate(m);
    }

    /*
     * Class under test for void validate(String, boolean, String)
     */
    @Test(expected=HL7Exception.class)
    public void testValidateString() throws HL7Exception {
        String m = "a message";
        assertFalse(myNonFailingValidator.validate(m, false, "2.5"));
        myFailingValidator.validate(m, false, "2.5");
    }

    @Test
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

        Parser parser = new DefaultHapiContext().getGenericParser();
        try {
            parser.parse(deviceObservationMessage);
            fail();
        } catch (Exception e) {
            assertTrue(e.getMessage().toLowerCase().contains("withdrawn"));
        }
    }
    
    // TODO to be enabled if Message Validation also tests primitives 
    @Ignore
    public void testWithdrawnDatatype2() throws EncodingNotSupportedException, HL7Exception {

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

        GenericParser parser = GenericParser.getInstanceWithNoValidation();
        Message m = parser.parse(deviceObservationMessage);
        try {
        	MessageValidator v = new MessageValidator(ValidationContextFactory.defaultValidation(), true);
        	v.validate(m);
        	fail();
        } catch (HL7Exception e) {
        	assertTrue(e.getMessage().toLowerCase().contains("withdrawn"));
        	assertTrue(e.getCause().getMessage().contains("PID-13(0)-1"));
        }
    }    

    private <S, T extends Rule<S>> T mockRule(Class<S> testClass, Class<T> ruleClass, boolean fail) {
    	T rule = mock(ruleClass);
    	when(rule.apply(any(testClass))).thenReturn(fail ? failed() : new ValidationException[0]);
    	return rule;
    }
    private ValidationException[] failed() {
    	ValidationException ve = new ValidationException("Blargh!");
    	ve.setLocation(Location.UNKNOWN);
    	return new ValidationException[] { ve };
    }

}
