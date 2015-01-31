package ca.uhn.hl7v2.validation.builder;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.model.v25.message.BAR_P01;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.ValidationException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class RejectMessageRuleBuilderTest {

	private MessageRuleBuilder b1;

	@Before
	public void setUp() throws Exception {
		b1 = new ValidationRuleBuilder()
                .forVersion("2.5")
                    .message().rejectOtherThan("A01", "A08");
	}

	@Test
	public void testAllowed() throws HL7Exception, IOException {
		ADT_A01 a01 = new ADT_A01();
		a01.initQuickstart("ADT", "A01", "P");
		MessageRule r = ((MessageRule) b1.getRules().iterator().next().getRule());
		assertEquals(0, r.apply(a01).length);
	}

    @Test
    public void testNotAllowed1() throws HL7Exception, IOException {
        ADT_A01 a01 = new ADT_A01();
        a01.initQuickstart("ADT", "A04", "P");
        MessageRule r = ((MessageRule) b1.getRules().iterator().next().getRule());
        ValidationException[] ve = r.apply(a01);
        assertEquals(1, ve.length);
    }

    @Test
    public void testNotAllowed2() throws HL7Exception, IOException {
        BAR_P01 p01 = new BAR_P01();
        p01.initQuickstart("BAR", "P01", "P");
        MessageRule r = ((MessageRule) b1.getRules().iterator().next().getRule());
        assertEquals(1, r.apply(p01).length);
    }
}
