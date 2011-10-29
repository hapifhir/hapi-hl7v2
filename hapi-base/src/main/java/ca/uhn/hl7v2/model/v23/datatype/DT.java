/**
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Original Code is "DT.java".  Description:
 * "Note: The class description below has been excerpted from the Hl7 2.3.0 documentation"
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2005.  All Rights Reserved.
 *
 * Contributor(s): ______________________________________.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 *
 */

package ca.uhn.hl7v2.model.v23.datatype;

import ca.uhn.hl7v2.model.Message;

/**
 * 
 * Note: The class description below has been excerpted from the Hl7 2.3.0 documentation. Sectional
 * references made below also refer to the same documentation.
 *
 * Format: YYYY[MM[DD]]
 * In prior versions of HL7, this data type was always specified to be in the format YYYYMMDD. In the current and future
 * versions, the precision of a date may be expressed by limiting the number of digits used with the format specification
 * YYYY[MM[DD]]. Thus, YYYY is used to specify a precision of "year," YYYYMM specifies a precision of "month,"
 * and YYYYMMDD specifies a precision of "day."
 * By site-specific agreement, YYYYMMDD may be used where backward compatibility must be maintained.
 * Examples:   |19880704|  |199503|
 * @author Neal Acharya
 */

public class DT extends ca.uhn.hl7v2.model.primitive.DT {
    
    /**
     * @param theMessage message to which this Type belongs
     */
    public DT(Message theMessage) {
        super(theMessage);
    }

    /**
     * @return "2.3"
     */
    public String getVersion() {
        return "2.3";
    }
}
