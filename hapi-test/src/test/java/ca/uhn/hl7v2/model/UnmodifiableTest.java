/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "UnmodifiableTest.java".  Description:
 ""

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2015.  All Rights Reserved.

 Contributor(s): ______________________________________.

 Alternatively, the contents of this file may be used under the terms of the
 GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 applicable instead of those above.  If you wish to allow use of your version of this
 file only under the terms of the GPL and not to allow others to use your version
 of this file under the MPL, indicate your decision by deleting  the provisions above
 and replace  them with the notice and other provisions required by the GPL License.
 If you do not delete the provisions above, a recipient may use your version of
 this file under either the MPL or the GPL.
 */

package ca.uhn.hl7v2.model;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.Location;
import ca.uhn.hl7v2.model.v23.message.ORU_R01;
import ca.uhn.hl7v2.util.ReadOnlyMessageIterator;
import ca.uhn.hl7v2.util.Terser;
import ca.uhn.hl7v2.validation.impl.ValidationContextFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class UnmodifiableTest extends Assert {

    private static final String MSG = "MSH|^~\\&|ULTRA|TML|OLIS|OLIS|200905011130||ORU^R01|20169838|T|2.3\r"
            + "PID|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r"
            + "PV1|1||OLIS||||OLIST^BLAKE^DONALD^THOR^^^^^921379^^^^OLIST\r"
            + "ORC|RE||T09-100442-RET-0^^OLIS_Site_ID^ISO|||||||||OLIST^BLAKE^DONALD^THOR^^^^L^921379\r"
            + "OBR|0||T09-100442-RET-0^^OLIS_Site_ID^ISO|RET^RETICULOCYTE COUNT^HL79901 literal|||200905011106|||||||200905011106||OLIST^BLAKE^DONALD^THOR^^^^L^921379||7870279|7870279|T09-100442|MOHLTC|200905011130||B7|F||1^^^200905011106^^R\r"
            + "OBX|1|NM|Z114099^Erc^L||4.00|tril/L|3.90-5.60||||F|||200905011111|PMH\r"
            + "ZPI|||7005728^^^TML^MR||TEST^RACHEL^DIAMOND||19310313|F|||200 ANYWHERE ST^^TORONTO^ON^M6G 2T9||(416)888-8888||||||1014071185^KR\r";

    private Message msg;

    @Before
    public void parseMessage() throws HL7Exception {
        HapiContext context = new DefaultHapiContext(ValidationContextFactory.noValidation());
        msg = Unmodifiable.unmodifiableMessage(context, MSG);

        assertTrue(Unmodifiable.isUnmodifiable(msg));
    }

    @Test
    public void encode() throws HL7Exception {
        assertSame(MSG, msg.encode());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void cannotUseTerserSet() throws HL7Exception {
        Terser t = new Terser(msg);
        assertEquals("7005728", t.get("/.PID-3-1"));
        t.set("/.PID-3-1", "4711");
    }

    @Test
    public void getTerserGetStructure() throws HL7Exception {
        assertTrue(Unmodifiable.isUnmodifiable(new Terser(msg).getSegment("MSH")));
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotAddExtraComponents() throws HL7Exception {
        Terser t = new Terser(msg);
        t.get("/.PID-3-7");
    }

    @Test(expected = ClassCastException.class)
    public void noCastsPossible() throws HL7Exception {
        ORU_R01 oru = (ORU_R01)msg;
    }

    @Test
    public void getStructures() throws HL7Exception {
        assertTrue(Unmodifiable.isUnmodifiable(msg.get("MSH")));
        assertTrue(Unmodifiable.isUnmodifiable(msg.get("RESPONSE")));
    }

    @Test
    public void visitor() throws HL7Exception {
        MessageVisitors.visit(msg, new AssertingVisitor());
    }


    @Test
    public void plainMessageIterator() throws HL7Exception {
        Iterator<Structure> structures = new ReadOnlyMessageIterator(msg);
        while (structures.hasNext()) {
            Structure s = structures.next();
            assertTrue(Unmodifiable.isUnmodifiable(s));
        }
    }


    @Test(expected = UnsupportedOperationException.class)
    public void cannotAddNonStandardSegment() throws HL7Exception {
        msg.addNonstandardSegment("XYZ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotAddRepetition() throws HL7Exception {
        Segment pid = new Terser(msg).getSegment("/.PID");
        pid.getField(3, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void cannotAddField() throws HL7Exception {
        Segment pid = new Terser(msg).getSegment("/.PID");
        pid.getField(33);
    }

    private class AssertingVisitor extends MessageVisitorSupport {

        @Override
        public boolean start(Message message) throws HL7Exception {
            assertTrue(Unmodifiable.isUnmodifiable(message));
            return super.start(message);
        }

        @Override
        public boolean start(Group group, Location location) throws HL7Exception {
            assertTrue(Unmodifiable.isUnmodifiable(group));
            return super.start(group, location);
        }

        @Override
        public boolean start(Segment segment, Location location) throws HL7Exception {
            assertTrue(Unmodifiable.isUnmodifiable(segment));
            return super.start(segment, location);
        }

        @Override
        public boolean start(Composite type, Location location) throws HL7Exception {
            assertTrue(Unmodifiable.isUnmodifiable(type));
            return super.start(type, location);
        }

        @Override
        public boolean visit(Primitive type, Location location) throws HL7Exception {
            assertTrue(Unmodifiable.isUnmodifiable(type));
            return super.visit(type, location);
        }
    }
}
