/**
 *
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */
package ca.uhn.hl7v2.testpanel.util.compare;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtraGroup extends StructureComparison {
    //~ Instance fields ------------------------------------------------------------------------------------------------

    private Group myGroup;
    private boolean myMessage1;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    public ExtraGroup(Group theGroup, boolean theMessage1) {
        myGroup = theGroup;
        myMessage1 = theMessage1;
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    private List<SegmentComparison> flatten(Structure theStructure) {
        if (theStructure instanceof Segment) {
            if (myMessage1) {
                return Collections.singletonList((SegmentComparison) new SegmentComparison(
                                                                                           theStructure.getName(),
                                                                                           (Segment) theStructure,
                                                                                           null));
            } else {
                return Collections.singletonList((SegmentComparison) new SegmentComparison(
                                                                                           theStructure.getName(),
                                                                                           null,
                                                                                           (Segment) theStructure));
            }
        }

        ArrayList<SegmentComparison> retVal = new ArrayList<SegmentComparison>();
        Group group = (Group) theStructure;

        for (String nextName : group.getNames()) {
            try {
                for (Structure nextRep : group.getAll(nextName)) {
                    retVal.addAll(flatten(nextRep));
                }
            } catch (HL7Exception e) {
                throw new Error(e);
            }
        }

        return retVal;
    }

    @Override
    public List<SegmentComparison> flattenMessage() {
        return flatten(myGroup);
    }

    public Group getGroup() {
        return myGroup;
    }

    public boolean isMessage1() {
        return myMessage1;
    }
}
