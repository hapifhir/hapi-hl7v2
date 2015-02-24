/*
 * Created on 18-May-2004
 */
package ca.uhn.hl7v2.protocol.impl;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.Map;

import ca.uhn.hl7v2.*;
import ca.uhn.hl7v2.validation.MessageRule;
import ca.uhn.hl7v2.validation.RespondingValidationExceptionHandler;
import ca.uhn.hl7v2.validation.ValidationContext;
import ca.uhn.hl7v2.validation.ValidationException;
import ca.uhn.hl7v2.validation.builder.ValidationRuleBuilder;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;
import org.junit.Before;
import org.junit.Test;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.parser.PipeParser;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.protocol.ReceivingApplicationException;
import ca.uhn.hl7v2.protocol.ReceivingApplicationExceptionHandler;
import ca.uhn.hl7v2.protocol.Transportable;
import ca.uhn.hl7v2.util.Terser;

/**
 * Unit tests for <code>ApplicationRouterImpl</code>.
 *
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-03-20 22:21:14 $ by $Author: jamesagnew $
 */
public class ApplicationRouterImplTest {

    private ApplicationRouterImpl myRouter;

    @Before
    public void setUp() throws Exception {
        myRouter = new ApplicationRouterImpl();
    }

    @Test
    public void testProcessMessage() throws Exception {
        AppRoutingDataImpl rd = new AppRoutingDataImpl("ADT", "A01", "P", "2.4");
        MockApplication app = new MockApplication();
        String message1 = "MSH|^~\\&|||||||ADT^A01|a|P|2.4\rNTE||foo\r";
        String response = "MSH|^~\\&|||||||ACK|b|P|2.4||||||UNICODE\rMSA|AA|a\r";
        String message2 = "MSH|^~\\&|||||||ADT^A14|a|P|2.4\rNTE||foo\r";
        String message3 = "MSH|^~\\&|||||||ADT^A14|a|P|2.4\rNTE|foo\r";  //NumberFormatException in NTE-1

        myRouter.bindApplication(rd, app);
        PipeParser parser = new PipeParser();
        app.setNextResponse(parser.parse(response));

        Transportable result = myRouter.processMessage(new TransportableImpl(message1));
        assertTrue(result.getMessage(), result.getMessage().indexOf("MSA|AA|a") > 0);
        assertEquals("UNICODE", result.getMetadata().get("MSH-18"));

        //note that this test assumes DefaultApplication is being used and returns a certain message
        result = myRouter.processMessage(new TransportableImpl(message2));
        assertTrue(result.getMessage().indexOf("No appropriate destination") > 0);

        result = myRouter.processMessage(new TransportableImpl(message3));
        assertTrue(result.getMessage().indexOf("MSA|AE|a|") > 0);
    }

    /**
     * https://sourceforge.net/p/hl7api/bugs/123/
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testExceptionHandlerWorksCorrectlyWithInvalidMessage() throws HL7Exception {

        ReceivingApplicationExceptionHandler handler = mock(ReceivingApplicationExceptionHandler.class);

        String msg = "BAD MESSAGE";
        String respMsg = "BAD RESPONSE MESSAGE";

        when(handler.processException(eq(msg), any(Map.class), any(String.class), any(Exception.class))).thenReturn(respMsg);

        myRouter.setExceptionHandler(handler);
        myRouter.processMessage(new TransportableImpl(msg));

        verify(handler).processException(eq(msg), any(Map.class), any(String.class), any(Exception.class));
    }

    @Test
    public void testHasActiveBinding() {
        AppRoutingDataImpl rdA = new AppRoutingDataImpl("ADT", "A01", "P", "2.4");
        ReceivingApplication<Message> appA = new MockApplication();
        assertEquals(false, myRouter.hasActiveBinding(rdA));

        myRouter.bindApplication(rdA, appA);
        assertEquals(true, myRouter.hasActiveBinding(rdA));

        AppRoutingDataImpl test1 = new AppRoutingDataImpl("foo", "A01", "P", "2.4");
        AppRoutingDataImpl test2 = new AppRoutingDataImpl("ADT", "foo", "P", "2.4");
        AppRoutingDataImpl test3 = new AppRoutingDataImpl("ADT", "A01", "foo", "2.4");
        AppRoutingDataImpl test4 = new AppRoutingDataImpl("ADT", "A01", "P", "foo");
        assertEquals(false, myRouter.hasActiveBinding(test1));
        assertEquals(false, myRouter.hasActiveBinding(test2));
        assertEquals(false, myRouter.hasActiveBinding(test3));
        assertEquals(false, myRouter.hasActiveBinding(test4));

        myRouter.disableBinding(rdA);
        assertEquals(false, myRouter.hasActiveBinding(rdA));
    }

    /**
     * Tests that wildcards in routing data work.  This is largely tested by
     * testMatches(), but we check it again quickly here.
     */
    @Test
    public void testWildcards() {
        AppRoutingDataImpl rd = new AppRoutingDataImpl("*", "A01", "P", "2.4");
        ReceivingApplication<Message> app = new MockApplication();
        myRouter.bindApplication(rd, app);
        assertTrue(myRouter.hasActiveBinding(new AppRoutingDataImpl("ADT", "A01", "P", "2.4")));
        assertTrue(myRouter.hasActiveBinding(new AppRoutingDataImpl("foo", "A01", "P", "2.4")));
        assertEquals(false, myRouter.hasActiveBinding(new AppRoutingDataImpl("ADT", "foo", "P", "2.4")));
    }

    /**
     * Tests that regex in routing data work.  This is largely tested by
     * testRegexMatches(), but we check it again quickly here.
     */
    @Test
    public void testRegex() {
        AppRoutingDataImpl rd = new AppRoutingDataImpl("ADT", "A0.", "P", "2.4");
        ReceivingApplication<Message> app = new MockApplication();
        myRouter.bindApplication(rd, app);
        assertTrue(myRouter.hasActiveBinding(new AppRoutingDataImpl("ADT", "A01", "P", "2.4")));
        assertTrue(myRouter.hasActiveBinding(new AppRoutingDataImpl("ADT", "A02", "P", "2.4")));
        assertEquals(false, myRouter.hasActiveBinding(new AppRoutingDataImpl("ADT", "A14", "P", "2.4")));
    }

    @Test
    public void testRegexMatches() {
        AppRoutingDataImpl ref1 = new AppRoutingDataImpl("ADT", "A0.", "P", "2.4");
        AppRoutingDataImpl ref2 = new AppRoutingDataImpl("ADT", "A0[12]", "P", "2.4");
        AppRoutingDataImpl ref3 = new AppRoutingDataImpl(".*", "A01", "P", "2.4");
        AppRoutingDataImpl ref4 = new AppRoutingDataImpl("ADT", "A01", ".", "2.4");
        AppRoutingDataImpl ref5 = new AppRoutingDataImpl("ADT", "A01", "P", ".*");

        AppRoutingDataImpl msg1 = new AppRoutingDataImpl("ADT", "A01", "P", "2.4");
        AppRoutingDataImpl msg2 = new AppRoutingDataImpl("ADT", "A02", "P", "2.4");
        AppRoutingDataImpl msg3 = new AppRoutingDataImpl("ADT", "A03", "P", "2.4");

        assertTrue(ApplicationRouterImpl.matches(msg1, ref1));
        assertTrue(ApplicationRouterImpl.matches(msg2, ref1));
        assertTrue(ApplicationRouterImpl.matches(msg3, ref1));
        assertTrue(ApplicationRouterImpl.matches(msg1, ref2));
        assertTrue(ApplicationRouterImpl.matches(msg2, ref2));
        assertEquals(false, ApplicationRouterImpl.matches(msg3, ref2));
        assertTrue(ApplicationRouterImpl.matches(msg1, ref3));
        assertTrue(ApplicationRouterImpl.matches(msg1, ref4));
        assertTrue(ApplicationRouterImpl.matches(msg1, ref5));
    }

    @Test
    public void testMatches() {
        AppRoutingDataImpl one = new AppRoutingDataImpl("a", "b", "b", "d");

        AppRoutingDataImpl d1 = new AppRoutingDataImpl("-", "b", "b", "d");
        AppRoutingDataImpl d2 = new AppRoutingDataImpl("a", "-", "b", "d");
        AppRoutingDataImpl d3 = new AppRoutingDataImpl("a", "b", "-", "d");
        AppRoutingDataImpl d4 = new AppRoutingDataImpl("a", "b", "b", "-");

        AppRoutingDataImpl w1 = new AppRoutingDataImpl("*", "b", "b", "d");
        AppRoutingDataImpl w2 = new AppRoutingDataImpl("a", "*", "b", "d");
        AppRoutingDataImpl w3 = new AppRoutingDataImpl("a", "b", "*", "d");
        AppRoutingDataImpl w4 = new AppRoutingDataImpl("a", "b", "b", "*");

        assertEquals(true, ApplicationRouterImpl.matches(one, one));
        assertEquals(false, ApplicationRouterImpl.matches(one, d1));
        assertEquals(false, ApplicationRouterImpl.matches(one, d2));
        assertEquals(false, ApplicationRouterImpl.matches(one, d3));
        assertEquals(false, ApplicationRouterImpl.matches(one, d4));

        assertEquals(true, ApplicationRouterImpl.matches(one, w1));
        assertEquals(true, ApplicationRouterImpl.matches(one, w2));
        assertEquals(true, ApplicationRouterImpl.matches(one, w3));
        assertEquals(true, ApplicationRouterImpl.matches(one, w4));

        assertEquals(false, ApplicationRouterImpl.matches(w1, one));
        assertEquals(false, ApplicationRouterImpl.matches(w2, one));
        assertEquals(false, ApplicationRouterImpl.matches(w3, one));
        assertEquals(false, ApplicationRouterImpl.matches(w4, one));
    }

    @Test
    public void testCanProcess() throws Exception {

        AppRoutingDataImpl rd = new AppRoutingDataImpl("*", "*", "*", "*");

        ADT_A01 adt = new ADT_A01();
        adt.initQuickstart("ADT", "A01", "P");
        adt.getMSH().getMessageControlID().setValue(MockOccasionalApplication.REJECT_CONTROL_ID);

        MockOccasionalApplication occApp = new MockOccasionalApplication();
        myRouter.bindApplication(rd, occApp);

        MockAlwaysApplication allApp = new MockAlwaysApplication();
        myRouter.bindApplication(rd, allApp);

        myRouter.processMessage(new TransportableImpl(adt.encode()));

        assertEquals(0, occApp.myCount);
        assertEquals(1, allApp.myCount);

    }

    @Test
    public void testUnbindRouting() throws Exception {
        AppRoutingDataImpl rd = new AppRoutingDataImpl("ADT", "A0.", "P", "2.4");
        ReceivingApplication<Message> app = new MockApplication();
        myRouter.bindApplication(rd, app);
        assertTrue(myRouter.hasActiveBinding(rd));
        assertTrue(myRouter.unbindApplication(rd));
        assertFalse(myRouter.hasActiveBinding(rd));
        assertFalse(myRouter.unbindApplication(rd));
    }

    @Test
    public void testBindClassBasedApplication() throws Exception {
        AppRoutingDataImpl rd = new AppRoutingDataImpl("ADT", "A01", "P", "*");
        ReceivingApplication<ADT_A01> app = new A01v25Application();
        myRouter.bindApplication(rd, app);

        ADT_A01 adt = new ADT_A01();
        adt.initQuickstart("ADT", "A01", "P");

        String response = myRouter.processMessage(new TransportableImpl(adt.encode())).getMessage();
        assertTrue(response.contains("ACK^A01"));
    }

    @Test
    public void testUnbindApplication() throws Exception {
        AppRoutingDataImpl rd = new AppRoutingDataImpl("ADT", "A0.", "P", "2.4");
        ReceivingApplication<Message> app = new MockApplication();
        myRouter.bindApplication(rd, app);
        assertTrue(myRouter.hasActiveBinding(rd));
        assertTrue(myRouter.unbindApplication(app));
        assertFalse(myRouter.hasActiveBinding(rd));
        assertFalse(myRouter.unbindApplication(rd));
    }

    @Test
    public void testProperResponseForValidatingParser() throws Exception {
        ca.uhn.hl7v2.model.v26.message.ADT_A01 a01 = new ca.uhn.hl7v2.model.v26.message.ADT_A01();
        a01.initQuickstart("ADT", "A01", "P");
        String message = new PipeParser().encode(a01);

        HapiContext context = new DefaultHapiContext();
        context.setValidationContext(context(failingMessageRule("PID-1", "PV1-44"), "ADT", "A01",
                Version.V26));
        context.getParserConfiguration().setValidating(true);
        RespondingValidationExceptionHandler handler = new RespondingValidationExceptionHandler(context);
        handler.setErrorAcknowledgementCode(AcknowledgmentCode.AR);
        context.setValidationExceptionHandlerFactory(handler);

        ApplicationRouterImpl router = new ApplicationRouterImpl(context);
        Transportable result = router.processMessage(new TransportableImpl(message));
        ca.uhn.hl7v2.model.v26.message.ACK ack = (ca.uhn.hl7v2.model.v26.message.ACK) context.getPipeParser().parse(result.getMessage());
        String messageId = a01.getMSH().getMessageControlID().getValue();
        assertEquals(messageId, ack.getMSA().getMessageControlID().getValue());
        assertEquals(AcknowledgmentCode.AR.name(), ack.getMSA().getAcknowledgmentCode().getValue());
        assertEquals("PID", ack.getERR(0).getErrorLocation(0).getSegmentID().getValue());
        assertEquals("1", ack.getERR(0).getErrorLocation(0).getFieldPosition().getValue());
        assertEquals("207", ack.getERR(0).getHL7ErrorCode().getIdentifier().getValue());
        assertEquals("PV1", ack.getERR(1).getErrorLocation(0).getSegmentID().getValue());
        assertEquals("44", ack.getERR(1).getErrorLocation(0).getFieldPosition().getValue());
        assertEquals("207", ack.getERR(1).getHL7ErrorCode().getIdentifier().getValue());

    }

    private ValidationContext context(final MessageRule rule, final String eventType,
                                      final String trigger, final Version version) {
        return ValidationContextFactory.fromBuilder(new ValidationRuleBuilder() {

            @Override
            protected void configure() {
                forVersion(version).message(eventType, trigger).test(rule);
            }

        });
    }

    private MessageRule failingMessageRule(String... locations) {
        MessageRule rule = mock(MessageRule.class);
        ValidationException[] exceptions = new ValidationException[locations.length];
        for (int i = 0; i < locations.length; i++) {
            String[] s = locations[i].split("-");
            Location l = new Location()
                    .withSegmentName(s[0])
                    .withField(Integer.parseInt(s[1]));
            ValidationException ve = new ValidationException();
            ve.setLocation(l);
            exceptions[i] = ve;
        }
        when(rule.apply(any(Message.class))).thenReturn(exceptions);
        return rule;
    }

    /**
     * Mock Application for testing purposes.  Use getId() as a handy
     * way to check which application the router is routing to.
     *
     * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
     * @version $Revision: 1.2 $ updated on $Date: 2009-03-20 22:21:14 $ by $Author: jamesagnew $
     */
    private static class MockApplication implements ReceivingApplication<Message> {

        private Message myNextResponse;

        public Message processMessage(Message arg0, Map<String, Object> arg1) throws ReceivingApplicationException, HL7Exception {
            return myNextResponse;
        }

        public boolean canProcess(Message arg0) {
            return true;
        }

        public void setNextResponse(Message theResponse) {
            myNextResponse = theResponse;
        }
    }

    private static class MockOccasionalApplication implements ReceivingApplication<Message> {

        public static final String REJECT_CONTROL_ID = "012234";
        int myCount = 0;

        public Message processMessage(Message arg0, Map<String, Object> arg1) throws ReceivingApplicationException, HL7Exception {
            myCount++;
            try {
                return arg0.generateACK();
            } catch (IOException e) {
                throw new HL7Exception(e);
            }
        }

        public boolean canProcess(Message arg0) {
            try {
                String controlId = new Terser(arg0).get("/MSH-10");
                if (controlId.equals(REJECT_CONTROL_ID)) {
                    return false;
                }
            } catch (HL7Exception e) {
                fail(e.getMessage());
            }
            return true;
        }

    }

    private static class MockAlwaysApplication implements ReceivingApplication<Message> {
        int myCount = 0;

        public Message processMessage(Message message, Map<String, Object> metadata) throws ReceivingApplicationException, HL7Exception {
            myCount++;
            try {
                return message.generateACK();
            } catch (IOException e) {
                throw new HL7Exception(e);
            }
        }

        public boolean canProcess(Message message) {
            return true;
        }

    }

    private static class A01v25Application extends ClassBasedReceivingApplication<ADT_A01> {
        public A01v25Application() {
            super(ADT_A01.class);
        }

        public Message processMessage(ADT_A01 message, Map<String, Object> theMetadata) throws ReceivingApplicationException, HL7Exception {
            try {
                return message.generateACK();
            } catch (IOException e) {
                throw new HL7Exception(e);
            }
        }
    }

}
