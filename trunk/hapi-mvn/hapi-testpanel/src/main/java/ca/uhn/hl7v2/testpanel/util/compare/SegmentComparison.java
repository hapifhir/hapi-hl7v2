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

import ca.uhn.hl7v2.model.Segment;

import java.util.Collections;
import java.util.List;

public class SegmentComparison extends StructureComparison {
    //~ Instance fields ------------------------------------------------------------------------------------------------

    private Boolean mySame;
    private List<FieldComparison> myFieldComparisons;
    private Segment myActualSegment;
    private Segment myExpectSegment;
    private String myName;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    public SegmentComparison(String theName, List<FieldComparison> theFieldComparisons) {
        myFieldComparisons = theFieldComparisons;
        myName = theName;
    }

    public SegmentComparison(String theName, Segment theExpectSegment, Segment theActualSegment) {
        myExpectSegment = theExpectSegment;
        myActualSegment = theActualSegment;
        myName = theName;
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    @Override
    public List<SegmentComparison> flattenMessage() {
        return Collections.singletonList(this);
    }

    public Segment getActualSegment() {
        return myActualSegment;
    }

    public Segment getExpectSegment() {
        return myExpectSegment;
    }

    public List<FieldComparison> getFieldComparisons() {
        return myFieldComparisons;
    }

    public String getName() {
        return myName;
    }

    public boolean isSame() {
        if (mySame == null) {
            if (myFieldComparisons != null) {
                mySame = true;

                for (FieldComparison next : myFieldComparisons) {
                    if (! next.isSame()) {
                        mySame = false;

                        break;
                    }
                }
            } else {
                mySame = false;
            }
        }

        return mySame;
    }
}
