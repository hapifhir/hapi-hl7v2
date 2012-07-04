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

import ca.uhn.hl7v2.model.Type;

import java.util.List;

public class FieldComparison {
    //~ Instance fields ------------------------------------------------------------------------------------------------

    private Boolean mySame;
    private List<Type> myDiffFields1;
    private List<Type> myDiffFields2;
    private List<Type> mySameFields;
    private String myFieldName;

    //~ Constructors ---------------------------------------------------------------------------------------------------

    public FieldComparison(String theFieldName, List<Type> theSameFields, List<Type> theDiffFields1,
                           List<Type> theDiffFields2) {
        myFieldName = theFieldName;
        mySameFields = theSameFields;
        myDiffFields1 = theDiffFields1;
        myDiffFields2 = theDiffFields2;
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    public List<Type> getDiffFieldsActual() {
        return myDiffFields2;
    }

    public List<Type> getDiffFieldsExpected() {
        return myDiffFields1;
    }

    private int getFieldCount() {
        return mySameFields.size();
    }

    public String getFieldName() {
        return myFieldName;
    }

    public List<Type> getSameFields() {
        return mySameFields;
    }

    public boolean isSame() {
        if (mySame == null) {
            mySame = true;

            for (int i = 0; i < getFieldCount(); i++) {
                if (myDiffFields1.get(i) != null) {
                    mySame = false;

                    break;
                }
            }
        }

        return mySame;
    }
}
