/*
 * DeepCopyPosTest.java
 *
 * Created on July 3, 2002, 3:12 PM
 */

package ca.uhn.hl7v2.util;

import ca.uhn.hl7v2.model.Primitive;
import ca.uhn.hl7v2.model.v24.datatype.*;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.model.v24.segment.AL1;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * JUnit test harness for DeepCopyTest
 *
 * @author Neal Acharya
 * @author Christian Ohr
 */
public class DeepCopyPosTest  {

    /**
     * + Test copy from primitive type to composite
     */
    @Test
    public void testPrimTOPrimCopy1() throws Exception {
        String value = "hello";
        ST st1 = new ST(null);
        st1.setValue(value);
        ST st2 = new ST(null);
        DeepCopy.copy(st1, st2);
        assertEquals(value, st2.getValue());
    }


    /**
     * + Test copy from primitive type to composite
     */
    @Test
    public void testPrimTOCompCopy1() throws Exception {
        String value = "hello";
        ST st = new ST(null);
        st.setValue(value);
        AD ad = new AD(null);
        DeepCopy.copy(st, ad);
        assertEquals(value, ad.getStreetAddress().getValue());
    }

    /**
     * + Test copy from composite type to primitive
     */
    @Test
    public void testCompToPrimCopy1() throws Exception {
        String value = "hello";
        ST st = new ST(null);
        AD ad = new AD(null);
        ad.getStreetAddress().setValue(value);
        DeepCopy.copy(ad, st);
        assertEquals(value, st.getValue());
    }

    /**
     * + Test copy from composite type to composite
     */
    @Test
    public void testCompToCompCopy1() throws Exception {
        String value = "hello";
        AD ad1 = new AD(null);
        AD ad2 = new AD(null);
        ad1.getStreetAddress().setValue(value);
        DeepCopy.copy(ad1, ad2);
        assertEquals(value, ad2.getStreetAddress().getValue());
    }

    /**
     * + Test copy from composite type to composite
     * multi value multi level copy.
     */
    @Test
    public void testCompToCompCopy2() throws Exception {
        String val1 = "M";
        String val2 = "123";
        AD ad = new AD(null);
        CQ cq = new CQ(null);
        cq.getQuantity().setValue(val2);
        cq.getUnits().getIdentifier().setValue(val1);
        cq.getUnits().getText().setValue(val1);
        DeepCopy.copy(cq, ad);
        assertEquals(val2, ad.getStreetAddress().getValue());
        assertEquals(val1, ad.getOtherDesignation().getValue());
        assertEquals(null, ad.getCity().getValue());
    }

    /**
     * + Test copy from composite type to composite
     * multi value multi level copy.
     */
    @Test
    public void testCompToCompCopy3() throws Exception {
        String val1 = "123";
        String val2 = "hello2";
        AD ad = new AD(null);
        CQ cq = new CQ(null);
        ad.getStreetAddress().setValue(val1);
        ad.getCity().setValue(val2);
        DeepCopy.copy(ad, cq);
        assertEquals(val1, cq.getQuantity().getValue());
        assertEquals(null, cq.getUnits().getText().getValue());
    }


    /**
     * + Test copy from composite type to composite
     */
    @Test
    public void testCompToCompCopy4() throws Exception {
        AD ad = new AD(null);
        DLN dln = new DLN(null);
        dln.getDriverSLicenseNumber().setValue("1234");
        dln.getIssuingStateProvinceCountry().setValue("12");
        dln.getExpirationDate().setValue("19990404");
        DeepCopy.copy(dln, ad);
        assertEquals("1234", ad.getStreetAddress().getValue());
        assertEquals("12", ad.getOtherDesignation().getValue());
        assertEquals("19990404", ad.getCity().getValue());
    }

    /**
     * + Test copy from composite type to composite
     * multi value multi level copy.
     */
    @Test
    public void testCompToCompCopy5() throws Exception {
        AD ad = new AD(null);
        CQ cq = new CQ(null);
        ad.getCity().setValue("hello");
        DeepCopy.copy(ad, cq);
        assertEquals(null, cq.getQuantity().getValue());
        assertEquals(null, cq.getUnits().getText().getValue());
    }

    @Test
    public void testCopySegment() throws Exception {
        ADT_A01 msg = new ADT_A01();
        AL1 a = msg.getAL1(0);
        AL1 b = msg.getAL1(1);
        a.getAllergyReactionCode(0).setValue("foo");
        a.getAllergyReactionCode(1).setValue("foo1");
        a.getAllergySeverityCode().getText().setValue("foo2");
        a.getAllergySeverityCode().getAlternateText().setValue("foo3");
        DeepCopy.copy(a, b);
        assertEquals(a.getAllergyReactionCode(0).getValue(), b.getAllergyReactionCode(0).getValue());
        assertEquals(a.getAllergyReactionCode(1).getValue(), b.getAllergyReactionCode(1).getValue());
        assertEquals(a.getAllergySeverityCode().getText().getValue(), b.getAllergySeverityCode().getText().getValue());
        assertEquals(a.getAllergySeverityCode().getAlternateText().getValue(), b.getAllergySeverityCode().getAlternateText().getValue());
        assertEquals(a.getIdentificationDate().getValue(), b.getIdentificationDate().getValue());
    }

    @Test
    public void testCopyExtraComponents() throws Exception {
        CE from = new CE(null);
        ST to = new ST(null);
        from.getIdentifier().setValue("one");
        from.getText().setValue("two");
        from.getNameOfCodingSystem().setValue("three");
        DeepCopy.copy(from, to);
        assertEquals("one", to.getValue());
        assertEquals("two", ((Primitive) to.getExtraComponents().getComponent(0).getData()).getValue());
        assertEquals("three", ((Primitive) to.getExtraComponents().getComponent(1).getData()).getValue());
    }

}
