/*
 The contents of this file are subject to the Mozilla Public License Version 1.1
 (the "License"); you may not use this file except in compliance with the License.
 You may obtain a copy of the License at http://www.mozilla.org/MPL/
 Software distributed under the License is distributed on an "AS IS" basis,
 WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 specific language governing rights and limitations under the License.

 The Original Code is "MessageVisitors.java ".  Description:
 "Static methods for working with MessageVisitor"

 The Initial Developer of the Original Code is University Health Network. Copyright (C)
 2013.  All Rights Reserved.

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

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.Location;

/**
 * Static methods for working with MessageVisitor
 */
public final class MessageVisitors {

    private MessageVisitors() {}

    /**
     * Lets a visitor visit a message of parts thereof.
     *
     * @param visitor MessageVisitor
     * @param visitable message element to be visited
     * @return the MessageVisitor
     * @throws HL7Exception if an error occurs while visiting
     */
    public static <T extends MessageVisitor> T visit(Visitable visitable, T visitor) throws HL7Exception {
        visitable.accept(visitor, new Location());
        return visitor;
    }

    /**
     * Returns a MessageVisitor that only visits structures
     * @param visitor delegate MessageVisitor instance
     * @return MessageVisitor that only visits structures
     */
    public static <T extends MessageVisitor> StructuresVisitor<T> visitStructures(T visitor) {
        return new StructuresVisitor<T>(visitor);
    }

    /**
     * Returns a MessageVisitor that only visits populated message elements.
     * You can further nest delegate visitors, e.g.
     * <code>structures(populated(new MyVisitor()))</code>
     *
     * @param visitor delegate MessageVisitor instance
     * @return MessageVisitor that only visits populated message elements
     */
    public static <T extends MessageVisitor> PopulatedVisitor<T> visitPopulatedElements(T visitor) {
        return new PopulatedVisitor<T>(visitor);
    }


    public final static class StructuresVisitor<T extends MessageVisitor> extends DelegatingMessageVisitor<T> {

        StructuresVisitor(T visitor) {
            super(visitor);
        }

        @Override
        public boolean start(Segment segment, Location location) throws HL7Exception {
            super.start(segment, location);
            return false;
        }

        @Override
        public final boolean start(Composite type, Location location) throws HL7Exception {
            return false;
        }

        @Override
        public boolean visit(Primitive type, Location location) throws HL7Exception {
            return false;
        }
    }

    public final static class PopulatedVisitor<T extends MessageVisitor> extends DelegatingMessageVisitor<T> {

        PopulatedVisitor(T visitor) {
            super(visitor);
        }

        @Override
        public boolean start(Group group, Location location) throws HL7Exception {
            return !group.isEmpty() && super.start(group, location);
        }

        @Override
        public boolean end(Group group, Location location) throws HL7Exception {
            return !group.isEmpty() && super.end(group, location);
        }

        @Override
        public boolean start(Segment segment, Location location) throws HL7Exception {
            return !segment.isEmpty() && super.start(segment, location);
        }

        @Override
        public boolean end(Segment segment, Location location) throws HL7Exception {
            return !segment.isEmpty() && super.end(segment, location);
        }

        @Override
        public final boolean start(Composite type, Location location) throws HL7Exception {
            return !type.isEmpty() && super.start(type, location);
        }

        @Override
        public boolean end(Composite type, Location location) throws HL7Exception {
            return !type.isEmpty() && super.end(type, location);
        }

        @Override
        public boolean visit(Primitive type, Location location) throws HL7Exception {
            return !type.isEmpty() && super.visit(type, location);
        }
 

    }
}
