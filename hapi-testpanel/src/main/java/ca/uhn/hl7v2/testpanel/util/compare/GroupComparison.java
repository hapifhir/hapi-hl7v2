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

import java.util.ArrayList;
import java.util.List;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Segment;
import ca.uhn.hl7v2.model.Structure;

public class GroupComparison extends StructureComparison {
    //~ Instance fields ------------------------------------------------------------------------------------------------

    private ArrayList<SegmentComparison> myFlattened;
    private Boolean mySame;
    private List<StructureComparison> myGroupComparisons;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    public GroupComparison(List<StructureComparison> theStructureComparison) {
        myGroupComparisons = theStructureComparison;
    }

    public GroupComparison(Group theExpected, Group theActual) {
        assert (theExpected != null) || (theActual != null);
        assert (theExpected == null) || (theActual == null);

        myGroupComparisons = new ArrayList<StructureComparison>();

        if (theExpected != null) {
            addStructures(theExpected, true);
        }

        if (theActual != null) {
            addStructures(theActual, false);
        }
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    private void addStructures(Group theGroup, boolean theIsGroupExpected)
                        throws Error {
        for (String nextName : theGroup.getNames()) {
            Structure[] allReps;

            try {
                allReps = theGroup.getAll(nextName);
            } catch (HL7Exception e) {
                throw new Error("Unknown name: " + nextName, e);
            }

            for (Structure nextStructure : allReps) {
                if (nextStructure instanceof Group) {
                    if (theIsGroupExpected) {
                        myGroupComparisons.add(new GroupComparison((Group) nextStructure, null));
                    } else {
                        myGroupComparisons.add(new GroupComparison(null, (Group) nextStructure));
                    }
                } else {
                    if (theIsGroupExpected) {
                        myGroupComparisons.add(new SegmentComparison(
                                                                     nextStructure.getName(),
                                                                     (Segment) nextStructure,
                                                                     null));
                    } else {
                        myGroupComparisons.add(new SegmentComparison(
                                                                     nextStructure.getName(),
                                                                     null,
                                                                     (Segment) nextStructure));
                    }
                }
            }
        }
    }

    @Override
    public List<SegmentComparison> flattenMessage() {
        if (myFlattened == null) {
            myFlattened = new ArrayList<SegmentComparison>();

            for (StructureComparison structureComparison : myGroupComparisons) {
                myFlattened.addAll(structureComparison.flattenMessage());
            }
        }

        return myFlattened;
    }

    public List<StructureComparison> getGroupComparisons() {
        return myGroupComparisons;
    }

    public boolean isSame() {
        if (mySame == null) {
            mySame = true;

            for (SegmentComparison next : flattenMessage()) {
                if (next.getActualSegment() != null) {
                    mySame = false;

                    break;
                } else if (next.getExpectSegment() != null) {
                    mySame = false;

                    break;
                } else {
                    for (FieldComparison nextField : next.getFieldComparisons()) {
                        if (! nextField.isSame()) {
                            mySame = false;

                            break;
                        }
                    }
                }
            }
        }

        return mySame;
    }
}
